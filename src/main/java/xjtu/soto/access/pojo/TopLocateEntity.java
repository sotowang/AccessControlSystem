package xjtu.soto.access.pojo;

import lombok.Data;

import javax.persistence.*;
import java.util.Objects;
@Data
@Entity
@Table(name = "top_locate", schema = "access", catalog = "")
public class TopLocateEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String address;
    private Integer top;
    private Integer down;

    public TopLocateEntity(String address, Integer top) {
        this.address = address;
        this.top = top;
    }

    public TopLocateEntity() {
    }
}
