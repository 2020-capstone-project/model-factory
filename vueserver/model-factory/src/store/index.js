import Vue from 'vue';
import Vuex from 'vuex';

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    drawer: true,
    signupDialog: false,
    successSignup: false,
  },
  getters: {
    getDrawer(state) {
      return state.drawer;
    },
    getSuccessSignup(state) {
      return state.successSignup;
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
  },
  actions: {},
  modules: {},
});
