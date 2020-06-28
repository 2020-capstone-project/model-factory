<template>
  <v-row justify="center">
    <v-col cols="8">
      <v-container class="max-width">
        <v-pagination v-model="page" class="my-4" :length="15"></v-pagination>
      </v-container>
    </v-col>
  </v-row>
</template>

<script>
export default {
  data() {
    return {
      page: 1,
    };
  },
};
</script>

<style></style>
