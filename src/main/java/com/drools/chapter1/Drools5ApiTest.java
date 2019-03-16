package com.drools.chapter1;

import com.drools.model.Goods;
import org.apache.xmlbeans.impl.tool.XSTCTester;
import org.drools.core.io.impl.ClassPathResource;
import org.junit.Test;
import org.kie.api.io.ResourceType;
import org.kie.internal.KnowledgeBase;
import org.kie.internal.builder.KnowledgeBuilder;
import org.kie.internal.builder.KnowledgeBuilderFactory;
import org.kie.internal.definition.KnowledgePackage;
import org.kie.internal.runtime.StatefulKnowledgeSession;

import java.util.Collection;

/**
 * @Author:shixianqing
 * @Date:2019/3/12 9:49
 * @Description:
 **/
public class Drools5ApiTest {


    @Test
    public void test(){

        KnowledgeBuilder knowledgeBuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();//创建知识库构造器

        //加载编译配置文件
        knowledgeBuilder.add(new ClassPathResource("com/rules/goods.drl"), ResourceType.DRL);

        //判断编译是否出错
        if (knowledgeBuilder.hasErrors()){
            System.out.println("编译规则文件出错！");
        }

        //获取规则文件所在包
        Collection<KnowledgePackage> knowledgePackages = knowledgeBuilder.getKnowledgePackages();

        //创建知识库
        KnowledgeBase knowledgeBase = knowledgeBuilder.newKnowledgeBase();

        //收集规则
        knowledgeBase.addKnowledgePackages(knowledgePackages);

        //创建有状态session
        StatefulKnowledgeSession session = knowledgeBase.newStatefulKnowledgeSession();

        //将实体插入到workMemory
        Goods goods = new Goods();
        session.insert(goods);

        //执行规则
        int count = session.fireAllRules();
        System.out.println("fired " +count+"条 rule");
        System.out.println("discount 更新后的值为："+goods.getDiscount());

    }

}
