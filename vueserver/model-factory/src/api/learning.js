import { learning } from './index';

function requestLearning(learningData) {
  return learning.post('', learningData);
}

export { requestLearning };
