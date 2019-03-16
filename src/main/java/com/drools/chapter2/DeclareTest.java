package com.drools.chapter2;

import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieSession;

/**
 * @Author:sxq
 * @Date: 2019/3/16
 * @Description:
 * 适用于直接定义规则引擎的数据原型，不用再在java中创建。
 * 新构建扩展原型
 *
 * declare Address
 *     number : int
 *     streetName : String
 *     city : String
 * end
 */
public class DeclareTest {


    @Test
    public void test(){

        KieSession kieSession = KieServices.Factory.get()
                .getKieClasspathContainer()
                .newKieSession("declareRule");
        kieSession.fireAllRules();
        kieSession.dispose();

    }
}


