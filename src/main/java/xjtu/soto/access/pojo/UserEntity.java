package xjtu.soto.access.pojo;

import lombok.Data;
import xjtu.soto.access.enums.UserIdentityEnum;
import xjtu.soto.access.enums.UserPermissionEnum;
import xjtu.soto.access.enums.UserStatusEnum;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
@Data
@Entity
@Table(name = "user", schema = "access")
public class UserEntity {
    @Id
    private String cardid;

    private String time;
    private String name;

    private Integer sex;
    private Integer status;
    private Integer permission;
    private String department;
    private Integer identity;

    private String password;

    public UserEntity() {
    }

    public UserEntity(String cardid, String name, Integer sex, String department, String password) {
        this.time = String.valueOf(new Date().getTime());
        this.cardid = cardid;
        this.name = name;
        this.sex = sex;
        this.department = department;
        this.password = password;
        this.permission = UserPermissionEnum.STUDENT.getCode();
        this.identity = UserIdentityEnum.STUDENT.getCode();
        this.status = UserStatusEnum.NORMAL.getCode();
    }


    @Override
    public String toString() {
        return "UserEntity{" +
                "time=" + time +
                ", cardid='" + cardid + '\'' +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", status=" + status +
                ", permission=" + permission +
                ", department='" + department + '\'' +
                ", identity=" + identity +
                ", password='" + password + '\'' +
                '}';
    }
}
