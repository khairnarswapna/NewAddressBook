import controller.AddressBookImplementation;
import controller.IAddressBook;
import model.Address;
import model.Person;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;

public class AddressBookTest {

    IAddressBook iAddressBook = new AddressBookImplementation();
    @Test
    public void givenPersonInWrittenToJson_Should_ReturnTrue() throws FileNotFoundException {
        Address address = new Address("Dhule  ", "100345", "Mh");
        Person person = new Person("puja", "Patil", address, "9405205050");
        //Manager manager = new AddressBookManager();
        boolean result =iAddressBook.addPerson(person, "/home/admin142/eclipse-workspace/AddressBook2/src/main/resources/Person.json");
        Assert.assertEquals(true, result);

    }

}
