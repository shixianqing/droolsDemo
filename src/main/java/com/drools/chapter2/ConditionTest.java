package com.drools.chapter2;

import com.drools.model.Car;
import com.drools.model.Person;
import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieSession;

/**
 * @Author:shixianqing
 * @Date:2019/3/15 15:32
 * @Description:
 *
 * 规则之间可以像java一样，实现继承，
 * 在Java中，如果有重复的代码我们会考虑进行重构，
 * 抽取公共方法或继承父类，以减少相同的代码在多处出现，达到代码的最优管理和不必要的麻烦。
 * Drools同样提供了类似的功能。下面我们以实例来逐步说明
 *
 * rule "rule-name1" extends "rule-name2"
 **/
public class ConditionTest {

    @Test
    public void test(){

        KieSession kieSession = KieServices.Factory.get()
                .newKieClasspathContainer()
                .newKieSession("condition-rule");

        Person person = new Person();
        person.setAge(30);

        Car car = new Car();
        car.setDiscount(90);

        kieSession.insert(person);
        kieSession.insert(car);
        kieSession.fireAllRules();
        kieSession.dispose();
    }
}


