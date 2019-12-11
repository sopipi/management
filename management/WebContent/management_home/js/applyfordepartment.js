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
    
    var data = getClubUser1();
    console.log("测试试试1");
    console.log(data);
   $.each(data, function (o, obj ) {
	   console.log("测试试试2"+obj.uid);
	   var dataInfo = getUserTxt(obj.uid);
	   console.log("测试试试3");
	   console.log(dataInfo);
	   i=o+1;
        html += "<tr>" +
            "<td style=\"text-align: center; width:5%;\" id=\"apply_uesr_no_"+i+"\">"+i+"</td>" +
            "<td  style=\"text-align: center; width:10%;\" id=\"apply_uesr_name_"+i+"\">"+dataInfo.uname+"</td>" +
            "<td style=\"text-align: center; width:15%;\" id=\"apply_uesr_ID_"+i+"\">"+dataInfo.uid+"</td>" +
            "<td style=\"text-align: center; width:5%;\" id=\"apply_uesr_sex_"+i+"\">"+dataInfo.sex+"</td>" +
            "<td style=\"text-align: center; width:15%;\" id=\"apply_uesr_phone_"+i+"\">"+dataInfo.phone+"</td>" +
            "<td style=\"text-align: center; width:15%;\" id=\"apply_uesr_applyTime_"+i+"\">2019.3.23</td>" +
            "<td style=\"text-align: center; width:15%;\"><input list=\"apply_uesr_department_"+i+"\" value=\""+obj.cid+"\" style=\"width: 80%\">" +
            "<datalist id=\"apply_uesr_department_"+i+"\">\n" +
            "<option  value=\"研发部\">" +
            "<option value=\"公关部\">" +
            "<option value=\"宣传部\">" +
            "</datalist></td>" +
            "<td style=\"text-align: center; width:25%;\" id=\"apply_uesr_decision_"+i+"\"><button onclick =\"agree(this)\" id=\""+i+"\" value=\""+i+"\">同意</button><button value=\"no\">不同意</button></td>" +
            "</tr>";
   });
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


function getMoreInfo2(){//获取用户的所有社团信息 did 
	var uid =  getUid("uid");
	 console.log("ceshji");
	 console.log("获取用户的社团信息"+uid);
	 var did;
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
	                 	did = obj.did;
	                 	data1["position"] = obj.position;
	            });
	        	
	        	 
	        }
	        });
	 return did;
}

function getUid(name) {//从路径获取uid
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
	var r = window.location.search.substr(1).match(reg);//匹配目标参数
	if (r != null) return unescape(r[2]);//返回参数值
	return null;
	};
	
var data4 = [];
function getClubUser1() {//获取所有的部门成员申请表
	var did = getMoreInfo2();
	 console.log("获取所有成员");
	 var data2 = {};
	
	 data2["did"] = did;//封装一个对象
	 $.ajax({
	        url: '/management/admin_Department_showUserVerify?', // 请求的Controller
	        type: 'post', // 请求方式
	        dataType: 'json', // 发送的数据类型
	        crossDomain: true,
	        async: false,
	        data: JSON.stringify(data2),// 要提交给服务端的数据
	        success: function (json) {
	        	data4 =[];
	        	console.log("CLUB");
	        	console.log(json);
	        	 $.each(json, function (index, item) {
	            		 var data3=[];
	            		 data3["uid"] = item.VerifyClubUser.uid;
	            		 data3["cid"] = item.VerifyClubUser.cid;
	            		 data3["did"] = item.VerifyClubUser.did;
	            		 data4[index] = data3;

	        	 console.log(data2);
	        	 });
	        }
});
	 return data4;
}



function getInfoMore(){
	var data = getClubUser1();
	
}

function getUserTxt(uid){//根据uid获取信息
	 var data2 = {};
	data1=[];
	    data2["uid"] = uid;//封装一个对象
		$.ajax({
	        url: '/management/admin_User_showInfo?', // 请求的Controller
	        type: 'post', // 请求方式
	        dataType: 'json', // 发送的数据类型
	        crossDomain: true,
	        async:false,
	        data: JSON.stringify(data2),// 要提交给服务端的数据
	        success: function (json) {
	        	/**
	        	 * User:
IDCard: "2131231231"
className: "1701"
faculty: "计算机科学与技术"
heardImg: ""
password: "12341234"
phone: ""
sex: "男"
uid: "201731104127"
uname: "梁杰"
	        	 */
	        	console.log("chenggong");
	        	console.log(json);
	        	console.log("遍历数组");   
	            	 $.each(json, function (i, obj ) {
	            		data1["IDCard"] = obj.IDCard;
	                 	data1["className"] = obj.className;
	                 	data1["password"] = obj.password;
	                 	oldPwd = obj.password;
	                 	data1["sex"] = obj.sex;
	                 	data1["uid"] = obj.uid;
	                 	data1["uname"] = obj.uname;
	                 	data1["phone"] = obj.phone;
	                 	data1["faculty"] = obj.faculty;
	            });
	            	 
	        	}
	        });
		
		return data1;
}





function agree(object) {//获取所有的部门成员申请表
	var i = object.value-1;
	console.log(i);
	 console.log(data4);
	 data2={};
	 data2["did"] = data4[i].did;//封装一个对象
	 data2["uid"] = data4[i].uid;//封装一个对象
	 data2["cid"] = data4[i].cid;//封装一个对象
	 console.log(data2);
	 $.ajax({
	        url: '/management/admin_Club_agreeUserVerify?', // 请求的Controller
	        type: 'post', // 请求方式
	        dataType: 'json', // 发送的数据类型
	        crossDomain: true,
	        async: false,
	        data: JSON.stringify(data2),// 要提交给服务端的数据
	        success: function (json) {
	        	console.log(json);
	        }
});
}