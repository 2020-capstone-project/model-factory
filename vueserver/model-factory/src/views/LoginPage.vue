<template>
  <v-layout align-center justify-center mt-15>
    <v-card class="elevation-12">
      <v-card class="elevation-12" width="800px">
        <v-toolbar color="primary" dark flat>
          <v-toolbar-title>Login</v-toolbar-title>
          <v-spacer></v-spacer>
        </v-toolbar>
        <template>
          <LoginForm></LoginForm>
        </template>
      </v-card>
    </v-card>
  </v-layout>
</template>

<script>
import LoginForm from '@/components/LoginForm.vue';

export default {
  components: {
    LoginForm,
  },
};
</script>

<style></style>
