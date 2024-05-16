package com.guarderiaJunior.controllers;

import com.guarderiaJunior.Clases.Clientes;
import com.guarderiaJunior.Clases.Reservas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.guarderiaJunior.Models.reservaRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;


/**
 *
 * @author Jose Antonio
 */
@RestController
@RequestMapping("/api/Reserva")
public class ReservaController {
     @Autowired /*Esto nos sirve para evitar usos de punteros this nota: Se pone el repositorio en el que guardas la información*/
    private reservaRepository reservaRepository;
    
    
    @GetMapping
     public List<Reservas>getAllHotels(){
         return reservaRepository.findAll();
     }
    
     @GetMapping("/{id}")
     public ResponseEntity<Reservas> getHotelById(@PathVariable Long id){/*Si nosotros queremos referenciar al id que tenemos en la linea 25 tendremos que hacer anotaciones*/
         Optional<Reservas> reserva = reservaRepository.findById(id);
         return reserva.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
     }
}
