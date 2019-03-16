package com.drools.chapter2;

import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieSession;

/**
 * @Author:sxq
 * @Date: 2019/3/16
 * @Description:
 * 相当于java中的方法，编译器会生成相应的辅助类。
 * 封装多处都调用的业务逻辑到一个方法中。
 * 函数的参数和结果数据类型与java一致
 *
 */
public class FunctionTest {


    @Test
    public void test(){
        KieSession kieSession = KieServices.Factory.get()
                                            .getKieClasspathContainer()
                                            .newKieSession("function-rule");
        kieSession.fireAllRules();
        kieSession.dispose();
    }
}


