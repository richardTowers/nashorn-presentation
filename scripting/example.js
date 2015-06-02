print($EXEC("cat example.js"));
var bytes = Java.type('java.security.MessageDigest').getInstance("MD5").digest($OUT.getBytes("UTF-8"));
var hex = '';
for (var index in bytes) {
	hex += ('0' + (bytes[index] & 0xFF).toString(16)).substr(-2);
}
print(hex);
