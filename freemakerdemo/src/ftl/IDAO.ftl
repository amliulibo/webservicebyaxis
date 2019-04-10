<#--  -->
<#--${shortname?upper_case}-->

Public Interface I${shortname}DAO {

	int insertOne( DBManager dbManager,${shortname}DTO  dto);
	
	int updateOne(DBManager dbManager,${shortname}DTO dto);
	int deleteOne(DBManager dbManager,String billid);
    
	public List<${shortname}DTO> selectList(DBManager dbManager);
	
	int insertList(DBManager dbManager,List<${shortname}DTO> dtoLst);
	
	String selectGUID(); 
}


