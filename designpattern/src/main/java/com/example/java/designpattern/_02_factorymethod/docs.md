# 팩토리 메소드 패턴
 > 다양한 구현체가 있고, 그중에서 특정한 구현체를 만들 수 있는 다양한 팩토리
> , 그리고 사용하는 서브클래스에 따라 생산되는 객체 인스턴스가 결정된다.(생산자 클래스가 실제 생산될 제품을 전혀 모르는 상태로 유지됨.)


기존에 팩토리 메서드 패턴이 abstract method나 class로 구현되었는데, java 8버전 이후부터는 충분히 interface로도 팩토리 메서드 패턴을 구현할 수 있게 되었다.
두 클래스의 성질에 대하여 알아보고 인터페이스로 설계할 경우 유용한 점에 대하여 알아보자.

### 추상클래스
- 추상 클래스는 상태(필드)와 추상메소드, 일반 메서드를 가질 수 있어 객체 생성로직을 포함한 기본 동작을 제공
- 자바는 다중상속을 지원하지 않아, 클래스가 이미 다른 클래스를 상속 받고 있는 경우 팩토리 메서드 패턴을 위해 추가로 추상 클래서를 상속받는 것이 불가능했음

### 인터페이스
- default 메서드와 static 메서드를 제공하면서, 인터페이스에서도 메서드의 기본 구현을 넣을 수 있게됨
- 인터페이스는 여러개를 구현할 수 있기 때문에 더 유연하게 설계할 수 있음.

```java
// Product 인터페이스
interface Product {
    String operation();
}

// Concrete Product A
class ConcreteProductA implements Product {
    @Override
    public String operation() {
        return "ConcreteProductA의 작업 실행";
    }
}

// Concrete Product B
class ConcreteProductB implements Product {
    @Override
    public String operation() {
        return "ConcreteProductB의 작업 실행";
    }
}

// Creator 인터페이스
interface Creator {
    // 팩토리 메서드
    Product factoryMethod();

    // Default 메서드로 구현된 someOperation
    default String someOperation() {
        Product product = factoryMethod();
        return "Creator: " + product.operation();
    }
}

// Concrete Creator A
class ConcreteCreatorA implements Creator {
    @Override
    public Product factoryMethod() {
        return new ConcreteProductA();
    }
}

// Concrete Creator B
class ConcreteCreatorB implements Creator {
    @Override
    public Product factoryMethod() {
        return new ConcreteProductB();
    }
}

// 실행
public class Main {
    public static void main(String[] args) {
        Creator creatorA = new ConcreteCreatorA();
        System.out.println(creatorA.someOperation());

        Creator creatorB = new ConcreteCreatorB();
        System.out.println(creatorB.someOperation());
    }
}

```

### interface로 구현한 팩토리 메서드 패턴 장점
- 유연한 상속 구조
  - 다중 구현 가능하여 복잡한 객체 생성 로직을 구현 가능
- 더 가벼운 구조
  - 행동(메서드)만을 공유할 때 적합
- 코드간결성
  - default 메서드를 활용하며 코드가 간결해짐

### 팩토리 메서드 패턴 사용이 유용한 경우
1. 객체 생성 로직이 복잡하거나 변경 가능성이 있을때
2. 코드의 확장성이 요구될때
3. 상위 클래스에서 하위 클래스 인스턴스를 제어해야하는 상황
