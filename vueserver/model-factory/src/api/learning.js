import { learning } from './index';

function requestLearning(learningData) {
  //   console.log(learningData);
  return learning.post('', learningData);
}

export { requestLearning };
