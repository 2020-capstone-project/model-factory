<template>
  <v-container fluid>
    <v-row justify="center">
      <v-col cols="3">
        <v-alert border="left" colored-border color="blue" elevation="2">
          <div class="ml-4">
            <h3 class="blue--text mb-1">학습명</h3>
            <h2>당뇨병 발병 여부 예측 모델</h2>
          </div>
        </v-alert>
      </v-col>
      <v-col cols="3">
        <v-alert border="left" colored-border color="indigo" elevation="2">
          <div class="ml-4">
            <h3 class="indigo--text mb-1">학습 시작 날짜</h3>
            <h2>2020.01.01 00:00</h2>
          </div>
        </v-alert>
      </v-col>
      <v-col cols="3">
        <v-alert border="left" colored-border color="teal" elevation="2">
          <div class="ml-4">
            <h3 class="teal--text mb-1">학습 진행률</h3>
            <v-progress-linear
              color="teal"
              :value="learningProgress"
              height="35"
              rounded
            >
              <strong class="white--text">70%</strong>
            </v-progress-linear>
          </div>
        </v-alert>
      </v-col>
      <v-col cols="3">
        <v-alert border="left" colored-border color="purple" elevation="2">
          <div class="ml-4">
            <h3 class="purple--text mb-1">학습 정확도</h3>
            <v-progress-linear color="purple" :value="accuracy" height="35">
              <strong class="white--text">78%</strong>
            </v-progress-linear>
          </div>
        </v-alert>
      </v-col>
    </v-row>
    <v-row justify="center">
      <v-col cols="12">
        <v-card elevation="10" class="primary" primary dark>
          <v-card-title>
            Learning Graph
          </v-card-title>
          <v-card-text class="white text-primary">
            asd
          </v-card-text>
        </v-card>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
export default {
  data: () => ({
    learningProgress: 70,
    accuracy: 78,
  }),
};
</script>

<style></style>
