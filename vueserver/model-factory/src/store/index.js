import Vue from 'vue';
import Vuex from 'vuex';
import { loginUser } from '../api/auth';
import { adjustInfo } from '../api/info';

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    drawer: true,
    signupDialog: false,
    successSignup: false,
    successAdjust: false,
    name: '',
    email: '',
    loginState: false,
  },
  getters: {
    getDrawer(state) {
      return state.drawer;
    },
    getSuccessSignup(state) {
      return state.successSignup;
    },
    getSuccessAdjust(state) {
      return state.successAdjust;
    },
    isLogin(state) {
      state.loginState = state.name !== '';
      return state.loginState;
    },
    getName(state) {
      return state.name;
    },
    getEmail(state) {
      return state.email;
    },
  },
  mutations: {
    changeDrawer(state) {
      state.drawer = !state.drawer;
    },
    changeSuccessSignup(state) {
      state.successSignup = !state.successSignup;
    },
    changeSuccessAdjust(state) {
      state.successAdjust = !state.successAdjust;
    },
    setName(state, name) {
      state.name = name;
    },
    clearName(state) {
      state.name = '';
    },
    setEmail(state, email) {
      state.email = email;
    },
    clearEmail(state) {
      state.email = '';
    },
  },
  actions: {
    async LOGIN({ commit }, userData) {
      const { data } = await loginUser(userData);
      commit('setName', data.name);
      commit('setEmail', data.email);
    },
    async ADJUST({ commit }, userData) {
      await adjustInfo(userData);
      commit('setName', userData.name);
      commit('changeSuccessAdjust');
    },
  },
  modules: {},
});
