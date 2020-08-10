# 10차 API 설계

# Spring REST API

- [x] 해당 학습의 모델 다운로드 API 구현
- [ ] 파일 추가 API 구현
- [ ] 파일의 공개여부에 따라 가져오는 데이터가 달라지기 때문에, 현재 플랫폼이 갖고 있는 파일들 조회 API 수정


<br>

## 회원

### POST /auth/login

로그인 API

* *요청 데이터*

  ```javascript
  {
    "email": "String",    // 이메일
    "password": "String"  // 비밀번호
  }
  ```

* *응답 데이터*

  ```javascript
  {
    "id": 0,              // 회원 번호
    "name": "String",     // 이름
    "email": "String",    // 이메일
    "password": "String"  // 비밀번호
  }
  ```

* *결과 코드*

  * `200` : 로그인 성공
  * `404` : 일치하는 아이디가 존재하지 않을 때
  * `401` : 비밀번호가 맞지 않을 때
  * `400` : 이메일이나 비밀번호가 빈 문자열이거나 이메일 형식이 맞지 않을 때

<br>

### POST /auth/signup

회원가입 API

* *요청 데이터*

  ```javascript
  {
    "name": "String",     // 이름
    "email": "String",    // 이메일
    "password": "String"  // 비밀번호
  }
  ```

* *결과 코드*

  * `201` : 회원가입 성공
  * `409` : 중복되는 이메일 존재
  * `400` : 이름이나 이메일, 비밀번호가 비어 있거나 공백이 있을 경우 및 이메일 형식이 맞지 않을 경우

<br>

### PUT /info

회원정보 수정 API

* *요청 데이터*

  ```javascript
  {
    "name": "String",             // 이름
    "email": "String",            // 이메일
    "currentPassword": "String",  // 기존 비밀번호
    "newPassword": "String"       // 새로운 비밀번호
  }
  ```

  

* *결과 코드*

  * `200` : 회원정보 수정 성공
  * `404` : 일치하는 이메일이 존재하지 않을 경우
  * `401` : 기존 비밀번호가 일치하지 않을 때
  * `400` : 이름, 이메일, 비밀번호가 빈 문자열이거나 공백일 경우

<br>

## 새로운 데이터 삽입

### POST /upload

파일 업로드 요청 API

<br>

## 기존 데이터 선택

### GET /files

현재 플랫폼이 갖고 있는 파일들 조회 API

* *응답 데이터*

  ```javascript
  [
    {
        "id": 0,                  // 파일 번호
        "name": "String",         // 파일 이름
        "description": "String"   // 파일 설명
    },
  ]
  ```

* *SQL*

  ```sql
  select id, name, description
  from _FILE
  ```

<br>

## 상세 데이터 선택

### GET /files/{fileId}/columns

파일의 상세 데이터 조회 API

* *응답 데이터*

  ```javascript
  [
    {
      "id": 0,                  // 컬럼 번호
      "name": "String",         // 컬럼 이름
      "description": "String",  // 컬럼 설명
      "data": [                 // 예시 값
        "String",
      ]
    },
  ]
  ```

* *SQL*

  ```sql
  select id, name, description
  from _colum
  where fileId = #{fileId}
  ```

  ```sql
  select value
  from data
  where columnId = #{id}
  ```

<br>

## 학습 요청

### POST /learning

학습 요청 API

* *요청 데이터*

  ```javascript
  {
    "fileId": 0,                          // 학습시킬 파일 번호
    "name": "String",                     // 학습명
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
        "information": {
          "name": 'String',                 // 레이어 이름
          "value": 0,                       // 특정 값
          "activationFunction": "String",   // 활성화 함수
          "neuronCount": 0,                 // 뉴런 개수
        }
      },
    ]
  }
  ```

* *응답 데이터*

  ```javascript
  {
    "learningId": 0 // 학습 번호
  }
  ```

* *매퍼*

  1. 학습 생성

     ```sql
     insert into learning 
     (batchSize, epoch, lossFunction, optimizerFunction, learningDate, memberId) values
     (#{batchSize}, #{epoch}, #{loss}, #{optimizer}, now(), #{memberId})
     returning id
     ```

  2. 모델 생성

     ```sql
     insert into model
     (createdDate, learninId) values (now(), #{learningId})
     returning id
     ```

  3. 레이어 생성

     ```sql
     insert into layer
     (number, information, modelId) values
     (#{number}, #{information}, #{modelId})
     ```

  4. 파일 경로 조회

     ```sql
     select path
     from _file
     where id = #{fileId}
     ```

<br>

## 히스토리 저장

### POST /history

히스토리 정보 삽입 API

* *요청 데이터*

  ```javascript
  {
    "learningId": 0,       // 학습 번호
    "epochCount": 0,       // 실행된 에포크 수
    "trainLoss": 0.0,      // 훈련 손실값
    "trainAccuracy": 0.0,  // 훈련 정확도
    "valLoss": 0.0,        // 평가 손실값
    "valAccuracy": 0.0     // 평가 정확도
  }
  ```

* *매퍼*

  ```sql
  insert into history (trainLoss, trainAccuracy, verificationLoss, verificationAccuracy, createdDate, executedEpoch, learningId) values
  (#{trainLoss}, #{trainAccuracy}, #{valLoss}, #{valAccuracy}, now(), #{epochCount}, #{learningId})
  ```


<br>

## 학습 현황

### GET /members/{id}/learning-status

학습 현황 리스트 조회 API

* *응답 데이터*

  ```javascript
  {
    "id": 0,                              // 학습 번호
    "name": "이름",                        // 학습명
    "learningDate": "2020-01-01 01:01",   // 학습 시작 날짜
    "learningState": "진행중",              // 학습 상태
    "learningProgress": 50,               // 학습 진행률
    "accuracy" : 12.31                    // 모델 정확도
  }
  ```

* *매퍼*

  ```sql
  select l.id, l.name, l.learningDate "learningDate", round(h.executedEpoch * 1.0 / l.epoch * 100, 0) "learningProgress", round((h.validationAccuracy * 100)::numeric, 2) "accuracy"
  from learning l left join history h on l.id = h.learningId
  where l.memberId = #{id}
  and h.createdDate in (
    select max(createdDate)
    from history
    group by learningId
  ) or h.createdDate is null;
  ```

<br>

### GET /members/{memberId}/learning-status/{learningId}

해당 학습 번호의 학습 현황 조회 API

* *응답 데이터*

  ```javascript
  {
    "trainLoss": [                   // 훈련 손실값 리스트
      1.0,
    ],
    "trainAccuracy": [               // 훈련 정확도 리스트
      1.0,
    ],
    "validationLoss": [              // 평가 손실값 리스트
      1.0,
    ],
    "validationAccuracy": [          // 평가 정확도 리스트
      1.0,
    ],
    "epoch": 10000,                  // 총 에포크
    "batchSize": 32,                 // 배치 사이즈
    "lossFunction": "binary",        // 손실 함수
    "optimizerFunction": "binary"    // 최적화 함수
  }
  ```

* *매퍼*

  ```sql
  -- 손실값, 정확도 리스트 (오름차순)
  select trainLoss, round((trainAccuracy * 100)::numeric, 2) "trainAccuracy", validationLoss, round((validationAccuracy * 100)::numeric, 2) "validationAccuracy"
  from history
  where learningId = #{learningId}
  order by executedEpoch;
  
  -- 하이퍼 파라미터
  select epoch, batchSize, lossFunction, optimizerFunction
  from learning
  where id = #{learningId};
  ```

<br>

### GET /members/{memberId}/learning-status/{learningId}/download

해당 학습의 모델 다운로드 API

* *응답 데이터*
  * **model.h5** 파일 반환

<br>

# Flask REST API

## 학습 요청

### POST /learning

학습 요청 API

* *요청 데이터*

  ```javascript
  {
    "learningId": 0,												// 학습 번호
    "learningFilepath": "String",           // 학습시킬 파일 경로
    "saveModelFilepath": "String",          // 학습 모델 저장 경로
    "saveDiagramFilepath": "String",        // 모델 SVG 다이어그램 저장 경로
    "prediction": "String",                 // 예측 정보
    "inputColumn" : [                       // 학습 입력 컬럼
      "String",                             // 컬럼 이름
    ],
    "outputColumn" : [                      // 학습 목표 컬럼
      "String",                             // 컬럼 이름
    ],
    "batchSize": 0,                         // 배치 사이즈
    "epoch": 0,                             // 에포크
    "lossFunction": "String",               // 손실 함수
    "optimizerFunction": "String",          // 최적화 함수
    "layers": [                             // 레이어
      {
        "number": 0,                        // 번호(0, 1, 2, ...)
        "activationFunction": "String",     // 활성화 함수
        "neuronCoun": 0,                    // 뉴런 개수
      },
    ]
  }
  ```

* *응답 데이터*

  ```javascript
  {
    "filepath": String // 모델 SVG 파일 경로
  }
  ```

