package xjtu.soto.access.pojo;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Data
@Table(name = "department", schema = "access", catalog = "")
public class DepartmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotEmpty
    private String name;


    public DepartmentEntity(String name) {
        this.name = name;
    }

    public DepartmentEntity() {
    }
}
