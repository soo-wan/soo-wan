<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table cellspacing="1" bgcolor="black" width="500" >
	<%
		// 이 영역에 tr 한번 td 한번씩만 써서 5행 5열의 테이블을 완성하세요. 반복실행문 이용 
		for(int i =1; i<=5; i++){
			out.print("<tr bgcolor='white' height='80' align='center'>");
			for(int j=1; j <=5; j++){
				out.print("<td>");
				out.print(i +"행" + j + "열");
				out.print("</td>");
			}
			out.print("</tr>");
		}
		%>
	</table>
		
		
		
        <%-- <% 
        for (int i = 0; i < 5; i++) {
            %>
            <tr>
            <% 
            for (int j = 0; j < 5; j++) {
                %>
                <td>행 <%= i+1 %>, 열 <%= j+1 %></td>
                <% 
            } 
            %>
            </tr>
            <% 
        } 
        %> --%>

</body>
</html>