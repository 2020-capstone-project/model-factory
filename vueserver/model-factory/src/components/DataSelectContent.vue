<template>
  <div>
    <v-card class="mb-12" color="grey lighten-3">
      <v-col cols="16" xl="14" md="12">
        <v-row justify="center">
          <v-col cols="6" md="3" lg="3" xl="2">
            <v-card
              height="500"
              width="400"
              class="text-center"
              shaped
              elevation="15"
            >
              <v-row justify="center" align="center">
                <v-img
                  src="../../public/img/clip.png"
                  max-width="100"
                  class="mt-16 mb-15"
                ></v-img>
                <v-card-text>
                  <p class="text-h5 text--primary">
                    새로운 데이터 업로드
                  </p>
                  <div class="text-subtitle-1">
                    내 컴퓨터에서 데이터 파일(CSV)을 업로드
                  </div>
                </v-card-text>
                <v-card-actions class="justify-right mt-10">
                  <v-btn depressed large color="primary text-white"
                    >data upload</v-btn
                  >
                </v-card-actions>
              </v-row>
            </v-card>
          </v-col>
          <v-col cols="6" md="3" lg="3" xl="2">
            <v-card
              height="500"
              width="400"
              class="text-center justify-center align-center"
              shaped
              elevation="15"
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
                <v-card-actions class="justify-center mt-10">
                  <v-btn depressed large color="primary text-white"
                    >data load</v-btn
                  >
                </v-card-actions>
              </v-row>
            </v-card>
          </v-col>
        </v-row>
      </v-col>
    </v-card>
    <v-btn
      color="primary"
      @click="$store.commit('setSequence', $store.getters.getSequence + 1)"
    >
      Continue
    </v-btn>
  </div>
</template>

<script>
export default {};
</script>

<style></style>
