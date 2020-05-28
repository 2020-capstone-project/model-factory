# 3차 요구 사항 설계

## 순서도

![image](https://user-images.githubusercontent.com/43431081/83146392-2980d580-a131-11ea-86e5-04eaa6cb56af.png)

<br>

## 구현 사항

### 01. 학습 데이터 선택 or 삽입 선택 페이지

![image](https://user-images.githubusercontent.com/43431081/82731803-2f974080-9d44-11ea-8d59-c59dcf8795aa.png)

<br>

![image](https://user-images.githubusercontent.com/43431081/82731933-04f9b780-9d45-11ea-9e1d-fc44488468db.png)

<br>

1. 사용자가 학습 데이터 선택 or 삽입 선택 페이지 요청

2. 웹은 HTTP 통신으로 프론트엔드 서버인 Vue.js에게 전달

3. Vue.js는 해당 화면 반환
   * 사용자가 기존 데이터 선택 버튼 클릭
     1. Vue는 기존 데이터 선택 페이지 반환
   * 사용자가 새로운 데이터 삽입 버튼 클릭
     1. Vue는 새로운 데이터 삽입 페이지 반환

<br>

### 02-1. 새로운 데이터 삽입 페이지

![image](https://user-images.githubusercontent.com/43431081/82731900-e09ddb00-9d44-11ea-930d-07996a863897.png)

<br>

![image](https://user-images.githubusercontent.com/43431081/82811231-38664e80-9ecb-11ea-96a7-dd1b8265eb6b.png)

<br>

1. 사용자가 학습 데이터 삽입 페이지 요청
   * 삽입할 파일의 예시를 보여준다.
   * 파일 첨부 버튼이 존재한다.

2. 웹은 HTTP 통신으로 프론트엔드 서버인 Vue.js에게 전달

3. 사용자가 파일을 첨부하고 완료 버튼을 누를 시, Vue에게 첨부된 파일과 다음 페이지 요청을 보낸다.

4. Vue.js는 첨부된 파일을 Spring에게 파일 저장을 요청한다.

5. Spring은 파일을 저장하고 PostgreSQL DBMS에게 파일 이름과 파일 경로, 파일 설명, 컬럼들, 컬럼의 데이터 3개, 파일을 첨부한 유저 식별자를 삽입 요청한다.

6. PostgreSQL은 삽입 요청을 처리하고 Spring에게 결과 반환

7. Spring은 파일 저장과 데이터 삽입을 성공 시, 파일 식별자를 JSON 형식으로 Vue에게 반환

8. Vue는 파일 식별자를 받아서 저장하고, 데이터 선택 페이지를 반환한다.

<br>

### 02-2. 기존 데이터 선택 페이지

![image](https://user-images.githubusercontent.com/43431081/82732064-e942e100-9d45-11ea-8939-c2513e5f3ea4.png)

<br>

![image](https://user-images.githubusercontent.com/43431081/82731954-1e9aff00-9d45-11ea-93d3-9b348ff2e84f.png)

<br>

1. 사용자가 기존 데이터 선택 페이지 요청

2. 웹은 HTTP 통신으로 프론트엔드 서버인 Vue.js에게 전달

3. Vue.js는 현재 플랫폼이 갖고 있는 파일들의 파일명을 보여주기 위해서 Spring에게 REST 방식으로 파일명들과 식별자들, 설명들을 요청

4. Spring은 PostgreSQL DBMS에게 파일명들과 식별자들, 설명들을 요청

5. PostgreSQL은 파일명들과 식별자들, 파일 설명들을 Spring에게 반환

6. Spring은 데이터들을 JSON 형식으로 Vue에게 전달

7. Vue는 파일 명들과 설명들을 데이터 선택화면에 바인딩 후 사용자에게 반환

8. 파일을 선택하고 “선택” 버튼을 누르면 Vue에서 파일 식별자를 저장하고 데이터 선택 페이지를 반환한다.

<br>

### 03. 상세 데이터 선택 페이지

![image](https://user-images.githubusercontent.com/43431081/82732103-198a7f80-9d46-11ea-9306-fbd4105c979e.png)

<br>

![image](https://user-images.githubusercontent.com/43431081/82731954-1e9aff00-9d45-11ea-93d3-9b348ff2e84f.png)

<br>

1. 사용자가 상세 데이터 선택 페이지 요청
   * 컬럼 번호, 컬럼명, 컬럼 설명, 사용 여부 토글, 목표 변수 체크 박스, 예시 값들을 표시

2. 웹은 HTTP 통신으로 프론트엔드 서버인 Vue.js에게 전달

3. Vue는 Spring에게 해당 파일의 컬럼 정보(컬럼명, 설명, 등)들을 조회 요청

4. Spring은 PostgreSQL DBMS에게 컬럼 정보들을 조회 요청

5. PostgreSQL은 조회 요청을 처리하고 Spring에게 컬럼 정보들을 반환

6. Spring은 컬럼 정보들을 JSON 형식으로 Vue에게 반환

7. Vue는 Spring에게 받은 컬럼 정보들을 화면에 바인딩한 후 사용자에게 반환

8. 사용자가 사용할 컬럼과 학습을 목표로 하는 변수를 체크한 뒤, “다음” 버튼을 누르면 사용할 컬럼명들과 목표 변수의 컬럼명을 Vue에서 저장하고 학습 방법 선택 페이지를 반환한다.

<br>

### 04. 수치 or 이진분류 or 다중분류 예측 선택 페이지

![image](https://user-images.githubusercontent.com/43431081/83146980-00ad1000-a132-11ea-88f2-618cb3883914.png)

<br>

![image](https://user-images.githubusercontent.com/43431081/82731933-04f9b780-9d45-11ea-9e1d-fc44488468db.png)

<br>

1. 사용자가 수치 or 이진분류 or 다중분류 예측 선택 페이지 요청

2. 웹은 HTTP 통신으로 프론트엔드 서버인 Vue.js에게 전달

3. Vue.js는 해당 화면 반환

4. 사용자가 선택한 예측 정보를 Vue에 저장하고 다음 페이지 반환

<br>

### 05. 추천 학습 모델 or 모델 커스터마이징 선택 페이지

![image](https://user-images.githubusercontent.com/43431081/82732136-45a60080-9d46-11ea-87b0-76574a160bfd.png)

<br>

![image](https://user-images.githubusercontent.com/43431081/82731933-04f9b780-9d45-11ea-9e1d-fc44488468db.png)

<br>

1. 사용자가 추천 학습 모델 or 모델 커스터마이징 선택 페이지 요청

2. 웹은 HTTP 통신으로 프론트엔드 서버인 Vue.js에게 전달

3. Vue.js는 해당 화면 반환
   * 사용자가 ＂추천 학습 모델” 버튼 클릭
     1. Vue는 추천 학습 모델 검토 페이지 반환
   * 사용자가 “모델 커스터마이징” 버튼 클릭
     1. Vue는 하이퍼 파라미터 & 레이어 커스터마이징 페이지 반환

<br>

### 06-1. 추천 학습 모델 검토 페이지

![image](https://user-images.githubusercontent.com/43431081/82745273-7412f280-9dbd-11ea-9c23-6126ff2c31a9.png)

<br>

* **추천 학습 모델 검토 페이지 요청 시 흐름도**

  ![image](https://user-images.githubusercontent.com/43431081/82745276-87be5900-9dbd-11ea-9833-23089598c374.png)

* **"학습" 버튼을 누른 뒤 흐름도**

  ![image](https://user-images.githubusercontent.com/43431081/82816077-74061600-9ed5-11ea-9c90-b8f5f4b21b23.png)

<br>

1. 사용자가 추천 학습 모델 검토 페이지 요청
   * 하이퍼 파라미터와 레이어 정보들을 보여준다.

2. 웹은 HTTP 통신으로 프론트엔드 서버인 Vue.js에게 전달

3. Vue는 Flask에게 JSON 형식으로 학습 목표 변수 개수와 예측 정보를 전송하고, 추천 학습 모델 구조 및 하이퍼 파라미터 조회 요청

4. Flask는 Vue로부터 목표 변수 개수와 예측 정보를 받아서, Keras 모듈을 이용해 학습 목표 변수 개수에 알맞는 기존의 학습 모델을 가져온다. 그 후 해당 모델 정보와 식별자를 Vue에게 반환

5. Vue는 Flask에게 받은 모델 정보를 화면에 바인딩한 후 사용자에게 반환

6. 사용자가 “학습” 버튼을 누르면 Vue에게 모델 학습을 요청한다.

7. Vue에 저장되어 있던 파일 식별자와 사용할 컬럼, 학습을 목표로 하는 컬럼들, 모델 구조, 하이퍼 파라미터 정보를 JSON 형식으로 변환해서 Spring에게 모델 학습 요청

8. Spring은 Vue에게 받은 파일 식별자를 통해 PostgreSQL에 파일 경로 조회 요청

9. PostgreSQL은 해당 파일 식별자의 파일 경로를 반환

10. Spring은 파일 경로와 사용할 컬럼들, 학습을 목표로 하는 컬럼들을 JSON 형식으로 변환해서 Flask에게 모델 학습 요청

11. Flask는 Spring에게 받은 파일 경로를 통해 파일을 불러오고, Keras에게 파일 정보 전달

12. Keras는 사용할 컬럼들과 학습 목표 컬럼들을 토대로 데이터를 전처리하고, 모델 식별자를 통해 모델을 불러와서 학습 시작
    1. 학습 식별자를 생성
    2. 모델 구성도를 파일로 저장하고 파일명과 파일 경로 데이터 생성
    3. 적당한 에포크마다 모델을 저장하고 모델 저장 경로와 모델 식별자 생성하고 학습 히스토리 정보를 주기적으로 저장한다.

13. 학습이 시작되면 Flask는 Spring에게 유저 식별자와 학습 식별자, 모델 구성도 파일명과 파일경로를 전송해 학습이 시작됨을 알리고, Flask는 Keras가 적당한 에포크마다 모델을 저장할 때 모델 저장 경로와 모델 식별자, 학습 식별자, 학습 히스토리 정보를 그때 그때 Spring에게 전송한다.

14. Spring은 Flask로부터 받은 유저 식별자를 통해 학습 식별자를 PostgreSQL에 삽입 요청한다. 그리고 모델 구성도 파일명과 파일경로를 PostgreSQL에게 삽입 요청한다. 주기적으로 Flask로부터 전송되는 학습 식별자와 모델 저장 경로, 모델 식별자, 학습 히스토리를 PostgreSQL에 삽입 요청한다. 마지막으로 학습 요청 결과 코드를 Vue에게 전송

15. Vue는 Spring에게 학습이 시작했다는 결과 코드가 오면 학습 진행 현황 페이지를 반환

<br>

### 06-2. 모델 커스터마이징 페이지

![image](https://user-images.githubusercontent.com/43431081/82745305-cce28b00-9dbd-11ea-896b-964a7128ed39.png)

<br>

* **모델 커스터마이징 페이지를 요청 시 흐름도**

  ![image](https://user-images.githubusercontent.com/43431081/82731933-04f9b780-9d45-11ea-9e1d-fc44488468db.png)

* **"학습" 버튼을 누른 뒤 흐름도**

  ![image](https://user-images.githubusercontent.com/43431081/82816077-74061600-9ed5-11ea-9c90-b8f5f4b21b23.png)

<br>

1. 사용자가 모델 커스터 페이지 요청
   * 하이퍼 파라미터 정보를 직접 입력할 수 있도록 한다.
   * 레이어를 추가, 삭제가 가능하고 여러 설정을 할 수 있도록 한다.

2. 웹은 HTTP 통신으로 프론트엔드 서버인 Vue.js에게 전달

3. Vue는 모델 커스터마이징 페이지를 반환한다.

4. 사용자가 하이퍼 파라미터와 레이어 정보를 입력하고 “학습” 버튼을 누르면 Vue에게 모델 학습을 요청한다.

5. Vue에 저장되어 있던 파일 식별자와 사용할 컬럼, 학습을 목표로 하는 컬럼들, 하이퍼 파라미터, 레이어 정보들을 JSON 형식으로 변환해서 Spring에게 모델 학습 요청

6. Spring은 Vue에게 받은 파일 식별자를 통해 PostgreSQL에 파일 경로 조회 요청

7. PostgreSQL은 해당 파일 식별자의 파일 경로를 반환

8. Spring은 여러 데이터들을 JSON 형식으로 변환해서 Flask에게 모델 학습 요청

9. Flask는 Spring에게 받은 파일 경로를 통해 파일을 불러오고, Keras에게 파일 정보 전달

10. Keras는 여러 데이터들을 토대로 데이터를 전처리하고, 사용자가 설정한 하이퍼 파라미터와 레이어 정보를 통해 모델을 만들어서 학습 시작
    1. 학습 식별자를 생성
    2. 모델 구성도를 파일로 저장하고 파일명과 파일 경로 데이터 생성
    3. 적당한 에포크마다 모델을 저장하고 모델 식별자 생성

11. 학습이 시작되면 Flask는 Spring에게 유저 식별자와 학습 식별자, 모델 구성도 파일명과 파일경로를 전송해 학습이 시작됨을 알리고, Flask는 Keras가 적당한 에포크마다 모델을 저장할 때 모델 저장 경로와 모델 식별자, 학습 식별자, 학습 히스토리 정보를 그때 그때 Spring에게 전송한다.

12. Spring은 Flask로부터 받은 유저 식별자를 통해 학습 식별자를 PostgreSQL에 삽입 요청한다. 그리고 모델 구성도 파일명과 파일경로를 PostgreSQL에게 삽입 요청한다. 주기적으로 Flask로부터 전송되는 학습 식별자와 모델 저장 경로, 모델 식별자, 학습 히스토리를 PostgreSQL에 삽입 요청한다. 마지막으로 학습 요청 결과 코드를 Vue에게 전송

13. Vue는 Spring에게 학습이 시작했다는 결과 코드가 오면 학습 진행 현황 페이지를 반환

<br>

### 07. 학습 진행 현황 페이지

![image](https://user-images.githubusercontent.com/43431081/82745345-16cb7100-9dbe-11ea-840d-e0bd1f7f84d5.png)

<br>

![image](https://user-images.githubusercontent.com/43431081/82731954-1e9aff00-9d45-11ea-93d3-9b348ff2e84f.png)

<br>

1. 사용자가 학습 진행 현황 페이지를 요청

2. 인터넷을 통해 Vue에게 HTTP 요청

3. Vue는 학습 식별자를 JSON 형식으로 변환해서 Spring에게 모델 학습 진행 현황 요청
   1. 학습 진행 현황 페이지는 주기적으로 Spring에게 모델 학습 진행 현황을 요청해서 페이지의 그래프가 주기적으로 바뀔 수 있도록 한다.

4. Spring은 Vue에게 받은 학습 식별자를 통해 PostgreSQL에 해당 학습 히스토리 조회를 요청

5. PostgreSQL은 해당 학습 식별자의 학습 히스토리를 조회하고 Spring에게 반환

6. Spring은 학습 히스토리들을 Vue에게 반환

7. Vue는 Spring으로 받은 학습 히스토리들을 화면에 바인딩하고 사용자에게 반환.

<br>

### 08. 학습 완료 페이지

![image](https://user-images.githubusercontent.com/43431081/82807986-f08ff900-9ec3-11ea-933f-6299ca00082d.png)

<br>

* **학습 완료 페이지 요청 시 흐름도**

  ![image](https://user-images.githubusercontent.com/43431081/82731954-1e9aff00-9d45-11ea-93d3-9b348ff2e84f.png)

* **모델 실행 버튼 클릭 시 흐름도**

  ![image](https://user-images.githubusercontent.com/43431081/82816343-f098f480-9ed5-11ea-8c34-5f444e821a3d.png)

* **모델 다운로드 버튼 클릭 시 흐름도**

  ![image](https://user-images.githubusercontent.com/43431081/82809825-f25bbb80-9ec7-11ea-8dd2-2111068d4f0a.png)

<br>

1. 사용자가 학습 완료 페이지 요청
   * 화면 구성
     * 모델 구성도
     * 훈련 손실값, 정확도 (수치, 그래프)
     * 검증 손실값, 정확도 (수치, 그래프)
     * 입력 값을 넣을 수 있는 공간
     * 모델 실행 요청 버튼
     * 결과 값 공간
     * 모델 다운로드 버튼
2. 웹은 HTTP 통신으로 프론트엔드 서버인 Vue.js에게 전달
3. Vue는 Spring에게 학습 식별자를 전송하여 모델 구성도와 히스토리 정보, 모델 경로를 요청
4. Spring은 Vue에게 받은 학습 식별자를 통해서 PostgreSQL에게 모델 구성도 파일 경로와 히스토리 정보, 모델 경로를 조회 요청
5. PostgreSQL은 요청된 데이터를 조회해서 Spring에게 반환
6. Spring은 모델 구성도 파일 경로와 히스토리 정보, 모델 경로를 JSON 형식으로 변환해서 Vue에게 반환
7. Vue는 Spring에게 받은 데이터들을 페이지에 바인딩한 후 사용자에게 반환

* **사용자가 모델 실행 버튼을 클릭 시**
  1. 사용자가 입력 공간에 넣은 값들을 Vue에게 전달하여 모델 실행을 요청
  2. Vue는 학습 식별자와 입력값들을 JSON 형식으로 Spring에게 모델 실행을 요청
  3. Spring은 학습 식별자를 통해 PostgreSQL에게 모델 경로 조회 요청
  4. PostgreSQL은 학습 식별자로 최근 저장된 모델의 경로를 조회하여 Spring에게 반환
  5. Spring은 모델의 경로와 입력값들을 JSON 형식으로 변환 후 Flask에게 모델 사용 요청
  6. Flask는 모델 경로와 입력값들을 받아서 Keras에게 전달
  7. Keras는 모델 경로를 통해 모델을 불러오고 입력값들을 통해 모델을 실행시킨다. 그 후 예측값을 Flask에게 전달
  8. Flask는 모델의 예측값을 Spring에게 반환
  9. Spring은 모델의 예측값을 Vue에게 반환
  10. Vue는 페이지에 예측값을 바인딩 후 사용자에게 반환
* **모델 다운로드 버튼 클릭 시**
  1. 사용자가 모델 다운로드를 Vue에게 요청
  2. Vue는 해당 URL의 파일을 Spring에게 요청
  3. Spring은 해당 URL의 파일을 Vue에게 반환