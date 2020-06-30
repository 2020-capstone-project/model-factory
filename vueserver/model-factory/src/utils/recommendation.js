class RecommendModel {
  getHyperparameter() {
    return {
      batchSize: 32,
      epoch: 10000,
      lossFunction: '',
      optimizerFunction: 'adam',
    };
  }
  getHiddenLayers() {
    return [
      {
        number: 0,
        information: {
          name: 'dense',
          activationFunction: 'relu',
          neuronCount: 256,
        },
      },
      {
        number: 1,
        information: {
          name: 'dropout',
          value: 0.25,
        },
      },
      {
        number: 2,
        information: {
          name: 'dense',
          activationFunction: 'relu',
          neuronCount: 256,
        },
      },
      {
        number: 3,
        information: {
          name: 'dropout',
          value: 0.25,
        },
      },
      {
        number: 4,
        information: {
          name: 'dense',
          activationFunction: 'relu',
          neuronCount: 256,
        },
      },
    ];
  }
  getRecommendLayers(prediction, outputColumnsLength) {
    var hiddenLayers = this.getHiddenLayers();
    switch (prediction) {
      case 'numeric':
        hiddenLayers.push({
          number: 5,
          information: {
            name: 'dense',
            neuronCount: outputColumnsLength,
          },
        });
        break;
      case 'binary':
        hiddenLayers.push({
          number: 5,
          information: {
            name: 'dense',
            activationFunction: 'sigmoid',
            neuronCount: outputColumnsLength,
          },
        });
        break;
      case 'multiple':
        hiddenLayers.push({
          number: 5,
          information: {
            name: 'dense',
            activationFunction: 'softmax',
            neuronCount: outputColumnsLength,
          },
        });
        break;
    }
    return hiddenLayers;
  }
  getRecommendHyperparameters(prediction) {
    var hyperparameters = this.getHyperparameter();
    switch (prediction) {
      case 'numeric':
        hyperparameters.lossFunction = 'mean_squared_error';
        break;
      case 'binary':
        hyperparameters.lossFunction = 'binary_crossentropy';
        break;
      case 'multiple':
        hyperparameters.lossFunction = 'categorical_crossentropy';
        break;
    }
    return hyperparameters;
  }
}

export { RecommendModel };
