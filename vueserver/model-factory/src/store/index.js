import Vue from 'vue';
import Vuex from 'vuex';

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    drawer: true,
    signupDialog: false,
    successSignupAlert: false,
  },
  getters: {
    getDrawer(state) {
      return state.drawer;
    },
  },
  mutations: {
    changeDrawer(state) {
      state.drawer = !state.drawer;
    },
    changeSignupDialog(state) {
      state.signupDialog = true;
    },
    changeSuccessSignupAlert(state) {
      state.successSignupAlert = true;
    },
  },
  actions: {},
  modules: {},
});
