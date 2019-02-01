<#-- 这是Freemarker注释 -->
<#-- 获取简单值 -->

Public Interface I${tablename}DAO {

	integer insert${tablename?upper_case}(List<{tablename?upper_case}DTO> dtoLst);
	
	
}


