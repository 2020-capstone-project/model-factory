<template>
  <v-navigation-drawer
    v-model="$store.state.drawer"
    :clipped="$vuetify.breakpoint.lgAndUp"
    app
  >
    <v-list dense>
      <template v-if="$store.getters.isLogin">
        <v-list-item two-line>
          <v-list-item-avatar>
            <v-icon>mdi-account-circle</v-icon>
          </v-list-item-avatar>
          <v-list-item-content>
            <v-list-item-title>{{ $store.getters.getName }}</v-list-item-title>
            <v-list-item-subtitle>Logged In</v-list-item-subtitle>
          </v-list-item-content>
        </v-list-item>
      </template>
      <v-divider></v-divider>
      <v-list-item @click="pushHomePage">
        <v-list-item-action>
          <v-icon>mdi-home</v-icon>
        </v-list-item-action>
        <v-list-item-content>
          <v-list-item-title>
            Home
          </v-list-item-title>
        </v-list-item-content>
      </v-list-item>

      <template v-if="!isUserLogin">
        <v-list-item
          v-for="item in notLoggedItems"
          :key="item.title"
          @click="item.click"
        >
          <v-list-item-action>
            <v-icon>{{ item.icon }}</v-icon>
          </v-list-item-action>
          <v-list-item-content>
            <v-list-item-title>
              {{ item.title }}
            </v-list-item-title>
          </v-list-item-content>
        </v-list-item>
      </template>

      <template v-else>
        <v-list-item
          v-for="item in loggedItems"
          :key="item.title"
          @click="item.click"
        >
          <v-list-item-action>
            <v-icon>{{ item.icon }}</v-icon>
          </v-list-item-action>
          <v-list-item-content>
            <v-list-item-title>
              {{ item.title }}
            </v-list-item-title>
          </v-list-item-content>
        </v-list-item>
      </template>
    </v-list>
  </v-navigation-drawer>
</template>

<script>
import { logoutUser } from '@/api/auth';
import { deleteCookie } from '@/utils/cookies';

export default {
  data() {
    return {
      notLoggedItems: [
        {
          click: this.pushLoginPage,
          icon: 'mdi-login',
          title: 'Login',
        },
        {
          click: this.pushSingupPage,
          icon: 'mdi-account-plus',
          title: 'Sign up',
        },
      ],
      loggedItems: [
        {
          click: this.pushMyInfoPage,
          icon: 'mdi-account',
          title: 'My Info',
        },
        {
          click: this.logout,
          icon: 'mdi-logout',
          title: 'Logout',
        },
      ],
    };
  },
  methods: {
    pushSingupPage() {
      this.$router.push('/signup');
    },
    pushLoginPage() {
      this.$router.push('/login');
    },
    pushHomePage() {
      this.$router.push('/home');
    },
    pushMyInfoPage() {
      this.$router.push('/myinfo');
    },
    logout() {
      this.$store.commit('clearName');
    },
  },
  computed: {
    isUserLogin() {
      return this.$store.getters.isLogin;
    },
  },
};
</script>

<style></style>
