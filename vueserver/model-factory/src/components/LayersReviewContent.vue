<template>
  <v-container v-if="isSelectModel">
    <v-row justify="center" align="center">
      <v-col cols="12">
        <v-card elevation="5" class="mt-5">
          <v-tabs-items v-model="page">
            <v-tab-item> </v-tab-item>
            <v-tab-item v-for="i in layers" :key="i.number">
              <v-row align="center">
                <v-col cols="4" class="text-center text-h5 text-primary"
                  ><b>Layer {{ i.number }}</b>
                </v-col>
                <v-col cols="8">
                  <v-col cols="10" class="mt-6">
                    <v-select
                      :items="layerKinds"
                      v-model="i.information.name"
                      label="레이어 종류 선택"
                      readonly
                      outlined
                    ></v-select>
                  </v-col>
                  <v-col cols="10" v-if="i.information.name == 'dense'">
                    <v-select
                      :items="activationFunctions"
                      v-model="i.information.activationFunction"
                      label="활성화 함수 선택"
                      readonly
                      outlined
                    ></v-select>
                  </v-col>
                  <v-col
                    cols="10"
                    class="mt-n5"
                    v-if="i.information.name == 'dropout'"
                  >
                    <v-text-field
                      v-model="i.information.value"
                      :rules="valueRules"
                      label="인풋 비율(%)"
                      readonly
                      required
                    ></v-text-field>
                  </v-col>
                  <v-col cols="10" v-if="i.information.name == 'dense'">
                    <v-text-field
                      v-model="i.information.neuronCount"
                      :rules="neuronCountRules"
                      label="뉴런 개수"
                      readonly
                      required
                    ></v-text-field>
                  </v-col>
                </v-col>
              </v-row>
            </v-tab-item>
          </v-tabs-items>
        </v-card>
      </v-col>
    </v-row>
    <v-row justify="center">
      <v-col cols="8">
        <v-container>
          <v-pagination
            v-model="page"
            class="my-4"
            :length="pageLength"
          ></v-pagination>
        </v-container>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import { RecommendModel } from '@/utils/recommendation.js';

export default {
  data() {
    return {
      page: 1,
      pageLength: 0,
      layers: [],
      activationFunctions: [
        'softmax',
        'elu',
        'selu',
        'softplus',
        'softsign',
        'relu',
        'tanh',
        'sigmoid',
        'hard_sigmoid',
        'exponential',
        'linear',
      ],
      layerKinds: ['dense', 'dropout'],
      neuronCountRules: [
        v => !!v || '뉴런 개수를 반드시 입력해주세요.',
        v => v >= 0 || '뉴런 개수는 반드시 0보다 커야 합니다.',
      ],
      valueRules: [
        v => !!v || '인풋 비율을 반드시 입력해주세요.',
        v =>
          (v < 1 && v > 0) || '인풋 비율은 0보다 크거나 1보다 작아야 합니다.',
      ],
      recommendModel: new RecommendModel(),
    };
  },
  computed: {
    isSelectModel() {
      if (this.$store.getters.getIsSelectModel != '') {
        this.setLayers(
          this.recommendModel.getRecommendLayers(
            this.$store.getters.getPrediction,
            this.$store.getters.getOutputColumnsLength,
          ),
        );
      }
      return true;
    },
  },
  methods: {
    setLayers(parameter) {
      this.layers = parameter;
      this.pageLength = this.layers.length;
    },
  },
  watch: {
    layers: function(newLayers) {
      this.$store.commit('setLayers', newLayers);
    },
  },
};
</script>

<style></style>
