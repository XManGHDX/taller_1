package cl.usm.hdd.taller1.entities;


import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "clientes")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class Cliente {
    private String nombre;
    private String apellido;
    private String rut;
    private int numSerie;
    private String estado;
}
