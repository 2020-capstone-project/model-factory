# 3차 DB 설계

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
  * 컬럼 최대값(maxValue)
  * 컬럼 최소값(minValue)
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
  * 학습 번호(learningId)
* **모델 구성도(MODEL_DIAGRAM)**
  * 번호(id)
  * 모델 번호(modelId)
  * 구성도 파일 경로(filepath)

<br>

## ER 모델

![image](https://user-images.githubusercontent.com/43431081/83390756-6862a400-a42d-11ea-969b-fde0b2957337.png)

<br>

## SQL

### MEMBER

```sql
create table MEMBER (
  id serial primary key,
  name varchar(15),
  email varchar(30),
  password varchar(15)
);
```

<br>

### _FILE

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

* **INSERT**

  ```sql
  insert into _file
  (name, path, description, memberId) values
  ('홍릉_도심_미세먼지_측정자료', '/Users/sangminlee/model-factory/restapiserver/src/main/resources/홍릉_도심_미세먼지_측정자료.csv', '홍등 도심의 미세먼지를 측정한 자료 입니다.', 1);
  ```

<br>

### _COLUMN

```sql
create table _COLUMN (
  id serial primary key,
  name varchar(50),
  description text,
  fileId integer,
  foreign key (fileId) references _file (id)
);
```

* **INSERT**

  ```sql
  insert into _column
  (name, description, fileId) values
  ('관측시간', '미세먼지를 관측한 시간을 나타낸다', '1'),
  ('Avoc-PM10(㎍/m³)', '미세먼지 농도', '1'),
  ('Avoc-PM2.5(㎍/m³)', '초미세먼지 농도', '1'),
  ('Avoc-PM1.0(㎍/m³)', '극초미세먼지 농도', '1'),
  ('Avoc-TC', '', '1'),
  ('Bvoc-TC', '', '1'),
  ('온도(℃)', '', '1'),
  ('습도(%)', '', '1'),
  ('풍향', '', '1'),
  ('풍속(㎧)', '', '1');
  ```

<br>

### DATA

```sql
create table DATA (
  id serial primary key,
  value varchar(50),
  columnId integer,
  foreign key (columnId) references _column (id)
);
```

* **INSERT**

  ```sql
  insert into data (value, columnId) values
  ('2019.8.29 10:50', 1),
  ('2019.8.29 11:00', 1),
  ('2019.8.29 11:10', 1),
  ('20.1', 2),
  ('18.1', 2),
  ('15.6', 2),
  ('16.8', 3),
  ('16.2', 3),
  ('13.9', 3),
  ('13.8', 4),
  ('14.2', 4),
  ('12.3', 4),
  ('218056.7', 5),
  ('202776.1', 5),
  ('169940.3', 5),
  ('219992.8', 6),
  ('38767.2', 6),
  ('46447.7', 6),
  ('24.7', 7),
  ('21.2', 7),
  ('20.3', 7),
  ('80.1', 8),
  ('94', 8),
  ('95.1', 8),
  ('1.4', 9),
  ('0.8', 9),
  ('1.2', 9),
  ('271.7', 10),
  ('250.9', 10),
  ('220.3', 10);
  ```

<br>

### LEARNING

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

<br>

### HISTORY

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

<br>

### MODEL

```sql
create table MODEL (
  id serial primary key,
  filepath varchar(100),
  createdDate timestamp,
  learningId integer,
  foreign key (learningId) references learning (id)
);
```

<br>

### MODEL_DIAGRAM

```sql
create table MODEL_DIAGRAM (
  id serial primary key,
  filepath varchar(100),
  modelId integer,
  foreign key (modelId) references model (id)
);
```

<br>

### LAYER

```sql
create table LAYER (
  id serial primary key,
  number integer,
  activationFunction varchar(20),
  neuronCount integer,
  learningId integer,
  foreign key (learningId) references learning (id)
);
```