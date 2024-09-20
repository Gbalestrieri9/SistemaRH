package exception;

import enums.ErrorCode;

public class DbException extends RuntimeException {

    public static void ErroSql (Exception e){
        ErrorCode errorCode = ErrorCode.fromMessage(e.getMessage());
        System.out.println(errorCode.getMessage());
    }
}
