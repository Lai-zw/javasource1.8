package designPattern.visitor;

/**
 * TODO
 *
 * @author : LaiZhw
 * @version : v1.0
 * @className : IShowVisitor
 * @createTime : 2022/6/27 11:33
 */
public interface IShowVisitor extends IVisitor{
    //展示报表
    void report();
}
