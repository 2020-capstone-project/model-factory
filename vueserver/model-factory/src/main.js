import Vue from 'vue';
import App from './App.vue';
import router from './router';
import store from './store';
import vuetify from './plugins/vuetify';
import HighchartsVue from 'highcharts-vue';

Vue.config.productionTip = false;

new Vue({
  router,
  store,
  vuetify,
  HighchartsVue,
  render: h => h(App),
}).$mount('#app');
