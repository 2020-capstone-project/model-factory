<template>
  <div>
    <v-card class="mb-12" color="grey lighten-3"> prediction </v-card>
    <v-btn
      color="grey text-white"
      @click="$store.commit('setSequence', $store.getters.getSequence - 1)"
    >
      before
    </v-btn>
    <v-btn
      color="primary"
      @click="$store.commit('setSequence', $store.getters.getSequence + 1)"
      class="ml-5"
    >
      Continue
    </v-btn>
  </div>
</template>

<script>
export default {};
</script>

<style></style>
