public with sharing class ComListAccountController {
	@AuraEnabled
    public static List<Account> GetAccounts(){
    
    	List<Account> a = Util.DynamicQuery('Account');
    	return a;
    	
    }
}