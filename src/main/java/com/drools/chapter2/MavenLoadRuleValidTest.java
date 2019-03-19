package com.drools.chapter2;

import com.drools.model.Person;
import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.builder.Message;
import org.kie.api.builder.Results;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import java.util.List;

/**
 * @Author:shixianqing
 * @Date:2019/3/18 13:42
 * @Description:
 *
 * 规则校验，不规范的规则文件，不执行
 **/
public class MavenLoadRuleValidTest {

    @Test
    public void test(){
        KieContainer kieContainer = KieServices.Factory.get().newKieClasspathContainer();

        Results results = kieContainer.verify();//校验规则

        List<Message> messages = results.getMessages();

        for (Message message : messages){
            System.out.println(message);
        }

//        KieSession kieSession = kieContainer.newKieSession("ksession-maven-load-rules");

    }
}
