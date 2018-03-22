$(function(){
    $('#dg').datagrid({
        url:'/admin/blog/list',
        title:'博客管理',
        iconCls:'',
        fit:true,
        striped:true,
        //下面的page条
        pagination:true,
        pageSize:10,
        pageList:[10,20,30,40,50],
        //是否出现横向滚动条
        fitColumns:true,
        //数据折行
        nowrap:false,
        border:false,
        //帮你记住你选过的，做跨页删除
        idField:'id',
        columns:[[
            {
                title:'',
                field:'cb',
                checkbox:true,
                align:'center',
            },
            {
                title:'编号',
                field:'id',
                width:20,
                align:'center'
            },
            {
                title:'标题',
                field:'title',
                width:150,
                align:'center',
                formatter:function (value,row,index) {
                    return "<a target='_blank' href='/blog/detail?id="+row.id+"'>"+value+"</a>";
                }
            },
            {
                title:'发布时间',
                field:'createDate',
                align:'center',
                width:50,
                align:'center',
            },
            {
                title:'博客类别',
                field:'blogType',
                align:'center',
                width:50,
                formatter:function (value,row,index) {
                    return row.blogType.name;
                }
            }
        ]],
        toolbar:"#tb"
    });
});
var dg = $('#dg');
function openBlogModifyTab(){
    var selectedRows=dg.datagrid("getSelections");
    if(selectedRows.length!=1){
        $.messager.alert("系统提示","请选择一个要修改的博客！");
        return;
    }
    var row=selectedRows[0];
    window.parent.openTab('修改博客','/admin/blog/update?id='+row.id,'icon-writeblog');
}

function deleteBlog(){
    var selectedRows=dg.datagrid("getSelections");
    console.info(selectedRows.length);
    if(selectedRows.length==0){
        $.messager.alert("系统提示","请选择要删除的数据！");
        return;
    }
    var strIds=[];
    for(var i=0;i<selectedRows.length;i++){
        strIds.push(selectedRows[i].id);
    }
    $.messager.confirm("系统提示","您确定要删除这<span style='color:red'>"+selectedRows.length+"</span>条数据吗？",function(r){
        if(r){
            $.post("/admin/blog/remove",{"ids":strIds},function(result){
                if(result.success){
                    $.messager.alert("系统提示","数据已成功删除！");
                    dg.datagrid("reload");
                    dg.datagrid('clearSelections');
                }else{
                    $.messager.alert("系统提示","数据删除失败！");
                }
            },"json");
        }
    });
}

function searchBlog() {
    dg.datagrid('load',{
        "title":$('#s_title').val()
    });
}

function undoBlog() {
    dg.datagrid('clearSelections');

}