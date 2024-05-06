
package com.guarderiaJunior.Models;

import com.guarderiaJunior.Clases.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface clienteRepository extends JpaRepository<Clientes,Long> {} // Esto <> es el operador diamond y nos sirve para especificarle el tipo de donde vamos a hacer el repositorio y el tipo de id 
