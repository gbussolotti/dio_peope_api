package com.gustavobussolotti.personapi.controller;

import com.gustavobussolotti.personapi.dto.request.PersonDTO;
import com.gustavobussolotti.personapi.dto.response.MessageResponseDTO;
import com.gustavobussolotti.personapi.exception.PersonNotFoundException;
import com.gustavobussolotti.personapi.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/people")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonController {

    private final PersonService personService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) //return 201
    public MessageResponseDTO createPerson(@Valid @RequestBody PersonDTO personDTO){
        return personService.createPerson(personDTO);
    }

    @GetMapping
    public List<PersonDTO> listAll(){
        return personService.listAll();
    }

    @GetMapping("/{id}")
    public PersonDTO findById(@PathVariable Long id) throws PersonNotFoundException {
        return personService.findById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) throws PersonNotFoundException {
        personService.deleteById(id);
    }

    @PutMapping("/{id}")
    public MessageResponseDTO updateByID(@PathVariable Long id,@Valid @RequestBody PersonDTO personDTO) throws PersonNotFoundException{
        return personService.updateById(id, personDTO );
    }
}
