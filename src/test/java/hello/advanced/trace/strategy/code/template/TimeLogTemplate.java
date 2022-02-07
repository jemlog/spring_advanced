package hello.advanced.trace.strategy.code.template;

import hello.advanced.trace.strategy.code.strategy.Strategy;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TimeLogTemplate {
    public void execute(Callback callback) // 템플릿 역할을 하는 context 스프링에서 주구장창 사용하는 패턴이 전략패턴!!!
    {
        long startTime = System.currentTimeMillis();
        //비즈니스 로직 실행
        callback.call(); // 상속
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("resultTime={}",resultTime);
    }

}
