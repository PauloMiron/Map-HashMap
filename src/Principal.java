

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Principal {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Caminho do arquivo: ");
        String caminhoArquivo = scanner.nextLine();

        Map<String,Integer> contagem = new HashMap<>();


        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
            String contaLinha = br.readLine();

            while (contaLinha != null) {

                String[] vect = contaLinha.split(",");
                String nomeCandidato = vect[0];
                Integer quantidadeVoto = Integer.parseInt(vect[1]);

                if (contagem.containsKey(nomeCandidato)){
                    int soma = contagem.get(nomeCandidato);
                    contagem.put(nomeCandidato,quantidadeVoto + soma);
                } else {
                    contagem.put(nomeCandidato,quantidadeVoto);
                }

                contaLinha = br.readLine();
            }

            for (String cont: contagem.keySet()){
                System.out.println(cont + ": "+contagem.get(cont));
            }


        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
