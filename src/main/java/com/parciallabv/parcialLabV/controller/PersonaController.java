package com.parciallabv.parcialLabV.controller;

import com.parciallabv.parcialLabV.model.Persona;
import com.parciallabv.parcialLabV.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonaController {
    @Autowired
    private PersonaService personaService;

    @PostMapping("")
    public void addPersona(@RequestBody Persona persona)
    {
        personaService.addPersona(persona);
    }

    @GetMapping("/{id}")
    public void getPersona(@PathVariable Integer personId)
    {
        personaService.getPersona(personId);
    }

    @GetMapping("")
    public List<Persona> getAll() {
        return personaService.getAll();

    }

    @PutMapping("/{id}/jugadores/{idJugador}")
    public void addJugadorToRepresentante(@PathVariable Integer id, @PathVariable Integer idJugador)
    {
        personaService.addJugadorToRepresentante(id,idJugador);
    }
    @DeleteMapping("")
    public void deletePersona(@RequestBody Persona persona)
    {
        personaService.deletePersona(persona);
    }


}
