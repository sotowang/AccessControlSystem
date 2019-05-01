package xjtu.soto.access.pojo;

import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Data
@Table(name = "identity", schema = "access", catalog = "")
public class IdentityEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String role;

    public IdentityEntity(String role) {
        this.role = role;
    }

    public IdentityEntity() {
    }
}
