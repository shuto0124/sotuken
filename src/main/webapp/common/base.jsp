<%-- 共通テンプレート --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
            <style>
            
				html, body {
                          margin: 0;
                          padding: 0;
                  }
				
 
 
            </style>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
	crossorigin="anonymous">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/sotuken.css">
<title>${param.title}</title>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
${param.scripts}
</head>
<body>
	<header class="py-3 bg-light border-bottom w-100 text-center">
         <h1 class="h4 m-0">${param.title}</h1>
    </header>



	<div id="wrapper" class="container">

 
		<div class="row justify-content-center">
			        <main class="col-9" style="min-height: 700px;"> ${param.content} </main>
		</div>
		<footer class="py-2 bg-dark bg-opacity-10 border-top border-3 align-bottom">
			<c:import url="/common/footer.jsp" />
		</footer>
 
	</div>
	
<script>
document.addEventListener("DOMContentLoaded", function() {

    const checkbox = document.getElementById("tableStatus");
    const statusText = document.getElementById("statusText");

    if (checkbox && statusText) {
        checkbox.addEventListener("change", function() {
            statusText.textContent =
                this.checked ? "停止" : "開始";
        });
    }

});
</script>
	
</body>
</html>