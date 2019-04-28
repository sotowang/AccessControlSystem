package xjtu.soto.access.pojo;

import lombok.Data;

import javax.persistence.*;
import java.sql.Time;
import java.util.Objects;

@Entity
@Data
@Table(name = "facility", schema = "access", catalog = "")
public class FacilityEntity {

    @Id
    private long fid;
    private Integer permission;
    private String locate;
    private Integer type;
    private Integer status;
    private String startTime;
    private String endTime;
    private String ipAddr;
    private String serverIp;


}
