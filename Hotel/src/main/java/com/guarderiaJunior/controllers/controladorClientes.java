
package com.guarderiaJunior.controllers;

import com.guarderiaJunior.Clases.Clientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.guarderiaJunior.Models.clienteRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/Clientes")
public class controladorClientes {
    
    @Autowired /*Esto nos sirve para evitar usos de punteros this nota: Se pone el repositorio en el que guardas la información*/
    private clienteRepository clienteRepository;
    
    
    @GetMapping
     public List<Clientes>getAllHotels(){
         return clienteRepository.findAll();
     }
    
     @GetMapping("/{id}")
     public ResponseEntity<Clientes> getHotelById(@PathVariable Long id){/*Si nosotros queremos referenciar al id que tenemos en la linea 25 tendremos que hacer anotaciones*/
         Optional<Clientes> cliente = clienteRepository.findById(id);
         return cliente.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
     }
     
     
     
     
     
     
     
}
