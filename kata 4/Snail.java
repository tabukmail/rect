import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Snail {
  public static void main(String[] args) {
    long startTime = System.nanoTime();
  ///////////////// ==================////////////////////
    
    // int[][] arr = {{1, 2, 3, 4, 5},
    //                {18, 19, 20, 21, 6},
    //                {17, 28, 29, 22, 7},
    //                {16, 27, 30, 23, 8},
    //                {15, 26, 25, 24, 9},
    //                {14, 13, 12, 11, 10}};


     int[][] arr = {{1, 2, 3},
                   {4, 5, 6},
                   {7, 8, 9}};
    
//--------------------------------------------------------------
//System.out.println("-------------------------------------------------------------------");
//--------------------------------------------------------------
//START. conver 2D array to 2D ArrayList
    ArrayList<ArrayList<Integer>> arrL = new ArrayList<>();
    
    for(int i = 0; i < arr.length; i++){
       ArrayList<Integer> tempL = new ArrayList<>();
       for(int j = 0; j <= arr[i].length-1; j++){
           tempL.add(arr[i][j]);
        }
      arrL.add(tempL);
    }
  //System.out.println(arrL);
  //System.out.println(arrL.get(1));


    ArrayList<Integer> arrFinal = new ArrayList<>();
    arrL.removeIf(n -> (n.size() == 0));  //if ther is an epty element in the list 

  while (arrL.size() > 0) {

// Task block 1 start point  {}
    int lCounter=0;
    for(ArrayList<Integer> num : arrL){
      lCounter++;
    //1. if num array index = 0 retrive whole array -----------------------------------
      if(arrL.indexOf(num) == 0){
        for(int zum : num){
          arrFinal.add(zum);
         }
      }
      //System.out.println(arrL.get(0));
      arrL.get(0).clear();
                //System.out.println(arrL.indexOf(num));
                // arrL.clear(arrL.get(0));
    //2. if num array index > 0 and < size-2 retrive only last elements from the member array--------
      if(arrL.indexOf(num) > 0 && arrL.indexOf(num) < arrL.size()-1){
        int temp = (num.get(num.size()-1));
       // System.out.println("== " + temp);
        arrFinal.add(temp);
        //System.out.println("add temp " + arrFinal);
        //System.out.println("arrL counter to remove " + (lCounter-1));
       // System.out.println("arrL before remove element " + arrL);
        arrL.get(lCounter-1).remove(num.size()-1);
        //System.out.println("arrL after remove element " + arrL);
      }
      
    //3. if num array index = last reverse las array and retrive whole----------------------
      
      if(arrL.indexOf(num) == arrL.size()-1){
        Collections.reverse(num);
       // System.out.println("last>> " + num);
        for(int zum : num){
          arrFinal.add(zum);
         }
       arrL.get(arrL.size()-1).clear();
      }
    }
    
// Task block 2 start point  {}
    //4. switch to back loop 
    ArrayList<Integer> tempo = new ArrayList<>();
    lCounter = 0;
    for(ArrayList<Integer> num3 : arrL){
      
      if(num3.size() > 0){
        lCounter++;
        
        int temp3 = num3.get(0);
        tempo.add(temp3);
        //System.out.println("arrL >> " + arrL);
       //System.out.println("lCounter >> " + lCounter);
        //System.out.println("temp3 >> " + temp3);
        arrL.get(lCounter).remove(0);
         
      }
      
           
    }
      Collections.reverse(tempo);
      //System.out.println("tempo outside the loop" + tempo);
      arrFinal.addAll(tempo);
// Task block 3 --> final ArrayList
       arrL.removeIf(n -> (n.size() == 0));  //if ther is a epty element in the list 
       
      // System.out.println(arrL);
} 
       //System.out.println("Final: " + arrFinal);
       int[] snail = new int[arrFinal.size()];
       int counter = -1 ;
       for(int n : arrFinal){
         counter ++;
         snail[counter] = n;
       }
        System.out.println(Arrays.toString(snail));
    
       
    // for(int i = 0; i < arr.length-(arr.length-1); i++){
    //   for(int j = 0; j <= arr[i].length-1; j++){
    //      System.out.println(arr[i][j]);
    //      arrL.add(arr[i][j]);
    //      arr[i][j] = 0;
    //     }
    // }
    // // for(int i = 1; i < arr.length-(arr.length-2); i++){
    // //   for(int j = arr[i].length-1; j <= arr[i].length-1; j++){
    // //      System.out.println(arr[i][j]);
    // //      arrL.add(arr[i][j]);
    // //      arr[i][j] = 0;
    // //     }
    // // }
    
    // System.out.println(Arrays.deepToString(arr));
    ///////////////// ==================////////////////////
    long endTime = System.nanoTime();
    long timeElapsed = endTime - startTime;
    System.out.println("Execution time in miliseconds: " + timeElapsed / 1000000);
    ///////////////// ==================////////////////////

  }

}