/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Desarrollo_Web.Desarrollo_Web.Service;

import Desarrollo_Web.Desarrollo_Web.Entity.pais;
import Desarrollo_Web.Desarrollo_Web.Repository.PaisRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Roberto
 */
@Service
public class paisService implements IPaisService{
    
    @Autowired
private PaisRepository PaisRepository; 
    
    @Override
    public List<pais> ListCountry() {
        return(List<pais>)PaisRepository.findAll();}
    }

