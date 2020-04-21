<template>
  <v-navigation-drawer
    v-model="$store.state.drawer"
    :clipped="$vuetify.breakpoint.lgAndUp"
    app
  >
    <v-list dense>
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
        <v-list-item @click="pushLoginPage">
          <v-list-item-action>
            <v-icon>mdi-login</v-icon>
          </v-list-item-action>
          <v-list-item-content>
            <v-list-item-title>
              Login
            </v-list-item-title>
          </v-list-item-content>
        </v-list-item>
        <v-list-item @click="pushSingupPage">
          <v-list-item-action>
            <v-icon>mdi-account-plus</v-icon>
          </v-list-item-action>
          <v-list-item-content>
            <v-list-item-title>
              Sign Up
            </v-list-item-title>
          </v-list-item-content>
        </v-list-item>
      </template>
      <template v-else>
        <v-list-item @click="logout">
          <v-list-item-action>
            <v-icon>mdi-logout</v-icon>
          </v-list-item-action>
          <v-list-item-content>
            <v-list-item-title>
              Logout
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
    logout() {
      console.log(this.$store.getters.getSessionId);
      logoutUser({
        sessionId: this.$store.getters.getSessionId,
      });
      this.$store.commit('clearSessionId');
      this.$store.commit('clearName');
      deleteCookie('auth');
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
