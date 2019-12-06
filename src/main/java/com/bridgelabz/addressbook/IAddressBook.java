package com.bridgelabz.addressbook;

import java.io.FileNotFoundException;

public interface IAddressBook {

        boolean addPerson(Person person, String filePath) throws FileNotFoundException;
        boolean editPerson(Person person, String mobileNumber) throws FileNotFoundException;
        boolean deletePerson(String mobileNumber) throws FileNotFoundException, CustomException;
        public void readAllPersons()throws Exception;

}