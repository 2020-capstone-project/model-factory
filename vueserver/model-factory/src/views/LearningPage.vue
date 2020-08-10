<template>
  <v-container fluid>
    <v-row justify="center" class="mt-n15">
      <v-col cols="12">
        <v-card elevation="5" style="background-color: blue">
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
                <template v-if="getDataSelectMenu == ''">
                  <DataSelectContent></DataSelectContent>
                </template>
                <template v-else-if="getDataSelectMenu == 'load'">
                  <TableSelectContent></TableSelectContent>
                </template>
                <template v-else-if="getDataSelectMenu == 'upload'">
                  <DataUploadContent></DataUploadContent>
                </template>
              </v-stepper-content>

              <v-stepper-content step="2">
                <DetailDataSelectContent></DetailDataSelectContent>
              </v-stepper-content>

              <v-stepper-content step="3">
                <PredictionSelectContent></PredictionSelectContent>
              </v-stepper-content>

              <v-stepper-content step="4">
                <ModelSelectContent></ModelSelectContent>
              </v-stepper-content>

              <v-stepper-content step="5">
                <template v-if="getIsSelectModel == 'recommend'">
                  <ModelReviewContent></ModelReviewContent>
                </template>
                <template v-else-if="getIsSelectModel == 'customize'">
                  <ModelCustomizeContent></ModelCustomizeContent>
                </template>
              </v-stepper-content>

              <v-stepper-content step="6">
                <StartLearningContent></StartLearningContent>
              </v-stepper-content>
            </v-stepper-items>
          </v-stepper>
        </v-card>
      </v-col>
    </v-row>
    <v-footer padless class="mt-15">
      <v-card
        flat
        tile
        width="100%"
        height="90"
        class="grey lighten-5 text-center"
      >
        <a
          href="https://github.com/2020-capstone-project/model-factory"
          class="s mt-3"
          style="text-decoration: none"
          icon
        >
          <v-icon size="40px" color="blue">mdi-github-circle</v-icon>
        </a>
        <v-card-text class="blue--text">
          2020 — <strong>Model Factory</strong>
        </v-card-text>
      </v-card>
    </v-footer>
  </v-container>
</template>

<script>
import DataSelectContent from '@/components/DataSelectContent.vue';
import DetailDataSelectContent from '@/components/DetailDataSelectContent.vue';
import PredictionSelectContent from '@/components/PredictionSelectContent.vue';
import TableSelectContent from '@/components/TableSelectContent.vue';
import ModelSelectContent from '@/components/ModelSelectContent.vue';
import ModelReviewContent from '@/components/ModelReviewContent.vue';
import StartLearningContent from '@/components/StartLearningContent.vue';
import ModelCustomizeContent from '@/components/ModelCustomizeContent.vue';
import DataUploadContent from '@/components/DataUploadContent';

export default {
  components: {
    DataSelectContent,
    DetailDataSelectContent,
    PredictionSelectContent,
    TableSelectContent,
    ModelSelectContent,
    ModelReviewContent,
    StartLearningContent,
    ModelCustomizeContent,
    DataUploadContent,
  },
  data() {
    return {
      dialog: true,
    };
  },
  computed: {
    getIsSelectModel() {
      return this.$store.getters.getIsSelectModel;
    },
    getDataSelectMenu() {
      return this.$store.getters.getDataSelectMenu;
    },
  },
};
</script>

<style></style>
