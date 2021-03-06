
<#-- ${column.COLUMN_NAME?cap_first} -->


public class ${shortname}DTO implement ISerializable {

	<#list dtocolumnList as column>
	private ${column.DATA_TYPE} ${column.COLUMN_NAME};
	</#list>
	
	<#list dtocolumnList as column>
	public void set${column.COLUMN_NAME?cap_first}(${column.DATA_TYPE} ${column.COLUMN_NAME})
	{
		this.${column.COLUMN_NAME} = ${column.COLUMN_NAME};
	}
	public ${column.DATA_TYPE} get${column.COLUMN_NAME?cap_first}(){
        return this.${column.COLUMN_NAME};
    }
	</#list> 

}
