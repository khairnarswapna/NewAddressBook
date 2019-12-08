package com.bridgelabz.addressbook;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface IAddressBook {

        boolean addPerson(Person person, String filePath) throws FileNotFoundException;
        boolean editPerson(Person person, String mobileNumber) throws FileNotFoundException;
        boolean deletePerson(String mobileNumber) throws FileNotFoundException, CustomException;
        boolean printAllRecord() throws IOException;
        boolean createNewAddressBook(String fileName) throws CustomException;
        boolean openExistingAddressBook(String fileName) throws CustomException;
        boolean saveAddressBook(String fileName);
        boolean saveAs(String oldName, String newName);
        List<Person> sortByLastName() throws IOException;
        List<Person> sortByZip() throws IOException;
        public void readAllPersons()throws Exception;

}