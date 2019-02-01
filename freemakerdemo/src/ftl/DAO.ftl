
<#-- ÕâÊÇFreemarker×¢ÊÍ-->


public class ${tablename}DAOImpl implement I${tablename}DAO {

	public integer insert${tablename?upper_case}(List<${tablename?upper_case}DTO> dtoLst)
	{
	
		String sql="insert into ${tablename}(<#list tablecolumnlist as column>${column.COLUMN_NAME} <#if column_has_next>,</#if> </#list> )
		values (<#list tablecolumnlist as column>? <#if column_has_next>,</#if> </#list>)";
		Object[] objs=new Object{ 
		<#list tablecolumnlist as column>dto.get${column.COLUMN_NAME?cap_first}<#if column_has_next>,</#if></#list> };
		Object ret= this.jdbcTemplate.execute(sql,objs);
		return ret;
	
	}	

}
