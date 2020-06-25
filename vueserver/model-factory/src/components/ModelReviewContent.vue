<template>
  <v-container>
    <v-row justify="center" align="center" class="mt-5">
      <v-btn color="grey text-white" @click="before">
        before
      </v-btn>
      <v-col col="1"></v-col>
      <v-btn color="primary" @click="next" class="ml-5">
        Continue
      </v-btn>
    </v-row>
  </v-container>
</template>

<script>
export default {
  methods: {
    before() {
      this.$store.commit('beforeSequence');
    },
    next() {
      this.$store.commit('nextSequence');
    },
  },
};
</script>

<style></style>
