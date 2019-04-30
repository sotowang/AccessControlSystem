package xjtu.soto.access.pojo;

import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Data
@Table(name = "third_locate", schema = "access", catalog = "")
public class ThirdLocateEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private Integer top;
    private String address;

    public ThirdLocateEntity(Integer top, String address) {
        this.top = top;
        this.address = address;
    }

    public ThirdLocateEntity() {
    }
}
