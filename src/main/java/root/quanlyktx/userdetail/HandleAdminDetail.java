package root.quanlyktx.userdetail;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import root.quanlyktx.entity.Admin;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class HandleAdminDetail implements UserDetails {
    private static final long serialVersionUID = 1L;
    private Admin admin;
    private Collection<? extends GrantedAuthority> authorities;



    public HandleAdminDetail(Admin admin, Collection<? extends GrantedAuthority> authorities
    ) {
        this.admin = admin;
        this.authorities=authorities;
    }
//    public static HandleUserDetail build(User user) {
//        List<GrantedAuthority> authorities= new ArrayList<>();
//        if(user.getRole()==4)
//            authorities.add(new SimpleGrantedAuthority("student"));
//        else if(user.getRole()==3)
//            authorities.add(new SimpleGrantedAuthority("admin"));
//
//
//        return new HandleUserDetail(user, authorities);
//    }
    public static HandleAdminDetail build(Admin admin) {
        List<GrantedAuthority> authorities= new ArrayList<>();

        authorities.add(new SimpleGrantedAuthority(admin.getRole().getRoleName()));
        return new HandleAdminDetail(admin, authorities);
    }
    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
    }
    @Override
    public Collection<? extends GrantedAuthority>  getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return admin.getPassword();
    }

    @Override
    public String getUsername() {
        return admin.getUsername();
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
