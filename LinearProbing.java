public class LinearProbing {
    int[] T;
    int m;
    int size;

    public LinearProbing(int m) {
        this.m = m;
        this.T = new int[m];
        this.size = 0;
        for (int i = 0; i < m; i++)
            T[i] = -1;
    }

    int hash(int k) {
        return k % m;
    }

    public void insert(int k) {
        if (size == m) {
            System.out.println("Hashtable is full! cannot insert");
            return;
        }
        int idx = hash(k);
        while (T[idx] != -1)
            idx = (idx + 1) % m;
        
        T[idx] = k;
        size++;
    }

    public boolean search(int k) {
        int idx = hash(k);
        while (T[idx] != -1) {
            if (T[idx] == k)
                return true;
            idx = (idx + 1) % m;
        }
        return false;
    }

    public void delete(int k) {
        int idx = hash(k);
        while (T[idx] != -1) {
            if (T[idx] == k) {
                T[idx] = -1; // Mark as deleted
                size--;
                return;
            }
            idx = (idx + 1) % m;
        }
        System.out.println("Key not found in the table!!!");
    }

    public void printTable() {
        for (int i = 0; i < m; i++) {
            if (T[i] == -1){

            
                System.out.println("EMPTY ");
            }else{
                System.out.print(T[i] + " ");

            }

        
                
        }
      System.out.println();
    }

    public static void main(String[] args) {
        LinearProbing obj = new LinearProbing(10);
        obj.insert(10);
        obj.insert(12);
        obj.insert(13);
        obj.insert(19);
        obj.insert(54);
        obj.insert(45);

        System.out.println("Hash Table after insertions: ");
        obj.printTable();
        System.out.println("Search for 13: " + obj.search(13));
        System.out.println("Search for 54: " + obj.search(54));
        obj.delete(45);
        System.out.println("Hash Table after deletion key 45: ");
        obj.printTable();
    }
}
