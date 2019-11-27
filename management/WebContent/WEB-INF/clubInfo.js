$(document).ready(function () {
//	获取cid参数
function getCid(name) {
var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
var r = window.location.search.substr(1).match(reg);//匹配目标参数
if (r != null) return unescape(r[2]);//返回参数值
return null;
};
var cid = getCid('cid');
console.log(cid);


});