import Vue from 'vue';
import VueRouter from 'vue-router';

Vue.use(VueRouter);

const routes = [
  {
    path: '/',
    name: 'root',
    component: () => import('@/views/HomePage.vue'),
  },
  {
    path: '/signup',
    name: 'Sign Up',
    component: () => import('@/views/SignupPage.vue'),
  },
  {
    path: '/login',
    name: 'Login',
    component: () => import('@/views/LoginPage.vue'),
  },
  {
    path: '/home',
    name: 'Home',
    component: () => import('@/views/HomePage.vue'),
  },
  {
    path: '/myinfo',
    name: 'My Info',
    component: () => import('@/views/MyInfoPage.vue'),
  },
  {
    path: '/learning',
    name: 'Learning',
    component: () => import('@/views/LearningPage.vue'),
  },
  {
    path: '/learning-status',
    name: 'Learning Status',
    component: () => import('@/views/LearningStatusPage.vue'),
  },
  {
    path: '/learning-status/detail',
    name: 'Detail Status',
    component: () => import('@/views/DetailStatusPage.vue'),
  },
];

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes,
});

export default router;
