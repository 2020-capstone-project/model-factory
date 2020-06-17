import keras


class CustomHistory(keras.callbacks.Callback):
    def init(self, totalEpoch):
        self.epochCount = 0
        self.epochCycle = totalEpoch * 0.1

    def on_epoch_end(self, batch, logs={}):
        self.epochCount += 1
        if self.epochCount % self.epochCycle == 0:
            print()
            print('\n=== train loss ===')
            print(logs.get('loss'))
            print('\n=== val loss ===')
            print(logs.get('val_loss'))
            print('\n=== train acc ===')
            print(logs.get('accuracy'))
            print('\n=== val acc ===')
            print(logs.get('val_accuracy'))
            print()
