package com.drools.chapter2;

import com.ysj.drools.Person;
import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.builder.KieScanner;
import org.kie.api.builder.ReleaseId;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 * @Author:shixianqing
 * @Date:2019/3/19 20:08
 * @Description:
 **/
public class workBenchTest {

    private static final String GROUP_ID = "com.ysj.drools";
    private static final String ARTIFACT_ID = "rule";
    private static final String VERSION = "1.0";
    @Test
    public void test() throws InterruptedException {
        KieServices kieServices = KieServices.Factory.get();
        ReleaseId releaseId = kieServices.newReleaseId(GROUP_ID, ARTIFACT_ID, VERSION);
        KieContainer kieContainer = kieServices.newKieContainer(releaseId);
        KieScanner kieScanner = kieServices.newKieScanner(kieContainer);
        kieScanner.start(1000);

        Person person = new Person();
        person.setAge(22);
        person.setName("李四");

        KieSession kieSession = kieContainer.newKieSession();
        kieSession.insert(person);

        while (true){
            Thread.sleep(2000);
            int count = kieSession.fireAllRules();
            System.out.println("执行了" + count +" 规则");
        }

    }
}
