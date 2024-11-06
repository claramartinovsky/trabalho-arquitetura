import java.util.Arrays;
public class RISCProcessor {

    private Registers registers;

    private Memory memory;

    private int pc; // Contador de programa 



    public RISCProcessor() {

        this.registers = new Registers(2); // R1 e R2 

        this.memory = new Memory(256); // Memória com 256 posições 

        this.pc = 0;

    }



    public Memory getMemory() {

        return memory;

    }



    public void load(int regIndex, int address) {

        registers.set(regIndex, memory.get(address));

        pc++;

    }



    public void store(int regIndex, int address) {

        memory.set(address, registers.get(regIndex));

        pc++;

    }



    public void add(int regIndex1, int regIndex2) {

        int result = registers.get(regIndex1) + registers.get(regIndex2);

        registers.set(regIndex1, result);

        pc++;

    }



    public void sub(int regIndex1, int regIndex2) {

        int result = registers.get(regIndex1) - registers.get(regIndex2);

        registers.set(regIndex1, result);

        pc++;

    }



    public void jmp(int address) {

        pc = address;

    }



    public void beq(int regIndex1, int regIndex2, int address) {

        if (registers.get(regIndex1) == registers.get(regIndex2)) {

            pc = address;

        } else {

            pc++;

        }

    }



    public void runProgram(String[][] program) {

        pc = 0;

        while (pc < program.length) {

            String[] instruction = program[pc];

            String opcode = instruction[0];



            switch (opcode) {

                case "LOAD":

                    load(Integer.parseInt(instruction[1].substring(1)) - 1, Integer.parseInt(instruction[2]));

                    break;

                case "STORE":

                    store(Integer.parseInt(instruction[1].substring(1)) - 1, Integer.parseInt(instruction[2]));

                    break;

                case "ADD":

                    add(Integer.parseInt(instruction[1].substring(1)) - 1, Integer.parseInt(instruction[2].substring(1)) - 1);

                    break;

                case "SUB":

                    sub(Integer.parseInt(instruction[1].substring(1)) - 1, Integer.parseInt(instruction[2].substring(1)) - 1);

                    break;

               case "JMP":

                    jmp(Integer.parseInt(instruction[1]));

                    break;

                case "BEQ":

                    beq(Integer.parseInt(instruction[1].substring(1)) - 1, Integer.parseInt(instruction[2].substring(1)) - 1, Integer.parseInt(instruction[3]));

                    break;

                default:

                    System.out.println("Instrução desconhecida: " + opcode);

                    return;

            }



            // Exibe o estado atual do processador 

            //System.out.println("PC: " + pc + ", Registers: " + Arrays.toString(registers.getRegistersSnapshot()) + ", Memory: " + Arrays.toString(memory.getMemorySnapshot(105)));
            System.out.println("PC: " + pc + ", Registers: " + Arrays.toString(registers.getRegistersSnapshot()) + ", Memory: [100: " + memory.get(100) + ", 101: " + memory.get(101) + ", 102: " + memory.get(102) + "]");
    }

    }

} 