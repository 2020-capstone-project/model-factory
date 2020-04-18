<template>
  <div id="app">
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
          <v-app-bar-nav-icon
            @click.stop="drawer = !drawer"
          ></v-app-bar-nav-icon>
          <span class="hidden-sm-and-down">Model Factory</span>
          <v-icon class="mx-2">mdi-factory</v-icon>
        </v-toolbar-title>
      </v-app-bar>

      <v-content>
        <v-container fluid fill-height>
          <v-layout align-center justify-center> </v-layout>
        </v-container>
      </v-content>
      <v-dialog v-model="$store.state.signupDialog" width="800px">
        <v-card class="elevation-12">
          <v-toolbar color="primary" dark flat>
            <v-toolbar-title>Sign up</v-toolbar-title>
            <v-spacer></v-spacer>
          </v-toolbar>
          <v-card-text>
            <v-alert v-if="!isSignupValid" type="error" class="ma-3">
              {{ signupErrorMeesage }}
            </v-alert>
            <v-form @submit.prevent="submitSignupForm">
              <v-text-field
                label="Name"
                name="login"
                prepend-icon="mdi-account"
                type="text"
                v-model="name"
                class="mt-3"
              ></v-text-field>

              <v-text-field
                label="Email"
                name="login"
                prepend-icon="mdi-email"
                type="text"
                v-model="email"
              ></v-text-field>

              <v-text-field
                id="password"
                label="Password"
                name="password"
                prepend-icon="mdi-lock"
                type="password"
                v-model="password"
              ></v-text-field>

              <v-text-field
                id="password"
                label="Confirm Password"
                name="password"
                prepend-icon="mdi-check"
                type="password"
                v-model="confirmPassword"
              ></v-text-field>
              <v-card-actions>
                <v-spacer></v-spacer>
                <v-btn type="submit" :disabled="!isSignupValid" color="primary"
                  >Create</v-btn
                >
              </v-card-actions>
            </v-form>
          </v-card-text>
        </v-card>
      </v-dialog>
    </v-app>
  </div>
</template>

<script>
// import SignupDialog from '@/views/SignupDialog.vue';
// import HomeNavigation from '@/components/common/HomeNavigation.vue';
// import AppHeader from '@/components/common/AppHeader.vue';
import { registerUser } from '@/api/auth';
import { validateEmail } from '@/utils/validation';

export default {
  components: {
    // HomeNavigation,
    // AppHeader,
  },
  data() {
    return {
      name: '',
      email: '',
      password: '',
      confirmPassword: '',
      signupErrorMeesage: '',
      drawer: null,
    };
  },
  computed: {
    isSignupValid() {
      if (!this.name) {
        // eslint-disable-next-line vue/no-side-effects-in-computed-properties
        this.signupErrorMeesage = '이름을 반드시 입력해주세요';
      } else if (!this.email) {
        // eslint-disable-next-line vue/no-side-effects-in-computed-properties
        this.signupErrorMeesage = '이메일을 반드시 입력해주세요';
      } else if (!validateEmail(this.email)) {
        // eslint-disable-next-line vue/no-side-effects-in-computed-properties
        this.signupErrorMeesage = '이메일을 올바르게 작성해주세요';
      } else if (!this.password) {
        // eslint-disable-next-line vue/no-side-effects-in-computed-properties
        this.signupErrorMeesage = '비밀번호를 반드시 입력해주세요.';
      } else if (this.password !== this.confirmPassword) {
        // eslint-disable-next-line vue/no-side-effects-in-computed-properties
        this.signupErrorMeesage =
          '비밀번호와 비밀번호 확인이 일치하지 않습니다.';
      } else {
        // eslint-disable-next-line vue/no-side-effects-in-computed-properties
        this.signupErrorMeesage = '';
      }
      return this.signupErrorMeesage === '';
    },
  },
  methods: {
    changeSignupDialog() {
      this.$store.commit('changeSignupDialog');
    },
    async submitSignupForm() {
      const userData = {
        name: this.name,
        email: this.email,
        password: this.password,
      };
      // const { data } = await registerUser(userData);
      // console.log(data);
      const result = await registerUser(userData);
      console.log(result);
    },
  },
};
</script>
