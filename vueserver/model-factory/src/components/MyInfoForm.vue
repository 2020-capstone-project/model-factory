<template>
  <v-card-text>
    <v-alert v-if="!isValid" type="error" class="ma-3">
      {{ errorMeesage }}
    </v-alert>
    <v-form @submit.prevent="submitAdjustForm">
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
        disabled=""
      ></v-text-field>

      <v-text-field
        label="Current Password"
        prepend-icon="mdi-lock"
        type="password"
        v-model="currentPassword"
      ></v-text-field>

      <v-text-field
        label="New Password"
        prepend-icon="mdi-lock"
        type="password"
        v-model="newPassword"
      ></v-text-field>

      <v-text-field
        label="Confirm Password"
        prepend-icon="mdi-check"
        type="password"
        v-model="confirmPassword"
      ></v-text-field>
      <v-card-actions>
        <v-alert v-if="isRequestError" type="error" class="ma-3">
          {{ requestMessage }}
        </v-alert>
        <v-spacer></v-spacer>
        <v-btn type="submit" :disabled="!isValid" color="primary"
          >Adjust
        </v-btn>
      </v-card-actions>
    </v-form>
  </v-card-text>
</template>

<script>
import { adjustInfo } from '@/api/info';
import { validateEmail } from '@/utils/validation';

export default {
  data() {
    return {
      name: this.$store.getters.getName,
      email: this.$store.getters.getEmail,
      currentPassword: '',
      newPassword: '',
      confirmPassword: '',
      errorMeesage: '',
      requestMessage: '',
    };
  },
  computed: {
    isValid() {
      if (!this.name) {
        // eslint-disable-next-line vue/no-side-effects-in-computed-properties
        this.errorMeesage = '이름을 반드시 입력해주세요';
      } else if (!this.email) {
        // eslint-disable-next-line vue/no-side-effects-in-computed-properties
        this.errorMeesage = '이메일을 반드시 입력해주세요';
      } else if (!validateEmail(this.email)) {
        // eslint-disable-next-line vue/no-side-effects-in-computed-properties
        this.errorMeesage = '이메일을 올바르게 작성해주세요';
      } else if (!this.currentPassword) {
        // eslint-disable-next-line vue/no-side-effects-in-computed-properties
        this.errorMeesage = '현재 비밀번호를 반드시 입력해주세요.';
      } else if (!this.newPassword) {
        // eslint-disable-next-line vue/no-side-effects-in-computed-properties
        this.errorMeesage = '새로운 비밀번호를 반드시 입력해주세요.';
      } else if (this.newPassword !== this.confirmPassword) {
        // eslint-disable-next-line vue/no-side-effects-in-computed-properties
        this.errorMeesage =
          '새로운 비밀번호와 비밀번호 확인이 일치하지 않습니다.';
      } else {
        // eslint-disable-next-line vue/no-side-effects-in-computed-properties
        this.errorMeesage = '';
      }
      return this.errorMeesage === '';
    },
    isRequestError() {
      return this.requestMessage !== '';
    },
  },
  methods: {
    async submitAdjustForm() {
      try {
        const userData = {
          name: this.name,
          email: this.email,
          currentPassword: this.currentPassword,
          newPassword: this.newPassword,
        };
        // const result = await adjustInfo(userData);
        // this.$store.commit('changeSuccessAdjust');
        await this.$store.dispatch('ADJUST', userData);
        this.initAdjustForm();
      } catch (error) {
        this.requestMessage = error.response.data.message;
      }
    },
    initAdjustForm() {
      this.name = '';
      this.email = '';
      this.currentPassword = '';
      this.newPassword = '';
    },
  },
};
</script>

<style></style>
