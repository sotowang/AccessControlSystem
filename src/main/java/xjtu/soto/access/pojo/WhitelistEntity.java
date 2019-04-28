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
    private int wid;
    private String cardid;
    private String locate;
    private Date startDate;
    private Date endDate;
    private Integer vip;
}
