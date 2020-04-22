import Vue from 'vue';
import Vuex from 'vuex';
import { loginUser } from '../api/auth';
import { saveAuthToCookie, getAuthFromCookie } from '@/utils/cookies';

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    drawer: true,
    signupDialog: false,
    successSignup: false,
    successSignin: false,
    name: '',
    loginState: false,
  },
  getters: {
    getDrawer(state) {
      return state.drawer;
    },
    getSuccessSignup(state) {
      return state.successSignup;
    },
    isLogin(state) {
      state.loginState = state.name !== '';
      return state.loginState;
    },
    getName(state) {
      return state.name;
    },
  },
  mutations: {
    changeDrawer(state) {
      state.drawer = !state.drawer;
    },
    changeSuccessSignupAlert(state) {
      state.successSignupAlert = true;
    },
    changeSuccessSignup(state) {
      state.successSignup = !state.successSignup;
    },
    changeSuccessSignin(state) {
      state.successSignin = !state.successSignin;
    },
    setName(state, name) {
      state.name = name;
    },
    clearName(state) {
      state.name = '';
    },
  },
  actions: {
    async LOGIN({ commit }, userData) {
      const { data } = await loginUser(userData);
      commit('setName', data.name);
    },
  },
  modules: {},
});
