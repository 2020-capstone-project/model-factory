class HistoryDto:
    def __init__(self, learningId, epochCount, trainLoss, trainAccuracy,
                 valLoss, valAccuracy, model, modelPath):
        self.learningId = learningId
        self.epochCount = epochCount
        self.trainLoss = trainLoss
        self.trainAccuracy = trainAccuracy
        self.valLoss = valLoss
        self.valAccuracy = valAccuracy
        self.model = model
        self.modelPath = modelPath

    def getData(self):
        return {'learningId': self.learningId, 'epochCount': self.epochCount,
                'trainLoss': self.trainLoss, 'trainAccuracy': self.trainAccuracy,
                'valLoss': self.valLoss, 'valAccuracy': self.valAccuracy,
                'model': self.model, 'modelPath': self.modelPath}
