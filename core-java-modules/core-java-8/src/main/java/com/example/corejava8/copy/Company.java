package com.example.corejava8.copy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Company {

    private Employee employee;

    private Boss boss;

    public static void main(String[] args) {
        Company company1 = new Company(new Employee("张三", 18L), new Boss("马云", 100L));
        Company company2 = new Company();
        BeanUtils.copyProperties(company1, company2);
        System.out.println(company1);
        System.out.println(company2);
        company2.getBoss().setName("马斯克");
        company2.getBoss().setAge(101L);
        System.out.println(company1);
    }
}
