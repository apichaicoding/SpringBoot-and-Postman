package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.example.demo.dao.PersonDao;
import com.example.demo.model.Person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    private final PersonDao personDao;

    @Autowired
    public PersonService(@Qualifier("fakeDao") PersonDao personDao) {
        this.personDao = personDao;

    }

    public int addPerson(Person person) {
        return personDao.insertPerson(person);
    }

    public List<Person> selectAllpeople(){
        return personDao.selectAllpeople();
    }

    public Optional<Person> getPersonById(UUID id){
        return personDao.selectPersonById(id);
    }

    public int deletPerson(UUID id){
        return personDao.delectePersonById(id);
    }

    public int updatePersonById(UUID id,Person newPerson){
        return personDao.updatePersonById(id,newPerson);
    }
}
