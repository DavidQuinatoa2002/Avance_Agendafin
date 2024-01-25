
package com.contactos.services;


import com.contactos.models.Contacto;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactoRepository extends MongoRepository<Contacto,String> {

    public Contacto findByNombre(String nombre);
    public Contacto findByEmail(String email);
    public Contacto findByCodigo(String codigo);

    public Contacto findByCelular(String celular);


}

