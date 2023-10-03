package com.javiermorales.apirest.Persona;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PersonService {
    
    private final PersonRepository personRepo;

    public void createPersona(Person person){
        personRepo.save(person);
    }

    public List<Person> getAllPersonas(){
      return personRepo.findAll();
    }

    public Optional<Person> getPersonById(Integer id){
        return personRepo.findById(id);
    }


    public void editPersona(Integer id, Person nuevaPersona){
         Optional<Person> personaExistente = personRepo.findById(id);

         if(personaExistente.isPresent()){
            Person persona = personaExistente.get();
            persona.setFirstName(nuevaPersona.getFirstName());
            persona.setLastName(nuevaPersona.getLastName());
            persona.setEmail(nuevaPersona.getEmail());

            personRepo.save(persona);
         }
    }

    public void borrarPersona(Integer id){
        personRepo.deleteById(id);
    }

}
