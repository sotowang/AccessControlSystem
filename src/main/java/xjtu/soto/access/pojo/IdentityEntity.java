package xjtu.soto.access.pojo;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Data
@Table(name = "identity", schema = "access", catalog = "")
public class IdentityEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty
    private String role;

    public IdentityEntity(String role) {
        this.role = role;
    }

    public IdentityEntity() {
    }
}
