package com.bridgelabz.addressbook;
import com.google.gson.stream.MalformedJsonException;
import util.Utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
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
   // List<Person> personList = new ArrayList<>();
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
        int isDetailsAvailable = 0;
        List<Person> personList = utility.readAllPersonsAddressList();
        for (Person editPerson : personList) {
            if (editPerson.getPhoneNumber().equals(mobileNo)) {
                editPerson.setFirstName(person.getFirstName());
                editPerson.setLastName(person.getLastName());
                editPerson.setPhoneNumber(person.getPhoneNumber());
                editPerson.setCity(person.getCity());
                editPerson.setZip(person.getZip());
                utility.writeIntoJsonFile(personList);
                isDetailsAvailable= 1;
                break;
            }
        }
        if (isDetailsAvailable== 1) {
            return true;
        } else
            return false;
    }
    @Override
    public boolean deletePerson(String mobileNumber) throws FileNotFoundException, CustomException {
        int isDetailsAvailable = 0;
        try {
            List<Person> personList = utility.readAllPersonsAddressList();
            for (Person person : personList) {
                if (person.getPhoneNumber().equals(mobileNumber)) {
                    personList.remove(person);
                    utility.writeIntoJsonFile(personList);
                     isDetailsAvailable= 1;
                    break;
                }
            }
            if (isDetailsAvailable == 1)
                return true;
            else{
                throw new CustomException("Problem is there while removing persondetails from AddressBook");
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomException("Problem is there while removing persondetails from AddressBook");
        }

    }
    @Override
    public List<Person> sortByLastName() throws IOException {
        List<Person> personList = utility.readAllPersonsAddressList();
        for(int i=0;i<personList.size()-1;i++){
            for(int j=0;j<personList.size()-i-1;j++){
                if(personList.get(j).getLastName().compareTo(personList.get(j+1).getLastName())>0){
                    Person tempObj=personList.get(j);
                    personList.set(j,personList.get(j+1));
                    personList.set(j+1,tempObj);
                }
            }
        }
        utility.writeIntoJsonFile(personList);
        return personList;
    }
    @Override
    public void readAllPersons() throws FileNotFoundException, MalformedJsonException {
        utility.readList();

    }
}


