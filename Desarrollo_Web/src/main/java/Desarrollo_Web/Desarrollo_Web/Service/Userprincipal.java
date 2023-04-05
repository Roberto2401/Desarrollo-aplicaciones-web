/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Desarrollo_Web.Desarrollo_Web.Service;

import Desarrollo_Web.Desarrollo_Web.Entity.persona;
import java.util.Collection;
import java.util.List;
import java.util.ArrayList;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author Roberto
 */
public class Userprincipal implements UserDetails {
    private persona persona;

    public Userprincipal(persona persona) {
        this.persona = persona;
    }
    

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        
         this.persona.gePermissionList().forEach(p ->{
        GrantedAuthority authority= new SimpleGrantedAuthority(p);
        authorities.add(authority);
    });
           this.persona.getRoleList().forEach(r ->{
        GrantedAuthority authority= new SimpleGrantedAuthority("ROLE_" + r);
        authorities.add(authority);
    });
    return authorities;
    }

    @Override
    public String getPassword() {
       return this.persona.getPassword();
    }

    @Override
    public String getUsername() {
        return this.persona.getNombre();
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
       return this.persona.getActive()==1;
    }
    
}
