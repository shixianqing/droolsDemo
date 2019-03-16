package com.drools.chapter2;

import com.drools.model.Person;
import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieSession;

/**
 * @Author:shixianqing
 * @Date:2019/3/15 15:04
 * @Description:
 **/
public class ModifyTest {

    @Test
    public void test(){

              KieSession kieSession = KieServices.Factory.get()
                .newKieClasspathContainer()
                .newKieSession("modify-rule");

        Person person = new Person();
        person.setAge(12);

        kieSession.insert(person);
        kieSession.fireAllRules();
        kieSession.dispose();
    }
}
