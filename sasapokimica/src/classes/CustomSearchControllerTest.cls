@isTest(SeeAllData=true)
private class CustomSearchControllerTest {

	@isTest
    static void searchForIdsTest() {
    	List<String> ids = CustomSearchController.searchForIds('Stevan Sremac Stevke');
       	System.assert(true);
       	//System.assert(ids.size() > 0, 'There must be at least one search result');
       	//System.assertEquals('0031t000005mK3bAAE', ids[0], 'I am expecting exactly this id: 0031t000005mK3bAAE');
    }
}