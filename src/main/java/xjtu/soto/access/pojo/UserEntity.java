package xjtu.soto.access.pojo;

import lombok.Data;
import xjtu.soto.access.enums.UserIdentityEnum;
import xjtu.soto.access.enums.UserPermissionEnum;
import xjtu.soto.access.enums.UserStatusEnum;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Date;
@Data
@Entity
@Table(name = "user", schema = "access")
public class UserEntity {
    @Id
    private String cardid;

    private Date time;
    private String name;

    private Integer sex;
    private Integer status;
    private Integer permission;
    private Long department;
    private Long identity;

    private String password;

    @Transient
    private String departmentName;

    @Transient
    private String roleName;

    public UserEntity() {
    }

    public UserEntity(String cardid, String name, Integer sex, Long department, String password) {
        this.time = new Date();

        this.cardid = cardid;
        this.name = name;
        this.sex = sex;
        this.department = department;
        this.password = password;
        this.permission = UserPermissionEnum.STUDENT.getCode();
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
