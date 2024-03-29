package com.gustavobussolotti.personapi.service;

import com.gustavobussolotti.personapi.dto.request.PersonDTO;
import com.gustavobussolotti.personapi.dto.response.MessageResponseDTO;
import com.gustavobussolotti.personapi.entity.Person;
import com.gustavobussolotti.personapi.exception.PersonNotFoundException;
import com.gustavobussolotti.personapi.mapper.PersonMapper;
import com.gustavobussolotti.personapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService {

    private PersonRepository personRepository;
    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public MessageResponseDTO createPerson(PersonDTO personDTO){
        Person personToSave = personMapper.toModel(personDTO);
        Person savedPerson = personRepository.save(personToSave);
        return createMessageResponse("Created person with ID "+savedPerson.getId());
    }



    public List<PersonDTO> listAll(){
        List<Person> allPeople = personRepository.findAll();
        return allPeople.stream()
                .map(personMapper::toDTO)
                .collect(Collectors.toList());
    }

    public PersonDTO findById(Long id) throws PersonNotFoundException {
        //Optional<Person> optionalPerson = personRepository.findById(id);
        //if(optionalPerson.isEmpty()){
        //    throw new PersonNotFoundException(id);
        //}
        //return personMapper.toDTO(optionalPerson.get());
        Person person = verifyIfExists(id);
        return personMapper.toDTO(person);
    }

    public void deleteById(Long id) throws PersonNotFoundException {
       verifyIfExists(id);
        personRepository.deleteById(id);
    }


    public MessageResponseDTO updateById(Long id, PersonDTO personDTO) throws PersonNotFoundException {
        verifyIfExists(id);

        Person personToUpdate = personMapper.toModel(personDTO);
        Person savedPerson = personRepository.save(personToUpdate);
        return createMessageResponse("Updated person with ID "+savedPerson.getId());
    }

    private Person verifyIfExists(Long id) throws PersonNotFoundException {
        Person person = personRepository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException(id));
        return person;
    }

    private MessageResponseDTO createMessageResponse(String message) {
        return MessageResponseDTO.builder()
                .message(message)
                .build();
    }
}
