package xjtu.soto.access.enums;

import lombok.Getter;

@Getter
public enum UserPermissionEnum implements CodeEnum {


    ADMIN(1, "超级系统管理员"),
    STUDENT(2,"普通用户"),
    PRIVILEGE(3,"系统权限管理员"),
    SETTING(4,"考勤设置管理员"),
    ATTENDBALANCE(5,"考勤结算管理员"),
    SYSTEMLOG(6,"系统日志管理员"),
    CONFERENCE(7,"会议考勤管理员"),
    TEST(8, "测试用户"),
    GAOZHONG(9,"高中部门禁管理员");

    private Integer code;
    private String information;

    UserPermissionEnum(Integer code, String information) {
        this.code = code;
        this.information = information;
    }

}
