package designPattern.mediator.model;

import designPattern.mediator.AbstractMediator;

/**
 * TODO
 *
 * @author : Laizhw@
 * @version : v1.0
 * @className : Mediator
 */
public class Mediator extends AbstractMediator {
    @Override
    public void execute(String str, Object... objects) {
        switch (str) {
            case "purchase.buy":
                //采购电脑
                this.buyComputer((Integer) objects[0]);
                break;
            case "sale.sell":
                //销售电脑
                this.sellComputer((Integer) objects[0]);
                break;
            case "sale.offsell":
                //折价销售
                this.offSell();
                break;
            case "stock.clear":
                //清仓处理
                this.clearStock();
                break;
        }
    }

    private void buyComputer(int number) {
        int saleStatus = super.sale.getSaleStatus();
        if (saleStatus > 80) {
            System.out.println("采购IBM电脑:" + number + "台");
            super.stock.increase(number);
        } else {
            int buyNumber = number / 2;
            System.out.println("采购IBM电脑：" + buyNumber + "台");
        }
    }

    private void sellComputer(int number) {
        if (super.stock.getStockNumber() < number) {
            //库存数量不够销售
            super.purchase.buyIBMcomputer(number);
        }
        super.stock.decrease(number);
    }

    private void offSell() {
        System.out.println("折价销售IBM电脑" + stock.getStockNumber() + "台");
    }

    private void clearStock() {
        //要求清仓销售
        super.sale.offSale();
        // 要求采购人员不要采购
        super.purchase.refuseBuyIBM();
    }

}
