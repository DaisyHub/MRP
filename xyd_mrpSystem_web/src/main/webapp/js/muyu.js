new_element=document.createElement("script");
new_element.setAttribute("type","text/javascript");
new_element.setAttribute("src","notie_tips.js");// 在这里引入了notie_tips.js
 //document.body.appendChild(new_element);

function getRootPath() {
	// 获取当前网址，如： http://localhost:80/xyd/index.jsp
	var curPath = window.document.location.href;
	// 获取主机地址之后的目录，如： xyd/index.jsp
	var pathName = window.document.location.pathname;
	var pos = curPath.indexOf(pathName);
	// 获取主机地址，如： http://localhost:80
	var localhostPaht = curPath.substring(0, pos);
	// 获取带"/"的项目名，如：/xyd
	var projectName = pathName
			.substring(0, pathName.substr(1).indexOf('/') + 1);
	// return(localhostPaht+projectName);
	return localhostPaht + projectName;
}

//len:生成几位数据的UUID 	radix：进制位，如2进制，10进制，
function uuid(len, radix) {
	var chars = '0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz'.split('');
	var uuid = [],
		i;
	radix = radix || chars.length;

	if(len) {
		for(i = 0; i < len; i++) uuid[i] = chars[0 | Math.random() * radix];
	} else {
		var r;

		uuid[8] = uuid[13] = uuid[18] = uuid[23] = '-';
		uuid[14] = '4';

		for(i = 0; i < 36; i++) {
			if(!uuid[i]) {
				r = 0 | Math.random() * 16;
				uuid[i] = chars[(i == 19) ? (r & 0x3) | 0x8 : r];
			}
		}
	}

	return uuid.join('');
}
