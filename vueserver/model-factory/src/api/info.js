import { info } from './index';

function adjustInfo(userData) {
  return info.put('/', userData);
}

export { adjustInfo };
