package designPattern.iterator;

/**
 * TODO
 *
 * @author : LaiZhw
 * @version : v1.0
 * @className : IProject
 * @createTime : 2022/6/20 11:30
 */
public interface IProject {
    // 增加项目
    public void add(String name, int num, int cost);

    // 项目信息
    public String getProjectInfo();

    // 获得一个可以被遍历的对象
    public IProjectIterator iterator();
}
