package exception;

import enums.ErrorCode;
import org.springframework.core.NestedExceptionUtils;
import org.springframework.lang.Nullable;

public class NestedRuntimeException extends RuntimeException {

    public static void ErroSql (Exception e){
        ErrorCode errorCode = ErrorCode.fromMessage(e.getMessage());
        System.out.println(errorCode.getMessage());
    }
}
