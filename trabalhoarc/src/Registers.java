public class Registers {

    private int[] registers;



    public Registers(int size) {

        registers = new int[size];

    }



    public int get(int index) {

        return registers[index];

    }



    public void set(int index, int value) {

        registers[index] = value;

    }



    public int[] getRegistersSnapshot() {

        return registers.clone();

    }

}