package xjtu.soto.access.enums;

import lombok.Getter;

@Getter
public enum UserIdentityEnum implements CodeEnum {

    STUDENT(1, "学生"),
    TEACHER(2,"老师"),
    OTHERS(3,"其他"),;

    private Integer code;
    private String information;

    UserIdentityEnum(Integer code, String information) {
        this.code = code;
        this.information = information;
    }
}
