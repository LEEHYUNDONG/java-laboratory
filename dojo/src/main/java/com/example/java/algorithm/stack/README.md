# Stack 알고리즘 연습 문제

스택을 활용한 전형적인 알고리즘 문제들입니다. 모든 문제는 테스트 코드가 작성되어 있으며, 구현을 완성하여 테스트를 통과시키는 것이 목표입니다.

## 문제 목록

### 1. ValidParentheses - 유효한 괄호

**난이도**: 쉬움

주어진 문자열의 괄호가 올바르게 짝지어져 있는지 판단하는 문제입니다.

**문제**:
- `isValid(String s)`: 괄호 `()`, `[]`, `{}`가 올바르게 닫혀있는지 확인
- `removeInvalidParentheses(String s)`: 유효하지 않은 괄호 제거
- `longestValidParentheses(String s)`: 가장 긴 유효한 괄호 부분의 길이

**핵심 아이디어**:
- 열린 괄호를 만나면 스택에 push
- 닫힌 괄호를 만나면 스택에서 pop하여 짝이 맞는지 확인
- 최종적으로 스택이 비어있어야 유효

**테스트 실행**:
```bash
./gradlew :dojo:test --tests "com.example.java.algorithm.stack.ValidParenthesesTest"
```

---

### 2. NextGreaterElement - 다음 큰 원소

**난이도**: 중간

배열의 각 원소에 대해, 오른쪽(또는 왼쪽)에 있는 원소 중 자신보다 큰(또는 작은) 첫 번째 원소를 찾는 문제입니다.

**문제**:
- `nextGreaterElements(int[] nums)`: 각 원소의 다음 큰 원소
- `nextGreaterElementsCircular(int[] nums)`: 원형 배열에서 다음 큰 원소
- `previousGreaterElements(int[] nums)`: 각 원소의 이전 큰 원소
- `nextSmallerElements(int[] nums)`: 각 원소의 다음 작은 원소

**핵심 아이디어**:
- 스택에 인덱스를 저장
- 현재 원소가 조건을 만족하면 스택에서 pop하여 결과 저장
- 시간 복잡도 O(n)으로 효율적 해결

**예시**:
```
입력: [4, 5, 2, 25]
출력: [5, 25, 25, -1]
```

**테스트 실행**:
```bash
./gradlew :dojo:test --tests "com.example.java.algorithm.stack.NextGreaterElementTest"
```

---

### 3. StockSpan - 주식 가격 스팬

**난이도**: 중간

주식의 스팬은 현재 날짜를 포함하여, 현재 가격보다 작거나 같은 연속된 이전 날짜들의 최대 개수입니다.

**문제**:
- `calculateSpan(int[] prices)`: 각 날짜의 스팬 계산
- `longestIncreasingStreak(int[] prices)`: 연속 증가 구간 최대 길이
- `OnlineStockSpan.next(int price)`: 온라인 스팬 계산기

**핵심 아이디어**:
- 스택에 인덱스 저장
- 현재 가격보다 작거나 같은 가격들을 스택에서 pop
- 스팬 = 현재 인덱스 - 스택 top 인덱스

**예시**:
```
가격: [100, 80, 60, 70, 60, 75, 85]
스팬: [1,   1,  1,  2,  1,  4,  6]
```

**테스트 실행**:
```bash
./gradlew :dojo:test --tests "com.example.java.algorithm.stack.StockSpanTest"
```

---

### 4. DailyTemperatures - 일일 온도

**난이도**: 중간

매일의 온도가 주어졌을 때, 더 따뜻한(또는 추운) 날씨를 위해 며칠을 기다려야 하는지 계산하는 문제입니다.

**문제**:
- `dailyTemperatures(int[] temperatures)`: 더 따뜻한 날까지 기다려야 하는 일수
- `dailyColderTemperatures(int[] temperatures)`: 더 추운 날까지 기다려야 하는 일수
- `waitForTemperatureRise(int[] temperatures, int k)`: k도 이상 상승하는 날까지 기다려야 하는 일수

**핵심 아이디어**:
- NextGreaterElement 문제의 변형
- 스택에 인덱스를 저장하고, 조건을 만족할 때 거리(일수) 계산

**예시**:
```
온도: [73, 74, 75, 71, 69, 72, 76, 73]
일수: [1,  1,  4,  2,  1,  1,  0,  0]
```

**테스트 실행**:
```bash
./gradlew :dojo:test --tests "com.example.java.algorithm.stack.DailyTemperaturesTest"
```

---

## 전체 테스트 실행

모든 스택 문제 테스트를 한 번에 실행:

```bash
./gradlew :dojo:test --tests "com.example.java.algorithm.stack.*"
```

## 학습 가이드

1. **시작하기**: ValidParentheses 문제부터 시작하세요. 가장 기본적인 스택 활용 문제입니다.

2. **핵심 패턴 이해**: NextGreaterElement 문제로 "스택에 인덱스 저장" 패턴을 학습하세요.

3. **응용 문제**: StockSpan과 DailyTemperatures는 NextGreaterElement의 응용입니다.

4. **시간 복잡도**: 모든 문제는 스택을 사용하면 O(n) 시간에 해결 가능합니다. 이중 for문(O(n²))을 사용하지 않도록 주의하세요.

## 공통 힌트

- **스택에 무엇을 저장할지**: 대부분의 경우 값이 아닌 **인덱스**를 저장합니다.
- **언제 pop?**: 현재 원소가 조건을 만족할 때 스택에서 pop합니다.
- **언제 push?**: 처리가 끝난 후 현재 인덱스를 push합니다.
- **결과 계산**: pop한 인덱스와 현재 인덱스의 차이, 또는 값의 비교로 결과를 계산합니다.
