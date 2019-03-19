package com.drools.chapter2;

import com.drools.model.Person;
import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 * @Author:shixianqing
 * @Date:2019/3/18 14:07
 * @Description:
 *使用maven 依赖需要大量引入其他依赖
 * 是否可以决定每个项目只使用指定的依赖？
 **/
public class MavenDynLoadRulesTest {

    private static final String GROUP_ID = "com.ysj.drools";
    private static final String ARTIFACT_ID = "drools-rules";
    private static final String VERSION = "1.0-SNAPSHOT";

    @Test
    public void test(){
        KieServices kieServices = KieServices.Factory.get();
        KieContainer kieContainer = kieServices.newKieContainer(kieServices.newReleaseId(GROUP_ID,ARTIFACT_ID,VERSION));
        KieSession kieSession = kieContainer.newKieSession("ksession-maven-load-rules");
        Person person = new Person();
        person.setAge(99);

        kieSession.insert(person);

        kieSession.fireAllRules();
        kieSession.dispose();
    }
}
