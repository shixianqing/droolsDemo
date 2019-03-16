package com.drools.chapter2;

import com.drools.model.Person;
import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieSession;

/**
 * @Author:shixianqing
 * @Date:2019/3/13 15:41
 * @Description:
 * salience 属性
 *      设置规则的优先级
 *      数字越大，优先级越高
 *      默认值为0，可以为负数
 *
 *
 **/
public class SalienceDemo {

    @Test
    public void test(){

        KieSession kieSession = KieServices.Factory.get().newKieClasspathContainer().newKieSession("salience-rules");

        Person p = new Person();
        p.setAge(11);

        kieSession.insert(p);

        kieSession.fireAllRules();

        kieSession.dispose();
    }
}
