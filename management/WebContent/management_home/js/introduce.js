function chageintroduce() {

    var html = "";
    $("div.right").empty();
    //主要的轮廓
    html += "<div class=\"right_view\">" +
        "<table id=\"NumThree\" class=\"TableBlack\">" +
        "<tbody id = \"content_show\">";
    //数据信息
    html += "  <tr>" +
        "<td id= \"actionName\" style=\"font-size:18pt;\" colspan=\"2\">修改社团信息</td>" +
        "</tr>" +
        "<tr>" +
        "                        <td  style=\"text-align: center; width:50%;\">社团名称</td>" +
        "                        <td  style=\"text-align: center; width:50%;\"> <input id = \"department_name\" type=\"text\" value=\"ACM\"></td>" +
        "                    </tr>" +
        "                    <tr>" +
        "                        <td  style=\"text-align: center; width:50%;\">社团介绍</td>" +
        "                        <<td style=\"text-align: center; width:50%;\"><input id = \"department_introduce\" type=\"text\" value=\"简单介绍\"></td>" +
        "                    </tr>";
    //提交按钮
    html += "<tr>" +
        "            <td bgcolor=\"#FFFFFF\" style=\"text-align: center;\" colspan=\"8\">" +
        "                <input type=\"submit\" name=\"BtnYes2\" onclick=\"\" value=\"确认提交\" id=\"BtnYes2\" style=\"height:26px;width:100px;\">" +
        "                &nbsp;</td>" +
        "        </tr>";
    //主要轮廓
    html += "</tbody>" +
        "          </table>" +
        "</div>";
    var comment = $("div.right");
    comment.html(html);
}