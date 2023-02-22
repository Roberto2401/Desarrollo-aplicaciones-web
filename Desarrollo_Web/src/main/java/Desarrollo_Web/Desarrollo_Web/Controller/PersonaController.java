/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Desarrollo_Web.Desarrollo_Web.Controller;

import Desarrollo_Web.Desarrollo_Web.Entity.pais;
import Desarrollo_Web.Desarrollo_Web.Entity.persona;
import Desarrollo_Web.Desarrollo_Web.Service.IPaisService;
import Desarrollo_Web.Desarrollo_Web.Service.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Roberto
 */
@Controller
public class PersonaController {
    
    @Autowired
     private IPersonaService personaService;
    
    @Autowired
    private IPaisService paisService;
    
    @GetMapping("/persona")       
    public String index(Model model){
        List <persona> ListaPersona = personaService.getAllPersona();
        model.addAttribute("titulo","Tabla Persona");
        model.addAttribute("persona",ListaPersona);
        return "personas";
    }
    @GetMapping("/personaN") 
    public String CrearPersona(Model model){
        List<pais> ListaPaises= paisService.ListCountry();
         model.addAttribute("Persona", new persona());
         model.addAttribute("Paises",ListaPaises);
         return "Crear";
    }
    
    
}
