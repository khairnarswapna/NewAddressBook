package com.bridgelabz.addressbook;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface IAddressBook {

        boolean addPerson(Person person, String filePath) throws FileNotFoundException;
        boolean editPerson(Person person, String mobileNumber) throws FileNotFoundException;
        boolean deletePerson(String mobileNumber) throws FileNotFoundException, CustomException;
        List<Person> sortByLastName() throws IOException;
        public void readAllPersons()throws Exception;

}