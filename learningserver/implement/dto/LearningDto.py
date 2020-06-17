class LearningDto:

    def __init__(self, learningId, epochs, batch_size, x_train, x_val, x_test,
                 y_train, y_val, y_test, x_length, y_length, model, modelPath, customHistory):
        self.learningId = learningId
        self.epochs = epochs
        self.batchSize = batch_size
        self.x_train = x_train
        self.x_val = x_val
        self.x_test = x_test
        self.y_train = y_train
        self.y_val = y_val
        self.y_test = y_test
        self.x_length = x_length
        self.y_length = y_length
        self.model = model
        self.customHistory = customHistory

    def getData(self):
        return {'learningId': self.learningId, 'epochs': self.epochs, 'batchSize': self.batchSize,
                'x_train': self.x_train, 'x_val': self.x_val, 'x_test': self.x_test,
                'y_train': self.y_train, 'y_val': self.y_val, 'y_test': self.y_test,
                'x_length': self.x_length, 'y_length': self.y_length, 'model': self.model,
                'customHistory': self.customHistory}

    def getLearningId(self):
        return self.learningId
