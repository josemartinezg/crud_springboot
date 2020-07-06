package com.pucmm.crud_springboot.entidades;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Usuario implements Serializable {
    @Id
    private String username;
    private String password;
    private boolean activo;
    private String nombre;
    private String email;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Rol> roles;

    public boolean isAdmin() {
        boolean isAdmin = false;
        for(Rol rol : this.roles) {
            if(rol.getRole().equals("ROLE_ADMIN")){
                isAdmin = true;
            }
        }
        return isAdmin;
    }
}
