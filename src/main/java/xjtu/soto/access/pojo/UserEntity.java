package xjtu.soto.access.pojo;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "user", schema = "access")
public class UserEntity implements UserDetails {
    @Id
    private String cardid;

    private Date time;
    private String name;

    private Integer sex;
    private Integer status;
    private Long permission;
    private Long department;
    private Long identity;

    private String password;

    @Transient
    private String departmentName;

    @Transient
    private String roleName;

    @Transient
    @ManyToMany(cascade = {CascadeType.REFRESH},fetch = FetchType.EAGER)
    private List<PermissionEntity> authorities;



    @Override
    //需要将List<PermissionEntity>转成List<SimpleGramtedAuthority>，否则前端拿不到角色列表名称
    public Collection<? extends GrantedAuthority> getAuthorities() {

        List<GrantedAuthority> auths = new ArrayList<>();
        List<PermissionEntity> roles = this.authorities;
//        for (PermissionEntity role : roles) {
//            auths.add(new SimpleGrantedAuthority(role.getName()));
//        }

        return auths;
    }

    @Override
    public String getUsername() {
        return this.cardid;
    }

    public void setAuthorities(List<PermissionEntity> authorities) {
        this.authorities = authorities;
    }



    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
