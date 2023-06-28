package com.example.corejava8.function;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * <a href="https://www.cnblogs.com/linzhanfly/p/9686941.html">详细参考</a>
 *
 * 1 作用
 * 消费某个对象
 *
 * 2 使用场景
 * Iterable接口的forEach方法需要传入Consumer，大部分集合类都实现了该接口，用于返回Iterator对象进行迭代。
 *
 * 3 设计思想
 * 开发者调用ArrayList.forEach时，一般希望自定义遍历的消费逻辑，比如：输出日志或者运算处理等。
 * 处理逻辑留给使用者，使用灵活多变。
 * 多变的逻辑能够封装成一个类（实现Consumer接口），将逻辑提取出来。
 *
 * PASS：Javascript能够将函数传递给另一个函数，这应该算是函数式编程的一个体现，java的function包中的类也是类似的。
 */
public class ConsumerDemo1 {

    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<>();
        String[] prefix = {"A", "B"};
        for (int i = 0; i < 10; i++) {
            employeeList.add(new Employee(prefix[i % 2] + i, BigDecimal.valueOf(i * 1000)));
        }
        employeeList.forEach(new NameConsumer());
        employeeList.forEach(new SalaryConsumer());

        // demo
        List<String> strings = Arrays.asList("A", "B", "C");
        strings.forEach(System.out::println);
    }


    @Data
    @AllArgsConstructor
    static class Employee {
        private String name;
        private BigDecimal salary;
    }

    static class NameConsumer implements Consumer<Employee> {
        @Override
        public void accept(Employee employee) {
            if (employee.name.startsWith("A")) {
                System.out.println(String.format("%s salary is %s", employee.name, employee.salary));
            }
        }
    }


    static class SalaryConsumer implements Consumer<Employee> {
        @Override
        public void accept(Employee employee) {
            if (employee.salary.compareTo(BigDecimal.valueOf(5000)) >= 0) {
                System.out.println(String.format("%s你需要交税了，因为你的salary为：%s", employee.name, employee.salary));
            }
        }
    }


}
