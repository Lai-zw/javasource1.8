package designPattern.chain.model;

import designPattern.chain.Handler;
import designPattern.chain.IWomen;

/**
 * TODO
 *
 * @author : Laizhw@
 * @version : v1.0
 * @className : Son
 */
public class Son extends Handler {

    // 儿子只处理母亲的请求
    public Son() {
        super(3);
    }

    @Override
    public void response(IWomen women) {
        System.out.println("--------母亲向儿子请示-------");
        System.out.println(women.getRequest());
        System.out.println("儿子的答复是：同意\n");
    }
}
