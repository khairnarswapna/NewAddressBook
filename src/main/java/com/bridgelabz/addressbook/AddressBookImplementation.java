package com.bridgelabz.addressbook;
import com.google.gson.stream.MalformedJsonException;
import util.Utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AddressBookImplementation implements IAddressBook {

    public static final String resourceFilePath="/home/admin142/eclipse-workspace/AddressBook2/src/main/resources/";
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
        int isDetailsAvailable = 0;
        List<Person> personList = utility.readAllPersonsAddressList();
        for (Person editPerson : personList) {
            if (editPerson.getPhoneNumber().equals(mobileNo)) {
                editPerson.setFirstName(person.getFirstName());
                editPerson.setLastName(person.getLastName());
                editPerson.setPhoneNumber(person.getPhoneNumber());
                editPerson.setAddress(person.getAddress());
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
                throw new CustomException(CustomException.ExceptionType.PERSON_NOT_FOUND,"person record not found");
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomException(CustomException.ExceptionType.PERSON_NOT_FOUND,"person record not found");
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
    public List<Person> sortByZip() throws IOException {
        List<Person> personList = utility.readAllPersonsAddressList();
        for(int i=0;i<personList.size()-1;i++){
            for(int j=0;j<personList.size()-i-1;j++){
                if(personList.get(j).getZip()<personList.get(j+1).getZip()){
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
    public boolean printAllRecord() throws IOException {
        List<Person> personList = utility.readAllPersonsAddressList();
        for (Person person : personList) {
            System.out.println("First Name:- "+person.getFirstName()+" Last Name:- "+person.getLastName());
            System.out.println("Phone Number:"+person.getPhoneNumber());
            System.out.println("Address:- "+person.getAddress());
            System.out.println("City:- "+person.getCity()+" State:- "+person.getState());
            System.out.println("Zip code:- "+person.getZip());
            System.out.println();
        }
        return true;
    }
    @Override
    public boolean createNewAddressBook(String fileName) throws CustomException {
        try {
            File file = new File(resourceFilePath + fileName + ".json");
            if (fileName.length() == 0) {
                throw new CustomException("File cannot be empty");

            } else if (file.createNewFile())
                return true;
            else
                throw new CustomException("File Cannot be created");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    @Override
    public boolean openExistingAddressBook(String fileName) {

        File file = new File(resourceFilePath + fileName);
        if (file.exists()) {
             Utility.readingAddressBook(resourceFilePath + fileName);
            return true;
        }
        throw new CustomException(CustomException.ExceptionType.ADDRESSBOOK_DOESNOT_EXIST, "given name addressbook does not exist");

    }
    @Override
    public boolean saveAddressBook(String fileName) {
        List<Person> personList = Utility.getSavedRecord();
        boolean IsSaveRecord = Utility.SavedIntoAddressBook(fileName, personList);
        if (IsSaveRecord)
            return true;
        else
            throw new CustomException(CustomException.ExceptionType.DADA_NOT_SAVED, "data not saved");

    }
    @Override
    public boolean saveAs(String oldName, String newName)
    {
        File oldFile = new File(resourceFilePath + oldName);
        if (oldFile.exists()) {
            File newFileName = new File(resourceFilePath + newName + ".json");
            oldFile.renameTo(newFileName);
            return true;
        }
        return false;
    }
    @Override
    public void readAllPersons() throws FileNotFoundException, MalformedJsonException {
        utility.readList();

    }

}


