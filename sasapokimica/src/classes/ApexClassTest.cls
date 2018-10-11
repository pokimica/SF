public with sharing class ApexClassTest {
    public static void addHelloWorld(Account[] accounts){
    	for (Account a: accounts){
    		if (a.Description != 'Hello World'){
    			a.Description = 'Hello World';
    		}
    	}
    }
}