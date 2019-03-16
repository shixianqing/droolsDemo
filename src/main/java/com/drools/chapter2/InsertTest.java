package com.drools.chapter2;

import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieSession;

/**
 * @Author:shixianqing
 * @Date:2019/3/15 13:29
 * @Description:insert()函数测试
 **/
public class InsertTest {

    @Test
    public void test(){
        KieSession kieSession = KieServices.Factory.get()
                                    .newKieClasspathContainer()
                                    .newKieSession("insert-rule");
        kieSession.fireAllRules();
        kieSession.dispose();
    }
}
