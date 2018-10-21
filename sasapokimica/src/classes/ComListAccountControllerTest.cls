@isTest(SeeAllData=true)
private class ComListAccountControllerTest {

    static testMethod void GetAccountsTest() {
        
        List<Account> aResult = ComListAccountController.GetAccounts();
        
        System.assertEquals('ABC Corp',aResult[0].Name);      
    }
}