package dress_up_studio_be.Users.Models;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class UserPrincipal implements UserDetails {

    private final UserDocument userDocument;
    public UserPrincipal(UserDocument userDocument) {
        this.userDocument = userDocument;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (userDocument.getRole().equals(Role.ADMIN)) {
            return Collections.singleton(new SimpleGrantedAuthority("ADMIN"));
        }
        if (userDocument.getRole().equals(Role.USER)) {
            return Collections.singleton(new SimpleGrantedAuthority("USER"));
        }
        if (userDocument.getRole().equals(Role.MAINTENANCE)) {
            return Collections.singleton(new SimpleGrantedAuthority("MAINTENANCE"));
        }
        return Collections.emptyList();
    }

    @Override
    public String getPassword() {
        return userDocument.getPassword();
    }

    @Override
    public String getUsername() {
        return userDocument.getEmail();
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
