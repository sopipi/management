function addactivity() {
//    addSuction();
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
        "<td><input id = \"clubname\"list=\"select_activity\" />\n" +
        "<datalist id=\"select_activity\">\n" +
        "<option value=\"软件部\">\n" +
        "<option value=\"SMUACM俱乐部\">\n" +
        "</datalist></td>\n" +
        "</tr>\n" +
        "<tr>\n" +
        "<td >活动名称</td>\n" +
        "<td><input id = \"aname\" type=\"text\"></td>\n" +
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
        "<td><input  id=\"aintro\"  type=\"text\"></td>\n" +
        "</tr>\n" +
        "</tr>";
    html += "<tr>\n" +
        "<td bgcolor=\"#FFFFFF\" style=\"text-align: center;\" colspan=\"2\">\n" +
        "<input type=\"submit\" name=\"BtnYes2\" onclick=\"addSuction()\" value=\"确认提交\" id=\"BtnYes2\" style=\"height:26px;width:100px;\">\n" +
        "&nbsp;</td>\n" +
        "</tr>";
    html += "</tbody>\n" +
        "          </table>\n" +
        "\t</div>";
    var comment = $("div.right");
    comment.html(html);
}

/**
 * "aname":"computer fix",
	"cid":1,
	"aintro":"this is a introduction for the aciton",
	"aimg":"https://images.cnblogs.com/cnblogs_com/zoey686/1581380/o_191103075448%E5%A3%81%E7%BA%B81.jpeg",
	"startTime": "",
	"endTime":""
 * @returns
 */
function getAText( ) {
	var  aname =$("#aname").val();
	var  cname =$("#clubname").val(); 
	var  cid = getCidByName(cname);
	var  aintro =$("#aintro").val(); 
	var startTime = new Date($("#start_time").val()).getTime();
	var endTime = new Date($("#end_time").val()).getTime();
	var data1 = {};
	  /**
     * "aname":"computer fix",
	"cid":1,
	"aintro":"this is a introduction for the aciton",
	"aimg":"https://images.cnblogs.com/cnblogs_com/zoey686/1581380/o_191103075448%E5%A3%81%E7%BA%B81.jpeg",
	"startTime": "",
	"endTime":""
     */
	 data1["aname"] = aname;
	 data1["aImg"] = "https://images.cnblogs.com/cnblogs_com/zoey686/1581380/o_191103075448%E5%A3%81%E7%BA%B81.jpeg";
	 data1["cname"] = cname;
	 data1["cid"] = cid;
	 data1["aintro"] = aintro;
	 data1["startTime"] = startTime;
	 data1["endTime"] = endTime;
	 console.log(data1);
	 return data1;
}
function addSuction() {
    // 发送异步请求
    var data1 =  getAText();
    $.ajax({
        url: '/management/admin_Department_addVerifyAction?', // 请求的Controller
        type: 'post', // 请求方式
        dataType: 'json', // 发送的数据类型
        crossDomain: true,
        data: JSON.stringify(data1),// 要提交给服务端的数据
        success: function (json) { // 请求成功后如何处理结果?，json其实就是服务端返回的响应内容
            console.log(json); // 打印到控制看一看


           
        }
    });
}

function getCidByName(name) {
	var data1 ={};
	var a;
	data1["cname"] = name;
	$.ajax({
        url: '/management/admin_Club_getCidByName?', // 请求的Controller
        type: 'post', // 请求方式
        dataType: 'json', // 发送的数据类型
        crossDomain: true,
        async:false,
        data: JSON.stringify(data1),// 要提交给服务端的数据
        success: function (json) { // 请求成功后如何处理结果?，json其实就是服务端返回的响应内容
        	console.log("俱乐部信息");
            console.log(json); // 打印到控制看一看
            console.log(json.clubInfo.cid);
            a =  json.clubInfo.cid;
            
        }
    });
	 return a;
}

function getDidByName(name) {
	var data1 ={};
	var a;
	data1["dname"] = name;
	$.ajax({
        url: '/management/admin_Department_getDidByName?', // 请求的Controller
        type: 'post', // 请求方式
        dataType: 'json', // 发送的数据类型
        crossDomain: true,
        async:false,
        data: JSON.stringify(data1),// 要提交给服务端的数据
        success: function (json) { // 请求成功后如何处理结果?，json其实就是服务端返回的响应内容
        	console.log("部门信息");
            console.log(json); // 打印到控制看一看
            console.log(json.DepartmentInfo.did);
           a = json.DepartmentInfo.did;
            
        }
    });
	 return a;
}