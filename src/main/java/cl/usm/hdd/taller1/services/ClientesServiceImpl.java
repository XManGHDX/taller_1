package cl.usm.hdd.taller1.services;

import cl.usm.hdd.taller1.entities.Cliente;
import cl.usm.hdd.taller1.repositories.ClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientesServiceImpl  implements ClientesService{
    @Autowired
    private ClientesRepository clienRepo;
    private static List<Cliente> clientes = new ArrayList<>();

    @Override
    public Cliente crear(Cliente cliente) {
        clientes.add(cliente);
        return cliente;
    }

    @Override
    public List<Cliente> obtener() {
        return clientes;
    }

    @Override
    public List<Cliente> filtrar(String estado) {
        return clientes.stream().filter(c -> c.getEstado()
                        .equalsIgnoreCase(estado))
                .collect(Collectors.toList());
    }
}
