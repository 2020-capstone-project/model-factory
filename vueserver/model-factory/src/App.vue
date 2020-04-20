<template>
  <v-app>
    <HomeNavigation></HomeNavigation>

    <AppHeader></AppHeader>

    <v-content>
      <v-container fluid fill-height>
        <router-view></router-view>
      </v-container>
    </v-content>
  </v-app>
</template>

<script>
import HomeNavigation from '@/components/common/HomeNavigation.vue';
import AppHeader from '@/components/common/AppHeader.vue';

export default {
  name: 'App',
  components: {
    HomeNavigation,
    AppHeader,
  },
};
</script>
