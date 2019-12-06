package com.bridgelabz.addressbook;
import com.google.gson.stream.MalformedJsonException;
import util.Utility;

import java.io.FileNotFoundException;
import java.util.List;

public class AddressBookImplementation implements IAddressBook {

    Utility utility;
    {
        try {
            utility = new Utility();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    @Override
    public boolean addPerson(Person person, String filePath) {

        try {
            utility.writeIntoJsonFile(person);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return true;
    }
    @Override
    public boolean editPerson(Person person, String mobileNo) throws FileNotFoundException {
        int isAvailable = 0;
        List<Person> personList = utility.readAllPersonsAddressList();
        for (Person editPerson : personList) {
            if (editPerson.getPhoneNumber().equals(mobileNo)) {
                editPerson.setFirstName(person.getFirstName());
                editPerson.setLastName(person.getLastName());
                editPerson.setPhoneNumber(person.getPhoneNumber());
                editPerson.setCity(person.getCity());
                editPerson.setZip(person.getZip());
                utility.writeIntoJsonFile(personList);
                isAvailable= 1;
                break;
            }
        }
        if (isAvailable== 1) {
            return true;
        } else
            return false;
    }

    @Override
    public void readAllPersons() throws FileNotFoundException, MalformedJsonException {
        utility.readList();

    }
}


