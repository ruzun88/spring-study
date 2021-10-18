# Response Body의 동작 원리
MVC 패턴에서는 통상적으로 View level이 리턴될 때는 viewResolver가 동작한다.   
그런데, `@ResponseBody`가 붙게 되면, `HttpMessageConverter`가 동작한다.   
문자는 String converter, 객체는 Jackson converter가 동작한다.