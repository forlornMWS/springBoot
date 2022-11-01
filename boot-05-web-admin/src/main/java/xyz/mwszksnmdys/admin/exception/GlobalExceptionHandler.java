package xyz.mwszksnmdys.admin.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/*处理异常*/
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({ArithmeticException.class, NullPointerException.class}) // 异常处理器
    public String handleArithmeticException(Exception e){
        log.error("异常是", e);
        return "login";
    }
}
