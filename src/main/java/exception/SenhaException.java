package exception;

import util.ConstantesUtil;

public class SenhaException extends Throwable {

    public SenhaException(String mensagem) {
        super(mensagem);
    }
    public SenhaException() {
        super(ConstantesUtil.MENSAGEM_ERRO_NOME_INVALIDO);
    }
}
