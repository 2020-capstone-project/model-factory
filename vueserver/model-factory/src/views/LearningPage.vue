<template>
  <v-container fluid>
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
            <template v-if="getDataSelectMenu == 'load'">
              <TableSelectContent></TableSelectContent>
            </template>
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
              <v-btn
                color="grey text-white"
                @click="$store.commit('beforeSequence')"
              >
                before
              </v-btn>
              <v-btn
                color="primary"
                @click="$store.commit('nextSequence')"
                class="ml-5"
              >
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
    <v-footer padless class="mt-10">
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

export default {
  components: {
    DataSelectContent,
    DetailDataSelectContent,
    PredictionSelectContent,
    TableSelectContent,
  },
  data() {
    return {};
  },
  computed: {
    getDataSelectMenu() {
      return this.$store.getters.getDataSelectMenu;
    },
  },
};
</script>

<style></style>
