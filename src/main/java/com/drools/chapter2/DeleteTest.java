package com.drools.chapter2;

import com.drools.model.Person;
import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.FactHandle;

/**
 * @Author:shixianqing
 * @Date:2019/3/15 14:08
 * @Description:
 **/
public class DeleteTest {


    @Test
    public void test(){

        KieSession kieSession = KieServices.Factory.get()
                .newKieClasspathContainer()
                .newKieSession("delete-rule");

        Person person = new Person();

        person.setAge(23);

        FactHandle factHandle = kieSession.insert(person);

//        kieSession.fireAllRules();

        kieSession.delete(factHandle,FactHandle.State.STATED);
        kieSession.fireAllRules();

        kieSession.dispose();
    }
}
