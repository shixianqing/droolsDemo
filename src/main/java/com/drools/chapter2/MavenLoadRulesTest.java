package com.drools.chapter2;

import com.drools.model.Person;
import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieSession;

/**
 * @Author:shixianqing
 * @Date:2019/3/18 10:58
 * @Description:
 *
 * 通过maven依赖，将规则与业务代码分开
 *
 * 将规则单独放在一个maven工程里，打包发布到本地仓库
 * 在业务工程的pom文件中将jar引入进来
 *
 * 将规则抽离出来，实现规则配置和业务代码分离
 * 业务代码只关心规则的调用及结果处理，不用过多关注规则
 **/
public class MavenLoadRulesTest {


    @Test
    public void test(){
        KieSession kieSession = KieServices.Factory.get()
                            .newKieClasspathContainer()
                            .newKieSession("ksession-maven-load-rules");
        Person person = new Person();
        person.setAge(99);

        kieSession.insert(person);

        kieSession.fireAllRules();
        kieSession.dispose();
    }
}
