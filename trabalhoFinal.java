import java.util.ArrayList;
import java.util.Random;

public class trabalhoFinal {

    public static void main(String[] args) {

        ArrayList<Integer> geracaoInicial = new ArrayList<>();

        multiplicadorDeGeracoes(geracaoInicial, 5);

    }

    public static ArrayList<Integer> gerarVetores(int tamanho) {
        ArrayList<Integer> geracaoInicial = new ArrayList<>();
        Random random = new Random();

        for (int i = 1; i < tamanho + 1; i++) {
            Integer vetor = random.nextInt(101);
            geracaoInicial.add(vetor);
        }

        return geracaoInicial;
    }

    public static ArrayList<String> conversaoDecimalBinario(ArrayList<Integer> geracaoInicial) {
        ArrayList<String> geracaoBinaria = new ArrayList<>();

        for (int numero : geracaoInicial) {
            String binario = Integer.toBinaryString(numero);
            geracaoBinaria.add(binario);
        }

        System.out.println(geracaoBinaria);
        return geracaoBinaria;
    }

    public static Integer conversaoBinarioDecimal(String binario) {
        return Integer.parseInt(binario, 2);
    }

    public static double conta(int x) {
        return Math.abs(x * Math.sin(Math.sqrt(Math.abs (x))));
    }

    public static String cruzamentoBinarios(String binario1, String binario2) {
        Random random = new Random();

        int tamanhoDoBinario1 = binario1.length();
        int tamanhoDoBinario2 = binario2.length();

        if (tamanhoDoBinario1 > tamanhoDoBinario2) {
            int diferenca = tamanhoDoBinario1 - tamanhoDoBinario2;

            for (int i = 0; i < diferenca; i++) {
                binario2 = "0" + binario2;
            }

        } else if (tamanhoDoBinario2 > tamanhoDoBinario1) {
            int diferenca = tamanhoDoBinario2 - tamanhoDoBinario1;

            for (int i = 0; i < diferenca; i++) {
                binario1 = "0" + binario1;
            }
        }

        int numeroCorte = random.nextInt(tamanhoDoBinario1);

        String[] listaB1 = binario1.split("");
        String binario1Parte1 = "";

        String[] listaB2 = binario2.split("");
        String binario2Parte2 = "";

        for (int i = 0; i < listaB1.length; i++) {
            if (i < numeroCorte) {
                binario1Parte1 = binario1Parte1 + listaB1[i];
            }
        }

        for (int i = 0; i < listaB2.length; i++) {
            if (i >= numeroCorte) {
                binario2Parte2 = binario2Parte2 + listaB2[i];
            }
        }

        return binario1Parte1 + binario2Parte2;
    }

    public static ArrayList<String> gerarNovaGeracao(ArrayList<String> geracaoBinaria) {
        Random random = new Random();

        int tamanhoGeracaoBinaria  = geracaoBinaria.size();
        ArrayList<Integer> selecionados = new ArrayList<>();
        ArrayList<String> novaGeracao = new ArrayList<>();
        ArrayList<Integer> tempNumerosSelecionados = new ArrayList<>();
        ArrayList<Double> tempResultados = new ArrayList<>();
        Integer vencedor;

        for (int i = 0; i < 50; i++) {

            for (int j = 0; j < 2; j++) {

                for (int k = 0; k < 2; k++) {

                    int numeroSelecionado = random.nextInt(tamanhoGeracaoBinaria);
                    String binario = geracaoBinaria.get(numeroSelecionado);

                    int numeroInteiro = conversaoBinarioDecimal(binario);
                    tempNumerosSelecionados.add(numeroInteiro);
                }

                for (Integer tempNumerosEscolhido : tempNumerosSelecionados) {
                    double resultado = conta(tempNumerosEscolhido);
                    tempResultados.add(resultado);
                }

                vencedor = tempResultados.get(0) >= tempResultados.get(1) ? tempNumerosSelecionados.get(0) : tempNumerosSelecionados.get(1);
                selecionados.add(vencedor);

                tempResultados.clear();
                tempNumerosSelecionados.clear();

                if (selecionados.size() > 1) {
                    String binario1 = Integer.toBinaryString(selecionados.get(0));
                    String binario2 = Integer.toBinaryString(selecionados.get(1));

                    String numeroCruzado = cruzamentoBinarios(binario1, binario2);
                    novaGeracao.add(numeroCruzado);

                    selecionados.clear();
                }

            }

        }

        System.out.println();
        System.out.println("Nova Geração: ");
        System.out.println(converterNovaGeracao(novaGeracao));
        System.out.println(novaGeracao);

        return novaGeracao;
    }

    public static ArrayList<Integer> converterNovaGeracao(ArrayList<String> geracaoBinaria) {
        ArrayList<Integer> novaGeracaoDecimal = new ArrayList<>();

        for (String s : geracaoBinaria) {
            novaGeracaoDecimal.add(conversaoBinarioDecimal(s));
        }

        return novaGeracaoDecimal;
    }

    public static ArrayList<Integer> mutacao(ArrayList<String> geracao, int porcentagem) {
        ArrayList<String> novaGeracaoBinaria = new ArrayList<>();
        ArrayList<String> numerosQueSofreramMutacao = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < geracao.size(); i++) {
            Integer numeroDaPorcentagem = random.nextInt(101);

            if (numeroDaPorcentagem <= porcentagem) {
                Integer numeroMutado = random.nextInt(geracao.get(i).length());


                String[] binarioSeparado = geracao.get(i).split("");
                String binario = "";

                for (int j = 0; j < binarioSeparado.length; j++) {
                    if (j == numeroMutado && binarioSeparado[j].equals("1")) {
                        binarioSeparado[j] = "0";
                    }  else if (j == numeroMutado && binarioSeparado[j].equals("0")) {
                        binarioSeparado[j] = "1";
                    }

                    binario = binario + binarioSeparado[j];
                }
                novaGeracaoBinaria.add(binario);
                numerosQueSofreramMutacao.add(binario);

            } else {
                novaGeracaoBinaria.add(geracao.get(i));
            }

        }

        System.out.println();
        System.out.println("Nova Geração após a mutação: ");
        System.out.println(converterNovaGeracao(novaGeracaoBinaria));
        System.out.println(novaGeracaoBinaria);
        System.out.println();
        System.out.println("Números que sofreram mutação");
        System.out.print("Em Decimal: ");
        System.out.println(converterNovaGeracao(numerosQueSofreramMutacao));
        System.out.println("Em Binário: " + numerosQueSofreramMutacao);
        System.out.println();
        System.out.println("===============================================================================");
        System.out.println();

        return converterNovaGeracao(novaGeracaoBinaria);
    }

    public static void multiplicadorDeGeracoes(ArrayList<Integer> geracaoInicial, int vezes) {

        for (int i = 0; i < vezes; i++) {
            System.out.println();
            System.out.println("============================== Geração " + (i + 1) + " ==============================");
            System.out.println();
            System.out.println("Geração Inicial: ");

            if (geracaoInicial == null || geracaoInicial.isEmpty()) {
                geracaoInicial = gerarVetores(50);
            }
            System.out.println(geracaoInicial);
            ArrayList<String> geracaoBinaria = conversaoDecimalBinario(geracaoInicial);
            ArrayList<String> novaGeracao = gerarNovaGeracao(geracaoBinaria);

            geracaoInicial = mutacao(novaGeracao, 1);
        }

    }

}
