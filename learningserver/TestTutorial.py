from tensorflow.keras.models import load_model
import numpy as np

dto = {'modelPath': '/Users/sangminlee/model-factory/restapiserver/src/main/resources/13/model.h5',
        'values': [6, 148, 72, 35, 0, 33.6, 0.627, 50]}

reshape = np.array(dto['values']).astype('float32').reshape(1, len(dto['values']))
model = load_model(dto['modelPath'])
result = model.predict_classes(reshape)
result = result.reshape(1,).tolist()
print(result)
print(type(reshape))
print(type(result))