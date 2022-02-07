package hello.advanced.app.v4;

import hello.advanced.trace.TraceStatus;
import hello.advanced.trace.logtrace.LogTrace;
import hello.advanced.trace.template.AbstractTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderControllerV4 {

    private final OrderServiceV4 orderService;
    private final LogTrace trace;

    @GetMapping("/v4/request")
    public String request(String itemId) // 클린코드 3장 : 함수는 한가지 작업만 해야한다. request 메서드에 try catch를
                                         // 걸었다면 catch 구문에서 메서드가 끝나게 하자. 다른 로직 추가 금지!
    {
        AbstractTemplate<String> template = new AbstractTemplate<String>(trace) {
            @Override
            protected String call() {  // 익명 클래스
                orderService.orderItem(itemId);
                return "ok";
            }
        };
        return template.execute("OrderController.request()");



    }
}
