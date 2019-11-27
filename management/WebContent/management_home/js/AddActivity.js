function addactivity() {
    addSuction();
    var html = "";
    $("div.right").empty();
    //头部框架
    html += "<div class=\"right_view\">" +
        "<table id=\"NumThree\" class=\"TableBlack\">" +
        "<tbody id = \"content_show\">";
    //内容填充
    html += " <tr>" +
        "<td id= \"actionName\" style=\"font-size:18pt;\" colspan=\"2\">活动发布</td>" +
        "</tr>" +
        "<tr>" +
        "<td >部门选择</td>\n" +
        "<td><input list=\"select_activity\" />\n" +
        "<datalist id=\"select_activity\">\n" +
        "<option value=\"软件部\">\n" +
        "<option value=\"硬件部\">\n" +
        "</datalist></td>\n" +
        "</tr>\n" +
        "<tr>\n" +
        "<td >活动名称</td>\n" +
        "<td><input type=\"text\"></td>\n" +
        "</tr>\n" +
        "<tr>\n" +
        "<td>开始时间</td>\n" +
        "<td><input id = \"start_time\" type=\"datetime-local\" value=\"2015-09-24T13:59:59\"/></td>\n" +
        "</tr>\n" +
        "<tr>\n" +
        "<td>结束时间</td>\n" +
        "<td><input id = \"end_time\" type=\"datetime-local\" value=\"2015-09-24T13:59:59\"/></td>\n" +
        "</tr>\n" +
        "<tr>\n" +
        "<td >活动地点</td>\n" +
        "<td><input type=\"text\"></td>\n" +
        "</tr>\n" +
        "<tr>\n" +
        "<td>详情图片</td>\n" +
        "<td><input type=\"file\" id=\"image\" name=\"test\" accept=\"image/gif, image/jpeg, image/png, image/jpg\"></td>\n" +
        "</tr>\n" +
        "<tr>\n" +
        "<td >活动详情</td>\n" +
        "<td><input type=\"text\"></td>\n" +
        "</tr>\n" +
        "</tr>";
    html += "<tr>\n" +
        "<td bgcolor=\"#FFFFFF\" style=\"text-align: center;\" colspan=\"2\">\n" +
        "<input type=\"submit\" name=\"BtnYes2\" onclick=\"\" value=\"确认提交\" id=\"BtnYes2\" style=\"height:26px;width:100px;\">\n" +
        "&nbsp;</td>\n" +
        "</tr>";
    html += "</tbody>\n" +
        "          </table>\n" +
        "\t</div>";
    var comment = $("div.right");
    comment.html(html);
}



function addSuction() {
    // 发送异步请求
    var uuid = "1";
    var data1 = {};
    data1["aid"] = 1;
    $.ajax({
        url: '/management/admin_Action_showActionByAid?uuid='+uuid, // 请求的Controller
        type: 'post', // 请求方式
        dataType: 'json', // 发送的数据类型
        crossDomain: true,
        data: JSON.stringify(data1),// 要提交给服务端的数据
        success: function (json) { // 请求成功后如何处理结果?，json其实就是服务端返回的响应内容
            console.log(json); // 打印到控制看一看


           
        }
    });
}