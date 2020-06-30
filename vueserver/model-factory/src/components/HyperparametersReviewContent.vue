<template>
  <v-row
    v-if="isSelectModel"
    justify="center"
    align="center"
    style="height: 500px;"
  >
    <v-col cols="6">
      <v-col class="d-flex" cols="12">
        <v-text-field
          v-model="epoch"
          :rules="epochRules"
          label="에포크(Epoch)"
          readonly
          required
        ></v-text-field>
        <v-tooltip right>
          <template v-slot:activator="{ on, attrs }">
            <v-icon color="primary" dark v-bind="attrs" v-on="on"
              >mdi-help</v-icon
            >
          </template>
          <span
            >에포크란?<br />
            학습 횟수를 의미합니다.</span
          >
        </v-tooltip>
      </v-col>
      <v-col class="d-flex mt-5" cols="12">
        <v-text-field
          class="mt-n6"
          v-model="batchSize"
          :rules="batchSizeRules"
          label="배치 사이즈(Batch Size)"
          readonly
          required
        ></v-text-field>
        <v-tooltip right>
          <template v-slot:activator="{ on, attrs }">
            <v-icon color="primary" dark v-bind="attrs" v-on="on"
              >mdi-help</v-icon
            >
          </template>
          <span
            >배치사이즈란?<br />
            설명.</span
          >
        </v-tooltip>
      </v-col>
      <v-col class="d-flex mt-5" cols="12">
        <v-select
          :items="lossFunctions"
          label="손실 함수 선택"
          v-model="loss"
          readonly
          outlined
        ></v-select>
        <v-tooltip right>
          <template v-slot:activator="{ on, attrs }">
            <v-icon color="primary" dark v-bind="attrs" v-on="on" class="mt-n5"
              >mdi-help</v-icon
            >
          </template>
          <span
            >손실 함수란?<br />
            설명.</span
          >
        </v-tooltip>
      </v-col>
      <v-col class="d-flex" cols="12">
        <v-select
          :items="optimizerFunctions"
          v-model="optimizer"
          label="최적화 함수 선택"
          readonly
          outlined
        ></v-select>
        <v-tooltip right>
          <template v-slot:activator="{ on, attrs }">
            <v-icon color="primary" dark v-bind="attrs" v-on="on" class="mt-n5"
              >mdi-help</v-icon
            >
          </template>
          <span
            >최적화 함수란?<br />
            설명.</span
          >
        </v-tooltip>
      </v-col>
    </v-col>
  </v-row>
</template>

<script>
import { RecommendModel } from '@/utils/recommendation.js';

export default {
  data() {
    return {
      optimizer: '',
      loss: '',
      optimizerFunctions: [
        'sgd',
        'rmsprop',
        'adagrad',
        'adadelta',
        'adam',
        'adamax',
        'nadam',
      ],
      lossFunctions: [
        'mean_squared_error',
        'binary_crossentropy',
        'categorical_crossentropy',
      ],
      batchSize: '',
      epoch: '',
      batchSizeRules: [
        v => !!v || '배치 사이즈를 반드시 입력해주세요.',
        v => v >= 0 || '배치 사이즈는 반드시 0보다 커야 합니다.',
      ],
      epochRules: [
        v => !!v || '에포크를 반드시 입력해주세요.',
        v => v >= 100 || '에포크는 100 보다 크거나 같아야 합니다.',
        v => v % 100 == 0 || '에포크는 100 배수이여야 합니다.',
      ],
      recommendModel: new RecommendModel(),
    };
  },
  computed: {
    isSelectModel() {
      if (this.$store.getters.getIsSelectModel != '') {
        this.setHyperparameters(
          this.recommendModel.getRecommendHyperparameters(
            this.$store.getters.getPrediction,
          ),
        );
      }
      return true;
    },
  },
  methods: {
    setHyperparameters(parameters) {
      this.optimizer = parameters.optimizerFunction;
      this.epoch = parameters.epoch;
      this.loss = parameters.lossFunction;
      this.batchSize = parameters.batchSize;
    },
  },
  watch: {
    optimizer: function(newOptimizer) {
      this.$store.commit('setOptimizerFunction', newOptimizer);
    },
    epoch: function(newEpoch) {
      this.$store.commit('setEpoch', newEpoch);
    },
    loss: function(newLoss) {
      this.$store.commit('setLossFunction', newLoss);
    },
    batchSize: function(newBatchSize) {
      this.$store.commit('setBatchSize', newBatchSize);
    },
  },
};
</script>

<style></style>
