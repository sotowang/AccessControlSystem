package xjtu.soto.access.pojo;

import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Data
@Table(name = "second_locate", schema = "access", catalog = "")
public class SecondLocateEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long top;
    private Long down;
    private String address;

    public SecondLocateEntity() {
    }

    public SecondLocateEntity(Long top, String address) {
        this.top = top;
        this.address = address;
    }
}
