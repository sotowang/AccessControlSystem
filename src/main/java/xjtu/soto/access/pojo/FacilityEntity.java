package xjtu.soto.access.pojo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;
import java.util.Objects;

@Entity
@Data
@Table(name = "facility", schema = "access", catalog = "")
public class FacilityEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long fid;

    //权限
    private Integer permission;

    //所在地：三级工作区
    private Long locate;

    //类型：单进单出，双进出
    private Integer type;
    //状态：1。关闭 2。开放
    private Integer status;

    //开放时间
    @DateTimeFormat(pattern = "HH:mm:ss")
    private Date startTime;

    @DateTimeFormat(pattern = "HH:mm:ss")
    private Date endTime;
    private String ipAddr;
    private String serverIp;
    private String name;

    //该字段不映射，表中不存在
    @Transient
    private String address;


}
