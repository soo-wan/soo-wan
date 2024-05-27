<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
//062_Forward_do.jsp

String sAge = request.getParameter("age");
int age = Integer.parseInt(sAge);

// 19세 이하는 되돌아감. 19세 이상이면 통과페이지로 이동(20세미만이므로 입장이 불가합니다 라는 경고창 표시)
// 20세 미만일때 "입장이 불가합니다" 라는 alert 창 표시하고 되돌아갑니다.

if(age<20){
%>
	<script type="text/javascript">
		alert("20세 미만이므로 입장이 불가합니다");
		histort.go(-1); // 뒤로 버튼을 클릭한 효과
		// location.href='061_ForwardForm.jsp';
	</script>
	<!-- html head body 등이 없다고해서 다른태그를 사용하지 못하는게 아닙니다. 그들은 양식일뿐 html 태그는
	어디서든 사용이 가능합니다. 자바스크립트 포함 -->	
<%
}else{
	//063_ForwardResult.jsp 로 이름과 나이를 갖고 갑니다.
	
	//request 객체에는 Attribute 라는 저장소(HashMap 형식과 비슷한 멤버변수)가 있습니다
	// 전달할 데이터를 Attribute 에다가 각 자료의 이름과 값을 같이 저장하고,
	// forward(이동)하면 목적지에 해당 데이터가 같이 이동합니다.
	
	// Attribute 라는 저장소에 "name" 이라는 이름으로 "홍길동" 이라는 값을 저장해두고 이동(forward)합니다.
	// 이때 현재 페이지의 request 와 response도 같이 이동합니다(forward 의 특징)
	request.setAttribute("name","홍길동"); // "name"이 Key, "홍길동"이 Value
	
	
	// request 와 response 을 담고 이동(forward)할 객체를 생성합니다.
	RequestDispatcher rd = request.getRequestDispatcher("063_ForwardResult.jsp"); 
	// 현재의 request 와 response 를 갖고 객체에 설정된 목적지로 이동
	rd.forward(request, response);
	
	// 현재 페이지의 request 객체의 수명은 forward 로 전달될 다음 페이지까지 입니다
	// forward 방식으로 이동된 페이지는 한글에 대한 "인코딩 작업이 필요가 없습니다."
	
}
%>