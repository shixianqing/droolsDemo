package com.drools.chapter2;

import com.drools.model.Car;
import com.drools.model.Goods;
import com.drools.model.Person;
import org.junit.Test;
import org.kie.api.KieBase;
import org.kie.api.KieServices;
import org.kie.api.event.kiebase.BeforeRuleRemovedEvent;
import org.kie.api.event.kiebase.DefaultKieBaseEventListener;
import org.kie.api.event.rule.*;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 * @Author:shixianqing
 * @Date:2019/3/19 16:02
 * @Description:
 * KIEBase的监听是与package结构相关的内容变化
 * KieSession的监听器主要监听运行时相关变化
 **/
public class EventTest {

    @Test
    public void test(){

        KieContainer kieContainer = KieServices.Factory.get().newKieClasspathContainer();
        KieBase kieBase = kieContainer.getKieBase("rules");
        kieBase.addEventListener(new DefaultKieBaseEventListener(){
            @Override
            public void beforeRuleRemoved(BeforeRuleRemovedEvent event) {
                super.beforeRuleRemoved(event);
                System.out.println("被移除规则的名称：" + event.getRule().getName());
            }
        });

        kieBase.removeRule("com.rules","test-age-older-than-60");

        KieSession kieSession = kieBase.newKieSession();

        kieSession.addEventListener(new DefaultRuleRuntimeEventListener(){
            @Override
            public void objectInserted(ObjectInsertedEvent event) {
                super.objectInserted(event);
                System.out.println("插入对象的为："+ event.getObject() );
            }

            @Override
            public void objectUpdated(ObjectUpdatedEvent event) {
                super.objectUpdated(event);

                System.out.println("老对象为：" + event.getOldObject() + "新对象为："+ event.getObject());
            }
        });

        kieSession.addEventListener(new DefaultAgendaEventListener(){
            @Override
            public void afterMatchFired(AfterMatchFiredEvent event) {
                super.afterMatchFired(event);
                System.out.println("对象 " + event.getMatch().getObjects());
            }
        });

        Person person = new Person();
        person.setAge(99);
        Car car = new Car();
        car.setPerson(person);

        Goods goods = new Goods();
        goods.setDiscount(100);

        kieSession.insert(car);
        kieSession.insert(goods);

        kieSession.fireAllRules();
        kieSession.dispose();

    }
}
