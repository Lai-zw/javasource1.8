package test.enumEntity;

public enum RoleEnum implements RoleOperation {
    ROLE_ROOT_ADMIN{
        @Override
        public String op() {
            return "ROLE_ROOT_ADMIN:" + " has AAA permission";
        }
    },
    ROLE_ORDER_ADMIN{
        @Override
        public String op() {
            return "ROLE_ORDER_ADMIN:" + " has AA permission";
        }
    },
    ROLE_NORMAL{
        @Override
        public String op() {
            return "ROLE_NORMAL:" + " has A permission";
        }
    }
}
