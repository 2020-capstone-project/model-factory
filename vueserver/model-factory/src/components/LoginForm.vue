<template>
  <v-card-text>
    <v-alert v-if="!isSignupValid" type="error" class="ma-3">
      {{ loginErrorMeesage }}
    </v-alert>
    <v-form @submit.prevent="submitSignupForm">
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

      <v-card-actions>
        <v-alert v-if="isRequestError" type="error" class="ma-3">
          {{ requestErrorMessage }}
        </v-alert>
        <v-spacer></v-spacer>
        <v-btn type="submit" :disabled="!isSignupValid" color="primary"
          >Login</v-btn
        >
      </v-card-actions>
    </v-form>
  </v-card-text>
</template>

<script>
import { loginUser } from '@/api/auth';
import { validateEmail } from '@/utils/validation';

export default {
  data() {
    return {
      email: '',
      password: '',
      loginErrorMeesage: '',
      requestErrorMessage: '',
    };
  },
  computed: {
    isSignupValid() {
      if (!this.email) {
        // eslint-disable-next-line vue/no-side-effects-in-computed-properties
        this.loginErrorMeesage = '이메일을 반드시 입력해주세요';
      } else if (!validateEmail(this.email)) {
        // eslint-disable-next-line vue/no-side-effects-in-computed-properties
        this.loginErrorMeesage = '이메일을 올바르게 작성해주세요';
      } else if (!this.password) {
        // eslint-disable-next-line vue/no-side-effects-in-computed-properties
        this.loginErrorMeesage = '비밀번호를 반드시 입력해주세요.';
      } else {
        // eslint-disable-next-line vue/no-side-effects-in-computed-properties
        this.loginErrorMeesage = '';
      }
      return this.loginErrorMeesage === '';
    },
    isRequestError() {
      return this.requestErrorMessage !== '';
    },
  },
  methods: {
    async submitSignupForm() {
      try {
        const userData = {
          email: this.email,
          password: this.password,
        };
        // const result = await loginUser(userData);
        await this.$store.dispatch('LOGIN', userData);
        this.initSignupForm();
        this.$router.push('/home');
      } catch (error) {
        console.log(error.response.data.message);
        this.requestErrorMessage = error.response.data.message;
      }
    },
    initSignupForm() {
      this.email = '';
      this.password = '';
    },
  },
};
</script>

<style></style>
