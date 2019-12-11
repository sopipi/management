
var data1 = [];//存储个人信息
var club = [];//存储部门信息
function cyrm() {
	
	console.log("1");
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
    $.each(club, function (index, obj) {
    	i=index+1;
    	 uname = obj.uname;
      	uid= obj.uid;
      	sex = obj.sex;
      	phone = obj.phone;
        html += "<tr>" +
            "<td style=\"text-align: center; width:5%;\" id=\"department_uesr_no_"+i+"\">"+i+"</td>" +
            "<td style=\"text-align: center; width:10%;\" id=\"department_uesr_name_"+i+"\">"+uname+"</td>" +
            "<td style=\"text-align: center; width:15%;\" id=\"department_uesr_ID_"+i+"\">"+uid+"</td>" +
            "<td style=\"text-align: center; width:5%;\" id=\"department_uesr_sex_"+i+"\">"+sex+"</td>" +
            "<td style=\"text-align: center; width:15%;\" id=\"department_uesr_phone_"+i+"\">"+phone+"</td>" +
            "<td style=\"text-align: center; width:15%;\" id=\"department_uesr_joinTime_"+i+"\">1998_2017</td>" +
            "<td style=\"text-align: center; width:10%;\"><input list=\"department_uesr_position_"+i+"\" value=\"普通成员\" style=\"width: 100%\">" +
            "<datalist id=\"department_uesr_position_"+i+"\">" +
            "<option  value=\"普通成员\">" +
            "<option value=\"副部长\">" +
            "<option value=\"部长\">" +
            "</datalist></td>" +
            "<td style=\"text-align: center; width:10%;\" id=\"department_uesr_delete\"><button>删除</button></td>" +
            "</tr>\n";
    });
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


function getMoreInfo1(){//获取用户的所有社团信息
	console.log("2");
	var uid =  getUid("uid");
	 console.log("ceshji");
	 console.log("获取用户的社团信息"+uid);
	 var data2 = {};
	 data2["uid"] = uid;//封装一个对象
	 $.ajax({
	        url: '/management/admin_User_showUserClubs?', // 请求的Controller
	        type: 'post', // 请求方式
	        dataType: 'json', // 发送的数据类型
	        crossDomain: true,
	        async: false,
	        data: JSON.stringify(data2),// 要提交给服务端的数据
	        success: function (json) {
	        	 console.log("获取用户的社团信息成功");
	        	console.log(json);
	        	 $.each(json, function (i, obj ) {
	        		 //1: {cid: 1, did: 1, joinTime: {…}, position: "普通成员", uid: "201731104127"}
	            		data1["cid"] = obj.cid;
	                 	data1["did"] = obj.did;
	                 	data1["position"] = obj.position;
	            });
	        	
	        	 
	        }
	        });
	 console.log(data1);
	 getClubUser(data1.did);
}

function getUid(name) {//从路径获取uid
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
	var r = window.location.search.substr(1).match(reg);//匹配目标参数
	if (r != null) return unescape(r[2]);//返回参数值
	return null;
	};
	
	
	
function getClubUser(did) {//获取所有的部门成员
	console.log("3");
	 console.log("获取所有成员");
	 var data2 = {};
	 data2["did"] = did;//封装一个对象
	 $.ajax({
	        url: '/management/admin_Department_showDepartmentUser?', // 请求的Controller
	        type: 'post', // 请求方式
	        dataType: 'json', // 发送的数据类型
	        crossDomain: true,
	        data: JSON.stringify(data2),// 要提交给服务端的数据
	        success: function (json) {
	        	console.log("CLUB");
	        	console.log(json);
	        	 $.each(json, function (index, item) {
	            	 $.each(item, function (i, obj ) {
	            		 var data3=[];
	 	        		/**
	 	        		 *  "DepartmentUser": {
	             "IDCard": "421087199999999999",
	             "className": "Software1701",
	             "faculty": "Computer",
	             "heardImg": "https://images.cnblogs.com/cnblogs_com/zoey686/1581380/o_191103075448%E5%A3%81%E7%BA%B81.jpeg",
	             "password": "111111",
	             "phone": "13477178888",
	             "sex": "female",
	             "uid": "201731104180",
	             "uname": "ZhangYu"
	 	        		 */
	            		 data3["uname"] = obj.uname;
	                 	data3["uid"] = obj.uid;
	                 	data3["sex"] = obj.sex;
	                 	data3["phone"] = obj.phone;
	                 	console.log(data3);
	                 	club[index] = data3;
	                 });
		            });
	        	 console.log(club);
	        	 cyrm();
	        }
	        });
}