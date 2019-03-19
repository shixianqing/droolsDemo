package com.drools.chapter2;

import com.drools.model.Car;
import com.drools.model.Goods;
import com.drools.model.Person;
import org.junit.Test;
import org.kie.api.KieBase;
import org.kie.api.io.Resource;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.internal.io.ResourceFactory;
import org.kie.internal.utils.KieHelper;

/**
 * @Author:shixianqing
 * @Date:2019/3/19 14:34
 * @Description:
 * 更方便的加载规则
 * 方式一：通过classpath加载规则
 * 方式二：直接加载规则
 * 新增规则重新构建
 **/
public class KieHelperTest {

    @Test
    public void test(){
//        Resource resource = ResourceFactory.newClassPathResource("com/rules/goods.drl");
//        Resource resource1 = ResourceFactory.newClassPathResource("com/rules/car.drl");
        Resource resource = ResourceFactory.newClassPathResource("com/rules/goods.drl");

        KieHelper kieHelper = new KieHelper();

//        kieHelper.addResource(resource, ResourceType.DRL);
        kieHelper.addContent("package com.rules;\n" +
                "import com.drools.model.Goods\n" +
                "dialect  \"mvel\"\n" +
                "\n" +
                "rule \"goods\"\n" +
                "    when\n" +
                "        $goods : Goods(discount == 100)\n" +
                "    then\n" +
                "        System.out.println(\"goods 规则进来了\");\n" +
                "        $goods.setDiscount(90);\n" +
                "end", ResourceType.DRL);

        KieBase kieBase = kieHelper.build();

        KieSession kieSession = kieBase.newKieSession();

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
