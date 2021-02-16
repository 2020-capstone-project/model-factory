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
              <div class="text-body-2 ml-3 mr-3">
                하나의 수치 값을 예측
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
              <div class="text-body-2 ml-3 mr-3">
                두 가지 경우 중에 예측
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
              <div class="text-body-2 ml-3 mr-3">
                세 가지 이상의 경우 중에 예측
              </div>
            </v-card-text>
            <v-btn
              depressed
              x-large
              rounded
              color="primary text-white"
              class="mt-11"
              @click="clickedMultiple()"
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
    <v-dialog v-model="dialog" persistent max-width="600px">
      <v-card>
        <v-card-title>
          <span class="headline">다중 분류 예측</span>
        </v-card-title>
        <v-card-text>
          <span>결과가 몇가지로 구분되는지 입력해주세요</span>
          <v-container>
            <v-row>
              <v-col cols="12">
                <v-text-field
                  v-model="outputLength"
                  :rules="lengthRules"
                  label="결과 분류 개수"
                  required
                ></v-text-field>
              </v-col>
            </v-row>
          </v-container>
        </v-card-text>
        <v-card-actions>
          <v-spacer></v-spacer>
          <v-btn color="grey" text @click="dialog = false">ClOSE</v-btn>
          <v-btn color="blue darken-1" text @click="nextMultiple()">NEXT</v-btn>
        </v-card-actions>
      </v-card>
    </v-dialog>
  </v-container>
</template>

<script>
export default {
  data: function() {
    return {
      outputLength: 0,
      dialog: false,
      lengthRules: [
        v => !!v || '개수를 반드시 입력해주세요.',
        v => v > 1 || '개수는 1 이상이여야 합니다.',
      ],
    };
  },
  methods: {
    before() {
      this.$store.commit('beforeSequence');
    },
    setPrediction(prediction) {
      this.$store.commit('setPrediction', prediction);
      this.$store.commit('nextSequence');
    },
    clickedMultiple() {
      this.dialog = true;
    },
    nextMultiple() {
      this.$store.commit('setPrediction', 'multiple');
      this.$store.commit('setOutputLengthForMultiple', this.outputLength);
      this.$store.commit('nextSequence');
      this.dialog = false;
    },
  },
};
</script>

<style></style>
