package com.drools.chapter2;

import com.drools.model.Person;
import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 * @Author:shixianqing
 * @Date:2019/3/13 14:03
 * @Description:
 * 在RHS通干update()修改fact对象，可能会出现死循环
 * no-look属性设置可以避免出现死循环
 * no-look属性默认值为false，可以设置循环
 **/
public class NolookDemo {

    @Test
    public void testNoLook(){

        KieServices kieServices = KieServices.Factory.get();
        KieContainer kieContainer = kieServices.newKieClasspathContainer();
        KieSession kieSession = kieContainer.newKieSession("no-loop-rules");

        Person p = new Person();
        p.setAge(3);

        kieSession.insert(p);
        kieSession.fireAllRules();
        kieSession.dispose();

    }
}
