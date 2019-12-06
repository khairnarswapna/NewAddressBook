package util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.bridgelabz.addressbook.Person;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Utility {

    public static final String FilePath ="/home/admin142/eclipse-workspace/AddressBook2/src/main/resources/Person.json";
    List<Person> personList = new ArrayList<>();
    Gson gson = new Gson();
    BufferedReader br = new BufferedReader(new FileReader(FilePath));
    //convert the json string back to object
    Person[] personDetails = gson.fromJson(br, Person[].class);

    public Utility() throws FileNotFoundException {
    }

    public boolean writeIntoJsonFile(Person person) throws FileNotFoundException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        readList();
        personList.add(person);
        //  personList.add(persons);
        String json = gson.toJson(personList);
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(FilePath);
            fileWriter.write(json);
            fileWriter.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean writeIntoJsonFile(List<Person> personList) throws FileNotFoundException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(personList);
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(FilePath);
            fileWriter.write(json);
            fileWriter.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }
    public boolean readList() throws FileNotFoundException {

        for (int i = 0; i < personDetails.length; i++) {
            personList.add(personDetails[i]);
            System.out.println(personDetails[i]);
        }
        return true;
    }
    public List<Person> readAllPersonsAddressList()   {

        for (int i = 0; i < personDetails.length; i++) {
            personList.add(personDetails[i]);
            System.out.println(personDetails[i]);
        }
        return personList;
    }

}
