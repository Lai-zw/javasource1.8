package designPattern.composite;

@SuppressWarnings("all")
public abstract class Corp {
    private String name = "";
    // 职位
    private String position = "";
    private int salary = 0;
    // 父节点
    private Corp parent = null;

    public Corp(String _name, String _position, int _salary) {
        this.name = _name;
        this.position = _position;
        this.salary = _salary;
    }

    public Corp getParent() {
        return parent;
    }

    public void setParent(Corp parent) {
        this.parent = parent;
    }

    // 获取员工信息
    public String getInfo() {

        String info = "";
        info = "姓名：" + this.name;
        info = info + "\t职位：" + this.position;
        info = info + "\t薪资：" + this.salary;
        return info;
    }
}