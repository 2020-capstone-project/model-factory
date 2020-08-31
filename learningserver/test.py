import pandas as pd

requestDto = {
    "learningId": 72,
    "learningFilePath": "/Users/sangminlee/model-factory/restapiserver/src/main/resources/피마족_인디언_당뇨병_발병_데이터셋.csv",
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
    "epoch": 100,
    "lossFunction": "binary_crossentropy",
    "optimizerFunction": "adam",
    "memberId": 1,
    "layers": [
        {
            "number": 0,
            "activationFunction": "relu",
            "neuronCount": 256
        },
        {
            "number": 1,
            "activationFunction": "dropout",
            "neuronCount": 25
        },
        {
            "number": 2,
            "activationFunction": "relu",
            "neuronCount": 256
        },
        {
            "number": 3,
            "activationFunction": "dropout",
            "neuronCount": 25
        },
        {
            "number": 4,
            "activationFunction": "relu",
            "neuronCount": 256
        },
        {
            "number": 5,
            "activationFunction": "dropout",
            "neuronCount": 25
        },
        {
            "number": 6,
            "activationFunction": "sigmoid",
            "neuronCount": 1
        }
    ]
}

dataset = pd.read_csv(requestDto['learningFilePath'])

# 학습셋, 검증셋, 시험셋 분리
x_train = dataset[requestDto.get('inputColumns')].values[1:].astype('float32')
print(x_train)
train_length = int(len(x_train) * 0.7)
val_length = int(len(x_train) * 0.2)
x_test = x_train[train_length + val_length:]
x_val = x_train[train_length: train_length + val_length]
x_train = x_train[:train_length]

# 학습셋, 검증셋, 시험셋 분리
y_train = dataset[requestDto.get('outputColumns')].values[1:].astype('float32')
y_test = y_train[train_length + val_length:]
y_val = y_train[train_length: train_length + val_length]
y_train = y_train[:train_length]

x_length = len(x_test[0])
y_length = len(y_test[0])
