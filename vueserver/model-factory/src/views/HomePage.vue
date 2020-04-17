<template>
  <v-app>
    <HomeNavigation></HomeNavigation>
    <AppHeader></AppHeader>

    <v-content>
      <v-container>
        <!-- <router-view></router-view> -->
      </v-container>
    </v-content>

    <v-footer app>
      <!-- -->
    </v-footer>
    <!-- <v-dialog v-model="dialog" width="800px"> -->
    <!-- <SignupDialog></SignupDialog> -->
    <!-- </v-dialog> -->
  </v-app>
</template>

<script>
import SignupDialog from '@/views/SignupDialog.vue';
import HomeNavigation from '@/components/common/HomeNavigation.vue';
import AppHeader from '@/components/common/AppHeader.vue';

export default {
  components: {
    HomeNavigation,
    AppHeader,
  },

  data: () => {
    return {
      drawer: $store.state.drawer,
      dialog: false,
    };
  },
};
</script>
