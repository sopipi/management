function applyfordepartment() {

    var html = "";
    $("div.right").empty();
    //头部框架
    html += "<div class=\"right_view_1\">" +
        "<table id=\"NumThree\" class=\"TableBlack\">" +
        "<tbody id = \"content_show\">";
    //内容填充
    html += "<tr>" +
        "<td id= \"actionName\" style=\"font-size:18pt;\" colspan=\"8\">哪个部门人员申请</td>" +
        "</tr>" +
        "<tr>" +
        "<td style=\"text-align: center; width:5%;\">序号</td>" +
        "<td style=\"text-align: center; width:10%;\">姓名</td>" +
        "<td style=\"text-align: center; width:15%;\">学号</td>" +
        "<td style=\"text-align: center; width:5%;\">性别</td>" +
        "<td style=\"text-align: center; width:15%;\">联系方式</td>" +
        "<td style=\"text-align: center; width:15%;\">申请时间</td>" +
        "<td style=\"text-align: center; width:10%;\">加入部门</td>" +
        "<td style=\"text-align: center; width:25%;\">决定</td>" +
        "</tr>";
    for(var i=1; i<6; i++) {
        html += "<tr>" +
            "<td style=\"text-align: center; width:5%;\" id=\"apply_uesr_no_"+i+"\">"+i+"</td>" +
            "<td  style=\"text-align: center; width:10%;\" id=\"apply_uesr_name_"+i+"\">梁杰</td>" +
            "<td style=\"text-align: center; width:15%;\" id=\"apply_uesr_ID_"+i+"\">201731104127</td>" +
            "<td style=\"text-align: center; width:5%;\" id=\"apply_uesr_sex_"+i+"\">男</td>" +
            "<td style=\"text-align: center; width:15%;\" id=\"apply_uesr_phone_"+i+"\">13540462017</td>" +
            "<td style=\"text-align: center; width:15%;\" id=\"apply_uesr_applyTime_"+i+"\">2019.3.23</td>" +
            "<td style=\"text-align: center; width:15%;\"><input list=\"apply_uesr_department_"+i+"\" value=\"公关部\" style=\"width: 80%\">" +
            "<datalist id=\"apply_uesr_department_"+i+"\">\n" +
            "<option  value=\"研发部\">" +
            "<option value=\"公关部\">" +
            "<option value=\"宣传部\">" +
            "</datalist></td>" +
            "<td style=\"text-align: center; width:25%;\" id=\"apply_uesr_decision_"+i+"\"><button value=\"yes\">同意</button><button value=\"no\">不同意</button></td>" +
            "</tr>";
    }
    //提交按钮
    html += "<tr>\n" +
        "<td bgcolor=\"#FFFFFF\" style=\"text-align: center;\" colspan=\"8\">" +
        "<input type=\"submit\" name=\"BtnYes2\" onclick=\"\" value=\"确认提交\" id=\"BtnYes2\" style=\"height:26px;width:100px;\">" +
        "&nbsp;</td>\n" +
        "</tr>";
    //底部框架
    html += "</tbody>" +
        "</table>" +
        "</div>";
    var comment = $("div.right");
    comment.html(html);
}