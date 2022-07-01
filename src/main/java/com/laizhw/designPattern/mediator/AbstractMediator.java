package com.laizhw.designPattern.mediator;

import com.laizhw.designPattern.mediator.model.Sale;
import com.laizhw.designPattern.mediator.model.Stock;
import com.laizhw.designPattern.mediator.model.Purchase;

/**
 * TODO
 *
 * @author : Laizhw@
 * @version : v1.0
 * @className : AbstractMediator
 */
public abstract class AbstractMediator {

    protected Purchase purchase;
    protected Sale sale;
    protected Stock stock;

    //构造函数
    public AbstractMediator() {
        purchase = new Purchase(this);
        sale = new Sale(this);
        stock = new Stock(this);
    }

    //中介者最重要的方法，叫做事件方法，处理多个对象之间的关系
    public abstract void execute(String str, Object... objects);

}
