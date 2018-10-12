public class Util {

	public static Map <String, Schema.SObjectType> schemaMap = Schema.getGlobalDescribe();
	
	public static string FormatFieldsForQuery(Map<string, Schema.SObjectField> fieldMap, string prefix){
		Set<string> fieldSet = fieldMap.keySet();  
		string fields = '';
		for(string f : fieldSet) fields += prefix + f +',';
		if(fields.endsWith(',')) fields = fields.substring(0,fields.length()-1);
		return fields;
	}
	
	
	public static List<SObject> DynamicQuery(String ObjectType) {
		Map<String, Schema.SObjectField> mapA = schemaMap.get(ObjectType).getDescribe().fields.getMap();
		string fields = FormatFieldsForQuery(mapA,'');
		string q = 'SELECT '+ fields +' FROM ' + ObjectType + ' ORDER BY Name';
		List<SObject> objects = Database.Query(q);
		return objects;
	}
}