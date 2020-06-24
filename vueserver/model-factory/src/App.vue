<template>
  <v-app>
    <HomeNavigation></HomeNavigation>

    <AppHeader></AppHeader>

    <v-main class="grey lighten-5">
      <v-container fluid fill-height>
        <router-view></router-view>
      </v-container>
    </v-main>

    <v-footer padless>
      <v-card
        flat
        tile
        width="100%"
        height="90"
        class="grey lighten-5 text-center"
      >
        <a
          href="https://github.com/2020-capstone-project/model-factory"
          class="s mt-3"
          style="text-decoration: none"
          icon
        >
          <v-icon size="40px" color="blue">mdi-github-circle</v-icon>
        </a>
        <v-card-text class="blue--text">
          2020 — <strong>Model Factory</strong>
        </v-card-text>
      </v-card>
    </v-footer>
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
