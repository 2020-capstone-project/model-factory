<template>
  <v-container>
    <v-row justify="center" align="center">
      <v-img
        src="../../public/img/learning.png"
        max-width="500"
        class="mt-16 mb-15"
      />
    </v-row>
    <v-row justify="center">
      <v-col cols="5">
        <v-text-field
          v-model="learningName"
          label="학습명"
          :rules="rules"
          outlined
        ></v-text-field>
      </v-col>
    </v-row>
    <v-row>
      <v-col cols="6">
        <v-row justify="center">
          <v-btn
            depressed
            x-large
            color="grey text-white"
            class="mt-5"
            rounded
            style="font-size: 1.5rem"
            @click="before"
            >Before</v-btn
          >
        </v-row>
      </v-col>
      <v-col cols="6">
        <v-row justify="center">
          <v-btn
            depressed
            x-large
            color="primary text-white"
            class="mt-5"
            :disabled="!isValid"
            rounded
            style="font-size: 1.5rem"
            @click="next"
            >Learning</v-btn
          >
        </v-row>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import { requestLearning } from '@/api/learning';

export default {
  data: () => ({
    learningName: '',
    rules: [value => !!value || '학습명을 반드시 입력해주세요.'],
  }),
  methods: {
    before() {
      this.$store.commit('beforeSequence');
    },
    async next() {
      try {
        this.$store.commit('visibleLearningDialog');
        this.$store.commit('setMemberId');
        this.$store.commit('setLearningName', this.learningName);
        await requestLearning(this.$store.getters.getLearningData);
        this.$router.push('/learning-status');
        this.$store.commit('resetData');
      } catch (error) {
        // TODO 예외 메시지 페이지에 출력
        console.log(error);
      } finally {
        this.$store.commit('invisibleLearningDialog');
      }
    },
  },
  computed: {
    isValid() {
      return this.learningName.length > 1;
    },
  },
};
</script>

<style></style>
