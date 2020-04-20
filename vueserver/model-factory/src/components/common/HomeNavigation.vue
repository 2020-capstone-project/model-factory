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
    </v-list>
  </v-navigation-drawer>
</template>

<script>
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
  },
};
</script>

<style></style>
