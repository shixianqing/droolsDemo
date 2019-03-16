package com.drools.chapter2;

import com.drools.model.Person;
import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieSession;

/**
 * @Author:shixianqing
 * @Date:2019/3/13 15:04
 * @Description:
 * lock-on-active 属性：
 *  避免因FACT对象被更新使得执行过的规则被再次执行
 *  触发此类规则的操作有update、retract、update、modify等
 *  拥有no-loop的功能，同时又能避免其他规则改变FACT对象导致规则重新执行
 **/
public class LockOnActiveDemo {

    @Test
    public void test(){

        KieSession kieSession = KieServices.Factory.get()
                                                    .newKieClasspathContainer()
                                                    .newKieSession("lock-on-active-rules");
        Person p = new Person();
        p.setAge(11);

        kieSession.insert(p);
        kieSession.fireAllRules();
        kieSession.dispose();

    }
}
