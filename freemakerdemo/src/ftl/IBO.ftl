public interface I${shortname}BO {

	 
	boolean saveOne(DBManager dbManager, ${shortname}DTO dto);

	
	 
	boolean updateOne(DBManager dbManager, ${shortname}DTO dto);
	
	
	List<${shortname}DTO> getList(DBManager dbManager, ${shortname}DTO dto);
	 
	
}	