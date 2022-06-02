import org.junit.jupiter.api.Test;
import test.enumEntity.JudgeRole;
import test.enumEntity.User;
import test.enumEntity.UserRole;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Map;

public class TestEnum {
    @Test
    public void test01() {
        JudgeRole judgeRole = new JudgeRole();
        String role_root_admin = judgeRole.judge("ROLE_ROOT_ADMIN");
        System.out.println(role_root_admin);
    }

    @Test
    public void test02() {
        EnumSet<UserRole> userRolesForAdmin  = EnumSet.of(UserRole.ROLE_ROOT_ADMIN, UserRole.ROLE_ORDER_ADMIN);
        Map<UserRole,Integer> userStatisticMap = new EnumMap<>(UserRole.class);
        ArrayList<User> userList = new ArrayList<>();
        userList.add(new User("zhangsan", UserRole.ROLE_ROOT_ADMIN));
        userList.add(new User("lisi", UserRole.ROLE_ORDER_ADMIN));
        userList.add(new User("wangwu", UserRole.ROLE_ORDER_ADMIN));
        userList.add(new User("zhaoliu", UserRole.ROLE_ROOT_ADMIN));
        userList.add(new User("sunqi", UserRole.ROLE_NORMAL));
        userList.add(new User("laoba", UserRole.ROLE_ORDER_ADMIN));
        for ( User user : userList ) {
            Integer num = userStatisticMap.get( user.getUserRole() );
            if( null != num ) {
                userStatisticMap.put((UserRole) user.getUserRole(), num+1 );
            } else {
                userStatisticMap.put((UserRole) user.getUserRole(), 1 );
            }
        }
        System.out.println(userStatisticMap);
    }
}
