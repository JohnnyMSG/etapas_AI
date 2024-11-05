public class etapa2 {

    public static void main(String[] args) {
        String resultado1 = inteiroParaBinario(78);
        System.out.println(resultado1);

        System.out.println();

        String resultado2 = binarioParaDecimal("1001110");
        System.out.println(resultado2);
    }

    public static String inteiroParaBinario(Integer inteiro) {
        String binario = Integer.toBinaryString(inteiro);

        return "O número inteiro " + inteiro + " em binário é: " + binario;
    }

    public static String binarioParaDecimal(String binario) {
        int inteiro = Integer.parseInt(binario, 2);

        return "O número inteiro " + binario + " em inteiro é: " + inteiro;
    }
}
