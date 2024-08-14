# 싱글톤 패턴

## enum을 사용하지 않은 싱글톤 패턴
```java
/**
 * @author : lhd
 * @packageName : com.example.java.designpattern._01_singleton.ex
 * @fileName : java
 * @description :
 * <p>
 * ====================================================
 * DATE            AUTHOR              NOTE
 * ====================================================
 * 2024-08-12         lhd
 */
public class Father {
    // 1
    // private static Father instance;
    //2
    // private static volatile Father instance;

    private Father() {}

    //3
    private static class FatherHolder {
        private static final Father INSTANCE = new Father();
    }


    // 1
//    public static Father getInstance() {
//        if(instance == null) {
//            instance = new Father();
//        }
//        return instance;
//    }

    /**
     * 2. thread-safe한 방법
     *  SYCHRONIZED 키워드 사용하기 -> 성능의 문제가 생길 수 있음.
     *  method 앞에 synchronize 키워드를 붙이면 인스턴스 메모리 사이즈와 관계없이 static final로 인하여 비용 소모가 크다
     *  하지만 method 앞이 아닌 getInstance 내부에 만들게 되면 아래와 같이 해결할 수 있음. (double checked locking)
     */
//    public static Father getInstance() {
//        if(instance == null) {
//            synchronized (Father.class) {
//                if(instance == null) {
//                    instance = new Father();
//                }
//            }
//        }
//        return instance;
//    }

    //3
    public static Father getInstance() {
        return FatherHolder.INSTANCE;
    }

}
```
위 코드가 멀티 스레드 환경에서도 singleton 패턴을 완벽하게 보장하는지 고민해보아야 한다. 실제로 Java Reflection과 데이터 직렬화 역직렬화를 통하여 싱글톤 패턴을 깨뜨릴수 있다.

1. Java Reflection
2. 직, 역직렬화

### Java Reflection 이용
```java
/**
 * @author : lhd
 * @packageName : com.example.java.designpattern._01_singleton.ex
 * @fileName : java
 * @description :
 * <p>
 * ====================================================
 * DATE            AUTHOR              NOTE
 * ====================================================
 * 2024-08-12         lhd
 */
public class SingletonMain {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Father father1 = Father.getInstance();
        Father father2 = Father.getInstance();
        Constructor<Father> constructor = Father.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        Father father3 = constructor.newInstance();
        System.out.println(father1 == father3);
    }
}
```

## private 생성자와 static 메소드를 사용하는 방법의 단점
## enum을 사용하여 싱글톤 패턴을 구현하는 방법의 장단점

## static inner 클래스를 사용해 싱글톤 패턴을 구현
```java
public class Father {
    private Father() {}
    
    private static class FatherHolder {
        private static final Father INSTANCE = new Father();
    }

    public static Father getInstance() {
        return FatherHolder.INSTANCE;
    }
}
```