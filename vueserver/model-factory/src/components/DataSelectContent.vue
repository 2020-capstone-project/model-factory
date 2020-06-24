<template>
  <v-container>
    <v-row style="height: 800px;" justify="center" align="center">
      <v-col cols="4">
        <v-card class="text-center" shaped elevation="15" height="500">
          <v-row justify="center" align="center">
            <v-img
              src="../../public/img/clip.png"
              max-width="100"
              class="mt-16 mb-15"
            />
            <v-card-text>
              <p class="text-h5 text--primary">
                새로운 데이터 업로드
              </p>
              <div class="text-subtitle-1">
                내 컴퓨터에서 데이터 파일(CSV)을 업로드
              </div>
            </v-card-text>
            <v-btn depressed large color="primary text-white" class="mt-11"
              >data upload</v-btn
            >
          </v-row>
        </v-card>
      </v-col>
      <v-col cols="1"></v-col>
      <v-col cols="4">
        <v-card
          class="text-center justify-center align-center"
          shaped
          elevation="15"
          height="500"
        >
          <v-row justify="center" align="center">
            <v-img
              src="../../public/img/db.png"
              max-width="100"
              class="mt-16 mb-15"
            ></v-img>
            <v-card-text>
              <p class="text-h5 text--primary">
                기존 데이터 불러오기
              </p>
              <div class=" text-subtitle-1">
                데이터베이스에서 기존 데이터 불러오기
              </div>
            </v-card-text>
            <v-btn depressed large color="primary text-white" class="mt-11"
              >data load</v-btn
            >
          </v-row>
        </v-card>
      </v-col>
    </v-row>
    <v-row justify="center">
      <v-btn
        color="primary"
        @click="$store.commit('setSequence', $store.getters.getSequence + 1)"
      >
        Continue
      </v-btn>
    </v-row>
  </v-container>
</template>

<script>
export default {};
</script>

<style></style>
