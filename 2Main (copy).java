
// import java.util.Arrays;
// import java.util.ArrayList;
// import java.util.Collections;
// import java.util.List;
// import java.util.Comparator;
// import java.util.Arrays;

// class Main {
//   public static int maxRightVal = 0;

//   ///////////////// Methods ////////////////////
//   // -- Method to check two squares intersection taken from 2D array during loop
//   // public static boolean olapRecCheck(int[] a, int[] b) {
//   //   boolean result = false;
//   //   if (a[2] > b[0] && 
//   //       a[3] > b[1] && 
//   //       b[2] > a[0] && 
//   //       b[3] > a[1]) {
//   //     result = true;
//   //     // maxRightVal=(maxRightVal <= Math.max(a[2], b[2]))?Math.max(a[2], b[2]) :
//   //     // maxRightVal;
//   //   } else {
//   //     result = false;
//   //     // maxRightVal=(maxRightVal <= Math.max(a[2], b[2]))?Math.max(a[2], b[2]) :
//   //     // maxRightVal;
//   //   }
//   //   System.out.println(result);
//   //   return result;
//   // }

//   // // --V1 Method to check two squares intersection taken from 2D Array[] and ArrayList during loop
//   // public static boolean olapRecCheck(int[] a, ArrayList <Integer> b) {
//   //   boolean result = false;
//   //   if (a[2] > b.get(0) && 
//   //       a[3] > b.get(1) && 
//   //       b.get(2) > a[0] && 
//   //       b.get(3) > a[1]) {
//   //     result = true;
//   //     // maxRightVal=(maxRightVal <= Math.max(a[2], b[2]))?Math.max(a[2], b[2]) :
//   //     // maxRightVal;
//   //   } else {
//   //     result = false;
//   //     // maxRightVal=(maxRightVal <= Math.max(a[2], b[2]))?Math.max(a[2], b[2]) :
//   //     // maxRightVal;
//   //   }
//   //   //System.out.println(result);
//   //   return result;
//   // }
 
//   // --V2 Method to check two squares intersection taken from 2D Array[] and ArrayList during loop
//   public static int olapRecCheck(int[] a, ArrayList <Integer> b) {
//     int result;
//     if (a[2] >= b.get(0) && 
//         a[3] >= b.get(1) && 
//         b.get(2) >= a[0] && 
//         b.get(3) >= a[1]) {
//             if(a[2] <= b.get(2) && 
//                a[3] <= b.get(3) && 
//                b.get(0) <= a[0] && 
//                b.get(1) <= a[1]){
//               System.out.println(" ------ inside");
//                  result = -1;   //inside OLAP not taking
                 
//                }else{
//               System.out.println(" ------ olap");
//                  result = 1;   //outside OLAP
              
//                }
      
      
//     } else {
//       System.out.println(" ------ outside");
//       result = 0; //non OLAP
      
      
//     }
    
//     return result;
//   }



//   //   // --V3 Method to check two squares intersection taken from 2D Array[] and ArrayList during loop
//   // public static int olapRecCheck(int[] a, ArrayList <Integer> b) {
//   //   int result;
//   //   if (((a[2] > b.get(0) && 
//   //       a[3] > b.get(1) && 
//   //       b.get(2) > a[0] && 
//   //       b.get(3) > a[1])) &&
//   //              (a[2] > b.get(2) && 
//   //              a[3] > b.get(3) && 
//   //              b.get(0) > a[0] && 
//   //              b.get(1) > a[1])){
//   //             System.out.println(" ------ inside");
//   //                result = -1;   //inside OLAP not taking
                 
//   //              }else{
//   //             System.out.println(" ------ olap");
//   //                result = 1;   //outside OLAP
              
//   //              }
      
      
//   //   if(((a[2] <= b.get(0) && 
//   //       a[3] <= b.get(1) && 
//   //       b.get(2) <= a[0] && 
//   //       b.get(3) <= a[1])) == false) {
//   //     System.out.println(" ------ non olap");
//   //     result = 0; //non OLAP
      
      
//   //   }
    
//   //   return result;
//   // }

   
  

// // -- Method to convert int[] to Integer[]
// public static Integer[] convertor(int[] xArr){
// Integer[] boxedInt = new Integer[xArr.length];
//   for(int i = 0; i < xArr.length; i++){
//     boxedInt[i] = Integer.valueOf(xArr[i]);
//   }
//   //System.out.println(Arrays.toString(boxedInt));
//   return boxedInt;
  
// } 


// // -- Method to convert int[] to ArrayList <Integer>
// public static ArrayList <Integer>  convertor2(int[] xArr){
// ArrayList <Integer> boxedInt = new ArrayList<>();
//   for(int i = 0; i < xArr.length; i++){
//     boxedInt.add(i, xArr[i]);
//   }
//   //System.out.println(boxedInt);
//   return boxedInt;
  
// } 
  
  

//   ///////////////// ======SART POINT=======////////////////////
//   public static void main(String[] args) {
//     long startTime = System.nanoTime();

//     ///////////////// ==================////////////////////
//     // System.out.println(Arrays.deepToString(Data.dArr));
//     int[][] arr = Data.dArr;

//     // 1. Sort the arrays by first
//     // element----------------------------------------------------------------
//     Arrays.sort(arr, new Comparator<int[]>() {
//       public int compare(int[] a0, int[] a1) {
//         return Integer.compare(a0[0], a1[0]);
//       }
//     });
   

//     // Arrays.sort(arr, Arrays::compare);
//     // System.out.println(Arrays.deepToString(arr));

// System.out.println(Arrays.deepToString(arr) + " arr not converted yet"); 

//     // 2.
//     // voodoo---------------------------------------------------------------
//     int rectCounter = 0; 
//     int olapCounterBoxLoop = 0;
//     int insideCounterBoxLoop = 0;
//     int checkResult = 0;
//     ArrayList <ArrayList<Integer>> box = new ArrayList<>();
//     ArrayList <ArrayList<Integer>> tempBox = new ArrayList<>();

//     while (rectCounter < arr.length) {
//       System.out.println("N: " + rectCounter + " LOOP");
  
//         if(tempBox.size() > 0){
//               for(ArrayList <Integer> t : tempBox){
//                 checkResult = olapRecCheck(arr[rectCounter], t);
//                   if(checkResult > 0){ //olap loop check
//                      olapCounterBoxLoop = olapCounterBoxLoop + 1;
//                      System.out.println("RECT WICH SOULD BE MODIFIED :: " + convertor2(arr[rectCounter]));
//                    }else if(checkResult < 0){
//                      olapCounterBoxLoop = olapCounterBoxLoop + 1;
//                }

//                }






          
//               // System.out.println("OLAP INSIDE COUNTER :: " + olapCounterBoxLoop);
//               // System.out.println("INSIDE INSIDE COUNTER :: " + insideCounterBoxLoop);
                  
//               if(olapCounterBoxLoop == 0 ){
//                          box.add(convertor2(arr[rectCounter]));
//                          }
          
//               if(box.size() > 0 ){
//                   tempBox.add(box.get(0));
//                   box.clear();
//                             } 
      
//         }else if(tempBox.size() == 0){
//           tempBox.add(convertor2(arr[rectCounter]));
//         }
      
//       System.out.println("BOX shoud be cleared :: " + box);
//       System.out.println(tempBox + " TEMPBOX list");
//       //System.out.println(rectCounter + "counter");
      
                  
//       olapCounterBoxLoop = 0;  
//       insideCounterBoxLoop = 0;
//       rectCounter = rectCounter + 1;

// }













    
//     // for (int i = 0, j = 1; i < arr.length - 1; i++, j++) {
//     //   int[] a = arr[i];
//     //   int[] b = arr[j];
//     //   if(olapRecCheck(a, b) == false){
//     //        if(a[2] > b[0]){
//     //          //System.out.println("time to put it in arraylist");
//     //           for(int[] v : arr){
//     //            tempBox.add(convertor2(v));
//     //           }
//     //        }
//     //   }


      
//     //   // System.out.println(" RULLER - max X value is: " + maxRightVal);
//     // }

//     //System.out.println(tempBox);

//     // UUID uuid = UUID.randomUUID();
//     // int nnn = uuid.hashCode();
//     // System.out.println(Integer.toBinaryString(nnn));

//     // String ss = "4";
//     // int ccc = ss.hashCode();
//     // System.out.println(ccc);
//     // System.out.println(Integer.toBinaryString(ccc));

//     // for(int i = 0, j = 1; i < arr.length-1; i++, j++) {
//     // if(arr[i][2] > arr[j][0] &&
//     // arr[i][3] > arr[j][1] &&
//     // arr[j][2] > arr[i][0] &&
//     // arr[j][3] > arr[i][1] ) {

//     // System.out.println(" squre " + i + " intersects squre " + j);
//     // } else {
//     // System.out.println(" no interseqction ");
//     // }

//     // System.out.println(" RULLER - max X value is: " + Math.max(arr[i][2],
//     // arr[j][2]));
//     // // System.out.println(arr[i][2] + " ** " + arr[j][0]);
//     // // System.out.println(arr[i][3] + " ** " + arr[j][1]);
//     // }

//     // for(int i = 0; i < arr.length; i++){
//     // for(int j = 0; j <= arr[i].length-1; j++){
//     // System.out.println((arr[i][j]));
//     // }

//     // }


















    
//     ///////////////// ==================////////////////////
//     long endTime = System.nanoTime();
//     long timeElapsed = endTime - startTime;
//     System.out.println("Execution time in miliseconds: " + timeElapsed / 1000000);
//     ///////////////// ==================////////////////////

//   }

// }