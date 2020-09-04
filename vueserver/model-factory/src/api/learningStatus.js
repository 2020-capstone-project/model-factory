import { learningStatus } from './index';

function getList(memberId) {
  return learningStatus.get(`${memberId}/learning-status`);
}

function getDetail(memberId, learningId) {
  return learningStatus.get(`${memberId}/learning-status/${learningId}`);
}

function postTest(memberId, learningId, values) {
  return learningStatus.post(
    `${memberId}/learning-status/${learningId}/test`,
    values,
  );
}

export { getList, getDetail, postTest };
