<template>
  <v-app id="inspire">
    <v-navigation-drawer
      v-model="drawer"
      :clipped="$vuetify.breakpoint.lgAndUp"
      app
    >
      <v-list dense>
        <v-list-item @click="changeSignupDialog">
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

    <v-app-bar
      :clipped-left="$vuetify.breakpoint.lgAndUp"
      app
      color="blue darken-3"
      dark
    >
      <v-toolbar-title style="width: 300px" class="ml-0">
        <v-app-bar-nav-icon @click.stop="drawer = !drawer"></v-app-bar-nav-icon>
        <span class="hidden-sm-and-down">Model Factory</span>
        <v-icon class="mx-2">mdi-factory</v-icon>
      </v-toolbar-title>
    </v-app-bar>

    <v-content>
      <v-container fluid fill-height>
        <v-layout align-center justify-center> </v-layout>
      </v-container>
    </v-content>
    <SignupDialog></SignupDialog>
  </v-app>
</template>

<script>
import SignupDialog from '@/views/SignupDialog.vue';
// import HomeNavigation from '@/components/common/HomeNavigation.vue';
// import AppHeader from '@/components/common/AppHeader.vue';
import { registerUser } from '@/api/auth';
import { validateEmail } from '@/utils/validation';

export default {
  components: {
    SignupDialog,
    // HomeNavigation,
    // AppHeader,
  },
  data() {
    return {
      drawer: null,
    };
  },
  methods: {
    changeSignupDialog() {
      this.$store.commit('changeSignupDialog');
    },
  },
};
</script>
