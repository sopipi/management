function applyforpositionjudje() {

    var html = "";
    $("div.right").empty();
    //头部轮廓
    html += "<div class=\"right_view_1\">\n" +
        "<table id=\"NumThree\" class=\"TableBlack\">\n" +
        "            <tbody id = \"content_show\">";
    //主要内容
    html += "<tr>" +
        "<td id= \"actionName\" style=\"font-size:18pt;\" colspan=\"9\">部门场地申请批准</td>" +
        "</tr>" +
        "<tr>" +
        "<td style=\"text-align: center; width:5%;\">序号</td>" +
        "<td style=\"text-align: center; width:10%;\">申请人姓名</td>" +
        "<td style=\"text-align: center; width:10%;\">联系方式</td>" +
        "<td style=\"text-align: center; width:10%;\">协会</td>" +
        "<td style=\"text-align: center; width:10%;\">职位</td>" +
        "<td style=\"text-align: center; width:15%;\">开始时间</td>" +
        "<td style=\"text-align: center; width:15%;\">结束时间</td>" +
        "<td style=\"text-align: center; width:10%;\">场地</td>" +
        "<td style=\"text-align: center; width:20%;\">决定</td>" +
        "</tr>";
    for(var i=1; i<6; i++) {
        html += "<tr>" +
            "<td style=\"text-align: center; width:5%;\" id=\"applyposition_uesr_no_"+i+"\">"+i+"</td>" +
            "<td style=\"text-align: center; width:10%;\" id=\"applyposition_uesr_name_"+i+"\">梁杰</td>" +
            "<td style=\"text-align: center; width:10%;\" id=\"applyposition_uesr_phone_"+i+"\">13540462017</td>" +
            "<td style=\"text-align: center; width:10%;\" id=\"applyposition_uesr_club_"+i+"\">ACM</td>" +
            "<td style=\"text-align: center; width:10%;\" id=\"applyposition_uesr_position_"+i+"\">会长</td>" +
            "<td style=\"text-align: center; width:15%;\" id=\"applyposition_uesr_starttime_"+i+"\">2019.10.10</td>" +
            "<td style=\"text-align: center; width:15%;\" id=\"applyposition_uesr_endtime_"+i+"\">2019.10.12</td>" +
            "<td style=\"text-align: center; width:10%;\" id=\"applyposition_uesr_local_"+i+"\">北广场</td>" +
            "<td style=\"text-align: center; width:20%;\" id=\"apply_uesr_decision_"+i+"\"><button value=\"yes\">同意</button><button value=\"no\">不同意</button></td>" +
            "</tr>";
    }
    //提交按钮
    html += "<tr>" +
        "<td bgcolor=\"#FFFFFF\" style=\"text-align: center;\" colspan=\"8\">" +
        "<input type=\"submit\" name=\"BtnYes2\" onclick=\"\" value=\"确认提交\" id=\"BtnYes2\" style=\"height:26px;width:100px;\">" +
        "&nbsp;</td>" +
        "</tr>";
    //后部
    html += "</tbody>" +
        "</table>" +
        "</div>";
    var comment = $("div.right");
    comment.html(html);
}