package com.guarderiaJunior.controllers;

import com.guarderiaJunior.Clases.Clientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.guarderiaJunior.Models.clienteRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author Martin
 */
@RestController
@RequestMapping("/api/Clientes")
public class ClientesController {

    @Autowired
    /*Esto nos sirve para evitar usos de punteros this nota: Se pone el repositorio en el que guardas la información*/
    private clienteRepository clienteRepository;

    @GetMapping
    public List<Clientes> getAllHotels() {
        return clienteRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Clientes> getHotelById(@PathVariable Long id) {/*Si nosotros queremos referenciar al id que tenemos en la linea 25 tendremos que hacer anotaciones*/
        Optional<Clientes> cliente = clienteRepository.findById(id);
        return cliente.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    /*Insertar*/
    public ResponseEntity<Clientes> createCliente(@RequestBody Clientes cliente) {
        Clientes savedCliente = clienteRepository.save(cliente);
        /*Variable para retornarla después*/
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCliente);/* Para nosotros decirle que nos guarde el codigo del valor en 201 tendremos que hacer la variable HTTPStatus.CREATED */
    }

    /* Para devolverle el cuerpo de la respuesta haremos .body((metodo que creamos antes))  */
    @DeleteMapping("/{id}")/*Eliminar*/
    public ResponseEntity<Void> deleteClientes(@PathVariable Long id) {/*Cuando borramos un elemento tendremos que decirle que nos devuelva nada ya que estamos borrando y si sale exitosa no deberíamos devolver nada*/
        if (!clienteRepository.existsById(id)) {/*Comprobamos si existe el id introducido (este patrón es el mas eficiente. Se llama patrón guarda)*/ /*Siempre que el id venga de una uri tendremos que poner @PathVariable*/
            return ResponseEntity.notFound().build();/*Le tiramos la respuesta 404*/
        }
        clienteRepository.deleteById(id);/*Método para borrar un dato*/
        return ResponseEntity.noContent().build();/*Mensaje para comunicarle al usuario que se borró correctamente*/
    }

    /*Actualizar*/
    @PutMapping("/{id}")
    public ResponseEntity<Clientes> updateCliente(@PathVariable Long id, @RequestBody Clientes updatedCliente) {
        if (!clienteRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        updatedCliente.setId(id);/*Le ponemos un id al objeto de actualizar*/
        Clientes savedCliente = clienteRepository.save(updatedCliente);/*Aqui guardamos la variable en el repositorio*/
        return ResponseEntity.ok(savedCliente);/*Retornamos el mensaje de respuesta que nos devuelve el ok*/
    }

}
