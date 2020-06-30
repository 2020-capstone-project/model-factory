<template>
  <v-container>
    <v-alert text color="primary" outlined>
      <v-img
        src="../../public/img/recommend.png"
        max-width="100"
        class="ma-15 float-left"
      ></v-img>
      <v-col>
        <v-row align="center" class="mt-10">
          <v-col>
            <h3 class="headline">추천 학습 모델</h3>
            학습 데이터들과 목표 변수들을 고려하여 학습 모델을 추천해줍니다.
            <v-row justify="end" class="mr-10">
              <v-col cols="1">
                <v-btn color="info" outlined @click="next('recommend')">
                  select
                </v-btn>
              </v-col>
            </v-row>
          </v-col>
        </v-row>
      </v-col>
    </v-alert>

    <v-alert text color="primary" outlined>
      <v-img
        src="../../public/img/customizing.png"
        max-width="100"
        class="ma-15 float-left"
      ></v-img>
      <v-col>
        <v-row align="center" class="mt-10">
          <v-col>
            <h3 class="headline">모델 커스터마이징</h3>
            하이퍼 파라미터와 레이어를 직접 구성하여 모델을 커스터마이징 할 수
            있습니다.
            <v-row justify="end" class="mr-10">
              <v-col cols="1">
                <v-btn color="info" outlined @click="next('customize')">
                  select
                </v-btn>
              </v-col>
            </v-row>
          </v-col>
        </v-row>
      </v-col>
    </v-alert>

    <v-row justify="center" align="center" class="mt-5">
      <v-btn color="grey text-white" @click="before">
        before
      </v-btn>
    </v-row>
  </v-container>
</template>

<script>
export default {
  methods: {
    before() {
      this.$store.commit('beforeSequence');
    },
    next(select) {
      this.$store.commit('setIsSelectModel', select);
      this.$store.commit('nextSequence');
    },
  },
};
</script>

<style></style>
