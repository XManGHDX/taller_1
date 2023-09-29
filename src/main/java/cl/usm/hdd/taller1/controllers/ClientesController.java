package cl.usm.hdd.taller1.controllers;

import cl.usm.hdd.taller1.entities.Cliente;
import cl.usm.hdd.taller1.services.ClientesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Stream;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/ClientesRepository")

public class ClientesController {
    @Autowired
    private ClientesService clientesService;

    private boolean esTipoValido(String estado) {

        String[] tiposEstado = {"Habilitado", "Con Deuda", "En Lista Negra"};
        return Stream.of(tiposEstado).anyMatch(e -> e.equalsIgnoreCase(estado));
    }
    @GetMapping("/mostrarClientes/{estado}")
    public ResponseEntity<List<Cliente>> filtrar(@PathVariable String tiposEstado){
        try {
            return ResponseEntity.ok(this.clientesService.filtrar(tiposEstado));
        }catch (Exception ex){
            return ResponseEntity.internalServerError().build();
        }
    }


    @GetMapping("/mostrarClientes")
    public ResponseEntity<List<Cliente>> obtener(){
        try {
            return ResponseEntity.ok(this.clientesService.obtener());
        }catch (Exception ex){
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping("/ingresarCliente")
    public ResponseEntity<Cliente> crear(@RequestBody Cliente cliente){
        if(!esTipoValido(cliente.getEstado())){
            return ResponseEntity.badRequest().build();
        }
        try {
            Cliente cliente1 = clientesService.crear(cliente);
            return ResponseEntity.ok(cliente1);
        }catch (Exception ex){
            return ResponseEntity.internalServerError().build();
        }
    }
}
