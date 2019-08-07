
function postCommit(){
    var parent_id = $("#parent-id").val();

    var content = $("#commit-content").val();

    $.ajax({
        method:"POST",
        url:"/commit",
        data:JSON.stringify({parent_id:parent_id,content:content,parent_type:1,commitParentTypeEnum:1}),
        dataType:"json",
        contentType:"application/json",
        success:function(resp){
            if (resp.statusCode == 200) {
                $(".commit-box").hide();
            }else {
                alert(resp.message);
            }
        },
        error:function(resp){
            alert("出错了！")
        }
    });
}