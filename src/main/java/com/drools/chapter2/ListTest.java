package com.drools.chapter2;

import com.drools.model.Person;
import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieSession;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author:shixianqing
 * @Date:2019/3/17 14:24
 * @Description:
 **/
public class ListTest {

    boolean a;
    @Test
    public void test(){
//        KieSession kieSession = KieServices.Factory.get().newKieClasspathContainer().newKieSession("listRule");
        Person p = new Person();
        p.setAge(12);
        p.setName("张三");
        Person p1 = new Person();
        p1.setAge(14);
        p1.setName("账单");
        Person p2 = new Person();
        p2.setAge(12);
        p2.setName("张三");
        List<Person> list = Arrays.asList(p,p1,p2);
//        kieSession.insert(list);
//        kieSession.fireAllRules();
//        kieSession.dispose();

//        List<Person> distinctList = list.stream()
//                .filter(person -> person.getAge() ==12 )
//                .collect(Collectors.collectingAndThen(Collectors.toCollection(
//                        // 利用 TreeSet 的排序去重构造函数来达到去重元素的目的
//                        () -> new TreeSet<>(Comparator.comparing(Person::getAge))), ArrayList::new));
//        System.out.println(distinctList);
//        Map<String,List<Person>> groupList =  distinctList.stream().collect(Collectors.groupingBy(Person::getName));
//        System.out.println(groupList);
//
//        System.out.println("a==="+a);
//       boolean flag = groupList.entrySet().stream().filter(x -> x.getValue().size()==1).count()>0;
//        System.out.println(flag);
    }
}
