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
        <v-row v-if="errorMessage !== ''">
          <v-col cols="12">
            <v-alert type="error">
              {{ errorMessage }}
            </v-alert>
          </v-col>
        </v-row>
        <v-row justify="center" align="center">
          <v-col cols="12">
            <v-simple-table style="border: 0.1px solid grey">
              <thead>
                <tr>
                  <th v-for="title in titles" :key="title.num">
                    {{ title.text }}
                  </th>
                </tr>
              </thead>
              <tbody>
                <tr v-for="list in dataList" :key="list.num">
                  <td v-for="element in list.text" :key="element.num">
                    {{ element.text }}
                  </td>
                </tr>
              </tbody>
            </v-simple-table>
          </v-col>
        </v-row>
        <v-row justify="center" class="mt-2">
          <v-col cols="6">
            <v-switch
              v-model="isPublic"
              :label="`파일 공개 여부 : ${isPublicValue}`"
            ></v-switch>
          </v-col>
        </v-row>
        <v-row justify="center" class="mt-7">
          <v-col cols="6">
            <v-file-input
              enctype="multipart/form-data"
              name="file"
              v-model="csv.file"
              show-size
              accept=".csv"
              label="파일(.csv)을 업로드 해주세요."
              dense
            ></v-file-input>
          </v-col>
        </v-row>
      </v-col>
    </v-row>
    <v-row justify="center">
      <v-col cols="6">
        <v-text-field
          v-model="fileDescription"
          label="파일 설명을 입력해주세요."
          :rules="rules"
          outlined
        ></v-text-field>
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
        @click="upload"
        class="ml-5"
        >upload</v-btn
      >
    </v-row>
  </v-container>
</template>

<script>
import { uploadFile } from '@/api/upload';

function numberingList(list) {
  var i = 1;
  return list.map(function(element) {
    return {
      num: i++,
      text: element,
    };
  });
}

export default {
  data() {
    return {
      errorMessage: '',
      isPublic: false,
      fileDescription: '',
      rules: [value => !!value || '파일 설명을 반드시 입력해주세요.'],
      csv: {
        file: null,
      },
      titles: numberingList([
        '임신 횟수',
        '혈장 포도당 농도',
        '이완기 혈압',
        '삼두근 피부 두께',
        '혈청 인슐린',
        '체질량 지수',
        '당뇨 직계 가족력',
        '나이',
        '당뇨병 발병 여부',
      ]),
      dataList: numberingList([
        numberingList([
          '임신 횟수',
          '경구 포도당 내성 검사에서 2시간 동안의 혈장 포도당 농도',
          '이완기 혈압(mm/Hg)',
          '삼두근 피부 두겹 두께(mm)',
          '2시간 혈청 인슐린 (mu U/ml)',
          '체질량 지수',
          '당뇨 직계 가족력',
          '나이(세)',
          '5년 이내 당뇨병 발병 여부',
        ]),
        numberingList([6, 148, 72, 35, 0, 33.6, 0.627, 50, 1]),
      ]),
    };
  },
  methods: {
    before() {
      this.$store.commit('setDataSelectMenu', '');
    },
    async upload() {
      try {
        let userEmail = this.getUserEmail();
        if (userEmail == null) return;

        let formData = new FormData();
        formData.append('file', this.csv.file);

        // let info = {
        //   email: userEmail,
        //   isPublic: this.isPublic,
        //   description: this.fileDescription,
        // };

        formData.append('email', userEmail);
        formData.append('isPublic', this.isPublic);
        formData.append('description', this.fileDescription);
        const result = await uploadFile(formData);
        console.log(result);
      } catch (error) {
        this.errorMessage = error.response.data.message;
        console.log(error.response.data.message);
      }
    },
    getUserEmail() {
      let userEmail = this.$store.getters.getEmail;
      if (userEmail === '') {
        this.errorMessage = '반드시 로그인을 해주세요.';
        return null;
      }
      return userEmail;
    },
  },
  computed: {
    isUploadFile() {
      return this.csv.file !== null && this.fileDescription !== '';
    },
    isPublicValue() {
      return this.isPublic == true ? '공개' : '비공개';
    },
  },
};
</script>

<style></style>
