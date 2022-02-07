package hello.advanced.trace.strategy;

import hello.advanced.trace.strategy.code.strategy.ContextV2;
import hello.advanced.trace.strategy.code.strategy.Strategy;
import hello.advanced.trace.strategy.code.strategy.StrategyLogic1;
import hello.advanced.trace.strategy.code.strategy.StrategyLogic2;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class ContextV2Test {
    @Test
    void strategyV1()
    {
        // 미리 조립해놓는것이 아니라 파라미터로 전략을 전달한다!
        // 컨텍스트 실행마다 인수로 전달!
        ContextV2 contextV2 = new ContextV2();
        contextV2.execute(new StrategyLogic1());
        contextV2.execute(new StrategyLogic2());
    }

    @Test
    void strategyV2()
    {
        // 미리 조립해놓는것이 아니라 파라미터로 전략을 전달한다!
        // 컨텍스트 실행마다 인수로 전달!
        ContextV2 contextV2 = new ContextV2();
        contextV2.execute(new Strategy() {
            @Override
            public void call() {
                log.info("비즈니스 로직1 실행"); // 코드 조각을 넘긴다!
            }
        });
        contextV2.execute(new Strategy() {
            @Override
            public void call() {
                log.info("비즈니스 로직2 실행");
            }
        });
    }
    @Test
    void strategyV3()
    {
        // 미리 조립해놓는것이 아니라 파라미터로 전략을 전달한다!
        // 컨텍스트 실행마다 인수로 전달!
        ContextV2 contextV2 = new ContextV2();
        contextV2.execute(()->log.info("비즈니스 로직1 실행"));
        contextV2.execute(()-> log.info("비즈니스 로직2 실행"));
    }
}
