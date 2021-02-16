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
                  <v-row justify="center" align="center">
                    <v-col cols="10" class="mt-6">
                      <v-select
                        :items="layerKinds"
                        v-model="i.information.name"
                        label="레이어 종류 선택"
                        outlined
                      ></v-select>
                    </v-col>
                    <v-col cols="2">
                      <v-tooltip left>
                        <template v-slot:activator="{ on, attrs }">
                          <v-icon
                            class="mt-n3"
                            color="primary"
                            dark
                            v-bind="attrs"
                            v-on="on"
                            >mdi-help</v-icon
                          >
                        </template>
                        <span
                          >레이어란?<br />
                          여러 뉴런이 하나의 신경망을 구성하는 층<br /><br />
                          1) Dense: 입력 뉴련과 출력 뉴런을 모두 연결하는
                          전결합층이다.<br />
                          신경망을 구성하는 가장 기본적인 레이어
                          <br /><br />
                          2) Dropout: 너무 많은 학습을 하면 학습 데이터에
                          치중되는데,<br />
                          이러한 과적합을 줄이고 학습 모델을 평균화하는 레이어
                        </span>
                      </v-tooltip>
                    </v-col>
                  </v-row>
                  <v-row
                    v-if="i.information.name == 'dense'"
                    justify="center"
                    align="center"
                  >
                    <v-col cols="10">
                      <v-select
                        :items="activationFunctions"
                        v-model="i.information.activationFunction"
                        label="활성화 함수 선택"
                        outlined
                      ></v-select>
                    </v-col>
                    <v-col cols="2">
                      <v-tooltip left>
                        <template v-slot:activator="{ on, attrs }">
                          <v-icon
                            class="mt-n8"
                            color="primary"
                            dark
                            v-bind="attrs"
                            v-on="on"
                            >mdi-help</v-icon
                          >
                        </template>
                        <span
                          >활성화 함수란?<br />
                          레이어에서 입력받은 데이터를 다음층으로 출력할지를
                          결정하는 역할을 한다.<br />
                          <br />
                          1) softmax: 입력받은 값을 출력으로 0 ~ 1 사이의
                          값으로<br />
                          모두 정규화하며 출력 값들의 총 합은 항상 1이 되는<br />
                          특성을 가진 함수이다. 주로 다중 분류의 출력층으로<br />
                          사용된다.<br /><br />
                          2) relu(Rectified Linear Unit): 경사함수로서
                          레이어가<br />
                          늘어날 때 값이 사라지는 현상을 해결하기 위한
                          함수이다.<br />
                          주로 은닉층을 구성할 때 자주 사용된다.<br /><br />
                          3) tanh: Sigmoid 함수를 활용하여 -1 ~ 1 의 범위를 갖는
                          함수이다.<br /><br />
                          4) sigmoid: 로지스틱 함수라고도 하며 입력 값의
                          변화에<br />
                          따라 0에서 1까지의 값을 출력하는 S자형 함수이다.<br /><br />
                          5) linear: 선형 함수이다.
                        </span>
                      </v-tooltip>
                    </v-col>
                  </v-row>
                  <v-row
                    v-if="i.information.name == 'dropout'"
                    justify="center"
                    align="center"
                  >
                    <v-col cols="10" class="mt-n5">
                      <v-text-field
                        v-model="i.information.value"
                        :rules="valueRules"
                        label="비활성 인풋 비율(%)"
                        required
                      ></v-text-field>
                    </v-col>
                    <v-col cols="2">
                      <v-tooltip left>
                        <template v-slot:activator="{ on, attrs }">
                          <v-icon
                            class="mt-n8"
                            color="primary"
                            dark
                            v-bind="attrs"
                            v-on="on"
                            >mdi-help</v-icon
                          >
                        </template>
                        <span
                          >비활성 인풋 비율 이란?<br />
                          레이어에 구성된 뉴런들 중에 비활성화 할 비율을
                          결정한다.
                        </span>
                      </v-tooltip>
                    </v-col>
                  </v-row>
                  <v-row
                    justify="center"
                    align="center"
                    v-if="i.information.name == 'dense'"
                  >
                    <v-col cols="10">
                      <v-text-field
                        v-model="i.information.neuronCount"
                        :rules="neuronCountRules"
                        label="뉴런 개수"
                        required
                      ></v-text-field>
                    </v-col>
                    <v-col cols="2">
                      <v-tooltip left>
                        <template v-slot:activator="{ on, attrs }">
                          <v-icon
                            class="mt-n8"
                            color="primary"
                            dark
                            v-bind="attrs"
                            v-on="on"
                            >mdi-help</v-icon
                          >
                        </template>
                        <span
                          >뉴런 개수란?<br />
                          레이어를 구성하는 뉴런의 개수를 의미한다.
                        </span>
                      </v-tooltip>
                    </v-col>
                  </v-row>
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
      activationFunctions: ['softmax', 'relu', 'tanh', 'sigmoid', 'linear'],
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
        this.setLayers(this.$store.getters.getLayers);
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
