function success(msg) {
	notie.alert(1, msg, 2);
}

function warning(msg) {
	notie.alert(2, msg, 2);
}

function error(msg) {
	notie.alert(3,msg, 2);
}

function info(msg) {
	notie.alert(4, msg, 2);
}

function confirm(tip,msg) {
	notie.confirm(
		tip,
		'确认', '取消', function() {
			notie.alert(1, msg, 2);
		});
}

function input(tip) {
	notie.input(tip, '确认', '取消',
			'email', 'name@example.com', 
			function(value_entered) {
				notie.alert(1, 'You entered: ' + value_entered, 2);
			});
}