<template>
  <v-container fluid>
    <v-row justify="center">
      <v-col cols="6">
        <v-card elevation="10" class="text-white">
          <v-card-title class="primary">
            <strong>학습 모델 테스트 (입력값)</strong>
          </v-card-title>
          <v-form v-model="valid">
            <v-container>
              <v-row
                justify="center"
                v-for="inputColumn in inputColumns"
                :key="inputColumn.name"
              >
                <v-col class="ml-6 mr-6 mb-n4">
                  <v-text-field
                    v-model="inputColumn.value"
                    :rules="rule"
                    :label="inputColumn.name"
                    required
                  ></v-text-field>
                </v-col>
              </v-row>
              <v-row justify="center" class="mt-3">
                <v-col cols="8"
                  ><v-btn
                    block
                    :disabled="!valid"
                    color="primary text-white"
                    @click="test"
                  >
                    TEST
                  </v-btn>
                </v-col>
              </v-row>
            </v-container>
          </v-form>
        </v-card>
      </v-col>
      <v-col cols="6">
        <v-card elevation="10" class="text-white">
          <v-card-title class="primary">
            <strong>학습 모델 테스트 (출력값)</strong>
          </v-card-title>
          <v-alert v-if="success" type="success" class="ma-10">
            테스트를 완료했습니다.
          </v-alert>
          <v-form>
            <v-row
              justify="center"
              v-for="outputColumn in outputColumns"
              :key="outputColumn.name"
            >
              <v-col class="ml-6 mr-6 mb-n4">
                <v-text-field
                  v-model="outputColumn.value"
                  :label="outputColumn.name"
                  readonly
                ></v-text-field>
              </v-col>
            </v-row>
          </v-form>
        </v-card>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import { postTest } from '@/api/learningStatus.js';

export default {
  props: ['inputColumns', 'outputColumns'],
  data: () => ({
    valid: false,
    firstname: '',
    lastname: '',
    rule: [
      v => !!v || '값을 반드시 입력해주세요.',
      v => !isNaN(v) || '값은 숫자만 가능합니다.',
    ],
    success: false,
  }),
  methods: {
    async test() {
      const values = this.inputColumns.map(obj => {
        return obj.value;
      });
      try {
        this.$store.commit('visibleLearningDialog');
        const { data } = await postTest(
          this.$store.getters.getMemberId,
          this.$store.getters.getDetailStatusInfo.id,
          { values: values },
        );
        this.$emit('update-result', data);
        this.success = true;
      } catch (error) {
        this.success = false;
      } finally {
        setTimeout(() => {
          this.success = false;
        }, 3000);
        this.$store.commit('invisibleLearningDialog');
      }
    },
  },
};
</script>

<style></style>
