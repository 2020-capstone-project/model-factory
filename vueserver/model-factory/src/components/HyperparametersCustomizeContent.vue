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
            학습 모델을 몇 샘플 마다 업데이트 시킬지를 결정하는 값</span
          >
        </v-tooltip>
      </v-col>
      <v-col class="d-flex mt-5" cols="12">
        <v-select
          :items="lossFunctions"
          label="손실 함수 선택"
          v-model="loss"
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
            컴퓨터가 대입한 결과와 실제 결과의 오차(손실)를 계산하는 함수<br /><br />
            1) mean_squared_error: 예측한 값과 실제 값 사이의 평균 제곱 오차를
            정의한다. 주로 수치 예측에 사용된다.<br /><br />
            2) binary_crossentropy: 실제 결과값과 예측 결과값 간의 교차 엔트로피
            손실을 계산한다. 주로 이진 분류 예측에 사용된다.<br /><br />
            3) categorical_crossentropy: 결과 값의 경우가 2개 이상일 경우
            사용되며,<br /><br />
            실제 결과값과 예측 결과값 간의 교차 엔트로피 손실을 계산한다. 주로
            다중 분류 예측에 사용된다.<br />
          </span>
        </v-tooltip>
      </v-col>
      <v-col class="d-flex" cols="12">
        <v-select
          :items="optimizerFunctions"
          v-model="optimizer"
          label="최적화 알고리즘 선택"
          outlined
        ></v-select>
        <v-tooltip right>
          <template v-slot:activator="{ on, attrs }">
            <v-icon color="primary" dark v-bind="attrs" v-on="on" class="mt-n5"
              >mdi-help</v-icon
            >
          </template>
          <span
            >최적화 알고리즘 이란?<br />
            손실 함수의 결괏값을 최소화하는 값을 찾아주는 알고리즘<br /><br />
            1) sgd(Stochastic gradient decent): 학습 데이터를 전체적으로<br />
            학습하는 것이 아니라 batch 라는 단위로 데이터를 나눠 학습시키는
            알고리즘
            <br /><br />
            2) rmsprop(RMSProp): 이전의 학습을 반영해서 학습시키는 알고리즘<br /><br />
            3) adagrad(AdaGrad): 학습을 통해 크게 변동이 있었던 예측값에
            대해서는<br />
            학습률을 감소시키고, 학습을 통해 예측값에 변동이 별로 없으면
            학습률을 증가시켜 학습시키는 알고리즘<br /><br />
            4) adam(Adam): 이전에 batch 크기만큼 학습한 결과와 RMSProp 방식을<br />
            같이 학습에 반영하는 알고리즘<br />
          </span>
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
      optimizerFunctions: ['sgd', 'rmsprop', 'adagrad', 'adam'],
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
      console.log(newOptimizer);
      this.$store.commit('setOptimizerFunction', newOptimizer);
    },
    epoch: function(newEpoch) {
      console.log(newEpoch);
      this.$store.commit('setEpoch', newEpoch);
    },
    loss: function(newLoss) {
      console.log(newLoss);
      this.$store.commit('setLossFunction', newLoss);
    },
    batchSize: function(newBatchSize) {
      console.log(newBatchSize);
      this.$store.commit('setBatchSize', newBatchSize);
    },
  },
};
</script>

<style></style>
