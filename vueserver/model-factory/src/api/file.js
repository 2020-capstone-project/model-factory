import { file } from './index';

function getFiles(id) {
  return file.get(`${id}`);
}

function getColumns(fileId) {
  return file.get(`${fileId}/columns`);
}

export { getFiles, getColumns };
