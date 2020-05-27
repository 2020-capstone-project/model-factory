# 2차 DB 설계

## 요구사항

* 회원은 식별할 수 있는 번호와 이름, 이메일, 비밀번호를 갖는다.
* 학습 파일은 파일 번호와 파일 이름, 파일 경로, 파일 설명, 업로드한 회원 번호를 갖는다.
  * 학습 파일은 회원이 업로드하거나 플랫폼이 업로드한다.
* 학습 파일에는 컬럼들이 존재한다.
* 컬럼은 컬럼 번호, 컬럼 이름, 컬럼 설명, 파일 번호를 갖는다.
* 데이터는 값과 컬럼 번호를 갖는다.
  * 한 컬럼의 3개 정도 데이터를 저장해놓는다.
* 학습은 학습 번호와 배치 사이즈, 에포크, 손실 함수, 최적화 함수, 학습 시작한 날짜, 학습 시킨 회원 번호를 갖는다.
* 히스토리는 번호, 훈련 손실값, 훈련 정확도, 검증 손실값, 검증 정확도, 시험 손실값, 시험 정확도, 히스토리를 생성한 날짜, 학습 번호, 실행된 에포크를 갖는다.
* 모델은 모델 번호와 레이어, 모델 파일 경로, 모델 생성한 날짜, 학습 번호를 갖는다.
* 레이어는 활성화 함수, 뉴런 개수, 모델 번호를 갖는다.
* 모델 구성도는 학습 번호, 구성도 파일 경로를 갖는다.

<br>

## 명명

* **회원(MEMBER)**
  * 번호(id)
  * 이름(name)
  * 이메일(email)
  * 비밀번호(password)
* **학습파일(_FILE)**
  * 번호(id)
  * 파일 이름(name)
  * 파일 경로(path)
  * 파일 설명(description)
  * 업로드한 회원 번호(memberId)
* **컬럼(_COLUMN)**
  * 번호(id)
  * 컬럼 이름(name)
  * 컬럼 설명(description)
  * 해당 파일 번호(fileId)
* **데이터(DATA)**
  * 번호(id)
  * 값(value)
  * 컬럼 번호(columnId)
* **학습(LEARNING)**
  * 번호(id)
  * 배치 사이즈(batchSize)
  * 에포크(epoch)
  * 손실 함수(lossFunction)
  * 최적화 함수(optimizerFunction)
  * 학습을 요청한 회원 번호(memberId)
  * 학습 시작한 날짜(learningDate)
* **히스토리(HISTORY)**
  * 번호(id)
  * 훈련 손실값(trainLoss)
  * 훈련 정확도(trainAccuracy)
  * 검증 손실값(verificationLoss)
  * 검증 정확도(verificationAccuracy)
  * 시험 손실값(testLoss)
  * 시험 정확도(testAccuracy)
  * 히스토리 생성 날짜(createdDate)
  * 실행된 에포크(executedEpoch)
  * 학습 번호(learningId)
* **모델(MODEL)**
  * 번호(id)
  * 모델 파일 경로(filepath)
  * 모델 생성한 날짜(createdDate)
  * 학습 번호(learningId)
* **레이어(LAYER)**
  * 번호(id)
  * 번호(number)
  * 활성화 함수(activationFunction)
  * 뉴런 개수(neuronCount)
  * 모델 번호(modelId)
* **모델 구성도(MODEL_DIAGRAM)**
  * 번호(id)
  * 학습 번호(modelId)
  * 구성도 파일 경로(filepath)

<br>

## ER 모델

![image](https://user-images.githubusercontent.com/43431081/82983753-a6c22280-a02b-11ea-9e77-b058d5768462.png)

<br>

## SQL

* **MEMBER**

  ```sql
  create table MEMBER (
    id serial primary key,
    name varchar(15),
    email varchar(30),
    password varchar(15)
  );
  ```

* **_FILE**

  ```sql
  create table _FILE (
    id serial primary key,
    name varchar(50),
    path varchar(100),
    description text,
    memberId integer,
    foreign key (memberId) references member (id)
  );
  ```

* **_COLUMN**

  ```sql
  create table _COLUMN (
    id serial primary key,
    name varchar(50),
    description text,
    fileId integer,
    foreign key (fileId) references _file (id)
  );
  ```

* **DATA**

  ```sql
  create table DATA (
    id serial primary key,
    value double precision,
    columnId integer,
    foreign key (columnId) references _column (id)
  );
  ```

* **LEARNING**

  ```sql
  create table LEARNING (
    id serial primary key,
    batchSize integer,
    epoch integer,
    lossFunction varchar(20),
    optimizerFunction varchar(20),
    learningDate timestamp,
    memberId integer,
    foreign key (memberId) references member (id)
  );
  ```

* **HISTORY**

  ```sql
  create table HISTORY (
    id serial primary key,
    trainLoss double precision,
    trainAccuracy double precision,
    verificationLoss double precision,
    verificationAccuracy double precision,
    testLoss double precision,
    testAccuracy double precision,
    createdDate timestamp,
    executedEpoch integer,
    learningId integer,
    foreign key (learningId) references learning (id)
  );
  ```

* **MODEL**

  ```sql
  create table MODEL (
    id serial primary key,
    filepath varchar(100),
    createdDate timestamp,
    learningId integer,
    foreign key (learningId) references learning (id)
  );
  ```

*  **MODEL_DIAGRAM**

  ```sql
  create table MODEL_DIAGRAM (
    id serial primary key,
    filepath varchar(100),
    modelId integer,
    foreign key (modelId) references model (id)
  );
  ```

* **LAYER**

  ```sql
  create table LAYER (
    id serial primary key,
    number integer,
    activationFunction varchar(20),
    neuronCount integer,
    modelId integer,
    foreign key (modelId) references model (id)
  );
  ```