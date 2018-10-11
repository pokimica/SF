public class MyContactListController {

	@AuraEnabled(cacheable=true)
	public static List<Contact> getContacts() {
    	return [SELECT Id, Name, Email, Title, Phone FROM Contact];
	}
}