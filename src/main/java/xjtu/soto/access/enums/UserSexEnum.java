package xjtu.soto.access.enums;

import lombok.Getter;

@Getter
public enum UserSexEnum implements CodeEnum {
    MAN(1,"男"),
    WOMAN(2,"女");

    private Integer code;
    private String information;

    UserSexEnum(Integer code, String information) {
        this.code = code;
        this.information = information;
    }
}
