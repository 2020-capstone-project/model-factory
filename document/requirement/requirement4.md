# 4차 요구사항 & 구현사항 분석

- [ ] 파일 추가 로직 구현

- [ ] 학습 현황 페이지에서 입력 값을 넣어서 테스트 해볼 수 있도록 환경 구성

<br>

## 파일 추가

1. 데이터 선택 페이지

   ![image](https://user-images.githubusercontent.com/43431081/89251258-82994800-d651-11ea-997c-6e8af78cf82d.png)

2. 새로운 데이터 업로드 선택

   ![image](https://user-images.githubusercontent.com/43431081/89356555-0eb27a80-d6f9-11ea-9b0e-8af8a0427b8f.png)

   * 파일 예시를 보여준다.

3. 저장 여부 선택

   ![image](https://user-images.githubusercontent.com/43431081/89356890-ec6d2c80-d6f9-11ea-955f-14b8d3aa95e4.png)

   * Yes 클릭시
     * 파일 업로드시 파일 형식 검사
       * 1, 2 행이 값들이 문자열인지와 빈 값이 있는지 검사
       * N행들이 모두 문자열이 아닌지와 빈 값이 있는지 검사
     * DB에 데이터 삽입
       * file 삽입
       * column 삽입
       * data 3개 씩 삽입

4. 상세 데이터 선택으로 이동

   ![image](https://user-images.githubusercontent.com/43431081/89252367-7d89c800-d654-11ea-95c5-8b81a74d45b0.png)

<br>

## 모델 테스트

1. 모델 현황 페이지

   ![image](https://user-images.githubusercontent.com/43431081/89253064-81b6e500-d656-11ea-99c9-71fdf5a971f7.png)

   * 입력 컬럼과 입력 란, 모델 실행 버튼
   * 출력 컬럼과 출력 란

2. 모델 실행

   1. API 서버에 POST 요청으로 입력 컬럼명, 입력 값, 학습 번호 전송
   2. API 서버는 입력 값들이 잘 넘어왔는지 확인
      * 숫자가 아닌 문자가 넘어왔는지
      * 입력 값 개수와 컬럼 개수가 맞는지
   3. API 서버는 Learning 서버로 입력 컬럼명, 입력 값, 학습 번호 전송
   4. Learning 서버는 모델을 불러와서 해당 컬럼명의 입력 값들을 넣어서 모델 실행
   5. Learning 서버는 결과 값과 결과 컬럼 명을 응답으로 반환

