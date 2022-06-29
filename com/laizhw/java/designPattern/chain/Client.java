package designPattern.chain;

import designPattern.chain.model.Father;
import designPattern.chain.model.Husband;
import designPattern.chain.model.Son;
import designPattern.chain.model.Women;

import java.util.ArrayList;
import java.util.Random;

/**
 * TODO
 *
 * @author : Laizhw@
 * @version : v1.0
 * @className : Client
 */
public class Client {
    public static void main(String[] args) {
        Random random = new Random();
        ArrayList<IWomen> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add(new Women(random.nextInt(4), "我出去逛街"));
        }
        // 定义三个请示对象
        Handler father = new Father();
        Handler husband = new Husband();
        Handler son = new Son();

        // 设置请示顺序
        father.setNext(husband);
        husband.setNext(son);

        for (IWomen women : list) {
            father.HandleMessage(women);
        }
    }
}
