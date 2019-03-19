package com.drools.chapter2;

import com.drools.model.Person;
import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.builder.KieScanner;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.scanner.embedder.MavenSettings;
import org.omg.CORBA.PUBLIC_MEMBER;

/**
 * @Author:shixianqing
 * @Date:2019/3/19 10:25
 * @Description:
 * 监测maven仓库中jar包的变化
 * 自动重新构建
 *
 * 1、业务工程里可以不用引入规则jar
 * 2、底层通过定时任务，从maven库中拉取规则jar，进行版本比较
 * 3、默认的maven库路径为【user.home】\.m2\repository 比如：C:\Users\shixianqing\.m2\repository
 * 4、1）可以通过System.setProperties(String key,String value) 自定义设置maven的setting文件路径
 *      System.setProperty(MavenSettings.CUSTOM_SETTINGS_PROPERTY,"D:\\soft\\software\\apache-maven-3.3.9\\conf\\settings.xml");
 *    2）配置系统环境变量，M2_HOME=dirOfSettings
 * 5、配置完系统环境变量后之后，需要重启电脑，否则环境变量不生效
 **/
public class KieScannerTest {

    private static final String GROUP_ID = "com.ysj.drools";
    private static final String ARTIFACT_ID = "drools-rules";
    private static final String VERSION = "1.0-SNAPSHOT";

    @Test
    public void test() throws InterruptedException {

        //M2_HOME
//        System.setProperty(MavenSettings.CUSTOM_SETTINGS_PROPERTY,"D:\\soft\\software\\apache-maven-3.3.9\\conf\\settings.xml");
        KieServices kieServices = KieServices.Factory.get();
        KieContainer kieContainer = kieServices.newKieContainer(kieServices.newReleaseId(GROUP_ID,ARTIFACT_ID,VERSION));
        KieScanner kieScanner = kieServices.newKieScanner(kieContainer);
        kieScanner.start(1000);

        KieSession kieSession = kieContainer.newKieSession("ksession-maven-load-rules");

        Person person = new Person();
        person.setAge(33);

        kieSession.insert(person);

        while (true){
            Thread.sleep(3000);
            int count = kieSession.fireAllRules();
            System.out.println("fire " + count +" rule");
        }

//        kieSession.dispose();
    }

    @Test
    public void test1(){
        System.out.println(System.getenv());
        String m2Home = System.getenv("M2_HOME");
        System.out.println(m2Home);
    }
}
