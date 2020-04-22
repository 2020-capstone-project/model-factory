<template>
  <v-layout align-center justify-center>
    <v-card class="elevation-12">
      <v-card class="elevation-12" width="800px">
        <v-toolbar color="primary" dark flat>
          <v-toolbar-title>My Info</v-toolbar-title>
          <v-spacer></v-spacer>
        </v-toolbar>
        <template v-if="!$store.getters.getSuccessAdjust">
          <MyInfoForm></MyInfoForm>
        </template>
        <template v-if="$store.getters.getSuccessAdjust">
          <AdjustSuccess></AdjustSuccess>
        </template>
      </v-card>
    </v-card>
  </v-layout>
</template>

<script>
import MyInfoForm from '@/components/MyInfoForm.vue';
import AdjustSuccess from '@/components/AdjustSuccess.vue';

export default {
  components: {
    MyInfoForm,
    AdjustSuccess,
  },
};
</script>

<style></style>
