package com.drools.chapter2;

import com.drools.model.Person;
import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.FactHandle;

/**
 * @Author:shixianqing
 * @Date:2019/3/15 9:22
 * @Description: 定时器
 * timer 属性
 * timer ( int: <initial delay> <repeat interval>? )
 * timer ( int: 30s )
 * timer ( int: 30s 5m )
 * timer ( cron: <cron expression> )
 * timer ( cron:* 0/15 * * * ? )
 **/
public class TimerTest {

    @Test
    public void test() throws InterruptedException {

        final KieSession kieSession = KieServices.Factory.get()
                                .newKieClasspathContainer()
                                .newKieSession("timer-rule");
        new Thread(new Runnable() {
            public void run() {
                /****
                 * 保持规则匹配，直到halt()方法被回调。在给定时间内，如果规则没有被匹配到，
                 * 则将等待一个匹配项添加到agenda-group或rule-flow-group组中，这将导致线程阻塞，
                 * 直到halt()方法被回调
                 */
                kieSession.fireUntilHalt();
            }
        }).start();

        Person p = new Person();
        p.setAge(1);
        FactHandle factHandle =  kieSession.insert(p);

        for (int i = 5; i < 20; i++) {
            Thread.sleep(1000);
            p.setAge(i);
            kieSession.update(factHandle,p);
        }

        Thread.sleep(60000);

        kieSession.halt();
    }
}
