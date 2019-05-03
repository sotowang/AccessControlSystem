package xjtu.soto.access.pojo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "record", schema = "access", catalog = "")
public class RecordEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long recordId;
    private Long fid;
    private String cardid;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date time;
    //出入标志
    private Integer type;
    private String name;
    private Long role;
    private Long department;
    private Long locate;

}
