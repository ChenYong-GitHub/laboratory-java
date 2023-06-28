package item3.staticfactory;

public class Dog {

    private static final Dog INSTANCE = new Dog();

    private Dog() {}

    public static Dog getInstance() {
        return INSTANCE;
    }

    // 防止反序列化时破坏单例（因为反序列后会调用此方法，因此 即使反序列创建了新实例，最终也只会返回正常创建的单实例）
    public Dog readResolve() {
        return INSTANCE;
    }

}
