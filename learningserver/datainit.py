import pandas as pd
import numpy as np

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

# dataset = np.loadtxt(data['filepath'], delimiter=',')
dataset = pd.read_csv(data['filepath'])
inputColumns = []
for col in data.get('inputColumns'):
    inputColumns.append(dataset[col])
    print('\n=== column ===\n')
    print(col)
    print()

print('\n=== dataset ===\n')
print(dataset)

# 배열 하나로 합치기
#   np.concatenate((a, b), axis=?))

# pandas to numpy
#   df.to_numpy()

x_train = []

print('\n=== inputColumns ===\n')
for col in inputColumns:
    print('\n===', col[0], '===\n')
    inputData = [value for value in col]
    x_train.append(inputData)