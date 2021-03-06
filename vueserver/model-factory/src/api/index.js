import axios from 'axios';

function createInstanceWithAuth(url) {
  return axios.create({
    baseURL: `${process.env.VUE_APP_API_URL}${url}`,
  });
}

export const auth = createInstanceWithAuth('auth');
export const info = createInstanceWithAuth('info');
export const file = createInstanceWithAuth('files');
export const learning = createInstanceWithAuth('learning');
export const learningStatus = createInstanceWithAuth('members');
export const upload = createInstanceWithAuth('upload');
