# 상품 정보 캐싱 시스템

## 문제 설명
외부 API를 통해 상품 정보를 조회하는 시스템이 있습니다.
매번 외부 API를 호출하면 느리고 비용이 발생하므로, 캐시를 구현하여 성능을 개선해야 합니다.

## 요구사항

### 1. 기본 캐시 기능
- 상품 ID를 키로 하여 상품 정보를 캐시에 저장
- 캐시에 데이터가 있으면 캐시에서 반환 (Cache Hit)
- 캐시에 데이터가 없으면 외부 API 호출 후 캐시에 저장 (Cache Miss)

### 2. TTL (Time To Live) 구현
- 각 캐시 항목은 설정된 TTL(예: 60초) 동안만 유효
- TTL이 만료된 데이터는 자동으로 무효화
- 만료된 데이터 조회 시 외부 API를 다시 호출

### 3. 캐시 무효화
- 특정 상품의 캐시를 수동으로 삭제하는 기능
- 전체 캐시를 삭제하는 기능

### 4. 캐시 통계
- Cache Hit 횟수
- Cache Miss 횟수
- Hit Rate (적중률) 계산

### 5. 동시성 제어
- 여러 쓰레드가 동시에 같은 상품을 조회할 때 중복 API 호출 방지
- 한 쓰레드가 API 호출 중이면 다른 쓰레드는 대기

## 구현해야 할 부분

### ProductCacheManager (TODO)
- `get(Long productId)`: 캐시에서 상품 조회 (없으면 API 호출)
- `put(Long productId, Product product)`: 캐시에 저장
- `evict(Long productId)`: 특정 상품 캐시 삭제
- `clear()`: 전체 캐시 삭제
- `getStatistics()`: 캐시 통계 반환
- TTL 만료 확인 로직
- 동시성 제어 로직

## 테스트 시나리오
1. 첫 조회 시 Cache Miss 발생 및 API 호출 확인
2. 두 번째 조회 시 Cache Hit 발생 및 API 호출 안 함 확인
3. TTL 만료 후 Cache Miss 발생 확인
4. 수동 캐시 삭제 후 Cache Miss 발생 확인
5. 동시에 같은 상품 조회 시 API 1번만 호출 확인
6. 통계 정보 정확성 확인

## 힌트
- `ConcurrentHashMap` 사용 고려
- 각 캐시 항목에 만료 시간 저장 필요
- 동시성 제어를 위해 `synchronized` 또는 `Lock` 사용 고려
- 통계는 `AtomicLong` 사용 권장
