<template>
  <v-container fluid>
    <v-row>
      <h1 class="ma-3">학습 현황</h1>
      <v-spacer></v-spacer>
      <a :href="fileDownloadLink" download>
        <v-btn class="mx-1 ma-3" color="primary">
          DOWNLOAD MODEL
        </v-btn>
      </a>
    </v-row>
    <v-row justify="center">
      <v-col cols="3">
        <v-alert border="left" colored-border color="blue" elevation="2">
          <div class="ml-4">
            <h6 class="blue--text mb-1">학습명</h6>
            <h5>{{ this.$store.getters.getDetailStatusInfo.name }}</h5>
          </div>
        </v-alert>
      </v-col>
      <v-col cols="3">
        <v-alert border="left" colored-border color="indigo" elevation="2">
          <div class="ml-4">
            <h6 class="indigo--text mb-1">학습 시작 날짜</h6>
            <h5>{{ this.$store.getters.getDetailStatusInfo.learningDate }}</h5>
          </div>
        </v-alert>
      </v-col>
      <v-col cols="3">
        <v-alert border="left" colored-border color="teal" elevation="2">
          <div class="ml-4">
            <h6 class="teal--text mb-1">진행률</h6>
            <v-progress-linear
              color="teal"
              :value="this.$store.getters.getDetailStatusInfo.learningProgress"
              height="30"
              rounded
            >
              <strong class="white--text"
                >{{
                  this.$store.getters.getDetailStatusInfo.learningProgress
                }}%</strong
              >
            </v-progress-linear>
          </div>
        </v-alert>
      </v-col>
      <v-col cols="3">
        <v-alert border="left" colored-border color="purple" elevation="2">
          <div class="ml-4">
            <h6 class="purple--text mb-1">정확도</h6>
            <v-progress-linear
              color="purple"
              :value="this.$store.getters.getDetailStatusInfo.accuracy"
              height="30"
            >
              <strong class="white--text"
                >{{ this.$store.getters.getDetailStatusInfo.accuracy }}%</strong
              >
            </v-progress-linear>
          </div>
        </v-alert>
      </v-col>
    </v-row>
    <v-row justify="center">
      <v-col cols="8">
        <v-card elevation="10" class="primary" primary dark>
          <v-card-title>
            <strong>학습 정확도</strong>
          </v-card-title>
          <v-card-text class="white text-primary">
            <Chart class="pa-8" :options="accuracyChartOptions"></Chart>
          </v-card-text>
        </v-card>
      </v-col>
      <v-col cols="4">
        <v-card elevation="10" class="indigo white--text" dark>
          <v-card-title>
            <strong>학습 정보</strong>
          </v-card-title>
          <v-card-text class="white blue-grey--text">
            <div class="pa-5 pt-7">
              <h6 class="mb-1">총 에포크</h6>
              <h5 class="mt-4">{{ learningInfo.epoch }}</h5>
            </div>
            <div class="pa-5 pt-7">
              <h6 class="mb-1">배치 사이즈</h6>
              <h5 class="mt-4">{{ learningInfo.batchSize }}</h5>
            </div>
            <div class="pa-5 pt-7">
              <h6 class="mb-1">손실 함수</h6>
              <h5 class="mt-4">{{ learningInfo.lossFunction }}</h5>
            </div>
            <div class="pa-5 pt-7">
              <h6 class="mb-1">최적화 알고리즘</h6>
              <h5 class="mt-4">{{ learningInfo.optimizerFunction }}</h5>
            </div>
          </v-card-text>
        </v-card>
      </v-col>
    </v-row>
    <v-row>
      <v-col cols="8">
        <v-card elevation="10" class="primary" primary dark>
          <v-card-title>
            <strong>학습 손실값</strong>
          </v-card-title>
          <v-card-text class="white text-primary">
            <Chart class="pa-8" :options="lossChartOptions"></Chart>
          </v-card-text>
        </v-card>
      </v-col>
      <v-col cols="4">
        <v-card elevation="10" class="indigo white--text" dark>
          <v-card-title>
            <strong>현재 모델의 손실값과 정확도</strong>
          </v-card-title>
          <v-card-text class="white blue-grey--text">
            <div class="pa-5 pt-6">
              <h6 class="mb-1">훈련 정확도</h6>
              <h5 class="mt-6">
                <v-progress-linear
                  rounded
                  color="indigo darken-3"
                  :value="trainAccuracy"
                  height="25"
                >
                  <strong class="white--text">{{ trainAccuracy }}%</strong>
                </v-progress-linear>
              </h5>
            </div>
            <div class="pa-5 pt-6">
              <h6 class="mb-1">평가 정확도</h6>
              <h5 class="mt-6">
                <v-progress-linear
                  rounded
                  color="indigo darken-3"
                  :value="validationAccuracy"
                  height="25"
                >
                  <strong class="white--text">{{ validationAccuracy }}%</strong>
                </v-progress-linear>
              </h5>
            </div>
            <div class="pa-5 pt-6">
              <h6 class="mb-1">훈련 손실값</h6>
              <h5 class="mt-4">{{ trainLoss }}</h5>
            </div>
            <div class="pa-5 pt-6">
              <h6 class="mb-1">평가 손실값</h6>
              <h5 class="mt-4">{{ validationLoss }}</h5>
            </div>
          </v-card-text>
        </v-card>
      </v-col>
    </v-row>
    <v-row>
      <v-col cols="6">
        <v-card elevation="10" class="primary" primary dark>
          <v-card-title>
            <strong>학습 테스트 (입력값)</strong>
          </v-card-title>
          <v-card-text class="white text-primary">
            <Chart class="pa-8" :options="lossChartOptions"></Chart>
          </v-card-text>
        </v-card>
      </v-col>
      <v-col cols="6">
        <v-card elevation="10" class="primary" primary dark>
          <v-card-title>
            <strong>학습 테스트 (출력값)</strong>
          </v-card-title>
          <v-card-text class="white text-primary">
            <Chart class="pa-8" :options="lossChartOptions"></Chart>
          </v-card-text>
        </v-card>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import { Chart } from 'highcharts-vue';
import { getDetail } from '@/api/learningStatus';

let xList = [];
for (let i = 1; i <= 100; i += 1) {
  xList.push(i);
}

export default {
  data: () => ({
    interval: null,
    learningInfo: {
      batchSize: null,
      epoch: null,
      lossFunction: null,
      optimizerFunction: null,
      trainAccuracy: null,
      trainLoss: null,
      validationAccuracy: null,
      validationLoss: null,
      fileDownloadLink: null,
    },
    trainAccuracy: 0,
    validationAccuracy: 0,
    trainLoss: 0,
    validationLoss: 0,
    accuracyChartOptions: {
      chart: {
        type: 'line',
      },
      xAxis: {
        title: {
          text: 'Epoch(%)',
        },
        categories: xList,
      },
      yAxis: {
        title: {
          text: '`<strong>Accuracy(%)</strong>`',
        },
        max: 100,
        min: 0,
      },
      title: {
        text: null,
      },
      series: [
        {
          name: '학습 정확도',
          data: null,
          color: '#03A9F4',
        },
        {
          name: '평가 정확도',
          data: null,
          color: '#E91E63',
        },
      ],
      plotOptions: {
        line: {
          dataLabels: {
            enabled: false,
          },
        },
      },
    },
    lossChartOptions: {
      chart: {
        type: 'line',
      },
      xAxis: {
        title: {
          text: 'Epoch(%)',
        },
        categories: xList,
      },
      yAxis: {
        title: {
          text: '`<strong>Loss</strong>`',
        },
      },
      title: {
        text: null,
      },
      series: [
        {
          name: '학습 손실값',
          data: null,
          color: '#009688',
        },
        {
          name: '평가 손실값',
          data: null,
          color: '#FF5722',
        },
      ],
      plotOptions: {
        line: {
          dataLabels: {
            enabled: false,
          },
        },
      },
    },
  }),
  methods: {
    async fetchData() {
      const { data } = await getDetail(
        this.$store.getters.getMemberId,
        this.$store.getters.getDetailStatusInfo.id,
      );
      this.learningInfo = data;
      this.accuracyChartOptions.series[0].data = this.learningInfo.trainAccuracy;
      this.trainAccuracy = this.learningInfo.trainAccuracy[
        this.learningInfo.trainAccuracy.length - 1
      ];
      this.validationAccuracy = this.learningInfo.validationAccuracy[
        this.learningInfo.validationAccuracy.length - 1
      ];
      this.accuracyChartOptions.series[1].data = this.learningInfo.validationAccuracy;
      this.lossChartOptions.series[0].data = this.learningInfo.trainLoss;
      this.trainLoss = this.learningInfo.trainLoss[
        this.learningInfo.trainLoss.length - 1
      ];
      this.validationLoss = this.learningInfo.validationLoss[
        this.learningInfo.validationLoss.length - 1
      ];
      this.lossChartOptions.series[1].data = this.learningInfo.validationLoss;
      this.$store.commit(
        'setLearningProgress',
        this.learningInfo.trainAccuracy.length,
      );
      this.$store.commit('setLearningAccuracy', this.validationAccuracy);
    },
  },
  watch: {
    learningInfo: function() {
      this.accuracyChartOptions.series[0].data = this.learningInfo.trainAccuracy;
      this.trainAccuracy = this.learningInfo.trainAccuracy[
        this.learningInfo.trainAccuracy.length - 1
      ];
      this.validationAccuracy = this.learningInfo.validationAccuracy[
        this.learningInfo.validationAccuracy.length - 1
      ];
      this.accuracyChartOptions.series[1].data = this.learningInfo.validationAccuracy;
      this.lossChartOptions.series[0].data = this.learningInfo.trainLoss;
      this.trainLoss = this.learningInfo.trainLoss[
        this.learningInfo.trainLoss.length - 1
      ];
      this.validationLoss = this.learningInfo.validationLoss[
        this.learningInfo.validationLoss.length - 1
      ];
      this.lossChartOptions.series[1].data = this.learningInfo.validationLoss;
    },
  },
  components: { Chart },
  created() {
    this.fetchData();
    this.fileDownloadLink =
      'http://localhost:8080/members/' +
      this.$store.getters.getMemberId +
      '/learning-status/' +
      this.$store.getters.getDetailStatusInfo.id +
      '/download';
    let memberId = this.$store.getters.getMemberId;
    let learningId = this.$store.getters.getDetailStatusInfo.id;
    this.interval = setInterval(this.fetchData, 1000);
  },
  destroyed() {
    clearInterval(this.interval);
  },
};
</script>

<style></style>
