<template>
  <v-row justify="center" align="center" style="height: 500px;">
    <v-col cols="8">
      <v-col class="d-flex" cols="12">
        <v-text-field
          v-model="epoch"
          :rules="epochRules"
          readonly
          label="에포크(Epoch)"
          required
        ></v-text-field>
      </v-col>
      <v-col class="d-flex" cols="12">
        <v-text-field
          class="mt-n6"
          v-model="batchSize"
          :rules="batchSizeRules"
          readonly
          label="배치 사이즈(Batch Size)"
          required
        ></v-text-field>
      </v-col>
      <v-col class="d-flex" cols="12">
        <v-select
          :items="lossFunctions"
          label="손실 함수 선택"
          v-model="loss"
          outlined
          readonly
        ></v-select>
      </v-col>
      <v-col class="d-flex" cols="12">
        <v-select
          class="mt-n5"
          :items="optimizerFunctions"
          v-model="optimizer"
          label="활성화 함수 선택"
          outlined
          readonly
        ></v-select>
      </v-col>
    </v-col>
  </v-row>
</template>

<script>
export default {
  data() {
    return {
      optimizer: '',
      loss: '',
      optimizerFunctions: [
        'SGD',
        'RMSprop',
        'Adagrad',
        'Adadelta',
        'Adam',
        'Adamax',
        'Nadam',
      ],
      lossFunctions: [
        'Mean squared error',
        'Binary crossentropy',
        'Categorical crossentropy',
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
    };
  },
};
</script>

<style></style>
