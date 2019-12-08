import com.bridgelabz.addressbook.*;
import org.junit.Assert;
import org.junit.Test;
import util.Utility;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class AddressBookTest {

    IAddressBook iAddressBook = new AddressBookImplementation();
    @Test
    public void givenPersonInWrittenToJson_Should_ReturnTrue() throws FileNotFoundException {
        Person person = new Person("Dhamini  ", "patil","9405205089","G.T.P colony","pune",345678,"Mh");
        boolean result =iAddressBook.addPerson(person, "/home/admin142/eclipse-workspace/AddressBook2/src/main/resources/newFile.json");
        Assert.assertEquals(true, result);

    }
    @Test
    public void givenPersonDetails_When_Editted_Successfully_Should_ReturnTrue() throws FileNotFoundException {
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
    public void givenMobileNumber_removePersonDetailsFromAddressbook_ButPersonDoesNotExist_ShouldReturnOne() throws IOException {
        try {
            boolean result = iAddressBook.deletePerson("9405205089");
            Assert.assertTrue(result);
        } catch (CustomException e) {
            Assert.assertEquals(CustomException.ExceptionType.PERSON_NOT_FOUND, e.type);
        }

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
    @Test
    public void givenFileName_WhenExist_Should_Open_And_ReturnTrue() throws CustomException {
        boolean result=iAddressBook.openExistingAddressBook("Firstjson.json");
        Assert.assertTrue(result);
    }
    @Test
    public void openAddressBook_AddressbookNameDoesNotExist_ShouldThrowException(){
        try {
            boolean result=iAddressBook.openExistingAddressBook("abc");
            Assert.assertTrue(result);
        } catch (CustomException e) {
            Assert.assertEquals(CustomException.ExceptionType.ADDRESSBOOK_DOESNOT_EXIST, e.type);
        }
    }
    @Test public void givenFileName_When_OpenFileSaveTheDetails_Should_ReturnTrue() {
        boolean result = iAddressBook.saveAddressBook(Utility.resourceFilePath+"newFile2");
        Assert.assertTrue(result);
    }
    @Test
    public void givenFileName_When_OpenedAndEdited_Should_BeAble_SaveAsWithNewName_Return_True() {
        boolean result = iAddressBook.saveAs("newFile2.json", "newFile");
        Assert.assertTrue(result);
    }


}
