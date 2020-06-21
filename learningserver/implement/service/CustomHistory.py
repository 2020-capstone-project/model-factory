import tensorflow.keras

from implement.service.ClientService import ClientService
from implement.dto.HistoryDto import HistoryDto


class CustomHistory(tensorflow.keras.callbacks.Callback):
    def init(self, totalEpoch, learningId, model, modelPath):
        self.epochCount = 0
        self.epochCycle = totalEpoch * 0.01
        self.learningId = learningId
        self.model = model
        self.modelPath = modelPath
        self.clientService = ClientService()

    def on_epoch_end(self, batch, logs={}):
        self.epochCount += 1
        if self.epochCount % self.epochCycle == 0:
            self.clientService.requestSaveHistory(HistoryDto(
                learningId=self.learningId,
                epochCount=self.epochCount,
                trainLoss=logs.get('loss'),
                trainAccuracy=logs.get('accuracy'),
                valLoss=logs.get('val_loss'),
                valAccuracy=logs.get('val_accuracy'),
                model=self.model, modelPath=self.modelPath))
