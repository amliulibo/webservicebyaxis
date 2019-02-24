


//客户端分页
function pagerFilter(data){
	//debugger;
    if (typeof data.length == 'number' && typeof data.splice == 'function'){    // 判断数据是否是数组
        data = {
            total: data.length,
            rows: data
        }
    }
    var dg = $(this);
    var opts = dg.datagrid('options');
    var pager = dg.datagrid('getPager');
    pager.pagination({
        onSelectPage:function(pageNum, pageSize){
            opts.pageNumber = pageNum;
            opts.pageSize = pageSize;
            pager.pagination('refresh',{
                pageNumber:pageNum,
                pageSize:pageSize
            });
            dg.datagrid('loadData',data);
        }
    });
    if (!data.originalRows){
        data.originalRows = (data.rows);
    }
    var start = (opts.pageNumber-1)*parseInt(opts.pageSize);
    var end = start + parseInt(opts.pageSize);
    data.rows = (data.originalRows.slice(start, end));
    return data;
}

function closeDialog(dialogName){
	$("#"+dialogName).dialog("close");
	
}




var editIdx=undefined;

function append(){
	dg.datagrid("appendRow",{});	
	editIdx=dg.datagrid("getRows").length-1;
	dg.datagrid("selectRow",editIdx).datagrid("beginEdit",editIdx);

}

function remove() {
	var dg=$(this);
    editIndex = dg.datagrid('getRows').length-1 ;
    dg.datagrid('deleteRow', editIndex);
    editIdx = undefined;
}

