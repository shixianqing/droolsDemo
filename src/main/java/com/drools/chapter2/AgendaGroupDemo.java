package com.drools.chapter2;

import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieSession;

/**
 * @Author:shixianqing
 * @Date:2019/3/13 16:06
 * @Description:
 **/
public class AgendaGroupDemo {

    @Test
    public void test(){

        KieSession kieSession = KieServices.Factory.get()
                                    .newKieClasspathContainer()
                                    .newKieSession("agenda-group-rules");
        kieSession.getAgenda().getAgendaGroup("test1").setFocus();

        kieSession.fireAllRules();
        kieSession.dispose();
    }
}
