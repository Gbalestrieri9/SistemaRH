package enums;

import org.springframework.core.NestedExceptionUtils;

public enum ErrorCode {


    VAGA_OCUPADA("A vaga % já está ocupada e não pode ser preenchida por outro candidato.", "A vaga já está ocupada e não pode ser preenchida por outro candidato."),
    VAGA_AVALIADOR("Não é permitido atribuir uma vaga para um usuário do tipo AVALIADOR.", "Não é permitido atribuir uma vaga para um usuário do tipo AVALIADOR."),
    OUTRO_ERRO("Outro erro", "Erro desconhecido");

    private final String message;
    private final String customMessage;

    ErrorCode(String message, String customMessage) {
        this.message = message;
        this.customMessage = customMessage;
    }

    public static ErrorCode fromMessage(String message) {
        for (ErrorCode code : ErrorCode.values()) {
            if (message.contains(code.getMessage())) {
                return code;
            }
        }
        return OUTRO_ERRO;
    }

    public String getMessage() {
        return message;
    }

    public String getCustomMessage() {
        return customMessage;
    }
}
