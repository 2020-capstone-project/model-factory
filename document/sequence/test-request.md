# 학습 모델 테스트 순서도

![image](https://user-images.githubusercontent.com/43431081/92217195-554eec80-eed2-11ea-9190-c575eea93fa8.png)

<br>

### 1) POST /members/{memberId}/learning-status/{learningId}/test

* 요청 데이터

  * **learningId** : 학습 번호

  * **JSON**

    ```javascript
    [ 1, 2, 3, ...] // 입력 컬럼 값들
    ```

<br>

### 2) "learningId" 로 modelPath를 조회

* Query

  ```sql
  select m.modelpath
  from learning l, model m
  where l.id = m.learningid and l.id = #{id};
  ```

<br>

### 3) clientService.test(modelPath, values);

### 4) POST /test

* 요청 데이터

  * **JSON**

    ```javascript
    {
      "modelPath": "~/model.5",
      "values": [ 1.3, 1.4, ... ]
    }
    ```

<br>

### 5) module.test(modelPath, values);

### 6) "values" 를 데이터 전처리(String or Int => Float)

### 7) "modelPath" 를 통해 모델을 불러온다.

### 8) 불러온 모델로 테스트 진행

### 9) return result;

### 10) Response JSON{result}

### 11) return result;

### 12) Response JSON{result}
