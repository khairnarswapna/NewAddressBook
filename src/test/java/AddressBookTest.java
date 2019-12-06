import com.bridgelabz.addressbook.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.List;

public class AddressBookTest {

    IAddressBook iAddressBook = new AddressBookImplementation();
    @Test
    public void givenPersonInWrittenToJson_Should_ReturnTrue() throws FileNotFoundException {
        Person person = new Person("yamini ", "Mhatre","9405205089","Pune ", "100345", "Mh");
        boolean result =iAddressBook.addPerson(person, "/home/admin142/eclipse-workspace/AddressBook2/src/main/resources/Person.json");
        Assert.assertEquals(true, result);

    }
    @Test
    public void givenPersonDetails_When_EdittedSuccessfully_Should_ReturnTrue() throws FileNotFoundException {
        Person person = new Person("swati", "More", "94052050566", "Pune", "556782", "MH");
        boolean result = iAddressBook.editPerson(person, "9405205050");
        Assert.assertTrue(result);
    }
    @Test
    public void givenMobileNumber_WhenPresent_ShouldRemovePersonDetails_FromAddressBook() throws FileNotFoundException, CustomException {
        boolean result =iAddressBook.deletePerson("9405205050");
        Assert.assertTrue(result);
    }
    @Test
    public void givenMobileNumber_WhenDetails_Notavilable_whileRemovingRecord_ThrowException() throws FileNotFoundException, CustomException {
        boolean result =iAddressBook.deletePerson("9405205050");
        Assert.assertTrue(result);
    }

    @Test
    public void sortAddressbook_ByLastname_ShouldReturnExpectedValue() throws Exception {
        List<Person> personList = iAddressBook.sortByLastName();
        Assert.assertEquals("Mhatre",personList.get(0).getLastName());
    }



}
