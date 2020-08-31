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
        :disabled="!isSelectedTable"
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
// import { getfiles } from s'@/api/file';

export default {
  props: ['fileList'],
  data() {
    return {
      userId: this.$store.getters.getUserId,
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
      tables: this.fileList,
    };
  },
  methods: {
    before() {
      this.$store.commit('setDataSelectMenu', '');
    },
    selectTable() {
      this.$store.commit('setFileId', this.selected[0].id);
      this.$store.commit('nextSequence');
    },
  },
  computed: {
    isSelectedTable() {
      return this.selected.length == 1;
    },
  },
  watch: {
    fileList: function(newVal) {
      this.tables = newVal;
    },
  },
};
</script>

<style></style>
