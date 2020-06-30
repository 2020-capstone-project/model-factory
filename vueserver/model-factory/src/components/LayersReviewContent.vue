<template>
  <v-container>
    <v-row justify="center" align="center">
      <v-col cols="12">
        <v-card elevation="5" class="mt-5">
          <v-tabs-items v-model="page">
            <v-tab-item> </v-tab-item>
            <v-tab-item>
              <v-row align="center">
                <v-col cols="4" class="text-center text-h5 text-primary"
                  ><b>Layer 0</b>
                </v-col>
                <v-col cols="8">
                  <v-col cols="10" class="mt-6">
                    <v-select
                      :items="layerKinds"
                      v-model="layerKind"
                      label="레이어 종류 선택"
                      outlined
                    ></v-select>
                  </v-col>
                  <v-col cols="10">
                    <v-select
                      :items="activationFunctions"
                      v-model="activationFunction"
                      label="활성화 함수 선택"
                      outlined
                    ></v-select>
                  </v-col>
                  <v-col cols="10" class="mt-n5">
                    <v-subheader>인풋 비율 설정(%)</v-subheader>
                    <v-card-text class="mt-n5">
                      <v-row>
                        <v-col class="pr-4">
                          <v-slider
                            v-model="value"
                            class="align-center"
                            :max="max"
                            :min="min"
                          >
                            <template v-slot:append>
                              <v-text-field
                                v-model="value"
                                class="mt-n8 pt-0"
                                hide-details
                                single-line
                                type="number"
                                style="width: 60px"
                              ></v-text-field>
                            </template>
                          </v-slider>
                        </v-col>
                      </v-row>
                    </v-card-text>
                  </v-col>
                  <v-col cols="10">
                    <v-text-field
                      class="mt-n6"
                      v-model="neuronCount"
                      :rules="neuronCountRules"
                      label="뉴런 개수"
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
          <v-pagination v-model="page" class="my-4" :length="15"></v-pagination>
        </v-container>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
export default {
  data() {
    return {
      page: 1,
      min: 0,
      max: 100,
      value: 25,
      activationFunction: '',
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
      layerKind: '',
      layerKinds: ['Dense', 'Dropout'],
      optimizer: '',
      neuronCount: '',
      neuronCountRules: [
        v => !!v || '뉴런 개수를 반드시 입력해주세요.',
        v => v >= 0 || '뉴런 개수는 반드시 0보다 커야 합니다.',
      ],
    };
  },
};
</script>

<style></style>
