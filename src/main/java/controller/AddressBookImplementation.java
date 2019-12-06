package controller;
import com.google.gson.stream.MalformedJsonException;
import model.Person;
import util.Utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

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
    public void readAllPersons() throws FileNotFoundException, MalformedJsonException {
        utility.readList();

    }
}


