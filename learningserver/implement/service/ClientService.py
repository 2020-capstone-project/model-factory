import requests, json
from threading import Thread
import time


class ClientService:
    def __init__(self):
        self.URL = 'http://localhost:8080/'

    # TODO Model 저장 로직 구현

    def saveHistory(self, learningId, epochCount, trainLoss, trainAccuracy,
                    valLoss, valAccuracy, model, modelPath):
        # TODO Spring 서버와 통신이 잘 되는지 확인 필요
        url = self.URL + 'history'
        data = {'learningId': learningId,
                'epochCount': epochCount,
                'trainLoss': trainLoss,
                'trainAccuracy': trainAccuracy,
                'valLoss': valLoss,
                'valAccuracy': valAccuracy}
        # requests.post(url, data=json.dumps(data))

    def requestSaveHistory(self, historyDto):
        Thread(target=self.saveHistory, args=(historyDto.learningId,
                                              historyDto.epochCount,
                                              historyDto.trainLoss,
                                              historyDto.trainAccuracy,
                                              historyDto.valLoss,
                                              historyDto.valAccuracy,
                                              historyDto.model)).start()
