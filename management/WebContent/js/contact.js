function login() {
	var data2 = {};
	var uid = $("#uid").val();
	var password = $("#password").val();
	console.log(uid);
	console.log(password);
	 data2["uid"] = uid;//封装一个对象
	 data2["password"] = password;//封装一个对象
	 $.ajax({
	        url: '/management/admin_User_login?', // 请求的Controller
	        type: 'post', // 请求方式
	        dataType: 'json', // 发送的数据类型
	        crossDomain: true,
	        data: JSON.stringify(data2),// 要提交给服务端的数据
	        success: function (json) {
	        	console.log(json);
	        	if(json.flag) {
	        		var url = "management_home/index.html?uid=" +uid; 
	        		window.open(url);
	        		console.log("yes");
	        	}
	        }
	        });
	 	

}

function toRegist() {
	var url = "information.html"; 
	window.open(url);
}

function regist() {
	var data1={};
	/**
	 *  "uid":"201731104180",
            "phone":"13477178888",
            "uname":"ZhangYu",
            "IDCard":"421087199999999999",
            "faculty":"Computer",
            "className":"Software1701",
            "heardImg":"https://images.cnblogs.com/cnblogs_com/zoey686/1581380/o_191103075456%E5%A3%81%E7%BA%B82.jpeg",
            "password":"123456",
            "sex":"female"
	 */
	data1["uid"] = $("#uid").val();
	data1["phone"] = $("#phone").val();
	data1["uname"] = $("#uname").val();
	data1["IDCard"] ="";
	data1["faculty"] = $("#faculty").val();
	data1["className"] = $("#className").val();
	data1["password"] = $("#password").val();
	data1["sex"] = $("#sex").val();
	data1["heardImg"] = "https://images.cnblogs.com/cnblogs_com/zoey686/1581380/o_191103075456%E5%A3%81%E7%BA%B82.jpeg";
	console.log(data1);
	 $.ajax({
	        url: '/management/admin_User_register?', // 请求的Controller
	        type: 'post', // 请求方式
	        dataType: 'json', // 发送的数据类型
	        crossDomain: true,
	        data: JSON.stringify(data1),// 要提交给服务端的数据
	        success: function (json) {
	        	console.log(json);
	        	if(confirm("注册成功?")) {
	        		var url = "contact.html"; 
	        		window.open(url);
	        	}
	        }
	        });
}
