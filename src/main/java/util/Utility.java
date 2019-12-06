package util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.bridgelabz.addressbook.Person;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Utility {

    public static final String FilePath ="/home/admin142/eclipse-workspace/AddressBook2/src/main/resources/Firstjson.json";
    public static final String resourceFilePath="/home/admin142/eclipse-workspace/AddressBook2/src/main/resources/";
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
    public static void readingAddressBook(String filePath) {
        try {
            Gson gson = new Gson();
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
            Person[] peoples = gson.fromJson(bufferedReader, Person[].class);
            for (int i = 0; i < peoples.length; i++) {
                System.out.println(peoples[i]);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static boolean SavedIntoAddressBook(String fileName, List<Person> personList) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        //  personList.add(persons);
        String json = gson.toJson(personList);
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(fileName);
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
    public static List<Person> getSavedRecord() {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("swati", "Desale", "9405205070", "G.T.P colony", "pune", 224534,"MH"));
        personList.add(new Person("Neha", "More", "46613260255", "Om Nagar", "Nashik", 234567,"MH"));
        return personList;
    }
    public List<Person> readAllPersonsAddressList()   {

        for (int i = 0; i < personDetails.length; i++) {
            personList.add(personDetails[i]);
            System.out.println(personDetails[i]);
        }
        return personList;
    }

}
