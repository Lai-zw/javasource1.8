package project.model;

public class JudgeRole {
    public String judge( String roleName ) {
        // 一行代码搞定！之前的if/else灰飞烟灭
        return RoleEnum.valueOf(roleName).op();
    }
}
