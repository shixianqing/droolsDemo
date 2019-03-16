package com.drools.chapter2;

import com.drools.model.Car;
import com.drools.model.Person;
import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.internal.utils.KieService;

/**
 * @Author:shixianqing
 * @Date:2019/3/12 18:43
 * @Description:
 **/
public class Drools7ApiTest {

    @Test
    public void test(){
        KieServices kieServices = KieServices.Factory.get();
        KieContainer kieContainer = kieServices.newKieClasspathContainer();
        KieSession kieSession = kieContainer.newKieSession("ksession-rules");

        Car car1 = new Car();
        Person p1 = new Person();
        p1.setAge(90);
        car1.setPerson(p1);

        Car car2 = new Car();
        Person p2 = new Person();
        p2.setAge(30);
        car2.setPerson(p2);

        kieSession.insert(car1);
        kieSession.insert(car2);
        int count = kieSession.fireAllRules();

        System.out.println("执行了："+count+"条规则");

        System.out.println("discount："+car1.getDiscount());
        System.out.println("discount："+car2.getDiscount());


    }
}
