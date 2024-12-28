## 요구사항 및 분석


- 테스트 대상이 되는 클래스 파일 
  - 테스트를 실행시킬 클래스를 인자로 넘겨받아 테스트를 돌린다.
    - java reflection을 이용해서 테스트 클래스와 메소드 정보를 불러온다.
      - Class 단위
        - tearDown
        - @JTest가 붙은 메소드들은
      - Method 단위
    

- 테스트 결과 - Test Result
  - Test Status
    - Success 1
    - Fail 0
  - Test Status Count
  - Test Message
    - 어떤 문제가 발생했는지, 성공했는지에 대한 메시지