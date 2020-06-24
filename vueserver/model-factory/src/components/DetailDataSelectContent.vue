<template>
  <v-container fluid>
    <v-row justify="center" align="center">
      <v-col cols="12">
        <v-card>
          <v-card-title class="text-h4">
            테이블 선택
            <v-spacer></v-spacer>
            <v-text-field
              v-model="search"
              append-icon="mdi-magnify"
              label="Search"
              single-line
              hide-details
            ></v-text-field>
          </v-card-title>

          <v-data-table
            v-model="selected"
            :headers="headers"
            :items="desserts"
            :single-select="true"
            item-key="name"
            :search="search"
            show-select
          >
          </v-data-table>
        </v-card>
      </v-col>
    </v-row>

    <v-col cols="">
      <v-row justify="center">
        <v-col cols="5">
          <v-btn
            color="grey text-white"
            @click="
              $store.commit('setSequence', $store.getters.getSequence - 1)
            "
          >
            before
          </v-btn>
          <v-btn
            color="primary"
            @click="
              $store.commit('setSequence', $store.getters.getSequence + 1)
            "
            class="ml-5"
          >
            Continue
          </v-btn>
        </v-col>
      </v-row>
    </v-col>
  </v-container>
</template>

<script>
export default {
  data() {
    return {
      search: '',
      selected: [],
      headers: [
        {
          text: '테이블 명',
          align: 'start',
          sortable: false,
          value: 'name',
        },
        { text: '테이블 설명', value: 'description' },
      ],
      desserts: [
        {
          name: '테이블 명 1',
          description: '설명 1',
        },
        {
          name: '테이블 명 2',
          description: '설명 2',
        },
      ],
    };
  },
};
</script>

<style></style>
