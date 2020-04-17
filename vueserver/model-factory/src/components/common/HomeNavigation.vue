<template>
  <v-app>
    <v-navigation-drawer app v-model="drawer" color="white">
      <v-list dense nav class="py-0">
        <v-list-item two-line :class="'px-0'">
          <v-list-item-avatar>
            <v-icon>mdi-account-circle</v-icon>
          </v-list-item-avatar>
          <v-list-item-content>
            <v-list-item-title>Email</v-list-item-title>
            <v-list-item-subtitle>Name</v-list-item-subtitle>
          </v-list-item-content>
        </v-list-item>
        <v-list-item v-for="item in items" :key="item.title" link>
          <v-list-item-icon>
            <v-icon>{{ item.icon }}</v-icon>
          </v-list-item-icon>

          <v-list-item-content>
            <v-list-item-title>{{ item.title }}</v-list-item-title>
          </v-list-item-content>
        </v-list-item>

        <v-divider></v-divider>
      </v-list>
    </v-navigation-drawer>
  </v-app>
</template>

<script>
export default {
  data: () => {
    return {
      drawer: this.$store.state.drawer,
      items: [
        { title: 'Home', icon: 'mdi-home' },
        { title: 'Login', icon: 'mdi-login' },
        { title: 'Logout', icon: 'mdi-logout' },
        { title: 'My Info', icon: 'mdi-information' },
        { title: 'Sign Up', icon: 'mdi-account-plus' },
      ],
    };
  },
};
</script>

<style></style>
