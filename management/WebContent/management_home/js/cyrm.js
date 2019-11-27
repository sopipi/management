function cyrm() {

    var html = "";
    $("div.right").empty();
    //主要轮廓
    html += "<div class=\"right_view_1\">" +
        "<table id=\"NumThree\" class=\"TableBlack\">" +
        "<tbody id = \"content_show\">";
    //主要内容
    html += "<tr>" +
        "<td id= \"actionName\" style=\"font-size:18pt;text-align: center;\" colspan=\"8\">哪个部门人员任免</td>" +
        "</tr>" +
        "<tr>" +
        "<td style=\"text-align: center; width:5%;\">序号</td>" +
        "<td style=\"text-align: center; width:10%;\">姓名</td>" +
        "<td style=\"text-align: center; width:15%;\">学号</td>" +
        "<td style=\"text-align: center; width:5%;\">性别</td>" +
        "<td style=\"text-align: center; width:15%;\">联系方式</td>" +
        "<td style=\"text-align: center; width:15%;\">加入时间</td>" +
        "<td style=\"text-align: center; width:10%;\">职位</td>" +
        "<td style=\"text-align: center; width:10%;\">删除</td>" +
        "</tr>";
    for(var i=1; i<6; i++) {
        html += "<tr>" +
            "<td style=\"text-align: center; width:5%;\" id=\"department_uesr_no_"+i+"\">"+i+"</td>" +
            "<td style=\"text-align: center; width:10%;\" id=\"department_uesr_name_"+i+"\">梁杰</td>" +
            "<td style=\"text-align: center; width:15%;\" id=\"department_uesr_ID_"+i+"\">201731104127</td>" +
            "<td style=\"text-align: center; width:5%;\" id=\"department_uesr_sex_"+i+"\">男</td>" +
            "<td style=\"text-align: center; width:15%;\" id=\"department_uesr_phone_"+i+"\">13540462017</td>" +
            "<td style=\"text-align: center; width:15%;\" id=\"department_uesr_joinTime_"+i+"\">1998_2017</td>" +
            "<td style=\"text-align: center; width:10%;\"><input list=\"department_uesr_position_"+i+"\" value=\"普通成员\" style=\"width: 100%\">" +
            "<datalist id=\"department_uesr_position_"+i+"\">" +
            "<option  value=\"普通成员\">" +
            "<option value=\"副部长\">" +
            "<option value=\"部长\">" +
            "</datalist></td>" +
            "<td style=\"text-align: center; width:10%;\" id=\"department_uesr_delete\"><button>删除</button></td>" +
            "</tr>\n";
    }
    //提交按钮
    html += "<tr>\n" +
        "            <td bgcolor=\"#FFFFFF\" style=\"text-align: center;\" colspan=\"8\">\n" +
        "                <input type=\"submit\" name=\"BtnYes2\" onclick=\"\" value=\"确认提交\" id=\"BtnYes2\" style=\"height:26px;width:100px;\">\n" +
        "                &nbsp;</td>\n" +
        "        </tr>";
    //下部分轮廓
    html += "</tbody>\n" +
        "          </table>\n" +
        "\t</div>";
    var comment = $("div.right");
    comment.html(html);
}