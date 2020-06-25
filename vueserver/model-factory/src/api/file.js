import { file } from './index';

function getfiles() {
  return file.get();
}

function getColumns(fileId) {
  return file.get(`${fileId}/columns`);
}

export { getfiles, getColumns };
