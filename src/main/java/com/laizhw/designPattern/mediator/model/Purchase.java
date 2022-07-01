package com.laizhw.designPattern.mediator.model;

import com.laizhw.designPattern.mediator.AbstractMediator;
import com.laizhw.designPattern.mediator.AbstractColleague;

/**
 * TODO
 *
 * @author : Laizhw@
 * @version : v1.0
 * @className : Purchase
 */
public class Purchase extends AbstractColleague {

    public Purchase(AbstractMediator _mediator) {
        super(_mediator);
    }

    public void buyIBMcomputer(int number) {
        super.mediator.execute("purchase.buy", number);
    }

    public void refuseBuyIBM() {
        System.out.println("不再采购IBM电脑");
    }

}
