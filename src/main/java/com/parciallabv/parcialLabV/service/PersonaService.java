package com.parciallabv.parcialLabV.service;

import com.parciallabv.parcialLabV.model.Jugador;
import com.parciallabv.parcialLabV.model.Persona;
import com.parciallabv.parcialLabV.model.Representante;
import com.parciallabv.parcialLabV.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@Service
public class PersonaService {
    @Autowired
    private PersonRepository personRepository;

    public void addPersona(Persona persona) {
        personRepository.save(persona);
    }

    public Persona getPersona(Integer personId) {
        return personRepository.findById(personId).orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
    }

    public void addJugadorToRepresentante(Integer id, Integer idJugador) {
        Jugador jugador;
        Representante representante;
        jugador = (Jugador)getPersona(id);
        representante = (Representante)getPersona(id);
        representante.getJugadores().add(jugador);
        representante.actualizarPeso(jugador.getCurrency().getMonto());
        representante.actualizarMontoTotal(jugador.getCurrency().getMonto(),jugador.getCurrency().getCurrency());
        personRepository.save(representante);
    }

    public void deletePersona(Persona persona) {
        personRepository.delete(persona);
    }

    public List<Persona> getAll() {
        return personRepository.findAll();
    }
}
