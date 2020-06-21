import requests, json
from threading import Thread
import time
from keras.models import load_model
import os

class ClientService:
    def __init__(self):
        self.URL = 'http://localhost:8080/'

    # TODO 테스트셋으로 검증후 저장 요청 로직 구현
    # TODO 예외 처리

    def saveHistory(self, learningId, epochCount, trainLoss, trainAccuracy,
                    valLoss, valAccuracy, model, modelPath):
        url = self.URL + 'history'
        model.save(modelPath)
        data = {'learningId': learningId,
                'epochCount': epochCount,
                'trainLoss': trainLoss,
                'trainAccuracy': trainAccuracy,
                'valLoss': valLoss,
                'valAccuracy': valAccuracy}
        print(requests.post(url, json=data))

    def requestSaveHistory(self, historyDto):
        Thread(target=self.saveHistory, args=(historyDto.learningId,
                                              historyDto.epochCount,
                                              historyDto.trainLoss,
                                              historyDto.trainAccuracy,
                                              historyDto.valLoss,
                                              historyDto.valAccuracy,
                                              historyDto.model,
                                              historyDto.modelPath)).start()
