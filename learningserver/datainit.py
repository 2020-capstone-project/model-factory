import pandas as pd
import numpy as np
from keras.models import Sequential
from keras.layers import Dense, Dropout

data = {
    "filepath": "/Users/sangminlee/model-factory/restapiserver/src/main/resources/홍릉_도심_미세먼지_측정자료.csv",
    "learningId": 71,
    "prediction": "numeric",
    "inputColumns": [
        "온도(℃)",
        "습도(%)",
        "풍향",
        "풍속(㎧)"
    ],
    "outputColumns": [
        "Avoc-PM10(㎍/m³)"
    ],
    "batchSize": 32,
    "epoch": 100,
    "lossFunction": "mse",
    "optimizerFunction": "rmsprop",
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
        }
    ]
}

# 파일 불러오기
dataset = pd.read_csv(data['filepath'])

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
model.add(Dense(256, input_dim=len(x_test[0]), activation="relu"))
model.add(Dense(256, activation="relu"))
model.add(Dense(256, activation="relu"))
model.add(Dense(1))

model.compile(optimizer=data.get('optimizerFunction'), loss=data.get('lossFunction'),
              metrics=['accuracy'])

hist = model.fit(x_train, y_train, epochs=200, batch_size=64)
