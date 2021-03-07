package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        basePackages = "hello.core", // bean으로 만들 대상 패키지 지정
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
        // 이번 예제에서 config 정보는 빈으로 등록하지 않는다. 일반 플젝시에는 그냥 포함해도 됨. 예제 코드를 살리기위해서 별도의 조치를 한 것
)
public class AutoAppConfig {

}
