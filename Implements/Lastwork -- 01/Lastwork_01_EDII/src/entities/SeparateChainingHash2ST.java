package entities;

public class SeparateChainingHash2ST<Key, Value> {
    private static final int INIT_CAPACITY = 97;

    private int n;                                // number of key-value pairs
    private int m;                                // hash table size
    private SequentialSearchST<Key, Value>[] st;  // array of linked-list symbol tables

    public SeparateChainingHash2ST() {
        this(INIT_CAPACITY);
    } 

    @SuppressWarnings("unchecked")
	public SeparateChainingHash2ST(int m) {
        this.m = m;
        st = (SequentialSearchST<Key, Value>[]) new SequentialSearchST[m];
        for (int i = 0; i < m; i++)
            st[i] = new SequentialSearchST<Key, Value>();
    } 

    // hash value between 0 and m-1
    private int hash(Key x) {
        int h = 0;
        String key = (String) x;
        for (int i=0; i<key.length(); i++)
        	h = (31 * h + key.charAt(i)) % this.m;
        return h;
    } 
    
    public double[] getFrequency() {
    	double[] frequency = new double[n];
    	int frequencyCounter = 0;
    	for(int i = 0 ; i < m ; i++) {
    		for(int j = 0 ; j < st[i].size() - 1 ; j++) {
    			frequency[frequencyCounter++] = (double) i;
    		}
    	}
    	return frequency;
    }
    
    public int hashSize() {
    	return m;
    }

    public int size() {
        return n;
    } 

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean contains(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to contains() is null");
        return get(key) != null;
    } 

    public Value get(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to get() is null");
        int i = hash(key);
        return st[i].get(key);
    } 

    public void put(Key key, Value val) {
        if (key == null) throw new IllegalArgumentException("first argument to put() is null");
        if (val == null) {
            delete(key);
            return;
        }

        int i = hash(key);
        if (!st[i].contains(key)) n++;
        st[i].put(key, val);
    } 

    public void delete(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to delete() is null");

        int i = hash(key);
        if (st[i].contains(key)) n--;
        st[i].delete(key);

    } 

    // return keys in symbol table as an Iterable
    public Iterable<Key> keys() {
        Queue<Key> queue = new Queue<Key>();
        for (int i = 0; i < m; i++) {
            for (Key key : st[i].keys())
                queue.enqueue(key);
        }
        return queue;
    } 


}
