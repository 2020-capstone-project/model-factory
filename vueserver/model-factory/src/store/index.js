import Vue from 'vue';
import Vuex from 'vuex';
import { loginUser } from '../api/auth';
import { adjustInfo } from '../api/info';
import { getFiles } from '@/api/file';

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    drawer: true,
    signupDialog: false,
    successSignup: false,
    successAdjust: false,
    learningDialog: false,
    userId: '0',
    name: '',
    email: '',
    loginState: false,
    sequence: 1,
    dataSelectMenu: '',
    learningData: {
      fileId: -1,
      prediction: '',
      inputColumns: [],
      outputColumns: [],
      batchSize: -1,
      epoch: -1,
      lossFunction: '',
      optimizerFunction: '',
      memberId: -1,
      layers: [],
      name: '',
    },
    isSelectModel: '',
    detailStatusInfo: {
      id: null,
      accuracy: null,
      learningDate: null,
      learningProgress: null,
      name: null,
    },
    files: null,
    outputLengthForMultiple: 0,
  },
  getters: {
    getUserId(state) {
      return state.userId;
    },
    getDrawer(state) {
      return state.drawer;
    },
    getSuccessSignup(state) {
      return state.successSignup;
    },
    getSuccessAdjust(state) {
      return state.successAdjust;
    },
    isLogin(state) {
      state.loginState = state.name !== '';
      return state.loginState;
    },
    getName(state) {
      return state.name;
    },
    getEmail(state) {
      return state.email;
    },
    getSequence(state) {
      return state.sequence;
    },
    getDataSelectMenu(state) {
      return state.dataSelectMenu;
    },
    getFileId(state) {
      return state.learningData.fileId;
    },
    getLearningData(state) {
      return state.learningData;
    },
    getIsSelectModel(state) {
      return state.isSelectModel;
    },
    getPrediction(state) {
      return state.learningData.prediction;
    },
    getOutputColumnsLength(state) {
      return state.learningData.outputColumns.length;
    },
    getLayers(state) {
      return state.learningData.layers;
    },
    getMemberId(state) {
      return state.userId;
    },
    getDetailStatusInfo(state) {
      return state.detailStatusInfo;
    },
    getFileList(state) {
      return state.files;
    },
    getOutputLengthForMultiple(state) {
      return state.outputLengthForMultiple;
    },
  },
  mutations: {
    changeDrawer(state) {
      state.drawer = !state.drawer;
    },
    changeSuccessSignup(state) {
      state.successSignup = !state.successSignup;
    },
    changeSuccessAdjust(state) {
      state.successAdjust = !state.successAdjust;
    },
    setName(state, name) {
      state.name = name;
    },
    setUserId(state, id) {
      state.userId = id;
    },
    setEmail(state, email) {
      state.email = email;
    },
    clearEmail(state) {
      state.email = '';
    },
    nextSequence(state) {
      state.sequence++;
    },
    beforeSequence(state) {
      state.sequence--;
    },
    setDataSelectMenu(state, menu) {
      state.dataSelectMenu = menu;
    },
    setFileId(state, id) {
      state.learningData.fileId = id;
    },
    setInputColumns(state, columns) {
      state.learningData.inputColumns = columns;
    },
    setOutputColumns(state, columns) {
      state.learningData.outputColumns = columns;
    },
    setPrediction(state, prediction) {
      state.learningData.prediction = prediction;
    },
    setIsSelectModel(state, select) {
      state.isSelectModel = select;
    },
    setOptimizerFunction(state, optimizer) {
      state.learningData.optimizerFunction = optimizer;
    },
    setEpoch(state, epoch) {
      state.learningData.epoch = epoch;
    },
    setLossFunction(state, loss) {
      state.learningData.lossFunction = loss;
    },
    setBatchSize(state, batchSize) {
      state.learningData.batchSize = batchSize;
    },
    setLayers(state, layers) {
      state.learningData.layers = layers;
    },
    setMemberId(state) {
      state.learningData.memberId = state.userId;
    },
    setLearningName(state, name) {
      state.learningData.name = name;
    },
    setOutputLengthForMultiple(state, length) {
      state.outputLengthForMultiple = length;
    },
    resetData(state) {
      state.sequence = 1;
      state.dataSelectMenu = '';
      state.learningData = {
        fileId: -1,
        prediction: '',
        inputColumns: [],
        outputColumns: [],
        batchSize: -1,
        epoch: -1,
        lossFunction: '',
        optimizerFunction: '',
        memberId: -1,
        layers: [],
        name: '',
      };
      state.isSelectModel = '';
    },
    visibleLearningDialog(state) {
      state.learningDialog = true;
    },
    invisibleLearningDialog(state) {
      state.learningDialog = false;
    },
    setDetailStatusInfo(state, info) {
      state.detailStatusInfo.id = info.id;
      state.detailStatusInfo.accuracy = info.accuracy;
      state.detailStatusInfo.learningDate = info.learningDate;
      state.detailStatusInfo.learningProgress = info.learningProgress;
      state.detailStatusInfo.name = info.name;
    },
    setLearningProgress(state, progress) {
      state.detailStatusInfo.learningProgress = progress;
    },
    setLearningAccuracy(state, accuracy) {
      state.detailStatusInfo.accuracy = accuracy;
    },
    setFiles(state, files) {
      state.files = files;
    },
    resetUser(state) {
      state.userId = '0';
      state.name = '';
      state.email = '';
    },
  },
  actions: {
    async LOGIN({ commit }, userData) {
      const { data } = await loginUser(userData);
      commit('setUserId', data.id);
      commit('setName', data.name);
      commit('setEmail', data.email);
    },
    async ADJUST({ commit }, userData) {
      await adjustInfo(userData);
      commit('setName', userData.name);
      commit('changeSuccessAdjust');
    },
    async SET_FILES({ commit }, userId) {
      const { data } = await getFiles(userId);
      commit('setFiles', data);
    },
  },
  modules: {},
});
