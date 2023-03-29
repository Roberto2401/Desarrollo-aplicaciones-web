/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Desarrollo_Web.Desarrollo_Web.Repository;

import Desarrollo_Web.Desarrollo_Web.Entity.pais;
import Desarrollo_Web.Desarrollo_Web.Entity.persona;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Roberto
 */
@Repository
public interface PersonaRepository extends CrudRepository<persona,Long> {
    persona findByNombre(String nombre);
    
   @Query(value="select * from personas e where e.apellido1 like %:keyword% or e.apellido2 like %:keyword%", nativeQuery =true)
    List<persona> findByKeyword(@Param("keyword") String keyword);
    
    
    
}
