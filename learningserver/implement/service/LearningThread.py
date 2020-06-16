from threading import Thread


class LearningThread:

    def __init__(self):
        self.threads = {}

    def learn(self, model, x_train, y_train, epochs, customHistory, batchSize, x_val, y_val, learningId):
        # TODO verbose 조정으로 출력문 안나오게 코드 수정
        model.fit(x_train, y_train, epochs=epochs,
                  callbacks=customHistory, batch_size=batchSize,
                  validation_data=(x_val, y_val))

    def start(self, learningDto):
        dt = learningDto.getData()
        Thread(target=self.learn, args=(dt['model'], dt['x_train'], dt['y_train'], dt['epochs'],
                                        dt['customHistory'], dt['batchSize'], dt['x_val'], dt['y_val'],
                                        dt['learningId'])).start()

    # TODO 추후에 학습 정지시키는 메서드 구현
