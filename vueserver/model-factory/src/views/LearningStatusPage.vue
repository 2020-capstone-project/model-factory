<template>
  <v-container fluid>
    <v-row justify="center" align="center">
      <v-col cols="10">
        <v-card>
          <v-data-table
            :headers="headers"
            :items="statusList"
            :search="search"
            sort-by="calories"
            class="elevation-1"
          >
            <template v-slot:top>
              <v-toolbar flat color="primary">
                <v-toolbar-title class="text-white text-h5"
                  >Learning Status</v-toolbar-title
                >
              </v-toolbar>
              <v-text-field
                v-model="search"
                label="찾으실 학습명을 입력해주세요."
                class="mx-4"
              ></v-text-field>
            </template>
            <template v-slot:item.tools="{ item }">
              <v-icon large class="ml-3" @click="editItem(item)">
                mdi-note-outline
              </v-icon>
            </template>
            <template v-slot:no-data>
              <v-btn color="primary" @click="fetchData">Reset</v-btn>
            </template>
          </v-data-table>
        </v-card>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import { getList } from '@/api/learningStatus';

export default {
  data: () => ({
    search: '',
    dialog: false,
    headers: [
      {
        text: '학습명',
        align: 'start',
        sortable: false,
        value: 'name',
      },
      { text: '학습 시작 날짜', value: 'learningDate' },
      { text: '학습 상태', value: 'learningState' },
      { text: '학습 진행률(%)', value: 'learningProgress' },
      { text: '모델 정확도(%)', value: 'accuracy' },
      { text: '자세히 보기', value: 'tools', sortable: false },
    ],
    statusList: [],
  }),

  computed: {},

  created() {
    this.fetchData();
  },

  methods: {
    async fetchData() {
      try {
        const { data } = await getList(this.$store.getters.getMemberId);
        this.statusList = data;
      } catch (error) {
        // TODO 예외 처리: 메시지로 표시
      }
    },
    editItem(item) {
      this.editedIndex = this.statusList.indexOf(item);
      this.editedItem = Object.assign({}, item);
      this.dialog = true;
    },
  },
};
</script>

<style></style>
