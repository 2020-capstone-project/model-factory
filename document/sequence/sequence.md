# 학습 요청

```sequence
UI Server->API Server: 1) 학습 요청
API Server->DB: 2) 학습 정보 삽입
DB->API Server: 3) 학습 번호 반환
API Server->DB: 4) 모델 정보 삽입
DB->API Server: 5) 모델 번호 반환
API Server->DB: 6) 레이어 정보 삽입
API Server->DB: 7) 학습할 파일경로 조회
DB->API Server: 8) 경로 반환
Note over API Server: 9) 학습에 필요한 DTO 객체 생성
API Server->ClientService: 10) 딥러닝 요청
ClientService-> Learning API Server: 11) 딥러닝 요청
Note over Learning API Server: 12) JSON 수신
Learning API Server->LearningService: 13) 객체 생성
Learning API Server->LearningService: 14) 딥러닝 요청
LearningService->CustomHistory: 15) 객체 생성
CustomHistory->(Learning)ClientService: 16) 객체 생성
Note over LearningService: 17) 파일 불러오기
Note Over LearningService: 18) 데이터셋 분리
Note Over LearningService: 19) 모델 생성 및 구성
LearningService->CustomHistory: 20) 학습에 필요한 데이터 초기화
LearningService->LearningDto: 21) 객체 생성
LearningService->LearningThread: 22) 학습 요청
LearningThread->LearningDto: 23) 데이터 추출
LearningThread->Thread: 24) 스레드 생성 & 시작
LearningThread->LearningService: 25) 결과 반환
LearningService->Learning API Server: 26) 결과 반환
Learning API Server->ClientService: 27) 결과 반환
ClientService->API Server: 28) 결과 반환
API Server->UI Server: 29) 학습 번호 반환
```

<br>

# 학습 & 히스토리 저장

```sequence
LearningThread->Thread1: 1) 학습 요청
Note over Thread1: 2) 학습 시작
Thread1->CustomHistory: 3) 콜백 호출
Thread1->CustomHistory: ...
Note over CustomHistory: 4) 에포크 수 % 주기(1%) == 0
CustomHistory->HistoryDto: 5) 객체 생성
CustomHistory->ClientService: 6) 히스토리 저장 요청
ClientService->HistoryDto: 7) 데이터 추출
ClientService->Thread2: 8) 스레드 생성 & 시작
Note over Thread2: 9) 모델 저장
Thread2->API Server: 10) 히스토리 저장 요청
API Server->DB: 11) 히스토리 정보 삽입
API Server->Thread2: 12) 결과 반환
```