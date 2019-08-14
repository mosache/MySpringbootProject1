function postCommit() {
    var parent_id = $("#parent-id").val();

    var content = $("#commit-content").val();

    $.ajax({
        method: "POST",
        url: "/commit",
        data: JSON.stringify({parent_id: parent_id, content: content, parent_type: 1, commitParentTypeEnum: 1}),
        dataType: "json",
        contentType: "application/json",
        success: function (resp) {
            if (resp.statusCode == 200) {
                $(".commit-box").hide();
            } else {
                alert(resp.message)
            }
        },
        error: function (resp) {
            alert("出错了！")
        }
    });
}

function postSubCommit(parent_id) {

    var content = $("#subCommit-text" + parent_id).val();

    $.ajax({
        method: "POST",
        url: "/commit",
        data: JSON.stringify({parent_id: parent_id, content: content, parent_type: 2, commitParentTypeEnum: 2}),
        dataType: "json",
        contentType: "application/json",
        success: function (resp) {
            if (resp.statusCode == 200) {
                alert("添加成功！");
            } else {
                alert(resp.message);
            }
        },
        error: function (resp) {
            alert("出错了！")
        }
    });
}

function showSubCommit(obj) {
    var id = $(obj).data("id");

    var subCommentBox = $("#commit-" + id)
    subCommentBox.toggleClass("in");

    var list = subCommentBox.find(" ul");
    if (subCommentBox.hasClass("in")) {
        //展开
        $.getJSON("/commit/" + id, function (data) {
            data.data.forEach(function (comment) {
                var li = $("  <li class=\"list-item\" style=\"padding: 20px;font-size: 14px;border-bottom:1px solid #eee;list-style: none\">\n" +
                    "                                    <div class=\"media\" style=\"margin-left: 0\">\n" +
                    "                                    <div class=\"media-left\">\n" +
                    "                                        <a href=\"#\">\n" +
                    "                                            <img class=\"media-object\" th:src=\"" + comment.user.avatar_url + "\" alt=\"...\" style=\"width: 40px;height: 40px;\">\n" +
                    "                                        </a>\n" +
                    "                                    </div>\n" +
                    "                                    <div class=\"media-body\" style=\"padding-left:16px\">\n" +
                    "                                        <h5 class=\"media-heading\">" + comment.user.name + "</h5>\n" +
                    "                                        <div>\n" +
                    "                                            <p>" + comment.content + "</p>\n" +
                    "                                        </div>\n" +
                    "\n" +
                    "                                    </div>\n" +
                    "                                </div>\n" +
                    "                            </li>")

                list.append(li);
            });
        });

    } else {
        //收起
        list.children("li").remove();
    }

}

function onTagClick(target){
    var dom = document.removeChild($(target)[0]);

}
