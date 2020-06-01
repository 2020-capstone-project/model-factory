from flask import Flask, request, jsonify
import pandas as pd

app = Flask(__name__)


class Layer:
    number = 0
    activationFunction = ''
    neuronCount = 0

    def __init__(self, number, activationFunction, neuronCount):
        self.number = number
        self.activationFunction = activationFunction
        self.neuronCount = neuronCount


class Model:
    batchSize = 0
    epoch = 0
    lossFunction = ''
    optimizerFunction = ''
    layers = []

    def __init__(self, batchSize, epoch, lossFunction, optimizerFunction, layers):
        self.batchSize = batchSize
        self.epoch = epoch
        self.lossFunction = lossFunction
        self.optimizerFunction = optimizerFunction
        self.layers = layers


class LearningData:
    def __init__(self, inputColumns, outputColumns):
        self.inputColumns = inputColumns
        self.outputColumns = outputColumns


@app.route('/learning', methods=['POST'])
def post_learning():
    learning = request.get_json()
    for key, value in learning.items():
        print(key, ':', value)
    file = pd.read_csv(learning.get('filepath'))

    inputColumns = []

    for col in learning.get('inputColumns'):
        inputColumns.append(file[col])

    print('\n=== 1 ===\n', inputColumns)
    print('\n=== 2 ===\n', inputColumns[0])
    print('\n=== 3 ===\n', inputColumns[0][0])
    print('\n=== 3 ===\n', inputColumns[0][0])

    print('\n=== value ===\n')

    for value in inputColumns[0]:
        print(value)
        print(type(value))

    return "hello"


if __name__ == '__main__':
    app.run()
