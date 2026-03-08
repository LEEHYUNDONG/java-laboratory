package com.example.java.practice.collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("MyHashMap 구현 테스트")
class MyHashMapTest {

    private MyHashMap<String, Integer> map;

    @BeforeEach
    void setUp() {
        map = new MyHashMap<>();
    }

    @Test
    @DisplayName("빈 맵 생성 테스트")
    void testEmptyMap() {
        assertTrue(map.isEmpty());
        assertEquals(0, map.size());
    }

    @Test
    @DisplayName("키-값 쌍 저장 테스트")
    void testPut() {
        assertNull(map.put("one", 1));
        assertNull(map.put("two", 2));
        assertNull(map.put("three", 3));

        assertEquals(3, map.size());
        assertEquals(1, map.get("one"));
        assertEquals(2, map.get("two"));
        assertEquals(3, map.get("three"));
    }

    @Test
    @DisplayName("기존 키의 값 업데이트 테스트")
    void testPutUpdate() {
        map.put("key", 100);
        Integer oldValue = map.put("key", 200);

        assertEquals(100, oldValue);
        assertEquals(200, map.get("key"));
        assertEquals(1, map.size());
    }

    @Test
    @DisplayName("값 조회 테스트")
    void testGet() {
        map.put("Apple", 10);
        map.put("Banana", 20);

        assertEquals(10, map.get("Apple"));
        assertEquals(20, map.get("Banana"));
        assertNull(map.get("Cherry"));
    }

    @Test
    @DisplayName("키-값 쌍 제거 테스트")
    void testRemove() {
        map.put("A", 1);
        map.put("B", 2);
        map.put("C", 3);

        assertEquals(2, map.remove("B"));
        assertEquals(2, map.size());
        assertNull(map.get("B"));
        assertFalse(map.containsKey("B"));

        assertNull(map.remove("D"));
    }

    @Test
    @DisplayName("containsKey 테스트")
    void testContainsKey() {
        map.put("key1", 100);
        map.put("key2", 200);

        assertTrue(map.containsKey("key1"));
        assertTrue(map.containsKey("key2"));
        assertFalse(map.containsKey("key3"));
    }

    @Test
    @DisplayName("containsValue 테스트")
    void testContainsValue() {
        map.put("A", 10);
        map.put("B", 20);

        assertTrue(map.containsValue(10));
        assertTrue(map.containsValue(20));
        assertFalse(map.containsValue(30));
    }

    @Test
    @DisplayName("null 키 처리 테스트")
    void testNullKey() {
        map.put(null, 999);
        map.put("key", 100);

        assertEquals(999, map.get(null));
        assertTrue(map.containsKey(null));

        assertEquals(999, map.remove(null));
        assertFalse(map.containsKey(null));
    }

    @Test
    @DisplayName("null 값 처리 테스트")
    void testNullValue() {
        map.put("key", null);

        assertTrue(map.containsKey("key"));
        assertNull(map.get("key"));
        assertTrue(map.containsValue(null));
    }

    @Test
    @DisplayName("해시 충돌 처리 테스트")
    void testHashCollision() {
        // 같은 해시값을 가지도록 하는 커스텀 키 클래스
        class CollisionKey {
            String value;

            CollisionKey(String value) {
                this.value = value;
            }

            @Override
            public int hashCode() {
                return 1; // 모두 같은 해시값
            }

            @Override
            public boolean equals(Object obj) {
                if (this == obj) return true;
                if (!(obj instanceof CollisionKey)) return false;
                return value.equals(((CollisionKey) obj).value);
            }
        }

        MyHashMap<CollisionKey, String> collisionMap = new MyHashMap<>();
        CollisionKey key1 = new CollisionKey("A");
        CollisionKey key2 = new CollisionKey("B");
        CollisionKey key3 = new CollisionKey("C");

        collisionMap.put(key1, "Value1");
        collisionMap.put(key2, "Value2");
        collisionMap.put(key3, "Value3");

        assertEquals(3, collisionMap.size());
        assertEquals("Value1", collisionMap.get(key1));
        assertEquals("Value2", collisionMap.get(key2));
        assertEquals("Value3", collisionMap.get(key3));
    }

    @Test
    @DisplayName("리해싱 테스트 - 많은 요소 추가")
    void testResizing() {
        // 초기 용량(16) * 로드팩터(0.75) = 12를 초과하여 추가
        for (int i = 0; i < 100; i++) {
            map.put("key" + i, i);
        }

        assertEquals(100, map.size());

        // 모든 요소가 제대로 저장되었는지 확인
        for (int i = 0; i < 100; i++) {
            assertEquals(i, map.get("key" + i));
        }
    }

    @Test
    @DisplayName("clear 테스트")
    void testClear() {
        map.put("A", 1);
        map.put("B", 2);
        map.put("C", 3);

        map.clear();

        assertTrue(map.isEmpty());
        assertEquals(0, map.size());
        assertNull(map.get("A"));
    }

    @Test
    @DisplayName("동일한 키로 여러 번 put 후 remove 테스트")
    void testMultiplePutAndRemove() {
        map.put("key", 1);
        map.put("key", 2);
        map.put("key", 3);

        assertEquals(1, map.size());
        assertEquals(3, map.get("key"));

        map.remove("key");
        assertEquals(0, map.size());
        assertNull(map.get("key"));
    }
}
