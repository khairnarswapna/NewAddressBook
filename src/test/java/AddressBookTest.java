import com.bridgelabz.addressbook.AddressBookImplementation;
import com.bridgelabz.addressbook.IAddressBook;
import com.bridgelabz.addressbook.Address;
import com.bridgelabz.addressbook.Person;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;

public class AddressBookTest {

    IAddressBook iAddressBook = new AddressBookImplementation();
    @Test
    public void givenPersonInWrittenToJson_Should_ReturnTrue() throws FileNotFoundException {
        Person person = new Person("leena", "Patil","9405205050","Dhule  ", "100345", "Mh");
        boolean result =iAddressBook.addPerson(person, "/home/admin142/eclipse-workspace/AddressBook2/src/main/resources/Person.json");
        Assert.assertEquals(true, result);

    }
    @Test
    public void givenPersonDetails_When_EdittedSuccessfully_Should_ReturnTrue() throws FileNotFoundException {
        Person person = new Person("swati", "More", "94052050566", "Pune", "556782", "MH");
        boolean result = iAddressBook.editPerson(person, "9405205050");
        Assert.assertTrue(result);
    }


}
