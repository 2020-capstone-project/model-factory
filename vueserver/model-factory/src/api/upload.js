import { upload } from './index';

function uploadFile(file) {
  return upload.post('', file, {
    headers: {
      'Content-Type': `multipart/form-data; boundary=${file.size}; application/json`,
    },
  });
}

export { uploadFile };
