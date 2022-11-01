package xyz.mwszksnmdys.admin.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FORBIDDEN, reason = "用户数量太多")
public class MaxUserNumberExceededException extends RuntimeException {
    public MaxUserNumberExceededException(){}
    public MaxUserNumberExceededException(String message){
        super(message);
    }
}
