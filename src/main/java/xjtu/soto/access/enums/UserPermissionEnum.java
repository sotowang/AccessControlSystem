package xjtu.soto.access.enums;

import lombok.Getter;

@Getter
public enum UserPermissionEnum implements CodeEnum {


    ADMIN(1, "管理员"),
    USER(2,"普通用户"),;

    private Integer code;
    private String information;

    UserPermissionEnum(Integer code, String information) {
        this.code = code;
        this.information = information;
    }

}
