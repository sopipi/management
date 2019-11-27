function add() {

    var html = "";
    $("div.right").empty();
    html += "\t<div class=\"right_view\">\n" +
        "\t\t<table id=\"NumThree\" class=\"TableBlack\">\n" +
        "\t\t\t  \n" +
        "            <tbody id = \"content_show\">";
    html += "<tr><td id= \"actionName\" style=\"font-size:18pt;\" colspan=\"2\">加入社团</td>\n" +
        "                    </tr>\n" +
        "                    <tr>\n" +
        "                        <td >社团选择</td>\n" +
        "                        <td><input list=\"select_club\" />\n" +
        "                            <datalist id=\"select_club\">\n" +
        "                                <option value=\"ACM\">\n" +
        "                                <option value=\"计协\">\n" +
        "<option value=\"机器人协会\">\n" +
        "                            </datalist></td>\n" +
        "                    </tr>\n" +
        "                    <tr>\n" +
        "                        <td >部门选择</td>\n" +
        "                        <td><input list=\"select_activity\" />\n" +
        "                            <datalist id=\"select_activity\">\n" +
        "                                <option value=\"软件部\">\n" +
        "                                <option value=\"硬件部\">\n" +
        "                            </datalist></td>\n" +
        "                    </tr>";
    html += "<tr>\n" +
        "            <td bgcolor=\"#FFFFFF\" style=\"text-align: center;\" colspan=\"2\">\n" +
        "                <input type=\"submit\" name=\"BtnYes2\" onclick=\"\" value=\"确认提交\" id=\"BtnYes2\" style=\"height:26px;width:100px;\">\n" +
        "                &nbsp;</td>\n" +
        "        </tr>";
    html += "</tbody>\n" +
        "          </table>\n" +
        "\t</div>";
    var comment = $("div.right");
    comment.html(html);
}