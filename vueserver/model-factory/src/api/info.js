import { info } from './index';

function getInfo(userId) {
  return info.get(userId);
}

function adjustInfo(userData) {
  return info.put('/', userData);
}

export { getInfo, adjustInfo };
