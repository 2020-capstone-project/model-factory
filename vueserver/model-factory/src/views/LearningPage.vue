<template>
  <v-container fluid>
    <v-card>
      <v-stepper v-model="$store.state.sequence" class="pa-5">
        <v-stepper-header>
          <v-stepper-step step="1">데이터 선택</v-stepper-step>

          <v-divider></v-divider>

          <v-stepper-step step="2">상세 데이터 선택</v-stepper-step>

          <v-divider></v-divider>

          <v-stepper-step step="3">예측 선택</v-stepper-step>
          <v-divider></v-divider>

          <v-stepper-step step="4">모델 선택</v-stepper-step>
          <v-divider></v-divider>

          <v-stepper-step step="5">모델 검토</v-stepper-step>
          <v-divider></v-divider>

          <v-stepper-step step="6">학습 시작</v-stepper-step>
        </v-stepper-header>
        <v-stepper-items>
          <v-stepper-content step="1">
            <DataSelectContent></DataSelectContent>
          </v-stepper-content>

          <v-stepper-content step="2">
            <DetailDataSelectContent></DetailDataSelectContent>
          </v-stepper-content>

          <v-stepper-content step="3">
            <PredictionSelectContent></PredictionSelectContent>
          </v-stepper-content>

          <v-stepper-content step="4">
            <div>
              <v-card class="mb-12" color="grey lighten-3"> </v-card>
              <v-btn color="grey text-white" @click="e1--">
                before
              </v-btn>
              <v-btn color="primary" @click="e1++" class="ml-5">
                Continue
              </v-btn>
            </div>
          </v-stepper-content>

          <v-stepper-content step="5">
            <div>
              <v-card class="mb-12" color="grey lighten-3"> </v-card>
              <v-btn color="grey text-white" @click="e1--">
                before
              </v-btn>
              <v-btn color="primary" @click="e1++" class="ml-5">
                Continue
              </v-btn>
            </div>
          </v-stepper-content>

          <v-stepper-content step="6">
            <div>
              <v-card class="mb-12" color="grey lighten-3"> </v-card>
              <v-btn color="grey text-white" @click="e1--">
                before
              </v-btn>
              <v-btn color="primary" @click="e1++" class="ml-5">
                Continue
              </v-btn>
            </div>
          </v-stepper-content>
        </v-stepper-items>
      </v-stepper>
    </v-card>
  </v-container>
</template>

<script>
import DataSelectContent from '@/components/DataSelectContent.vue';
import DetailDataSelectContent from '@/components/DetailDataSelectContent.vue';
import PredictionSelectContent from '@/components/PredictionSelectContent.vue';

export default {
  components: {
    DataSelectContent,
    DetailDataSelectContent,
    PredictionSelectContent,
  },
  data() {
    return {
      e1: 1,
    };
  },
};
</script>

<style></style>
