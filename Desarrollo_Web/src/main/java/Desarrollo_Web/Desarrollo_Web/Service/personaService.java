/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Desarrollo_Web.Desarrollo_Web.Service;

import Desarrollo_Web.Desarrollo_Web.Entity.persona;
import Desarrollo_Web.Desarrollo_Web.Repository.PersonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Roberto
 */

@Service
public class personaService implements IPersonaService{

    @Autowired
    private PersonaRepository personaRepository;
    
    @Override
    public List<persona> getAllPersona() {
       return(List<persona>)personaRepository.findAll();
    }

    @Override
    public persona getPersonaById(Long Id) {
        return personaRepository.findById(Id).orElse(null);
    }

    @Override
    public void savePersona(persona persona) {
        personaRepository.save(persona);
    }

    @Override
    public void delete(long Id) {
      personaRepository.deleteById(Id);
    }
    public List<persona> findByKeyword(String keyword){
        return personaRepository.findByKeyword(keyword);
    }

    @Override
    public persona findByNombre(String username) {
      return  personaRepository.findByNombre(username);
    }
    
}
