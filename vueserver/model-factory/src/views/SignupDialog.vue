<template>
  <v-dialog v-model="$store.state.signupDialog" width="800px">
    <v-card class="elevation-12">
      <v-toolbar color="primary" dark flat>
        <v-toolbar-title>Sign up</v-toolbar-title>
        <v-spacer></v-spacer>
      </v-toolbar>
      <SignupForm></SignupForm>
    </v-card>
    <!-- <v-alert
        :value="$store.state.successSignupAlert"
        color="green"
        dark
        center
        width="300px"
        border="top"
        icon="mdi-check"
        transition="scale-transition"
      >
        회원 가입이 완료되었습니다.
      </v-alert> -->
  </v-dialog>
</template>

<script>
import SignupForm from '@/components/SignupForm.vue';
import { registerUser } from '@/api/auth';
import { validateEmail } from '@/utils/validation';

export default {
  components: {
    SignupForm,
  },
};
</script>

<style></style>
