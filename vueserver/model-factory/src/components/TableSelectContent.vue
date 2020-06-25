<template>
  <v-container fluid>
    <v-row justify="center" align="center">
      <v-col cols="12">
        <v-alert v-if="!isSelectedTable" type="error" class="mb-5">
          테이블을 반드시 선택해주세요.
        </v-alert>
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
            :items="tables"
            :single-select="true"
            item-key="name"
            :search="search"
            show-select
          >
          </v-data-table>
        </v-card>
      </v-col>
    </v-row>
    <v-row justify="center" align="center" class="mt-5">
      <v-btn color="grey text-white" @click="before">
        before
      </v-btn>
      <v-col col="1"></v-col>
      <v-btn
        :loading="loading"
        :disabled="!isSelectedTable || loading"
        color="primary"
        @click="selectTable"
        class="ml-5"
      >
        Continue
      </v-btn>
    </v-row>
  </v-container>
</template>

<script>
import { getfiles } from '@/api/file';

export default {
  data() {
    return {
      loading: false,
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
      tables: [],
    };
  },
  methods: {
    before() {
      this.$store.commit('setDataSelectMenu', '');
    },
    async fetchData() {
      const { data } = await getfiles();
      this.tables = data;
    },
    selectTable() {
      this.$store.commit('setFileId', this.selected[0].id);
      this.loading = true;
      setTimeout(() => {
        this.$store.commit('nextSequence');
        this.loading = false;
      }, 500);
    },
  },
  computed: {
    isSelectedTable() {
      return this.selected.length == 1;
    },
  },
  created() {
    this.fetchData();
  },
};
</script>

<style></style>
