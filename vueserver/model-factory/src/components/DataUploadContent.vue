<template>
  <v-container>
    <v-row justify="center" align="center">
      <v-col cols="12">
        <v-row>
          <h3>파일 예시</h3>
          <p class="font-italic mt-2 ml-2">
            (1행: 컬럼명, 2행: 컬럼 설명, N행: 데이터)
          </p>
        </v-row>
        <v-row>
          <v-col cols="12">
            <v-alert type="error">
              파일 형식이 잘못되었습니다.
            </v-alert>
          </v-col>
        </v-row>
        <v-row justify="center" align="center">
          <v-col cols="12">
            <v-simple-table style="border: 0.1px solid grey">
              <thead>
                <tr>
                  <th v-for="title in titles" :key="title">{{ title }}</th>
                </tr>
              </thead>
              <tbody>
                <tr v-for="list in dataList" :key="list">
                  <td v-for="element in list" :key="element">{{ element }}</td>
                </tr>
              </tbody>
            </v-simple-table>
          </v-col>
          <v-row justify="center" align="center" class="mt-7">
            <v-col cols="10">
              <v-file-input
                v-model="file"
                show-size
                accept=".csv"
                label="파일(.csv)을 업로드 해주세요."
                dense
              ></v-file-input>
            </v-col>
          </v-row>
        </v-row>
      </v-col>
    </v-row>
    <v-row justify="center" align="center" class="mt-5">
      <v-btn color="grey text-white" @click="before">
        before
      </v-btn>
      <v-col cols="1"></v-col>
      <v-btn
        color="primary"
        :disabled="!isUploadFile"
        :click="() => {}"
        class="ml-5"
        >upload</v-btn
      >
    </v-row>
  </v-container>
</template>

<script>
export default {
  data() {
    return {
      file: null,
      titles: [
        '임신 횟수',
        '혈장 포도당 농도',
        '이완기 혈압',
        '삼두근 피부 두께',
        '혈청 인슐린',
        '체질량 지수',
        '당뇨 직계 가족력',
        '나이',
        '당뇨병 발병 여부',
      ],
      dataList: [
        [
          '임신 횟수',
          '경구 포도당 내성 검사에서 2시간 동안의 혈장 포도당 농도',
          '이완기 혈압(mm/Hg)',
          '삼두근 피부 두겹 두께(mm)',
          '2시간 혈청 인슐린 (mu U/ml)',
          '체질량 지수',
          '당뇨 직계 가족력',
          '나이(세)',
          '5년 이내 당뇨병 발병 여부',
        ],
        [6, 148, 72, 35, 0, 33.6, 0.627, 50, 1],
      ],
    };
  },
  methods: {
    before() {
      this.$store.commit('setDataSelectMenu', '');
    },
  },
  computed: {
    isUploadFile() {
      return this.file !== null;
    },
  },
};
</script>

<style></style>
