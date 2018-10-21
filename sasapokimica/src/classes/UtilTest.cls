@isTest
private class UtilTest {

    public static testMethod void FormatFieldsForQueryTest() {
        Map<String, Schema.SObjectField> mp = new Map<String, Schema.SObjectField>{'0' => null, '1' => null, '2' => null, '3' => null, '4' => null, '5' => null, '6' => null, '7' => null, '8' => null, '9' => null};
        
        String expected = '0,1,2,3,4,5,6,7,8,9';
        String result = Util.FormatFieldsForQuery(mp, '');
        
        System.assertEquals(result, expected);
        
        String prefix = 'ns';
        String expectedWithPrefix = 'ns0,ns1,ns2,ns3,ns4,ns5,ns6,ns7,ns8,ns9';
        result = Util.FormatFieldsForQuery(mp, prefix); 
        System.assertEquals(result, expectedWithPrefix);        
    }
    
    public static testMethod void DynamicQueryTest(){
    	List<TestObj__c> objs = Util.DynamicQuery('TestObj__c');
    	
    	System.assert(objs != null && objs.size() == 10, true);
    	
    	String expected = '0,1,2,3,4,5,6,7,8,9';
    	
    	String result = '';
    	for(TestObj__c t: objs){
    		result += t.Name + ',';
    	}
    	
    	result = result.substring(0,result.length()-1);
    	
    	System.assertEquals(result, expected);    	
    }
}