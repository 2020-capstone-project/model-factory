<template>
  <v-layout align-center justify-center>
    <div>
      <v-card class="primary mx-auto outlined mb-15" elevation="20" shaped>
        <header class="py-5 mb-5">
          <div class="container h-100">
            <div class="row h-100 align-items-center">
              <div class="col-lg-12">
                <h1 class="display-4 text-white mb-2">
                  웹 기반 딥러닝 자동화 플랫폼<br /><b>Model Factory</b>
                </h1>
                <p class="lead mb-5 text-white">
                  편리한 사용자 인터페이스와 많은 데이터 그리고 학습 상태
                  시각화를 제공하여 딥러닝을 손쉽게 자동화 할 수 있도록 합니다.
                </p>
              </div>
            </div>
          </div>
        </header>
      </v-card>

      <!-- Page Content -->
      <div class="container">
        <div class="container">
          <h2 class="text-center">SERVICES</h2>
          <div class="row features-icons text-center">
            <div class="col-lg-3">
              <div class="features-icons-item mx-auto mb-5 mb-lg-0 mb-lg-3">
                <div class="features-icons-icon d-flex">
                  <i class="fas fa-images m-auto text-primary"></i>
                </div>
                <h5>편리한 UI</h5>
              </div>
            </div>
            <div class="col-lg-3">
              <div class="features-icons-item mx-auto mb-5 mb-lg-0 mb-lg-3">
                <div class="features-icons-icon d-flex">
                  <i class="fas fa-signal m-auto text-primary"></i>
                </div>
                <h5>학습 시각화</h5>
              </div>
            </div>
            <div class="col-lg-3">
              <div class="features-icons-item mx-auto mb-0 mb-lg-3">
                <div class="features-icons-icon d-flex">
                  <i class="fas fa-file m-auto text-primary"></i>
                </div>
                <h5>데이터 제공</h5>
              </div>
            </div>
            <div class="col-lg-3">
              <div class="features-icons-item mx-auto mb-0 mb-lg-3">
                <div class="features-icons-icon d-flex">
                  <i class="fas fa-sync-alt m-auto text-primary"></i>
                </div>
                <h5>딥러닝 자동화</h5>
              </div>
            </div>
          </div>
        </div>
      </div>

      <div class="container">
        <div class="row">
          <div>
            <h2>What We Do</h2>
            <hr />
            <p>
              딥러닝은 많은 분야에서 빠질 수 없는 핵심 기술이다. 그러나 비전공자
              및 여러 중소기업들은 이용하고 싶어도 어려운 이론과 사용법 때문에
              접근하기 힘들다는 한계가 있다. 이 자동화 플랫폼은 위 한계를
              극복하기 위해 편리한 사용자 인터페이스로 높은 접근성을 제공한다.
              또한 학습 데이터 제공으로 데이터에 대한 고민을 해결하고 딥러닝을
              자동화하여 사용자는 복잡한 프로그래밍 없이 딥러닝을 구축할 수
              있다.
            </p>
          </div>
        </div>
      </div>

      <div class="container">
        <div class="text-center">
          <button
            class="btn btn-primary text-uppercase mt-10 mb-5"
            style="font-size: 1.9rem"
            @click="() => $router.push('/learning')"
          >
            학습 시작 하기
          </button>
        </div>
      </div>
    </div>
  </v-layout>
</template>

<script>
export default {};
</script>
