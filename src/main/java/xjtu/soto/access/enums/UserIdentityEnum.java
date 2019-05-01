package xjtu.soto.access.enums;

import lombok.Getter;

@Getter
public enum UserIdentityEnum implements CodeEnum {

    STUDENT(1, "工程硕士"),
    TEACHER(2,"高中生"),
    QUJIANG(4,"曲江校区临时人员"),
    OTHERS(3,"其他"),







    ;

    private Integer code;
    private String information;

    UserIdentityEnum(Integer code, String information) {
        this.code = code;
        this.information = information;
    }
}
