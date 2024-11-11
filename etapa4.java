import java.util.ArrayList;
import java.util.Random;

public class etapa4 {

    public static void main(String[] args) {

        ArrayList<Integer> geracaoInicial = gerarVetores(50);
        ArrayList<String> geracaoBinaria = conversaoDecimalBinario(geracaoInicial);
        gerarNovaGeracao(geracaoBinaria);

    }

    public static ArrayList<Integer> gerarVetores(int tamanho) {
        ArrayList<Integer> geracaoInicial = new ArrayList<>();
        Random random = new Random();

        for (int i = 1; i < tamanho + 1; i++) {
            Integer vetor = random.nextInt(101);
            geracaoInicial.add(vetor);
        }

        System.out.println(geracaoInicial);
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
                System.out.print(i);
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

        System.out.println();
        System.out.println("============ Binários cruzados ============");
        System.out.println();
        System.out.println("Binario 1: " + binario1);
        System.out.println("Binario 2: " + binario2);
        System.out.println();
        System.out.println("Seu corte ficou na casa: " + numeroCorte);
        System.out.println();
        System.out.println(binario1Parte1 + " " + binario2Parte2);
        System.out.println();
        System.out.println("===========================================");
        System.out.println();

        return binario1Parte1 + binario2Parte2;
    }

    public static void gerarNovaGeracao(ArrayList<String> geracaoBinaria) {
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

        System.out.println("Nova Geração em Binaários: ");
        System.out.println(novaGeracao);
        System.out.println();
        System.out.println("Nova Geração em Decimais: ");
        converterNovaGeracao(novaGeracao);

    }

    public static void converterNovaGeracao(ArrayList<String> geracaoBinaria) {
        ArrayList<Integer> novaGeracaoDecimal = new ArrayList<>();

        for (String s : geracaoBinaria) {
            novaGeracaoDecimal.add(conversaoBinarioDecimal(s));
        }

        System.out.println(novaGeracaoDecimal);
    }

}
