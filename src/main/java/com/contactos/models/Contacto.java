
package com.contactos.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Contacto {

    @Id
    private String id;
    private String nombre;

    private String codigo;
    @Indexed(name="email",unique = true)
    private String email;
    private String celular;

    public Contacto() {
    }

    public Contacto(String nombre, String codigo, String email, String celular) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.email = email;
        this.celular = celular;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }


}
