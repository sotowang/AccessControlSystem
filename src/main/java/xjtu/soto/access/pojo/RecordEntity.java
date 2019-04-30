package xjtu.soto.access.pojo;

import lombok.Data;

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
    private Date time;
    private Integer type;
    private String name;

    public RecordEntity() {
    }

    public RecordEntity(String cardid, Date time, Integer type, String name) {
        this.cardid = cardid;
        this.time = time;
        this.type = type;
        this.name = name;
    }
}
