<template>
  <v-container>
    <v-alert text color="primary" outlined>
      <v-img
        src="../../public/img/recommend.png"
        max-width="100"
        class="ma-15 float-left"
      ></v-img>
      <v-row align="center">
        <v-col>
          <h3 class="headline">추천 학습 모델</h3>
          설명
          <v-row justify="end" class="mr-10">
            <v-col cols="1">
              <v-btn color="info" outlined @click="next">
                select
              </v-btn>
            </v-col>
          </v-row>
        </v-col>
      </v-row>
    </v-alert>

    <v-alert text color="primary" outlined>
      <v-img
        src="../../public/img/customizing.png"
        max-width="100"
        class="ma-15 float-left"
      ></v-img>
      <v-row align="center">
        <v-col>
          <h3 class="headline">모델 커스터마이징</h3>
          설명
          <v-row justify="end" class="mr-10">
            <v-col cols="1">
              <v-btn color="info" outlined @click="next">
                select
              </v-btn>
            </v-col>
          </v-row>
        </v-col>
      </v-row>
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
    next() {
      this.$store.commit('nextSequence');
    },
  },
};
</script>

<style></style>
