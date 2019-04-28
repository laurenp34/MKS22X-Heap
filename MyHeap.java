public class MyHeap {


  private static void swap(int[] data, int i1, int i2) {
    int temp = data[i1];
    data[i1] = data[i2];
    data[i2] = temp;
  }

  /*We discussed these 2 methods already:
  - size  is the number of elements in the data array.
  - push the element at index i downward into the correct position. This will swap with the larger of the child nodes provided thatchild is larger. This stops when a leaf is reached, or neither child is larger. [ should be O(logn) ]
  - precondition: index is between 0 and size-1 inclusive
  - precondition: size is between 0 and data.length-1 inclusive.
  */
private static void pushDown(int[]data,int size,int index){
  int nextI = 2*index + 1;
  if (nextI >= size) return; //if data[index] is already a leaf.
  // find larger of 2 nodes: (nextI is set to larger)
  if (nextI+1 <= size && data[nextI+1] > data[nextI]) nextI++;
  //if larger of 2 nodes is larger than current node, swap and call method recursively.
  if (data[nextI] > data[index]) {
    swap(data, nextI, index);
    
  }

}

/*
- push the element at index i up into the correct position. This will swap it with the parent node until the parent node is larger or the root is reached. [ should be O(logn) ]
- precondition: index is between 0 and data.length-1 inclusive.
*/
private static void pushUp(int[]data,int index){}


/*We will discuss this today:
      - convert the array into a valid heap. [ should be O(n) ]
      */
public static void heapify(int[]){}


//- sort the array by converting it into a heap then removing the largest value n-1 times. [ should be O(nlogn) ]
public static void heapsort(int[]) {}

}
