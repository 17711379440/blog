$(function () {
    $('#dg').datagrid({
        url: '/admin/blogType/list',
        title: '博客类别管理',
        iconCls: '',
        fit: true,
        striped: true,
        //下面的page条

        //是否出现横向滚动条
        fitColumns: true,
        //数据折行
        nowrap: false,
        border: false,
        //帮你记住你选过的，做跨页删除
        columns: [[
            {
                title: '',
                field: 'cb',
                checkbox: true,
                align: 'center',
            },
            {
                title: '编号',
                field: 'id',
                width: 20,
                align: 'center'
            },
            {
                title: '名称',
                field: 'name',
                width: 150,
                align: 'center'
            }
        ]],
        toolbar: "#tb"
    });
});
var url; //请求路径
var dlg = $("#dlg");
var dg = $("#dg");

function addBlogType() {
    dlg.dialog("open").dialog("setTitle", "添加博客类别信息");
    url = '/admin/blogType/add';
}

function updateBlogType() {
    var selectedRows = $("#dg").datagrid("getSelections");
    if (selectedRows.length != 1) {
        $.messager.alert("系统提示", "请选择一个要修改的博客类别！");
        return;
    }
    dlg.dialog("open").dialog("setTitle", "修改博客类别信息");
    var row = selectedRows[0];
    $("#form").form("load", row);
    url = '/admin/blogType/update?id='+row.id;
}

function deleteBlogType() {
    var selectedRows = $("#dg").datagrid("getSelections");
    if (selectedRows.length == 0) {
        $.messager.alert("系统提示", "请选择要删除的数据！");
        return;
    }
    var strIds = [];
    for (var i = 0; i < selectedRows.length; i++) {
        strIds.push(selectedRows[i].id);
    }
    $.messager.confirm("系统提示", "您确定要删除这<span style='color:red'>" + selectedRows.length + "</span>条数据吗？", function (r) {
        if (r) {
            $.post("/admin/blogType/remove", {"ids": strIds}, function (result) {
                if (result.success) {
                    $.messager.alert("系统提示", "数据已成功删除！");
                    $("#dg").datagrid("reload");
                    $("#dg").datagrid('clearSelections');
                } else {
                    $.messager.alert("系统提示", "数据删除失败！");
                }
            }, "json");
        }
    });
}

function undoBlogType() {
    dg.datagrid('clearSelections');
}

function saveBlogType() {
    //让表单（form）成为 ajax 提交的表单（form）
    $('#form').form('submit', {
        url: url,
        onSubmit: function () {
            return $(this).form("validate");
        },
        success: function (result) {
            console.info(result);
            if (result) {
                $.messager.alert('系统提示', '保存成功');
                resetValue();
                dlg.dialog('close');
                dg.datagrid('reload');
            } else {
                $.messager.alert('系统提示', '保存失败');
                return;
            }
        }
    });
}

function resetValue() {
    $('#name').val('');
}

function closeBlogType() {
    $('#dlg').dialog('close');
    resetValue();
}