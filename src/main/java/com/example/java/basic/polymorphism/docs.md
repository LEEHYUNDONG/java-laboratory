## 다형성
> 객체지향 츠로그래밍의 대표적인 특징 캡슐화, 상속, 다형성이 있다.





## 추상클래스
동물과 같이 부모 클래스는 제공하지만, 실제 생성되면 안되는 클래스를 추상클래스라 한다.
- 직접 인스턴스를 생성할 수 없는 제약이 있다.
- 부모 클래스를 상속 받는 자식 클래스가 반드시 오버라이딩 해야 하는 메서드를 부모 클래스에 정의할 수 있다. 즉 상속받은 하위 클래스에서 구체적인 구현을 제공하여 인스턴스화 한다.

````java 

public abstract class ElectronicDevice {
    abstract void doSomething();

    public void turnOn() {
        System.out.println("전원 켬");
    }
    
    public void turnOff() {
        System.out.println("전원 끔");
    }
    
}

public class Phone extends ElectronicDevice{
    @Override
    void doSomething() {
        System.out.println("전화, 검색 ...");
    }
}

public class Tv extends ElectronicDevice{
    @Override
    void doSomething() {
        System.out.println("Netflix, Youtube 시청 ...");
    }
}

public class AbstractMain1 {
    public static void main(String[] args) {
        ElectronicDevice[] devices = {new Phone(), new Tv()};

        for (ElectronicDevice electronicDevice : devices) {
            print(electronicDevice);
        }

    }

    private static void print(ElectronicDevice electronicDevice) {
        electronicDevice.turnOn();
        electronicDevice.doSomething();
        electronicDevice.turnOff();
    }
}

````

- 추상 메서드가 하나라도 존재한다면 추상 클래스로 선언해야 함.
- 추상 클래스는 공통 동작을 정의하면서, 각기 다른 구현이 필요한 하위 클래스에서 구