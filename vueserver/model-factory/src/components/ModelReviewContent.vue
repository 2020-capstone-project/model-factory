<template>
  <v-container>
    <v-row justify="center" align="center">
      <v-col>
        <v-card elevation="10" class="primary" primary dark>
          <v-card-title>
            Deep Learning
          </v-card-title>
          <v-card-text class="white text-primary">
            <v-row align="center">
              <v-col cols="4">
                <v-img src="../../public/img/deeplearning2.png" />
              </v-col>
              <v-col cols="8">
                <v-tabs v-model="tab" light>
                  <v-tab v-for="item in items" :key="item.tab">
                    {{ item.tab }}
                  </v-tab>
                </v-tabs>
                <v-tabs-items v-model="tab">
                  <v-tab-item key="0">
                    <v-card flat>
                      <HyperparametersReviewContent></HyperparametersReviewContent>
                    </v-card>
                  </v-tab-item>
                  <v-tab-item key="1">
                    <LayersReviewContent></LayersReviewContent>
                  </v-tab-item>
                </v-tabs-items>
              </v-col>
            </v-row>
          </v-card-text>
        </v-card>
      </v-col>
    </v-row>
    <v-row justify="center" align="center" class="mt-5">
      <v-btn color="grey text-white" @click="before">
        before
      </v-btn>
      <v-col col="1"></v-col>
      <v-btn color="primary" @click="next" class="ml-5">
        Continue
      </v-btn>
    </v-row>
  </v-container>
</template>

<script>
import HyperparametersReviewContent from './HyperparametersReviewContent.vue';
import LayersReviewContent from './LayersReviewContent.vue';

export default {
  components: {
    HyperparametersReviewContent,
    LayersReviewContent,
  },
  data() {
    return {
      tab: null,
      items: [
        {
          tab: '하이퍼 파라미터',
        },
        { tab: '레이어' },
      ],
    };
  },
  methods: {
    before() {
      this.$store.commit('beforeSequence');
    },
    next() {
      this.$store.commit('nextSequence');
    },
  },
};
</script>

<style></style>
