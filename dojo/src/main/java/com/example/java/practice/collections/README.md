# Java Collection 구현 연습

주요 자바 Collection을 직접 구현하며 자료구조의 내부 동작 원리를 학습합니다.

## 📚 구현 목록

### 1. MyArrayList
- **자료구조**: 동적 배열 (Dynamic Array)
- **시간복잡도**:
  - 인덱스 접근: O(1)
  - 끝에 추가: O(1) 평균 (리사이징 시 O(n))
  - 중간 삽입/삭제: O(n)
- **핵심 개념**: 배열 동적 확장, 요소 이동

### 2. MyLinkedList
- **자료구조**: 이중 연결 리스트 (Doubly Linked List)
- **시간복잡도**:
  - 인덱스 접근: O(n)
  - 앞/뒤 추가/삭제: O(1)
  - 중간 삽입/삭제: O(1) (노드 위치를 알 때)
- **핵심 개념**: 노드 연결, 포인터 관리

### 3. MyHashMap
- **자료구조**: 해시 테이블 (Hash Table with Chaining)
- **시간복잡도**:
  - put/get/remove: O(1) 평균, O(n) 최악
- **핵심 개념**: 해시 함수, 충돌 처리 (체이닝), 리해싱

### 4. MyHashSet
- **자료구조**: HashMap 기반 Set
- **시간복잡도**:
  - add/contains/remove: O(1) 평균
- **핵심 개념**: HashMap 활용, 중복 방지

### 5. MyStack
- **자료구조**: 배열 기반 스택 (Array-based Stack)
- **특징**: LIFO (Last In First Out)
- **시간복잡도**:
  - push/pop/peek: O(1)
- **핵심 개념**: LIFO 구조, 동적 배열 확장

### 6. MyQueue
- **자료구조**: 연결 리스트 기반 큐 (LinkedList-based Queue)
- **특징**: FIFO (First In First Out)
- **시간복잡도**:
  - offer/poll/peek: O(1)
- **핵심 개념**: FIFO 구조, head/tail 포인터

### 7. MyPriorityQueue
- **자료구조**: 이진 힙 (Binary Heap - Min Heap)
- **시간복잡도**:
  - offer: O(log n)
  - poll: O(log n)
  - peek: O(1)
- **핵심 개념**: 힙 속성, siftUp/siftDown, 우선순위

## 🎯 학습 순서 (권장)

난이도 순으로 학습하는 것을 권장합니다:

1. **MyStack** ⭐ (가장 쉬움)
   - 단순한 배열 기반 구조
   - LIFO 개념 이해

2. **MyQueue** ⭐⭐
   - 연결 리스트 기초
   - FIFO 개념 이해

3. **MyArrayList** ⭐⭐
   - 동적 배열 개념
   - 배열 크기 조정 로직

4. **MyLinkedList** ⭐⭐⭐
   - 이중 연결 리스트
   - 포인터 관리 복잡도 증가

5. **MyHashSet** ⭐⭐⭐
   - HashMap 활용 (HashMap 먼저 구현 필요)
   - Set의 중복 방지 메커니즘

6. **MyHashMap** ⭐⭐⭐⭐
   - 해시 함수와 충돌 처리
   - 리해싱 메커니즘

7. **MyPriorityQueue** ⭐⭐⭐⭐⭐ (가장 어려움)
   - 이진 힙 구조
   - siftUp/siftDown 알고리즘

## 🚀 시작하기

### 1. 테스트 실행
각 구현 클래스에 대응하는 테스트가 준비되어 있습니다:

```bash
# 전체 테스트 실행
./gradlew test --tests "com.example.java.practice.collections.*"

# 특정 Collection 테스트 실행
./gradlew test --tests MyArrayListTest
./gradlew test --tests MyHashMapTest
```

### 2. 구현 방법
1. 각 클래스의 `TODO` 주석을 따라 메서드 구현
2. 주석에 있는 힌트를 참고
3. 테스트를 실행하여 구현 검증
4. 모든 테스트가 통과할 때까지 수정

### 3. 학습 포인트
- 각 자료구조의 **시간복잡도**를 이해하고 구현
- **공간복잡도** 고려 (메모리 사용 최적화)
- **엣지 케이스** 처리 (null, empty, boundary)
- Java 표준 라이브러리와 비교

## 📖 참고사항

### 테스트 구조
- `@BeforeEach`: 각 테스트 전 초기화
- `@DisplayName`: 테스트 설명 (한글)
- `assertXXX`: 검증 메서드

### 구현 시 주의사항
1. **Generic 타입** 사용 (`<E>`, `<K, V>`)
2. **@SuppressWarnings("unchecked")** 사용 이유 이해
3. **IndexOutOfBoundsException** 등 적절한 예외 처리
4. **null 값** 처리 (Collection 종류에 따라 다름)

### 추가 학습 자료
- Java Collections Framework 공식 문서
- 알고리즘 책: "Introduction to Algorithms" (CLRS)
- 온라인 코스: Coursera - Algorithms Part I, II

## 💡 팁

1. **한 번에 하나씩**: 한 Collection을 완전히 구현한 후 다음으로 이동
2. **테스트 주도 개발**: 테스트를 먼저 확인하고 구현
3. **디버깅**: 테스트가 실패하면 디버거를 활용하여 단계별 확인
4. **코드 리뷰**: 구현 후 Java 표준 라이브러리 소스코드와 비교
5. **성능 측정**: 큰 데이터셋으로 실제 성능 확인

## 🎓 고급 과제

기본 구현을 완료한 후 시도해볼 만한 과제:

- **Iterator 구현**: `Iterable<E>` 인터페이스 구현
- **TreeMap/TreeSet**: 레드-블랙 트리 기반 정렬된 Map/Set
- **LinkedHashMap**: 삽입 순서를 유지하는 HashMap
- **Deque**: 양방향 큐 (ArrayDeque, LinkedDeque)
- **ConcurrentHashMap**: 스레드 안전한 HashMap

---

화이팅! 🔥
