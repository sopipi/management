var oldPwd;
var data1=[];//存储个人信息
var club = [];//存储社团信息
var department = [];//存储部门信息
$(document).ready( getTxt());
function getUid(name) {//从路径获取uid
var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
var r = window.location.search.substr(1).match(reg);//匹配目标参数
if (r != null) return unescape(r[2]);//返回参数值
return null;
};

function getTxt(){//根据uid获取信息
	var name = "uid";
	var uid = getUid(name);
	 var data2 = {};
	data1=[];
	    data2["uid"] = uid;//封装一个对象
		$.ajax({
	        url: '/management/admin_User_showInfo?', // 请求的Controller
	        type: 'post', // 请求方式
	        dataType: 'json', // 发送的数据类型
	        crossDomain: true,
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
	            	 getMoreInfo(uid);
	            	 
	        	}
	        });
		
		
}

function resetPwd() {//获取密码
	var data2 = {};
	var uid = $("span#UserIds").text();
	var newPwd = $("#Pwd1").val();
	var newPwd2 = $("#Pwd2").val();
	if(newPwd != newPwd2) {
		$("#CompareValidator1").css("display","block");
	}
	console.log(uid);
	console.log(newPwd);
	console.log(oldPwd);
	 data2["uid"] = uid;//封装一个对象
	 data2["newPwd"] = newPwd;//封装一个对象
	 data2["oldPwd"] = oldPwd;//封装一个对象
	 $.ajax({
	        url: '/management/admin_User_changePwd?', // 请求的Controller
	        type: 'post', // 请求方式
	        dataType: 'json', // 发送的数据类型
	        crossDomain: true,
	        data: JSON.stringify(data2),// 要提交给服务端的数据
	        success: function (json) {
	        	if(confirm("修改成功?")) {
	        		$("#BtnYes2").css("display","none");
	        	}
	        }
	        });
	 
}

function setInfo(data1) {//渲染数据
	console.log("chenggongle xuanran ");
	$("#UserIds").text(data1.uid);
	$("#Unit").text(data1.faculty);
	$("#UserName").text(data1.uname);
	$("#Sex").text(data1.sex);
}

function getMoreInfo(uid){//获取用户的所有社团信息
	 console.log("ceshji");
	 console.log("获取用户的社团信息");
	 var data2 = {};
	 data2["uid"] = uid;//封装一个对象
	 $.ajax({
	        url: '/management/admin_User_showUserClubs?', // 请求的Controller
	        type: 'post', // 请求方式
	        dataType: 'json', // 发送的数据类型
	        crossDomain: true,
	        data: JSON.stringify(data2),// 要提交给服务端的数据
	        success: function (json) {
	        	console.log(json);
	        	 $.each(json, function (i, obj ) {
	        		 //1: {cid: 1, did: 1, joinTime: {…}, position: "普通成员", uid: "201731104127"}
	            		data1["cid"] = obj.cid;
	                 	data1["did"] = obj.did;
	                 	data1["position"] = obj.position;
	            });
	        	 setInfo(data1);
	        }
	        });
}
	