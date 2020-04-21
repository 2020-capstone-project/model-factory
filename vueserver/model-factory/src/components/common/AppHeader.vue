<template>
  <v-app-bar
    :clipped-left="$vuetify.breakpoint.lgAndUp"
    app
    color="blue darken-3"
    dark
  >
    <v-toolbar-title style="width: 300px" class="ml-0">
      <v-app-bar-nav-icon @click.stop="changeDrawer"></v-app-bar-nav-icon>
      <span class="hidden-sm-and-down">Model Factory</span>
      <v-icon class="mx-2">mdi-factory</v-icon>
    </v-toolbar-title>
  </v-app-bar>
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
