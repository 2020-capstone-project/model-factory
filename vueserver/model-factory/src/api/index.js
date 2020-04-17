import axios from 'axios';

function createInstance() {
  return axios.create({
    baseURL: process.env.VUE_APP_API_URL,
  });
}

function createInstanceWithAuth(url) {
  return axios.create({
    baseURL: `${process.env.VUE_APP_API_URL}${url}`,
  });
}

export const auth = createInstanceWithAuth('auth');
