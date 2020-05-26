# 2차 DB 설계

## 요구사항

* 회원은 식별할 수 있는 번호와 이름, 이메일, 비밀번호를 갖는다.
* 파일은 파일 번호와 파일 이름, 파일 경로, 파일 설명, 업로드한 회원 번호를 갖는다.
  * 파일은 회원이 업로드하거나 플랫폼이 업로드한다.
* 파일에는 컬럼들이 존재한다.
* 컬럼은 컬럼 번호, 컬럼 이름, 컬럼 설명, 파일 번호를 갖는다.
* 데이터는 값과 컬럼 번호를 갖는다.
  * 한 컬럼의 3개 정도 데이터를 저장해놓는다.
* 학습은 학습 번호와 배치 사이즈, 에포크, 손실 함수, 최적화 함수, 학습 시킨 회원 번호를 갖는다.
* 히스토리는 훈련 손실값, 훈련 정확도, 검증 손실값, 검증 정확도, 시험 손실값, 시험 정확도, 데이터를 생성한 날짜, 학습 번호를 갖는다.
* 모델은 모델 번호와 레이어, 모델 파일 경로, 모델 생성한 날짜, 학습 번호를 갖는다.
* 레이어는 활성화 함수, 뉴런 개수, 모델 번호를 갖는다.
* 모델 구성도는 학습 번호, 구성도 파일 경로를 갖는다.

<br>

## 명명

* **회원(Member)**
  * 번호(id)
  * 이름(name)
  * 이메일(email)
  * 비밀번호(password)

<br>

## ER 모델

### 회원

<img src="https://user-images.githubusercontent.com/43431081/79348199-a6843100-7f6f-11ea-9ac8-f00d736bb33d.png" alt="image" style="zoom:33%;" />

<br>

## ER Diagram

### 회원

<img src="https://user-images.githubusercontent.com/43431081/79348283-c3b8ff80-7f6f-11ea-95bc-1c8dffe0d9e1.png" alt="image" style="zoom:33%;" />

<br>

## SQL

* **MEMBER**

  ```sql
  create table MEMBER (
    id serial primary key,
    name text,
    email text,
    password text
  );
  ```