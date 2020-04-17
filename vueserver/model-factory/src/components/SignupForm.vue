<template>
  <v-card class="elevation-12">
    <v-toolbar color="primary" dark flat>
      <v-toolbar-title>Sign up</v-toolbar-title>
      <v-spacer></v-spacer>
    </v-toolbar>
    <v-card-text>
      <v-form>
        <v-text-field
          label="Name"
          name="login"
          prepend-icon="mdi-account"
          type="text"
        ></v-text-field>

        <v-text-field
          label="Email"
          name="login"
          prepend-icon="mdi-email"
          type="text"
        ></v-text-field>

        <v-text-field
          id="password"
          label="Password"
          name="password"
          prepend-icon="mdi-lock"
          type="password"
        ></v-text-field>

        <v-text-field
          id="password"
          label="Confirm Password"
          name="password"
          prepend-icon="mdi-check"
          type="password"
        ></v-text-field>
      </v-form>
    </v-card-text>
    <v-card-actions>
      <v-spacer></v-spacer>
      <v-btn color="primary">Create</v-btn>
    </v-card-actions>
  </v-card>
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
    };
  },
};
</script>

<style></style>
