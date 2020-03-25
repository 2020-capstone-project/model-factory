# 사용 시나리오

1. 회원가입이 되어 있지 않은 회원은 회원가입을 한다.

   <img src="https://user-images.githubusercontent.com/43431081/77502569-901e1480-6e9e-11ea-9bb5-1078b6627d90.png" alt="image" style="zoom:50%;" />

   * 회원이 회원가입 URL을 GET 요청하면 Vue가 그에 해당하는 화면 반환
   * Vue에서 이메일 형식, 비밀번호 및 비밀번호 확인 Valid 체크
   * 회원가입 클릭 시, POST 요청.
   * Spring은 요청된 회원가입을 수행 및 결과 반환
   * 회원가입 실패나 완료

   <br>

2. 회원가입이 되어 있으면 로그인을 한다.

   <img src="https://user-images.githubusercontent.com/43431081/77502612-aaf08900-6e9e-11ea-9bbd-71abcd1dbacf.png" alt="image" style="zoom:50%;" />

   * 로그인 URL을 GET 요청.
   * Vue가 로그인 페이지를 반환
   * Vue가 이메일 비밀번호 Valid 체크
   * 로그인 클릭 시, POST 요청
   * Spring은 요청된 로그인을 수행 및 결과 반환
   * 로그인 실패나 완료

   <br>

3. 머신 러닝을 하기 위해 시작 버튼을 누르고 회원은 데이터 선택이나 삽입을 클릭한다.

   ![image](https://user-images.githubusercontent.com/43431081/77502701-e5f2bc80-6e9e-11ea-9916-0276bf9250ef.png)

   * 시작 버튼 누르면 Vue에게 GET 요청
   * Vue는 데이터 선택 화면 반환
   * 데이터 선택 클릭 시, Vue에게 GET 요청

   <br>

## 데이터 선택 클릭 시

1. DB로 부터 현재 갖고 있는 테이블을 보여준다.

   ![image](https://user-images.githubusercontent.com/43431081/77502846-64e7f500-6e9f-11ea-924c-895f32db075b.png)

   * Vue가 GET 요청을 받아서 Spring에게 데이터 정보 GET 요청 
   * Spring은 DB로부터 공공 데이터들을 담아 놓은 테이블들의 이름과 설명을 가져오고 JSON 형식으로 Vue에게 반환하면 Vue는 화면에 바인딩한다.
   * 테이블 이름을 누르면 Vue는 GET 요청을 받게 되고, 해당 테이블의 자세한 데이터들을 가져오기 위해 Spring에게 GET 요청을 한다. Spring은 DB로부터 해당 테이블과 매칭되는 파일의 경로를 가져온다. 그 후, 스토리지 서버로부터 파일을 가져와서 JSON 형식으로 변환한 뒤 Vue에게 반환한다.
   * 사용자는 원하는 테이블을 선택하고 선택 버튼을 누르면 다음 화면을 POST 요청

   <br>

2. 테이블을 선택하게 되면 그 테이블에 대해서 상세한 데이터를 볼 수 있다. 그리고 어떤 데이터를 사용할 것인지나 어떤 데이터를 학습 목표 변수로 지정할지를 결정한다.

   ![image](https://user-images.githubusercontent.com/43431081/77502991-c14b1480-6e9f-11ea-8b5e-70bf2a643d80.png)

   * Vue는 해당 테이블의 자세한 데이터들을 가져오기 위해 Spring에게 GET 요청을 한다. Spring은 DB로부터 해당 테이블과 매칭되는 파일의 경로를 가져온다. 그 후, 스토리지 서버로부터 파일을 가져와서 JSON 형식으로 변환한 뒤 Vue에게 반환한다.
   * Vue는 Spring에서 반환된 JSON을 통해 화면을 출력시킨다.
   * 선택 버튼을 클릭 시, Vue에게 GET 요청을 보내고 다음 화면을 출력한다.

   <br>

3. 모델 학습 방법을 선택한다.

   ![image](https://user-images.githubusercontent.com/43431081/77506304-db3d2500-6ea8-11ea-80b0-e43dc56b3c0f.png)

   * 학습 방법(알고리즘)을 선택한다.
   * 다음 화면을 Vue에게 GET 요청을 한다.

   <br>

4. 하이퍼 파라미터를 선택한다.

   ![image](https://user-images.githubusercontent.com/43431081/77506373-0f184a80-6ea9-11ea-8678-f374bbd35cb8.png)

   * 선택된 학습 방법에 필요한 하이퍼 파라미터들을 입력한다.
   * 학습 시작 버튼 클릭.
   * POST 요청으로 하이퍼 파라미터들의 값을 전송하고 Vue는 Spring에게 전달한다.
   * 지금까지 선택된 데이터 테이블이나 학습 목표 변수, 하이퍼 파라미터 등의 데이터들을 Spring이 JSON 형식으로 만들어서 Flask에 POST로 학습을 요청한다.
   * Flask는 데이터들을 스토리지 서버로부터 가져온다.
   * Keras 모듈을 사용해서 학습 방법을 구현해놓은 것 중에서 사용자가 선택한 학습 방법을 찾고 사용자가 입력하거나 선택한 데이터들과 하이퍼 파라미터나 학습 목표 변수를 삽입하여 학습을 시작시킨다.
   * JSON 형식으로 만들어서 스토리지 서버에 저장시켜놓는다.

   <br>

5. 학습 현황 보기

   * 사용자가 학습 현황 보기를 Vue 에게 GET 요청을 한다.
   * Vue는 요청한 사용자의 아이디와 학습 고유 번호를 통해 Spring에게 GET 요청한다.
   * Spring은 해당 아이디의 학습 고유 번호를 식별해서 DB로 부터 스토리지 서버에 있는 학습 현황을 기록해놓은 JSON 파일의 경로를 가져오고, 그 경로에 있는 JSON 파일을 읽어온다.
   * 읽은 JSON을 Vue에게 반환해주고 Vue는 그 JSON 형식을 화면에 바인딩한다.

   <br>

6. 학습 결과로 테스트 해보기

   * 사용자가 학습 결과 테스트 해보기를 Vue에게 GET 요청
   * Vue는 요청한 사용자의 아이디와 학습 고유 번호를 통해 Spring에게 학습 결과를 GET 요청
   * Spring은 해당 아이디의 학습 고유 번호를 식별해서 DB로 부터 스토리지 서버에 있는 학습 현황을 기록해놓은 JSON 파일의 경로를 가져오고, 그 경로에 있는 JSON 파일을 읽어온다.
   * 읽은 JSON을 Vue에게 반환해주고 Vue는 그 JSON 형식을 화면에 바인딩한다.
   * 사용자가 입력 값을 지정하고 테스트를 POST로 요청한다.
   * Vue가 Spring에게 JSON 형식으로 POST 요청 전달
   * Spring은 요청한 사용자의 아이디와 학습 고유 번호, 테스트 입력 값, 학습 모델 경로를  JSON 형식으로 Flask 에게 전달
   * Flask는 스토리지 서버로부터 학습 모델 경로를 통해 학습 모델을 가져와서 Keras 모듈을 사용해 입력 값을 테스트한 후 결과 값을 JSON으로 Spring으로 전달
   * Vue에서 전달받은 JSON을 화면에 바인딩