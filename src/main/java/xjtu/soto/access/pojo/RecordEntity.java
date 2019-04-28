package xjtu.soto.access.pojo;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;
@Data
@Entity
@Table(name = "record", schema = "access", catalog = "")
public class RecordEntity {
    @Id
    private int recordId;
    private Long fid;
    private String cardid;
    private Timestamp time;
    private Integer type;


}
