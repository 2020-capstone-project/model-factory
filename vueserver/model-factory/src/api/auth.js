import { auth } from './index';

function registerUser(userData) {
  return auth.post('signup', userData);
}

function loginUser(userData) {
  return auth.post('login', userData);
}

export { registerUser, loginUser };
