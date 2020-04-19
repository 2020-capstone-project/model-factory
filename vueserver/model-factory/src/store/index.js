import Vue from 'vue';
import Vuex from 'vuex';

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    drawer: null,
    signupDialog: false,
    successSignupAlert: false,
  },
  mutations: {
    changeDrawer() {
      drawer != drawer;
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
