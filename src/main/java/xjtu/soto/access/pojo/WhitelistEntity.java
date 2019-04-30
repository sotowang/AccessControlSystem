package xjtu.soto.access.pojo;

import lombok.Data;

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
    private Date startDate;
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
