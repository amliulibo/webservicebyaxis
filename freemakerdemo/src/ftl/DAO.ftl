
<#-- ${tablename?upper_case}-->


public class ${shortname}DAOImpl implement I${shortname}DAO {


	public int insertOne(DBManager dbManager,${shortname}DTO dto)
	{
	
		String sql="insert into "+dbManager.getSchema()+".${tablename}(<#list tablecolumnlist as column>${column.COLUMN_NAME} <#if column_has_next>,</#if> </#list> )"
		+"values (<#list tablecolumnlist as column>? <#if column_has_next>,</#if> </#list>)";
		Object[] objs=new Object[]{ 
		<#list tablecolumnlist as column>dto.get${column.COLUMN_NAME?cap_first}()<#if column_has_next>,</#if></#list> };
		int ret= this.jdbcTemplate.update(sql,objs);
		return ret;
	
	}
	
	
	
	public int updateOne(DBManager dbManager,${shortname}DTO dto)
	{
	
		String sql="update "+dbManager.getSchema()+".${tablename} set  <#list tablecolumnlist as column>${column.COLUMN_NAME}=?, </#list> where billseq=?";
		Object[] ob = new Object[]
			{ 
			<#list tablecolumnlist as column>dto.get${column.COLUMN_NAME?cap_first}(),</#list>
			dto.getBillId()
			};
		int ret= this.jdbcTemplate.update(sql, ob);
		return ret;
		
	}
	public int deleteOne(DBManager dbManager,String billid)
	{
		String sql = "update " + dbManager.getSchema()
				+ ".${tablename} set billstatus=-1 where billid=? ";
		return this.jdbcTemplate.update(sql, new Object[]{ billid });
	}
	 
	
    
	public List<${shortname}DTO> selectList(DBManager dbManager)
	{
		String sql = "select * from " + dbManager.getSchema() + ".${tablename}"
				+ " where 1=1  ";
		Object[] params ={  };
		 
		List<${shortname}DTO> list = this.jdbcTemplate.query(sql, params, new ${shortname}Mapper());
		return list;
	}
	
	public String selectGUID() {
		String guid = jdbcTemplate.queryForObject("SELECT sys_guid() FROM dual",	String.class);
		return guid;
	}

}
