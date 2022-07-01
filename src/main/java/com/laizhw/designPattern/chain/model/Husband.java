package com.laizhw.designPattern.chain.model;

import com.laizhw.designPattern.chain.IWomen;
import com.laizhw.designPattern.chain.Handler;

/**
 * TODO
 *
 * @author : Laizhw@
 * @version : v1.0
 * @className : Husband
 */
public class Husband extends Handler {

    // 丈夫只处理妻子的请求
    public Husband() {
        super(2);
    }

    // 丈夫请示的答复
    @Override
    public void response(IWomen women) {
        System.out.println("--------妻子向丈夫请示-------");
        System.out.println(women.getRequest());
        System.out.println("丈夫的答复是：同意\n");
    }
}
