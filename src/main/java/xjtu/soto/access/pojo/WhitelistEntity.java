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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long wid;
    private String cardid;
    private Long locate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDate;


    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate;
    private Integer vip;

    @Transient
    private String locateName;

    public WhitelistEntity() {
    }


}
