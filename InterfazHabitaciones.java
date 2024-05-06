/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.guarderiaJunior.Hotel;

import com.guarderiaJunior.Clases.Habitaciones;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Jose Antonio
 */
public interface InterfazHabitaciones extends JpaRepository<Habitaciones, Long>{}
