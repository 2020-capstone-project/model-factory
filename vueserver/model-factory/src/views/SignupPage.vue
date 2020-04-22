<script src="../store/index.js"></script>
<template>
  <v-layout align-center justify-center>
    <v-card class="elevation-12">
      <v-card class="elevation-12" width="800px">
        <v-toolbar color="primary" dark flat>
          <v-toolbar-title>Sign up</v-toolbar-title>
          <v-spacer></v-spacer>
        </v-toolbar>
        <template v-if="!$store.getters.getSuccessSignup">
          <SignupForm></SignupForm>
        </template>
        <template v-if="$store.getters.getSuccessSignup">
          <SignupSuccess></SignupSuccess>
        </template>
      </v-card>
    </v-card>
  </v-layout>
</template>

<script>
import SignupForm from '@/components/SignupForm.vue';
import SignupSuccess from '@/components/SignupSuccess.vue';

export default {
  components: {
    SignupForm,
    SignupSuccess,
  },
};
</script>

<style></style>
