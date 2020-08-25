<template>
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
        <v-alert v-if="isRequestError" type="error" class="ma-3">
          {{ requestErrorMessage }}
        </v-alert>
        <v-spacer></v-spacer>
        <v-btn type="submit" :disabled="!isSignupValid" color="primary"
          >Create</v-btn
        >
      </v-card-actions>
    </v-form>
  </v-card-text>
</template>

<script>
import { registerUser } from '@/api/auth';
import { validateEmail } from '@/utils/validation';

export default {
  data() {
    return {
      name: '',
      email: '',
      password: '',
      confirmPassword: '',
      signupErrorMeesage: '',
      requestErrorMessage: '',
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
    isRequestError() {
      return this.requestErrorMessage !== '';
    },
  },
  methods: {
    async submitSignupForm() {
      try {
        const userData = {
          name: this.name,
          email: this.email,
          password: this.password,
        };
        const result = await registerUser(userData);
        this.$store.commit('changeSuccessSignup');
        this.initSignupForm();
      } catch (error) {
        this.requestErrorMessage = error.response.data.message;
      }
    },
    initSignupForm() {
      this.name = '';
      this.email = '';
      this.password = '';
      this.confirmPassword = '';
    },
  },
};
</script>

<style></style>
