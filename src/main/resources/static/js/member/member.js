$(document).ready(function(){
    $("#deleteForm").click(function(){
        if(confirm("정말 삭제하시겠습니까?")){
            $(this).attr("method","post");
            $(this).attr("action","/board/delete");
        }else{
            return false;
        }

    }); // deleteForm end

   $("#listForm").click(function(){
       $(this).attr("action","/board/list");
   });

        // 목록버튼 클릭시 넘겨줄 파라미터 값들
        var currentUrl = location.href;
        var queryString = currentUrl.split('?')[1];
        if(queryString){
            var params = queryString.split('&');
            for(var i = 0; i<params.length; i++){
                var param = params[i].split('=');
                if(param[0] && param[1]){
                    var paramName = decodeURIComponent(param[0]);
                    var paramValue = decodeURIComponent(param[1]);
                    var hiddenInput = document.createElement("input");
                    hiddenInput.setAttribute("type","hidden");
                    hiddenInput.setAttribute("name",paramName);
                    hiddenInput.setAttribute("value",paramValue);
                    document.getElementById("listForm").appendChild(hiddenInput);
                }
            }
        }
        console.log("queryString : " +queryString)





});// load end