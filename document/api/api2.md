# 1차 API 설계

# HTTP Status Code

## 성공 응답은 `2XX` 로 응답한다.

* **200** : OK
* **201** : Created
  * POST, PUT에 사용
* **202** : Accepted
  * 클라이언트 요청을 받은 후 요청은 유효하나 서버가 아직 처리하지 않은 경우에 응답한다.
* **204** : No Content
  * 응답 body가 필요 없음.

<br>

## 실패 응답은 `4XX` 로 응답한다.

* **400** : Bad Request
  * 클라이언트 요청이 미리 정의된 파라미터 요구사항을 위반한 경우
* **401** : Unauthorized
* **403** : Forbidden
  * 해당 요청은 유효하나 서버 작업 중 접근이 허용되지 않은 자원을 조회하려는 경우
  * 권한이 없는 경우
* **404** : Not Found
* **405** : Method Not Allowed
  * ex) POST 요청을 해야하는데 GET 요청을 했을 때
* **409** : Conflict
  * 해당 요청의 처리가 비지니스 로직상 불가능하거나 모순이 생긴 경우
  * 모든 자원이 비어있는데 DELETE 요청을 했을 때
* **429** : Too Many Requests

<br>

## `5XX` 에러는 절대 사용자에게 나타내지 마라!

웹 서버가 오류일 때는 500 에러

<br>

# Spring REST API

## auth(인증)

### login

* **POST /auth/login**
  * 수신 데이터: String email(이메일), String password(비밀번호)
  * 송신 데이터
    * 성공 시: Integer id(식별자), String name(이름), String email(이메일), String password(비밀번호)
      * Session에 회원 정보를 저장하고 데이터 및 `200` 반환
    * 실패 시
      * 일치하는 아이디가 존재하지 않을 때 `404` 반환
      * 비밀번호가 맞지 않을 때  `401` 반환
      * 이메일이나 비밀번호가 빈 문자열이거나 이메일 형식이 맞지 않으면 `400` 반환

<br>

### signup

* **POST /auth/signup**
  * 수신 데이터: String name(이름), String email(이메일), String password(비밀번호)
  * 송신 데이터
    * 성공 시: DB에 정보 저장 후 `201` 반환
    * 실패 시
      * 중복되는 이메일 존재시 `409` 반환
      * 이름이나 이메일, 비밀번호가 비어 있거나 공백이 있을 경우 및 이메일 형식이 맞지 않을 경우 `400` 반환

<br>

## info(회원정보)

### adjust

* **PUT /info**
  * 수신 데이터: String name(이름), String email(이메일), String currentPassword(기존 비밀번호), String newPassword(새로운 비밀번호)
  * 송신 데이터
    * 성공 시: DB에 정보 저장 후 `200` 반환
    * 실패 시
      * 해당 email(이메일)과 일치하는 회원이 없을 경우 `404` 반환
      * 현재 비밀번호가 일치하지 않을 때 `401` 반환
      * 이름, 이메일, 비밀번호가 빈 문자열이거나 공백일 경우 `400` 반환