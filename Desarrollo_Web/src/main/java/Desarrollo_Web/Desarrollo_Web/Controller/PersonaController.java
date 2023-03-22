/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Desarrollo_Web.Desarrollo_Web.Controller;

import Desarrollo_Web.Desarrollo_Web.Entity.pais;
import Desarrollo_Web.Desarrollo_Web.Entity.persona;
import Desarrollo_Web.Desarrollo_Web.Service.IPaisService;
import Desarrollo_Web.Desarrollo_Web.Service.IPersonaService;
import Desarrollo_Web.Desarrollo_Web.Service.personaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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
    
    @Autowired
    private personaService personaService1;

    @GetMapping("/persona")
    public String index(Model model, String keyword) {
        List<persona> ListaPersona = personaService.getAllPersona();
        model.addAttribute("titulo", "Tabla Persona");
        model.addAttribute("persona", ListaPersona);
        if(keyword != null){
            model.addAttribute("persona", personaService1.findByKeyword(keyword));
        }else{
          model.addAttribute("persona", personaService.getAllPersona());
        }
        return "personas";
    }

    @GetMapping("/personaN")
    public String CrearPersona(Model model) {
        List<pais> ListaPaises = paisService.ListCountry();
        model.addAttribute("persona", new persona());
        model.addAttribute("Paises", ListaPaises);
        return "crear";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") long idpersona) {
        personaService.delete(idpersona);
        return "redirect:/persona";

    }

    @PostMapping("/save")
    public String guardarPersona(@ModelAttribute persona persona) {
        personaService.savePersona(persona);
        return "redirect:/persona";
    }

    @GetMapping("/editPersona/{id}")
    public String editarPersona(@PathVariable("id") Long idpersona, Model model) {
        persona persona = personaService.getPersonaById(idpersona);
        List<pais> ListaPaises = paisService.ListCountry();
        model.addAttribute("persona",persona);
        model.addAttribute("Paises", ListaPaises);
        return "Crear";
    }
}
