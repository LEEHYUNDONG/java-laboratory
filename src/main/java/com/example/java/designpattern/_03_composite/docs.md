# Template Method Pattern

## 개념

Template Method 패턴은 알고리즘의 골격을 상위 클래스에서 정의하고, 세부 구현은 하위 클래스에서 담당하도록 하는 행위(Behavioral) 디자인 패턴이다.

### 핵심 원리

1. **알고리즘 골격 정의**: 상위 클래스에서 전체 실행 흐름을 `final` 메서드로 정의하여 변경 불가능하게 함
2. **Hook Method**: 하위 클래스에서 반드시 구현해야 하는 추상 메서드 제공
3. **코드 재사용**: 공통 로직은 상위 클래스에, 변경되는 부분만 하위 클래스에 구현

### 장점

- 코드 중복 제거
- 알고리즘 구조 변경 없이 특정 단계만 재정의 가능
- 개방-폐쇄 원칙(OCP) 준수

### 단점

- 하위 클래스가 상위 클래스에 강하게 결합
- 알고리즘 단계가 많아지면 유지보수 어려움

---

## 구조

```
┌─────────────────────────────────┐
│      GenerativeAi (Abstract)    │
├─────────────────────────────────┤
│ - name: String                  │
├─────────────────────────────────┤
│ + generate(): void {final}      │  ← Template Method
│ - defineProblem(): void         │
│ - search(): void                │
│ - answer(): void                │
│ # algorithm(): void {abstract}  │  ← Hook Method
│ # askQuestion...(): void {abs}  │  ← Hook Method
└─────────────────────────────────┘
              △
              │
    ┌─────────┴─────────┐
    │                   │
┌───────────┐     ┌───────────┐
│  ChatGpt  │     │  Claude   │
├───────────┤     ├───────────┤
│algorithm()│     │algorithm()│
│askQuestion│     │askQuestion│
└───────────┘     └───────────┘
```

---

## 코드

### 1. 추상 클래스 (Template)

```java
public abstract class GenerativeAi {

    private final String name;

    public GenerativeAi(String name) {
        this.name = name;
    }

    // Template Method - 알고리즘 골격 정의
    public final void generate() {
        defineProblem();
        search();
        algorithm();
        answer();
        askQuetionAboutMoreInformation();
    }

    // 공통 구현
    private void defineProblem() {
        System.out.println(name + "문제를 정의합니다.");
    }

    private void search() {
        System.out.println(name + "문제를 해결하기 위해 검색합니다.");
    }

    private void answer() {
        System.out.println(name + "가 답변합니다.");
    }

    // Hook Method - 하위 클래스에서 구현
    protected abstract void algorithm();
    protected abstract void askQuetionAboutMoreInformation();
}
```

### 2. 구체 클래스 - ChatGpt

```java
public class ChatGpt extends GenerativeAi {

    private static final String name = "ChatGpt";

    public ChatGpt() {
        super(name);
    }

    @Override
    public void algorithm() {
        System.out.println("ChatGPT 방식으로 해결해보려 합니다.");
    }

    @Override
    public void askQuetionAboutMoreInformation() {
        System.out.println("ChatGPT가 더 필요한 정보가 없는지 제대로 답변했는지 질문합니다.");
    }
}
```

### 3. 구체 클래스 - Claude

```java
public class Claude extends GenerativeAi {

    private static final String name = "Claude";

    public Claude() {
        super(name);
    }

    protected void algorithm() {
        System.out.println(name + " 방식으로 해결해보려 합니다.");
    }

    protected void askQuetionAboutMoreInformation() {
        System.out.println(name + "가 더 필요한 정보가 없는지 제대로 답변했는지 질문합니다.");
    }
}
```

### 4. 클라이언트 코드

```java
public class GenerativeAiApp {
    public static void main(String[] args) {
        GenerativeAi claude = new Claude();
        claude.generate();

        GenerativeAi chatGpt = new ChatGpt();
        chatGpt.generate();
    }
}
```

---

## 실행 결과

```
Claude문제를 정의합니다.
Claude문제를 해결하기 위해 검색합니다.
Claude 방식으로 해결해보려 합니다.
Claude가 답변합니다.
Claude가 더 필요한 정보가 없는지 제대로 답변했는지 질문합니다.
ChatGpt문제를 정의합니다.
ChatGpt문제를 해결하기 위해 검색합니다.
ChatGPT 방식으로 해결해보려 합니다.
ChatGpt가 답변합니다.
ChatGPT가 더 필요한 정보가 없는지 제대로 답변했는지 질문합니다.
```

---

## Before vs After 비교

| 항목 | Before | After |
|------|--------|-------|
| 코드 중복 | `generate()` 메서드가 각 클래스에 중복 | 공통 로직은 상위 클래스에 집중 |
| 확장성 | 새 AI 추가 시 전체 로직 복사 필요 | 추상 메서드만 구현하면 됨 |
| 유지보수 | 공통 로직 변경 시 모든 클래스 수정 | 상위 클래스만 수정 |
| 알고리즘 순서 보장 | 각 클래스에서 순서 변경 가능 | `final` 메서드로 순서 고정 |
