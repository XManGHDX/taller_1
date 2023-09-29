package cl.usm.hdd.taller1.services;

import cl.usm.hdd.taller1.entities.Cliente;

import java.util.List;

public interface ClientesService {
    Cliente crear(Cliente cliente);
    List<Cliente> obtener();

    List<Cliente> filtrar(String estado);
}
