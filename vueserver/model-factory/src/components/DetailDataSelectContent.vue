<template>
  <v-container fluid>
    <v-row justify="center" align="center">
      <v-col cols="12">
        <v-alert v-if="!isValid" type="error" class="mb-5">
          {{ errorMessage }}
        </v-alert>
        <v-card>
          <v-card-title class="text-h4">
            상세 데이터 선택
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
            v-if="isSelectedTable"
            :headers="headers"
            :items="columns"
            item-key="name"
            :search="search"
          >
            <template v-slot:item.learningTarget="{ item }">
              <v-simple-checkbox
                single
                v-model="item.learningTarget"
              ></v-simple-checkbox>
            </template>
            <template v-slot:item.remove="{ item }">
              <v-icon medium @click="deleteItem(item)">
                mdi-delete
              </v-icon>
            </template>
          </v-data-table>
        </v-card>
      </v-col>
    </v-row>
    <v-row justify="center" align="center" class="mt-5">
      <v-btn color="grey text-white" @click="before">
        before
      </v-btn>
      <v-col col="1"></v-col>
      <v-btn color="primary" @click="next" class="ml-5">
        Continue
      </v-btn>
    </v-row>
  </v-container>
</template>

<script>
import { getColumns } from '@/api/file';

export default {
  data() {
    return {
      search: '',
      selected: [],
      headers: [
        {
          text: '컬럼 명',
          align: 'start',
          sortable: false,
          value: 'name',
        },
        { text: '컬럼 설명', value: 'description' },
        { text: '예시 데이터', value: 'data' },
        { text: '학습 목표 컬럼', value: 'learningTarget', sortable: false },
        { text: '컬럼 삭제', value: 'remove', sortable: false },
      ],
      columns: [],
      valid: false,
      errorMessage: '학습 목표 컬럼을 반드시 선택해주세요.',
    };
  },
  computed: {
    isSelectedTable() {
      if (this.$store.getters.getFileId != -1) {
        this.fetchData();
      }
      return true;
    },
    isValid() {
      return this.valid;
    },
  },
  methods: {
    async fetchData() {
      const { data } = await getColumns(this.$store.getters.getFileId);
      data.forEach(element => {
        element.learningTarget = false;
      });
      this.columns = data;
    },
    deleteItem(item) {
      const index = this.columns.indexOf(item);
      confirm('컬럼을 삭제하시겠습니까?') && this.columns.splice(index, 1);
    },
    before() {
      this.$store.commit('setFileId', -1);
      this.$store.commit('beforeSequence');
    },
    next() {
      var inputColumns = [];
      var outputColumns = [];
      this.columns.forEach(element => {
        if (element.learningTarget) inputColumns.push(element.name);
        else outputColumns.push(element.name);
      });
      if (outputColumns.length < 1) {
        this.valid = false;
        this.errorMessage = '학습 목표 컬럼을 반드시 선택해주세요.';
        return;
      } else if (inputColumns.length < 1) {
        this.valid = false;
        this.errorMessage = '두 개 이상의 컬럼을 반드시 사용해주세요.';
        return;
      } else this.valid = true;
      this.$store.commit('nextSequence');
      this.$store.commit('setInputColumns', inputColumns);
      this.$store.commit('setOutputColumns', outputColumns);
    },
  },
  updated() {},
};
</script>

<style></style>
