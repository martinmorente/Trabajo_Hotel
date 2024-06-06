/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.guarderiaJunior.Hotel.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guarderiaJunior.Hotel.Clases.Habitaciones;
import com.guarderiaJunior.Hotel.Models.habitacionesRepository;

/**
 *
 * @author Coral
 */
@RestController
@RequestMapping("/api/habitaciones")
public class HabitacionesController {

    @Autowired
    private habitacionesRepository habitacionesRepository;

    @GetMapping
    public List<Habitaciones> getAllHabitaciones() {
        return habitacionesRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Habitaciones> getHabitacionesById(@PathVariable Long id) {
        Optional<Habitaciones> habitaciones = habitacionesRepository.findById(id);
        return habitaciones.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Habitaciones> createHabitaciones(@RequestBody Habitaciones habitaciones) {
        Habitaciones savedHabitaciones = habitacionesRepository.save(habitaciones);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedHabitaciones);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHabitaciones(@PathVariable Long id) {
        if (!habitacionesRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        habitacionesRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Habitaciones> updateHabitaciones(@PathVariable Long id,
            @RequestBody Habitaciones updatedHabitaciones) {
        if (!habitacionesRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        updatedHabitaciones.setIdHabitacion(id);
        Habitaciones savedHabitaciones = habitacionesRepository.save(updatedHabitaciones);
        return ResponseEntity.ok(savedHabitaciones);
    }
}
