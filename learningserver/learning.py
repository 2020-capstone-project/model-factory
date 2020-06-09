import pandas as pd
import numpy as np
from keras.models import Sequential
from keras.layers import Dense, Dropout
from IPython.display import SVG
from keras.utils.vis_utils import model_to_dot
import keras
import matplotlib.pyplot as plt

data = {
    "learningFilePath": '/Users/sangminlee/model-factory/restapiserver/src/main/resources/피마족_인디언_당뇨병_발병_데이터셋.csv',
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
            "neuronCount": 16
        },
        {
            "number": 1,
            "activationFunction": "relu",
            "neuronCount": 16
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

# 학습셋, 검증셋, 시험셋 분리
x_train = dataset[data.get('inputColumns')].values.astype('float32')
train_length = int(len(x_train) * 0.7)
val_length = int(len(x_train) * 0.2)
x_test = x_train[train_length + val_length:]
x_val = x_train[train_length: train_length + val_length]
x_train = x_train[:train_length]

# 학습셋, 검증셋, 시험셋 분리
y_train = dataset[data.get('outputColumns')].values.astype('float32')
y_test = y_train[train_length + val_length:]
y_val = y_train[train_length: train_length + val_length]
y_train = y_train[:train_length]

x_length = len(x_test[0])
y_length = len(y_test[0])

model = Sequential()
layers = data.get('layers')
for i in range(len(layers)):
    if i == 0:
        model.add(
            Dense(
                layers[i]['neuronCount'],
                input_dim = x_length,
                activation = layers[i]['activationFunction']))
    elif i == len(layers) - 1:
        model.add(Dense(y_length))
    else:
        model.add(
            Dense(
                layers[i]['neuronCount'],
                activation = layers[i]['activationFunction']))

def visualize(model):
    return SVG(model_to_dot(model, show_shapes=True, dpi=65)
                .create(prog='dot', format='svg'))

class CustomHistory(keras.callbacks.Callback):
    def init(self):
        self.train_loss = []
        self.val_loss = []
        self.train_accuracy = []
        self.val_accuracy = []

    def on_epoch_end(self, batch, logs={}):
        self.train_loss.append(logs.get('loss'))
        self.val_loss.append(logs.get('val_loss'))
        self.train_accuracy.append(logs.get('accuracy'))
        self.val_accuracy.append(logs.get('val_acc'))

visualize(model)

model.compile(optimizer=data.get('optimizerFunction'),
                loss=data.get('lossFunction'),
                metrics=['accuracy'])

custom_hist = CustomHistory()
custom_hist.init()

hist = model.fit(x_train, y_train, epochs=data.get('epoch'),
                 callbacks=[custom_hist], batch_size=data.get('batchSize'),
                 validation_data=(x_val, y_val))

fig, loss_ax = plt.subplots()

acc_ax = loss_ax.twinx()

loss_ax.plot(hist.history['loss'], 'y', label='train loss')
loss_ax.plot(hist.history['val_loss'], 'r', label='val loss')

acc_ax.plot(hist.history['accuracy'], 'b', label='train acc')
acc_ax.plot(hist.history['val_accuracy'], 'g', label='val acc')

loss_ax.set_xlabel('epoch')
loss_ax.set_ylabel('loss')
acc_ax.set_ylabel('accuracy')

loss_ax.legend(loc='upper left')
acc_ax.legend(loc='lower left')

plt.show()

loss_and_metrics = model.evaluate(x_test, y_test, batch_size=64)
print('## evaluation loss and metrics ##')
print(loss_and_metrics)