import { file } from './index';

function getfiles(id) {
  return file.get(id);
}

function getColumns(fileId) {
  return file.get(`${fileId}/columns`);
}

export { getfiles, getColumns };
