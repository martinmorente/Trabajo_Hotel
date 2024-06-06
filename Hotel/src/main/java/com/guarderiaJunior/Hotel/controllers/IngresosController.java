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

import com.guarderiaJunior.Hotel.Clases.IngresosCaja;
import com.guarderiaJunior.Hotel.Models.ingresosRepository;

/**
 *
 * @author Ludmila
 */

@RestController
@RequestMapping("/api/ingresos_caja")
public class IngresosController {
    @Autowired
    private ingresosRepository ingresosRepository;

    @GetMapping
    public List<IngresosCaja> getAllIngresos_Caja() {
        return ingresosRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<IngresosCaja> getIngresos_CajaById(@PathVariable Long id) {
        Optional<IngresosCaja> ingresos = ingresosRepository.findById(id);
        return ingresos.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping /* Crear */
    public ResponseEntity<IngresosCaja> createIngresos_Caja(@RequestBody IngresosCaja ingresos) {
        IngresosCaja savedIngresos_Caja = ingresosRepository.save(ingresos);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedIngresos_Caja);
    }

    @DeleteMapping("/{id}") /* Borrar */
    public ResponseEntity<Void> deleteIngresos_Caja(@PathVariable Long id) {
        if (!ingresosRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        ingresosRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}") /* Actualizar */
    public ResponseEntity<IngresosCaja> updateIngresos_Caja(@PathVariable Long id,
            @RequestBody IngresosCaja updatedIngresos_Caja) {
        if (!ingresosRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        updatedIngresos_Caja.setId(id);
        IngresosCaja savedIngresos_Caja = ingresosRepository.save(updatedIngresos_Caja);
        return ResponseEntity.ok(savedIngresos_Caja);
    }

}
