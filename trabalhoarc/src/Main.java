public class Main {

    public static void main(String[] args) {

        RISCProcessor processor = new RISCProcessor();



        // Inicializando a memória

        processor.getMemory().set(100, 42); // Endereço de memória 100 contém 42

        processor.getMemory().set(101, 10); // Endereço de memória 101 contém 10



        // Programa com instruções

        String[][] program = {

                {"LOAD", "R1", "100"},   // Carrega o valor da memória endereço 100 em R1

                {"LOAD", "R2", "101"},   // Carrega o valor da memória endereço 101 em R2

                {"ADD", "R1", "R2"},     // Soma R1 com R2 e armazena o resultado em R1

                {"STORE", "R1", "102"},  // Armazena o valor de R1 na memória no endereço 102

                {"SUB", "R1", "R2"},     // Subtrai R2 de R1 e armazena o resultado em R1

                {"BEQ", "R1", "R2", "6"}, // Se R1 == R2, salta para a instrução na posição 6


        };



        // Executando o programa

        processor.runProgram(program);

    }

}