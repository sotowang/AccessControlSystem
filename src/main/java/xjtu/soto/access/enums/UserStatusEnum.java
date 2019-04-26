package xjtu.soto.access.enums;

import lombok.Getter;

@Getter
public enum  UserStatusEnum implements CodeEnum {
    NORMAL(1,"正常"),
    ABNORMAL(2,"异常"),;
    private Integer code;
    private String information;

    UserStatusEnum(Integer code, String information) {
        this.code = code;
        this.information = information;
    }
}
