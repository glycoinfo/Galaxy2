//――――――――――――――――――――――――――――――――――――――
// 作成者 るび～/ACCESS R http://www5e.biglobe.ne.jp/~access_r/
//――――――――――――――――――――――――――――――――――――――
function NowLoading(){
	if(document.all){
		document.all("now_loading").style.visibility = 'hidden';
	}else if(document.getElementById){
		document.getElementById("now_loading").style.visibility = 'hidden';
	}
}
if(document.all || document.getElementById){
	document.write('<DIV ID="now_loading">Now Loading...</DIV>');
	window.onload = NowLoading;
}