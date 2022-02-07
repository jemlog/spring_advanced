package hello.advanced.trace.template;

import hello.advanced.trace.TraceStatus;
import hello.advanced.trace.logtrace.LogTrace;
import lombok.extern.java.Log;


// 추상 클래스 내부에서 인터페이스처럼 틀만 제공해줄수 있다. 상속하는 객체들이 그 함수를 구현하면 된다!!
public abstract class AbstractTemplate<T> {

    private final LogTrace trace;

    public AbstractTemplate(LogTrace trace)
    {
        this.trace = trace;
    }

    public T execute(String message)
    {
        TraceStatus status = null;
        try {  // try 블록 안에서만 유효
            // 클린코드 3장 : try catch 구문 안의 코드는 한줄로 줄이자. 외부로 메서드 추출 해주는게 좋음
            status = trace.begin(message);
            //로직 호출
            T result = call();

            trace.end(status);
            return result;
        }catch (Exception e)
        {
            trace.exception(status,e);  // e를 throw 안해주면 에러가 발생하지 않는다. 정상 흐름으로 변하면 안된다.
            throw e; // 예외를 꼭 다시 던져줘야 한다.
        }
    }

    protected abstract T call();
}
