import pandas as pd
import tensorflow as tf
import os
from tensorflow.keras.layers import Dense, Dropout

from implement.service.CustomHistory import CustomHistory
from implement.dto.LearningDto import LearningDto
from implement.service.LearningThread import LearningThread


class LearningService:
    def __init__(self, requestDto):
        self.requestDto = requestDto
        self.learningId = requestDto.get('learningId')
        self.epochs = requestDto.get('epoch')
        self.batch_size = requestDto.get('batchSize')
        self.customHistory = CustomHistory()
        self.learningThread = LearningThread()
        self.modelPath = requestDto.get('modelPath')

    def separateDataset(self):
        # 파일 불러오기
        dataset = pd.read_csv(self.requestDto['learningFilePath'])

        # 학습셋, 검증셋, 시험셋 분리
        self.x_train = dataset[self.requestDto.get('inputColumns')].values[1:].astype('float32')
        train_length = int(len(self.x_train) * 0.7)
        val_length = int(len(self.x_train) * 0.2)
        self.x_test = self.x_train[train_length + val_length:]
        self.x_val = self.x_train[train_length: train_length + val_length]
        self.x_train = self.x_train[:train_length]

        # 학습셋, 검증셋, 시험셋 분리
        self.y_train = dataset[self.requestDto.get('outputColumns')].values[1:].astype('float32')
        self.y_test = self.y_train[train_length + val_length:]
        self.y_val = self.y_train[train_length: train_length + val_length]
        self.y_train = self.y_train[:train_length]

        self.x_length = len(self.x_test[0])
        self.y_length = len(self.y_test[0])

    def createModel(self):
        layers = self.requestDto.get('layers')
        model = tf.keras.Sequential()
        for layer in layers:
            info = layer['information']
            if layer['number'] == 0:
                model.add(Dense(info['neuronCount'],
                                input_dim=self.x_length,
                                activation=info['activationFunction']))
            else:
                if info['name'] == 'dense':
                    activation = info['activationFunction']
                    neuron = info['neuronCount']
                    model.add(Dense(neuron, activation=activation))
                elif info['name'] == 'dropout':
                    model.add(Dropout(info['value']))

        self.model = model

    def compileModel(self):
        self.model.compile(optimizer=self.requestDto.get('optimizerFunction'),
                           loss=self.requestDto.get('lossFunction'),
                           metrics=['accuracy'])

    def requestLearning(self):
        # TODO 예외 처리 추가
        #  * 에포크가 100 보다 작거나 x % 100 != 0 이면 에러 발생
        try:
            os.mkdir(self.modelPath[:-8])
            self.separateDataset()
            self.createModel()
            self.compileModel()
            self.customHistory.init(self.epochs, self.learningId, self.model, self.modelPath)
            return self.learningThread.start(self.getLearningDto())
        except Exception as e:
            print(e)
            return {"code": 400, "message": "error"}

    def getLearningDto(self):
        return LearningDto(self.learningId, self.epochs, self.batch_size,
                           self.x_train, self.x_val, self.x_test,
                           self.y_train, self.y_val, self.y_test,
                           self.x_length, self.y_length, self.model,
                           self.modelPath, self.customHistory)
