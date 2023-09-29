package cl.usm.hdd.taller1.repositories;

import cl.usm.hdd.taller1.entities.Cliente;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClientesRepository extends MongoRepository <Cliente, String>{
}
