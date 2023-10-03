package com.javiermorales.apirest.Persona;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/persona")
@RequiredArgsConstructor
public class personController {
    
    private final PersonService personService;

    @PostMapping("/create")
    public void createPersona(@RequestBody Person person){
        personService.createPersona(person);
    }

    @GetMapping("/users")
    public List<Person> getAllUsers(){
       return personService.getAllPersonas();
    }


    @GetMapping("/user/{id}")
    public Optional<Person> getPersonById(@PathVariable Integer id){
        return personService.getPersonById(id);
    }

    @PutMapping("/modify/{id}")
    public void editPerson(@RequestBody Person person, @PathVariable Integer id){
        personService.editPersona(id, person);
    }

    @DeleteMapping("/delete/{id}")
    public void deletePerson(@PathVariable Integer id){
        personService.borrarPersona(id);
    }
}
