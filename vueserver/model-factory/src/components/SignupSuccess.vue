<template>
  <v-card-text>
    <v-alert
      :value="$store.state.successSignupAlert"
      color="green"
      dark
      border="top"
      icon="mdi-check"
      transition="scale-transition"
      :class="`d-flex justify-center`"
      class="ma-4"
    >
      회원 가입이 완료되었습니다.
    </v-alert>
    <v-card-actions>
      <v-spacer></v-spacer>
      <v-btn color="normal" @click="pushHomePage">Home</v-btn>
      <v-spacer></v-spacer>
    </v-card-actions>
  </v-card-text>
</template>

<script>
export default {
  methods: {
    pushHomePage() {
      this.$router.push('/home');
      this.$store.commit('changeSuccessSignup');
    },
  },
};
</script>

<style></style>
