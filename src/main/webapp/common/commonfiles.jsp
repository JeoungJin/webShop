<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<script
  src="https://code.jquery.com/jquery-3.6.4.min.js" ></script>
<script>
    var flag = true;

    $(window).on('beforeunload', function() {
    	location.href = "../first";
        return windowClose();
    });

    $(document).keydown(function(e) {
        var key = (e) ? e.keyCode : event.keyCode;
        //alert(key)
        if(e.ctrlKey){
            //이걸로 컨트롤키 뽑을 수 있음
        }
        if(e.altKey){
            //이걸로 알트키 뽑을 수 있음
        }
        if(e.ctrlKey && e.keyCode == 82){
            flag = false;
            console.log("컨트롤 + R");
        }
        if(e.keyCode == 116){
            flag = false;
            console.log("F5");
        }
        if(e.keyCode == 115){
            console.log("F4");
        }
        // ctrl = 17
        // alt = 18
        // r == 82
        // f4 = 115
        // f5 = 116
        // backspace = 8
    });

    //새로고침이나 X 표시 누르면 무조건 동작
    //return String 을 할 경우 멈춰 세울순 있으나 동작 자체는 무조건 하므로 막을 방법이 없음
    //F5, ctrl + r 일때 빼고 모든 동작 시켜야 할듯
    //https://developer.mozilla.org/ko/docs/Web/API/Window/beforeunload_event
    var windowClose = function(e){
       // var agent = navigator.userAgent.toLowerCase();
        console.log(flag);
        if(flag){
            console.log("로그아웃");
            goLogout();
        }else{
            console.log("새로고침");
        }

        /*if(agent.indexOf('chrome')!= -1){
            console.log("크롬");
            //return "종료 하시겠습니까?";
        }else{
            console.log("크롬 외 브라우저");
            //return "종료 하시겠습니까?";
        }*/
    }
    /*
    setInterval(keepAlive,1000);
	
    function keepAlive(){
        $.ajax({
            type:"POST"
            , dataType:'text'
            , url:"/test/was/keepAlive"
            , success : function(data){

            },error:function(x,error){
                alert("처리중 오류가 발생했습니다.");
            }
        });
    }*/

    function goLogout(){
        $.ajax({
            type:"POST"
            , dataType:'text'
            , url:"../auth/logout.do"
            , success : function(data){

            },error:function(x,error){
                alert("처리중 오류가 발생했습니다.");
            }
        });
    }

    $(document).on('mousedown', function() {
        if ((event.button == 2) || (event.which == 3)) {
            console.log("마우스 우클릭");
        }
    });
</script> 



 