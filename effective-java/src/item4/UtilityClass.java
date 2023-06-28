package item4;

/**
 * 使用私有构造方法执行非实例化
 *
 * 试图通过创建抽象类来强制执行非实例化是行不通的。 该类可以被子类化，子类可以被实例化。此外，它误导
 * 用户认为该类是为继承而设计的（条目 19）。不过，有一个简单的方法来确保非实例化。只有当类不包含显式构造
 * 方法时，才会生成一个默认构造方法，因此可以通过包含一个私有构造方法来实现类的非实例化：
 */
public class UtilityClass {

    private UtilityClass() {
        throw new AssertionError();
    }
}