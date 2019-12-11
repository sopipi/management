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
        "                        <td><input id = \"select_c\"list=\"select_club\" />\n" +
        "                            <datalist id=\"select_club\">\n" +
        "                                <option value=\"SMUACM俱乐部\">\n" +
//        "                                <option value=\"计协\">\n" +
        "<option value=\"机器人协会\">\n" +
        "                            </datalist></td>\n" +
        "                    </tr>\n" +
        "                    <tr>\n" +
        "                        <td >部门选择</td>\n" +
        "                        <td><input id = \"select_d\" list=\"select_activity\" />\n" +
        "                            <datalist id=\"select_activity\">\n" +
        "                                <option value=\"研发部\">\n" +
//        "                                <option value=\"硬件部\">\n" +
        "                            </datalist></td>\n" +
        "                    </tr>";
    html += "<tr>\n" +
        "            <td bgcolor=\"#FFFFFF\" style=\"text-align: center;\" colspan=\"2\">\n" +
        "                <input type=\"submit\" name=\"BtnYes2\" onclick=\"getJoinClubText()\" value=\"确认提交\" id=\"BtnYes2\" style=\"height:26px;width:100px;\">\n" +
        "                &nbsp;</td>\n" +
        "        </tr>";
    html += "</tbody>\n" +
        "          </table>\n" +
        "\t</div>";
    var comment = $("div.right");
    comment.html(html);
}


function getJoinClubText() {
var data2 = {};	
	console.log("dese");
	var cid = getCidByName($("#select_c").val());
	var did = getDidByName($("#select_d").val());
	var uid = getUid("uid");
	data2["cid"] = cid;
	data2["did"] =did ;
	data2["uid"] =uid ;
	 $.ajax({
	        url: '/management/admin_User_applyForJoinClub?', // 请求的Controller
	        type: 'post', // 请求方式
	        dataType: 'json', // 发送的数据类型
	        crossDomain: true,
	        data: JSON.stringify(data2),// 要提交给服务端的数据
	        success: function (json) {
	        	console.log(json);
	        }
	        });
}