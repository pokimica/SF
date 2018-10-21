@isTest(SeeAllData=true)
private class MyContactListControllerTest {

    static testMethod void getContactsTest() {
        
        List<Contact> cExpected = [SELECT Id, Name, Email, Title, Phone FROM Contact];

		List<Contact> cResult = MyContactListController.getContacts();
		
		System.assertEquals(cExpected, cResult);
    }
}