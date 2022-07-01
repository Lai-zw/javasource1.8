package com.laizhw.designPattern.mediator;

/**
 * TODO
 *
 * @author : Laizhw@
 * @version : v1.0
 * @className : AbstractColleague
 */
public abstract class AbstractColleague {

    protected AbstractMediator mediator;

    public AbstractColleague(AbstractMediator _mediator) {
        this.mediator = _mediator;
    }

}
