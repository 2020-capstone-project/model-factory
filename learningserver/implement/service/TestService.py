from tensorflow.keras.models import load_model
import numpy as np


class TestService:
    def __init__(self, dto):
        self.dto = dto

    def testModel(self):
        reshape = np.array(self.dto['values']).astype('float32').reshape(1, len(self.dto['values']))
        model = load_model(self.dto['modelPath'])
        return model.predict_classes(reshape).reshape(1,).tolist()
