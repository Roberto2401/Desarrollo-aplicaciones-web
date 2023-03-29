/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Desarrollo_Web.Desarrollo_Web.Service;

import Desarrollo_Web.Desarrollo_Web.Entity.persona;
import java.util.List;

/**
 *
 * @author Roberto
 */
public interface IPersonaService {

    public List<persona> getAllPersona();

    public persona getPersonaById(Long Id);

    public void savePersona(persona persona);

    public void delete(long Id);

    public persona findByNombre(String username);
}
