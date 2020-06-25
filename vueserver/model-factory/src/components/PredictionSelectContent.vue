<template>
  <v-container>
    <v-row style="height: 600px;" justify="center" align="center">
      <v-col cols="4">
        <v-card class="text-center" elevation="15" height="500">
          <v-row justify="center" align="center">
            <v-img
              src="../../public/img/numeric.png"
              max-width="100"
              class="mt-16 mb-15"
            />
            <v-card-text>
              <p class="text-h5 text--primary">
                수치 예측
              </p>
              <div class="text-subtitle-1">
                설명
              </div>
            </v-card-text>
            <v-btn
              depressed
              x-large
              color="primary text-white"
              class="mt-11"
              rounded
              @click="setPrediction('numeric')"
              >select</v-btn
            >
          </v-row>
        </v-card>
      </v-col>
      <v-col cols="4">
        <v-card
          class="text-center justify-center align-center"
          elevation="15"
          height="500"
        >
          <v-row justify="center" align="center">
            <v-img
              src="../../public/img/binary2.png"
              max-width="100"
              class="mt-16 mb-15"
            ></v-img>
            <v-card-text>
              <p class="text-h5 text--primary">
                이진 분류 예측
              </p>
              <div class=" text-subtitle-1">
                설명
              </div>
            </v-card-text>
            <v-btn
              depressed
              x-large
              color="primary text-white"
              class="mt-11"
              rounded
              @click="setPrediction('binary')"
              >select</v-btn
            >
          </v-row>
        </v-card>
      </v-col>
      <v-col cols="4">
        <v-card
          class="text-center justify-center align-center"
          elevation="15"
          height="500"
        >
          <v-row justify="center" align="center">
            <v-img
              src="../../public/img/multiple.png"
              max-width="100"
              class="mt-16 mb-15"
            ></v-img>
            <v-card-text>
              <p class="text-h5 text--primary">
                다중 분류 예측
              </p>
              <div class=" text-subtitle-1">
                설명
              </div>
            </v-card-text>
            <v-btn
              depressed
              x-large
              rounded
              color="primary text-white"
              class="mt-11"
              @click="setPrediction('multiple')"
              >select</v-btn
            >
          </v-row>
        </v-card>
      </v-col>
    </v-row>
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
    setPrediction(prediction) {
      this.$store.commit('setPrediction', prediction);
      this.$store.commit('nextSequence');
    },
  },
};
</script>

<style></style>
