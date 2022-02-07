package hello.advanced.trace.template.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class AbstractTemplate {

    public void execute()  // 변하지 않는 부분!
    {
        long startTime = System.currentTimeMillis();
        //비즈니스 로직 실행
        call(); // 상속
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("resultTime={}",resultTime);
    }

    protected  abstract  void call(); // 변하는 부분 자식 클래스로 해결!
}
