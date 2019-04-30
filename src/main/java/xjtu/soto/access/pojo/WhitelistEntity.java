package xjtu.soto.access.pojo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Data
@Table(name = "whitelist", schema = "access", catalog = "")
public class WhitelistEntity {
    @Id
    private Long wid;
    private String cardid;
    private String locate;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date startDate;


    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date endDate;
    private Integer vip;

    public WhitelistEntity() {
    }

    public WhitelistEntity(Long wid, String cardid, String locate, Date startDate, Date endDate, Integer vip) {
        this.wid = wid;
        this.cardid = cardid;
        this.locate = locate;
        this.startDate = startDate;
        this.endDate = endDate;
        this.vip = vip;
    }
}
