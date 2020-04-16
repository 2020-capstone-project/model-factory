# 1차 DB 설계

## 요구사항

* 회원은 식별할 수 있는 번호와 이름, 이메일, 비밀번호를 갖고 있다.

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