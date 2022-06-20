package designPattern.iterator;

/**
 * 迭代器模式
 *
 * @author : LaiZhw
 * @version : v1.0
 * @className : Boss
 */
public class Boss {
    public static void main(String[] args) {
        IProject project = new Project();

        for (int i = 0; i < 100; i++) {
            project.add("第 " + (i + 1) + " 个项目", (i + 1)  * 5, (i + 1)  * 100000);
        }

        // 遍历取出数据
        IProjectIterator iterator = project.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next().getProjectInfo());
        }

    }
}
