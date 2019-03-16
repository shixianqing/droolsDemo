package com.drools.chapter2;

import com.drools.model.Person;
import org.drools.core.command.impl.ContextImpl;
import org.drools.core.command.runtime.rule.FireAllRulesCommand;
import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.StatelessKieSession;
import org.kie.api.runtime.rule.FactHandle;
import org.kie.internal.command.CommandFactory;

import java.util.Arrays;

/**
 * @Author:shixianqing
 * @Date:2019/3/13 11:08
 * @Description:
 **/
public class StateLessSessionDemo {

    @Test
    public void testStateLessSession(){

        KieServices kieServices = KieServices.Factory.get();

        KieContainer kieContainer = kieServices.newKieClasspathContainer();

        StatelessKieSession kieSession = kieContainer.newStatelessKieSession("state-less-session");

        Person p = new Person();
        p.setAge(33);

        Person p1 = new Person();
        p1.setAge(22);
//        kieSession.execute(p);

//        kieSession.execute(Arrays.asList(p,p1));

//        int count = fireAllRulesCommand.execute(new ContextImpl());
//        FactHandle factHandle = (FactHandle) kieSession.                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            execute(CommandFactory.newInsert(p));


    }
}
