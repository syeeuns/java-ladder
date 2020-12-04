# 사다리 게임

## Step1 자바8 스트림, 람다, Optional

* [X] Lambda
* [X] Stream
* [X] Optional

## Step2 사다리(생성)

### 기능 요구사항

* 사다리 게임에 참여하는 사람에 이름을 최대5글자까지 부여할 수 있다. 사다리를 출력할 때 사람 이름도 같이 출력한다.
* 사람 이름은 쉼표(,)를 기준으로 구분한다.
* 사람 이름을 5자 기준으로 출력하기 때문에 사다리 폭도 넓어져야 한다.
* 사다리 타기가 정상적으로 동작하려면 라인이 겹치지 않도록 해야 한다.
* |-----|-----| 모양과 같이 가로 라인이 겹치는 경우 어느 방향으로 이동할지 결정할 수 없다.

### 프로그래밍 요구사항

* 자바 8의 스트림과 람다를 적용해 프로그래밍한다.
* 규칙 6: 모든 엔티티를 작게 유지한다.

### 파생 요구사항(설계)

* User
  * [X] '이름 길이는 최대 5자 조건' 을 검증하는 역할
* Users
  * [X] 최소 인원 검증 역할
  * [X] 게임에 참여하는 유저들을 관리하는 역할
  * [X] 인원 수 getter
* InputParser
  * [X] , 기준으로 인풋을 분리하는 기능 `String -> <List>String`
* HorizontalLine
  * [X] 지정된 길이 만큼, true 가 2개 이상 연속되지 않은 `List<boolean>` 로 변환하는 역할
  * [X] Line 의 `List<Boolean>` 반환 기능
* Ladder
  * [X] 사다리 높이 만큼 `HorizontalLine` 을 생성하는 역할
  * [X] ResultView 용 출력 데이터 생성 하는 역할
  * [X] 각 `HorizontalLine`에 layout 을 바꾸도록 요청하는 역할
* ResultView
  * [X] User 에 대해 출력 하는 역할
  * [X] `List<List<boolean>>` 을 사다리로 출력하는 역할
* InputView
  * [X] User 정보 입력 받는 기능
  * [X] 사다리 높이 입력 받는 기능

## [Step 3] 사다리(게임 실행)

### 리뷰어님 피드백 정리

* [X] 변수 네이밍 (Client, HorizontalLine)
* 테스트 코드 가독성 및 람다식 적용
* [X] 정적 팩토리 메소드
  개선 [참고](https://velog.io/@ljinsk3/%EC%A0%95%EC%A0%81-%ED%8C%A9%ED%86%A0%EB%A6%AC-%EB%A9%94%EC%84%9C%EB%93%9C%EB%8A%94-%EC%99%9C-%EC%82%AC%EC%9A%A9%ED%95%A0%EA%B9%8C)
* 유효성 검사 분리
* [X] 매직넘버 치환 [참고](https://hoonmaro.tistory.com/44)
* 테스트 하기 힘든 로직 외부 주입
* 불변 객체 [참고](https://woowacourse.github.io/javable/2020-05-08/First-Class-Collection)
* DTO 객체 생성방식
* Static method 만 가지고 있는 유틸성 클래스에 대한 불필요한 인스턴스화 방지

### 피드백 액션플랜 및 개인 묙표

* 정적 팩토리 메소드 이펙티브 자바 보고 정리(일반적인 정적 팩토리 메소드의 네이밍 컨벤션도 정리)
* 네이밍 전체 재검토(축약 금지, 책임을 축약해서 충분히 설명하는지 등등) 해보기
* Junit 에서 유용하게 적용할 수 있는 문법 공부
* 매직넘버 관리 방안(각 클래스 내부, 혹은 패키지 전체 공유) 장단점 생각해보기

### 기능 요구사항

* 사다리 실행 결과를 출력해야 한다.
* 개인별 이름을 입력하면 개인별 결과를 출력하고, "all"을 입력하면 전체 참여자의 실행 결과를 출력한다.

### 프로그래밍 요구사항

* 자바 8의 스트림과 람다를 적용해 프로그래밍한다.
* 규칙 6: 모든 엔티티를 작게 유지한다.
* 규칙 7: 3개 이상의 인스턴스 변수를 가진 클래스를 쓰지 않는다.
