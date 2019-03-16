package com.drools.model;

/**
 * @Author:shixianqing
 * @Date:2019/3/12 10:52
 * @Description:
 **/
public class Car {

    private Integer discount;//折扣率

    private Person person;

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
