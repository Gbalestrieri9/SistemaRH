import controller.MenuController;
import util.ConstantesUtil;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws SQLException {
        Scanner input = new Scanner(System.in);
        MenuController menu = new MenuController();

        int acaoDigitada;

        boolean executando = true;

        while(executando) {
            try {
                System.out.println("\n---MENU DE CONTROLE---\n"
                        + "1.Se cadastre\n"
                        + "2.Acessar conta\n"
                        + "3.Cadastrar habilidade\n"
                        + "4.Acessar habilidades do candidato\n"
                        + "5.Inserir candidato na vaga\n"
                        + "6.Sair \n");

                System.out.println(ConstantesUtil.MENSAGEM_DIGITAR_NUMERO_MENU);
                acaoDigitada = input.nextInt();
               // input.nextLine();
                System.out.println("\n");

                if(acaoDigitada == 10) {
                    menu.controle(acaoDigitada);
                    executando = false;
                    input.close();
                    System.out.println(ConstantesUtil.MENSAGEM_FINALIZACAO_PROGRAMA);
                } else if(acaoDigitada ==1) {
                    menu.controle(acaoDigitada);
                }
                else {
                    if((acaoDigitada>= 3 && acaoDigitada<=9) && menu != null) {
                        menu.controle(acaoDigitada);
                    }else {
                        menu.controle(2);
                    }
                }
            } catch(Exception e) {
                System.out.println(ConstantesUtil.MENSAGEM_ERRO_MENU);
                input.nextLine();
            }
        }

    }
}
