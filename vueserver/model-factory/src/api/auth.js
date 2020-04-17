import { auth } from './index';

function registerUser(userData) {
  return auth.post('signup', userData);
}

function loginUser(userData) {
  return auth.post('login', userData);
}

function logoutUser(userData) {
  return auth.post('logout', userData);
}

export { registerUser, loginUser, logoutUser };
