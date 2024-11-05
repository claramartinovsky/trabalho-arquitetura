public class Memory {

    private int[] memory;



    public Memory(int size) {

        memory = new int[size];

    }



    public int get(int address) {

        return memory[address];

    }



    public void set(int address, int value) {

        memory[address] = value;

    }



    public int[] getMemorySnapshot(int limit) {

        int[] snapshot = new int[limit];

        System.arraycopy(memory, 0, snapshot, 0, limit);

        return snapshot;

    }

}
