import com.bridgelabz.addressbook.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class AddressBookTest {

    IAddressBook iAddressBook = new AddressBookImplementation();
    @Test
    public void givenPersonInWrittenToJson_Should_ReturnTrue() throws FileNotFoundException {
        Person person = new Person("yamini ", "Mhatre","9405205089","G.T.P colony","pune",345678,"Mh");
        boolean result =iAddressBook.addPerson(person, "/home/admin142/eclipse-workspace/AddressBook2/src/main/resources/Person.json");
        Assert.assertEquals(true, result);

    }
    @Test
    public void givenPersonDetails_When_EdittedSuccessfully_Should_ReturnTrue() throws FileNotFoundException {
        Person person = new Person("swati", "More", "94052050566", "Om Nagar","dhule",563457,"MH");
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
    @Test
    public void sortAddressbook_ByZip_ShouldReturnExpectedValue() throws Exception {
        List<Person> personList = iAddressBook.sortByZip();
        Assert.assertEquals(556782,personList.get(0).getZip());
    }
    @Test
    public void givenPersonDetail_WhenProperPrintAllRecord_ShouldReturnTrue() throws IOException {
        boolean result=iAddressBook.printAllRecord();
        Assert.assertEquals(true, result);
    }
    @Test
    public void givenFileName_WhenCreatedSuccessfully_Should_ReturnTrue() throws CustomException {
        boolean result = iAddressBook.createNewAddressBook("newFile2");
        Assert.assertTrue(result);
    }
    @Test
    public void givenNewFileName_WhenStringNull_throwsException() throws Exception{
        Assert.assertFalse(iAddressBook.createNewAddressBook(null));
    }



}
