import { learningStatus } from './index';

function getList(memberId) {
  return learningStatus.get(`${memberId}/learning-status`);
}

function getDetail(memberId, learningId) {
  return learningStatus.get(`${memberId}/learning-status/${learningId}`);
}

export { getList, getDetail };
