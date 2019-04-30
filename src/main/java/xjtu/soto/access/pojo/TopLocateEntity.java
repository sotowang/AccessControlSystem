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
    private Long id;
    private String address;
    private Long top;
    private Long down;

    public TopLocateEntity(String address) {
        this.address = address;
    }

    public TopLocateEntity() {
    }
}
