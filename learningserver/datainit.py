import pandas as pd
import numpy as np
from keras.models import Sequential
from keras.layers import Dense, Dropout

data = {
    "learningFilePath": "/content/drive/My Drive/capstone/피마족_인디언_당뇨병_발병_데이터셋.csv",
    "modelPath": "/Users/sangminlee/model-factory/restapiserver/src/main/resources/78/model.h5",
    "diagramPath": "/Users/sangminlee/model-factory/restapiserver/src/main/resources/78/diagram.svg",
    "prediction": "binary",
    "inputColumns": [
        "임신 횟수",
        "혈장 포도당 농도",
        "이완기 혈압",
        "삼두근 피부 두께",
        "혈청 인슐린",
        "체질량 지수",
        "당뇨 직계 가족력",
        "나이"
    ],
    "outputColumns": [
        "당뇨병 발병 여부"
    ],
    "batchSize": 64,
    "epoch": 1500,
    "lossFunction": "binary_crossentropy",
    "optimizerFunction": "adam",
    "memberId": 1,
    "layers": [
        {
            "number": 0,
            "activationFunction": "relu",
            "neuronCount": 32
        },
        {
            "number": 1,
            "activationFunction": "relu",
            "neuronCount": 32
        },
        {
            "number": 2,
            "activationFunction": "sigmoid",
            "neuronCount": 1
        }
    ]
}

# 파일 불러오기
dataset = pd.read_csv(data['learningFilePath'])

# 입력 데이터 전처리 및 학습셋, 검증셋, 시험셋 분리
x_train = dataset[data.get('inputColumns')].values[1:].astype('float32')
train_length = int(len(x_train) * 0.7)
val_length = int(len(x_train) * 0.2)
x_test = x_train[train_length + val_length:]
x_val = x_train[train_length: train_length + val_length]
x_train = x_train[:train_length]

# 결과 데이터 전처리 및 학습셋, 검증셋, 시험셋 분리
y_train = dataset[data.get('outputColumns')].values[1:].astype('float32')
y_test = y_train[train_length + val_length:]
y_val = y_train[train_length: train_length + val_length]
y_train = y_train[:train_length]
print(len(y_test[0]))

x_length = len(x_test[0])
y_length = len(y_test[0])

model = Sequential()
layers = data.get('layers')
for i in range(len(layers)):
    print(layers['number'])
    # if i == 0:

# model.add(Dense(256, input_dim=x_length, activation="relu"))
# model.add(Dense(256, activation="relu"))
# model.add(Dense(256, activation="relu"))
# model.add(Dense(y_length))
#
# model.compile(optimizer=data.get('optimizerFunction'), loss=data.get('lossFunction'),
#               metrics=['accuracy'])
#
# hist = model.fit(x_train, y_train, epochs=200, batch_size=64)
