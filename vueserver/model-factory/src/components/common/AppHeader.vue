<template>
  <v-app>
    <v-app-bar app color="blue darken-3" dark>
      <v-app-bar-nav-icon @click="changeDrawer"></v-app-bar-nav-icon>
      <v-toolbar-title class="px-2">Model Factory</v-toolbar-title>
      <v-icon class="px-1">mdi-factory</v-icon>
    </v-app-bar>
  </v-app>
</template>

<script>
export default {
  methods: {
    changeDrawer() {
      this.$store.commit('changeDrawer');
    },
  },
};
</script>

<style></style>
