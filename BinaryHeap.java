
public class BinaryHeap {

    int size;
    int [] a;

    public BinaryHeap(){
        size = 0;
        a = new int[10];  //intialize the array to 10
    }

    private void growArray(){


        
        int [] arr = new int[a.length*2];      //grows the array 
        for (int i = 0; i < a.length; i++){
            arr[i] = a[i];
        }
        a = arr;
    }


     public int remove(){
        if(size == 0){

            throw new IndexOutOfBoundsException();
        }

            int removed = a[0];
            a[0] = a[--size];

            siftdown(0);                   //the remove funtion removes the root, when the root is removed to keep the tree ordered we swap what needs be. 
            return removed;
    }   

    private void siftdown(int parent){   
           //swtiches the heap so the smallest priority is the root after a swap
        int ch = 2 * parent + 1;

        if(ch < size) {

            if (ch + 1 < size && (a[ch] > a[ch + 1])) {

                ch += 1;
            }
            if (a[parent] > a[ch]) {
                swap(parent, ch);
                siftdown(ch);
            }
        }
    }


    public void add(int value){
        if(size == a.length){           //this adds a value to the heap 
            growArray();
        }

        a[size++] = value;
        int ch = size - 1;
        int parent = (ch - 1) / 2;

        while(parent >= 0 && (a[parent] > a[ch])){    

            swap(parent, ch);

            ch = parent;

            parent = (ch - 1) / 2;
        }
    }
    private void swap(int x, int y){
       //the method that swaps two values
        int temp = a[x];

        a[x] = a[y];

        a[y] = temp;
    }

 

}