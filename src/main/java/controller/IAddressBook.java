package controller;

import model.Person;

import java.io.FileNotFoundException;

public interface IAddressBook {

        boolean addPerson(Person person, String filePath) throws FileNotFoundException;
        public void readAllPersons()throws Exception;

}