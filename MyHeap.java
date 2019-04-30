import java.io.*;
import java.util.*;

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
  if (nextI+1 < size && data[nextI+1] > data[nextI]) nextI++;
  //if larger of 2 nodes is larger than current node, swap and call method recursively.
  if (data[nextI] > data[index]) {
    swap(data, nextI, index);
    pushDown(data,size,nextI); // because nextI represented where you swapped to.
  }

}

/*
- push the element at index i up into the correct position. This will swap it with the parent node until the parent node is larger or the root is reached. [ should be O(logn) ]
- precondition: index is between 0 and data.length-1 inclusive.
*/
private static void pushUp(int[]data,int index){
  // if it is the root:
  if (index==0) return;
  int nextI = (index-1)/2;
  if (data[nextI] < data[index]) {
    swap(data,nextI,index);
    pushUp(data,nextI);
  }
}


/*We will discuss this today:
      - convert the array into a valid heap. [ should be O(n) ]
      */
public static void heapify(int[] data){
  //base case: size 0 or 1
  if (data.length <= 1) return;

  for (int i=data.length-1;i>=0;i--) {
    pushDown(data,data.length-1,i);
  }

}


//- sort the array by converting it into a heap then removing the largest value n-1 times. [ should be O(nlogn) ]
public static void heapsort(int[] data) {
  //base case: size 0 or 1 is already sorted.
  if (data.length <= 1) return;

  heapify(data);
  System.out.println(Arrays.toString(data));
  //i represents the last element (aka the one to be swapped)
  //i also represents the size of the newly shortened heap.
  for (int i=data.length-1;i>=1;i--) {
    //System.out.println(Arrays.toString(data));
    swap(data,0,i);
    //System.out.println("sorted: "+Arrays.toString(Arrays.copyOfRange(data,i,data.length)));
    pushDown(data,i,0);
    //System.out.println("pusheddown: "+Arrays.toString(Arrays.copyOfRange(data,0,i)));
  }

}

  public static void main(String[] args) {
    int[] d1 = {10,5,7,3,2,6,1,1,0,9};
    pushUp(d1,d1.length-1);
    System.out.println(Arrays.toString(d1)+"\n");

    int[] d2 = {4,6,9,2,4,10,0,4,7,4,11};
    heapsort(d2);
    System.out.println(Arrays.toString(d2));
  }

}
