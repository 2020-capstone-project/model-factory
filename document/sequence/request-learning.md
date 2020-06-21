# Sequence Diagram

## 학습 요청

![image](https://user-images.githubusercontent.com/43431081/84881101-5f79ff80-b0c8-11ea-8026-2b7f281e80a1.png)

### 1) 학습 요청

* **URL** : `POST /learning`

* **body(JSON)**

  ```json
  {
    "fileId": 0,                          // 학습시킬 파일 번호
    "prediction": "String",               // 예측 정보 (numeric: 수치,
                                          // 	binary : 이진, multiple : 다중)
    
    "inputColumns" : [                    // 학습 입력 컬럼
      "String",                           // 컬럼 이름
    ],
    "outputColumns" : [                   // 학습 목표 컬럼
      "String",                           // 컬럼 이름
    ],
    "batchSize": 0,                       // 배치 사이즈
    "epoch": 0,                           // 에포크
    "lossFunction": "String",             // 손실 함수
    "optimizerFunction": "String",        // 최적화 함수
    "memberId": 0,                        // 학습을 요청한 회원 번호
    "layers": [                           // 레이어
      {
        "number": 0,                      // 번호(0, 1, 2, ...)
        "activationFunction": "String",   // 활성화 함수
        "neuronCount": 0,                 // 뉴런 개수
      },
    ]
  }
  ```

- [ ] 구현
  - [x] API 설계
  - [x] API 구현
  - [ ] UI Server가 API 요청 구현
- [ ] 테스트
  - [x] API Client(Postman)로 API 요청 테스트
  - [ ] UI Server가 API 요청 테스트

<br>

### 2) 학습 정보 삽입

- [ ] 구현
  - [ ] API 로직 구현
    - [x] Controller
    - [x] Service
    - [x] Mapper
    - [ ] Exception Handling
- [ ] 테스트
  - [x] API Client(Postman) API 요청 테스트
  - [ ] 예외 처리 테스트

<br>

### 3) 학습 번호 반환

- [ ] 구현
  - [ ] API 로직 구현
    - [x] Controller
    - [x] Service
    - [x] Mapper
    - [ ] Exception Handling
- [ ] 테스트
  - [x] API Client(Postman)로 API 요청 테스트
  - [ ] 예외 처리 테스트

<br>


### 4) 모델 정보 삽입

- [ ] 구현
  - [ ] API 로직 구현
    - [x] Controller
    - [x] Service
    - [x] Mapper
    - [ ] Exception Handling
- [ ] 테스트
  - [x] API Client(Postman)로 API 요청 테스트
  - [ ] 예외 처리 테스트

<br>

### 5) 모델 번호 반환

- [ ] 구현
  - [ ] API 로직 구현
    - [x] Controller
    - [x] Service
    - [x] Mapper
    - [ ] Exception Handling
- [ ] 테스트
  - [x] API Client(Postman)로 API 요청 테스트
  - [ ] 예외 처리 테스트


<br>
### 6) 레이어 정보 삽입

- [ ] 구현
  - [ ] API 로직 구현
    - [x] Controller
    - [x] Service
    - [x] Mapper
    - [ ] Exception Handling
- [ ] 테스트
  - [x] API Client(Postman)로 API 요청 테스트
  - [ ] 예외 처리 테스트

<br>

### 7) 학습할 파일 경로 조회

- [ ] 구현
  - [ ] API 로직 구현
    - [x] Controller
    - [x] Service
    - [x] Mapper
    - [ ] Exception Handling
- [ ] 테스트
  - [x] API Client(Postman)로 API 요청 테스트
  - [ ] 예외 처리 테스트

<br>

### 8) 경로 반환

- [ ] 구현
  - [ ] API 로직 구현
    - [x] Controller
    - [x] Service
    - [x] Mapper
    - [ ] Exception Handling
- [ ] 테스트
  - [x] API Client(Postman)로 API 요청 테스트
  - [ ] 예외 처리 테스트

<br>

### 9) 학습에 필요한 DTO 객체 생성

- [ ] 구현
  - [x] API 로직 구현
    - [x] Controller
- [ ] 테스트
  - [x] API Client(Postman)로 API 요청 테스트
  - [ ] 예외 처리 테스트

<br>

### 10) 딥러닝 요청

학습 요청 메서드를 호출하면서 메서드의 파라미터로 DTO 객체를 전달

- [ ] 구현
  - [x] API 로직 구현
    - [x] Controller
- [ ] 테스트
  - [x] API Client(Postman)로 API 요청 테스트
  - [ ] 예외 처리 테스트

<br>

### 11) 딥러닝 요청

POST /learning

- [x] 구현
  - [x] API 로직 구현
    - [x] Service
- [ ] 테스트
  - [x] API Client(Postman)로 API 요청 테스트
  - [ ] 예외 처리 테스트

<br>

### 12) JSON 수신

- [ ] 구현
  - [ ] API 로직 구현
- [ ] 테스트
  - [ ] API Client(Postman)로 API 요청 테스트
  - [ ] 예외 처리 테스트

<br>

### 13) 객체 생성

LearningService 객체를 생성하고 JSON 데이터를 통해 필드 초기화

- [ ] 구현
  - [x] API 로직 구현
- [ ] 테스트
  - [x] API Client(Postman)로 API 요청 테스트
  - [ ] 예외 처리 테스트

<br>

### 14) 딥러닝 요청

메서드 호출을 통해 딥러닝 요청

- [ ] 구현
  - [x] API 로직 구현
- [ ] 테스트
  - [x] API Client(Postman)로 API 요청 테스트
  - [ ] 예외 처리 테스트

<br>

### 15) 객체 생성

콜백 클래스를 직접 커스터마이징해서 구현한 객체를 생성한다.

- [ ] 구현
  - [x] 로직 구현
- [ ] 테스트
  - [x] API Client(Postman)로 API 요청 테스트
  - [ ] 예외 처리 테스트

<br>

### 16) 객체 생성

Learning Server 와 API Server와 통신할 수 있도록 하는 객체 생성

- [ ] 구현
  - [x] 로직 구현
- [ ] 테스트
  - [x] API Client(Postman)로 API 요청 테스트
  - [ ] 예외 처리 테스트

<br>

### 17) 파일 불러오기

- [ ] 구현
  - [x] 로직 구현
- [ ] 테스트
  - [x] API Client(Postman)로 API 요청 테스트
  - [ ] 예외 처리 테스트

<br>

### 18) 데이터셋 분리

- [ ] 구현
  - [x] 로직 구현
- [ ] 테스트
  - [x] API Client(Postman)로 API 요청 테스트
  - [ ] 예외 처리 테스트

<br>

### 19) 모델 생성 및 구성

- [ ] 구현
  - [x] 로직 구현
- [ ] 테스트
  - [x] API Client(Postman)로 API 요청 테스트
  - [ ] 예외 처리 테스트

<br>

### 20) 학습에 필요한 데이터 초기화

- [ ] 구현
  - [x] 로직 구현
- [ ] 테스트
  - [x] API Client(Postman)로 API 요청 테스트
  - [ ] 예외 처리 테스트

<br>

### 21) 객체 생성

학습에 필요한 데이터를 갖는 DTO 객체 생성

- [ ] 구현
  - [x] 로직 구현
- [ ] 테스트
  - [x] API Client(Postman)로 API 요청 테스트
  - [ ] 예외 처리 테스트

<br>

### 22) 학습 요청

학습 요청 메서드를 호출하면서 메서드의 파라미터로 DTO 객체를 전달

- [ ] 구현
  - [x] 로직 구현
- [ ] 테스트
  - [x] API Client(Postman)로 API 요청 테스트
  - [ ] 예외 처리 테스트

<br>

### 23) 데이터 추출

학습에 필요한 데이터들 추출

- [ ] 구현
  - [x] 로직 구현
- [ ] 테스트
  - [x] API Client(Postman)로 API 요청 테스트
  - [ ] 예외 처리 테스트

<br>

### 24) 스레드 생성 & 시작

스레드 생성과 동시에 학습하는 메서드와 학습 메서드에 필요한 학습 정보들을 전달하고 곧바로 실행시킨다.

- [ ] 구현
  - [x] 로직 구현
- [ ] 테스트
  - [x] API Client(Postman)로 API 요청 테스트
  - [ ] 예외 처리 테스트

<br>

### 25) 결과 반환

- [ ] 구현
  - [ ] 로직 구현
  - [ ] 예외 처리
- [ ] 테스트
  - [ ] API Client(Postman)로 API 요청 테스트
  - [ ] 예외 처리 테스트

<br>

### 26) 결과 반환

- [ ] 구현
  - [ ] 로직 구현
  - [ ] 예외 처리
- [ ] 테스트
  - [ ] API Client(Postman)로 API 요청 테스트
  - [ ] 예외 처리 테스트

<br>

### 27) 결과 반환

- [ ] 구현
  - [ ] 로직 구현
  - [ ] 예외 처리
- [ ] 테스트
  - [ ] API Client(Postman)로 API 요청 테스트
  - [ ] 예외 처리 테스트

<br>

### 28) 결과 반환

- [ ] 구현
  - [ ] 로직 구현
  - [ ] 예외 처리
- [ ] 테스트
  - [ ] API Client(Postman)로 API 요청 테스트
  - [ ] 예외 처리 테스트

<br>

### 29) 학습 번호 반환

- [ ] 구현
  - [ ] 로직 구현
  - [ ] 예외 처리
- [ ] 테스트
  - [ ] API Client(Postman)로 API 요청 테스트
  - [ ] 예외 처리 테스트
