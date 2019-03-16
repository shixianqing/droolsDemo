package com.drools.chapter2;

import com.drools.model.Person;
import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.QueryResults;
import org.kie.api.runtime.rule.QueryResultsRow;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author:shixianqing
 * @Date:2019/3/15 17:10
 * @Description:
 * Query语法提供了一种查询working memory中符合约束条件的FACT对象的简单方法。
 * 仅包含规则文件中的LHS部分，不用指定“when”和“then”部分。
 * Query有一个可选参数集合，每一个参数都有可选的类型。如果没有指定类型，则默认为Object类型
 * Query名称需要全局唯一
 *
 * 语法格式：
 *      query [name] (Object... params)
 *          LHS
 *      end
 *
 *
 * 获取fact对象
 **/
public class QueryTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Test
    public void test(){
        KieSession kieSession = KieServices.Factory.get().newKieClasspathContainer().newKieSession("query-rule");


        Person p = new Person();
        p.setName("Tom");
        p.setAge(3);

        Person p1 = new Person();
        p1.setAge(33);
        p1.setName("Bob");

        kieSession.insert(p);
        kieSession.insert(p1);

        kieSession.fireAllRules();

        QueryResults queryResultsRows = kieSession.getQueryResults("query-by-age");
        for (QueryResultsRow row : queryResultsRows){
            Person person = (Person) row.get("$p1");
            System.out.println("person name is " + person.getName());
        }

        System.out.println("-----------------------------------");

        QueryResults resultsRows = kieSession.getQueryResults("query-by-ageParam",1);
        for (QueryResultsRow row: resultsRows){
            Person person = (Person) row.get("$person");
            logger.info("person name is " + person.getName());
        }
        kieSession.dispose();
    }
}
