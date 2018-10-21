@isTest(SeeAllData=true)
private class ContactControllerTest {

    static testMethod void getContactsTest() {
        List<Contact> cExpected = [SELECT Id, Name, MailingStreet, Phone, Email, LeadSource FROM Contact];
		List<Contact> cResult = ContactController.getContacts();

		System.assert(cExpected == cResult);
    }
}