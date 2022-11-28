
// import java.util.Arrays;
// import java.util.ArrayList;
// import java.util.Collections;
// import java.util.List;
// import java.util.Comparator;
// import java.util.Arrays;

// class Main {
//   public static int maxRightVal = 0;

//   ///////////////// Methods ////////////////////
  
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


//   // -- Method to calculate area
// public static int  area(Object x1,Object y1, Object x2, Object y2 ){
//      int area = ((int)x2 - (int)x1)*((int)y2 - (int)y1);
//      return area;
  
//   }

  
 
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
   


// System.out.println(Arrays.deepToString(arr) + " arr not converted yet"); 

//     // 2.
//     // voodoo---------------------------------------------------------------
//     int rectCounter = 0; 
//     int areaJar = 0;
//     ArrayList <ArrayList<Integer>> box = new ArrayList<>();
//     ArrayList <ArrayList<Integer>> tempBox = new ArrayList<>();
//     ArrayList <ArrayList<Integer>> slicerBox = new ArrayList<>();
//     ArrayList <Integer> flipX = new ArrayList<>();
//     Integer sliceStart = 0;
//     Integer sliceEnd = 0;

//     while (rectCounter < arr.length) {
//       System.out.println("N: " + rectCounter + " LOOP");
//       //System.out.println(Arrays.toString(arr[rectCounter]));

//       if(tempBox.size() == 0){
//         tempBox.add(convertor2(arr[0]));
//         System.out.println("1st ELEMENT " + tempBox);
//       }


      
      
//       if(rectCounter > 0 ){
        
         

//         box.add(convertor2(arr[rectCounter-1]));
//         tempBox.add(convertor2(arr[rectCounter])); 
//         System.out.println("CURRENT START VALUE  " +  tempBox.get(tempBox.size()-1).get(0));
        
//         flipX.add(tempBox.get(rectCounter-1).get(2));
        
//         System.out.println("FLIPX  = " + flipX);
//         System.out.println("FLIPX MIN " + Collections.min(flipX));


//           Integer newX = tempBox.get(tempBox.size()-1).get(0);
//           Integer minX = Collections.min(flipX);
        
//           if(newX < minX){
//                   System.out.println("Ok!");
//                   sliceStart = (Integer)arr[rectCounter-1][0];
//                   sliceEnd = (Integer)arr[rectCounter][0];//get x 
//                   System.out.println("SLICE OPERATORS = " + sliceStart +" * "+ sliceEnd);
             
      
//                     //////
//                       for(int k = 0; k < slicerBox.size(); k++){
//                    slicerBox.get(k).set(0, sliceStart);
//                    slicerBox.get(k).set(2, sliceEnd);
//                    }
             
//                   box.get(0).set(2, sliceEnd);
//                   slicerBox.add(box.get(0));  // OLAP if condition  *****************
                 
//                   System.out.println("SLICERBOX  = " + slicerBox);
        
              
          
      
      
//               for(ArrayList <Integer> i : tempBox){
//                     i.set(0, sliceEnd); // modify x coordinates in the tempbox move slicer
                  
//               }  /////
                
          
          
//           }else if(newX > minX){
//                int minCounter = 0;
//                int minJar = minX;
               
//                 while (newX > minX) {
//                     System.out.println("TEMPBOX SHOULD BE CORE>>> " + tempBox);
//                     // CLONE TEMBOX FOR SLICERBOX 
//                     flipX.remove(minX);
//                     sliceStart = (minCounter == 0) ? (Integer)arr[rectCounter-1][0] : minJar;
//                     sliceEnd = minX;
//                     System.out.println("SLICE OPERATORS = " + sliceStart +" * "+ sliceEnd);
                 
                  
//                    for(int k = 0; k < slicerBox.size(); k++){
//                        slicerBox.get(k).set(0, sliceStart);
//                        slicerBox.get(k).set(2, sliceEnd);
//                         }

                  
               
//                   box.get(0).set(2, sliceEnd);
//                   slicerBox.add(box.get(0));
                  
//                  // System.out.println("SLICERBOX INSIDE box value = " + box + box.get(0).size());
//                   if(minCounter > 0){
//                     slicerBox.remove(slicerBox.size()-1);
//                   }
//                   System.out.println("SLICERBOX INSIDE  = " + slicerBox);

//                   for(ArrayList <Integer> i : tempBox){
//                        if(i.get(0) < minX){
//                           i.set(0, sliceEnd); // modify x coordinates in the tempbox move slicer
//                         }
//                       } 
                 
//                    minX = Collections.min(flipX);
//                    minCounter = minCounter + 1; 
                 
//             }
            
            
            
//             // sliceStart = (Integer)arr[rectCounter-1][0];
//             // sliceEnd = minX;
//             // System.out.println("SLICE OPERATORS = " + sliceStart +" * "+ sliceEnd);
//             // flipX.remove(minX);
//             // System.out.println("FLIPX AFTER REMOVE = " + flipX);

           
//           }





        

        
      
       

        
//         System.out.println("TEMPBOX AT THE END ###" + tempBox);
//         System.out.println("############### *** ############");
       
        
//         box.clear();


        
//       }

    
      
     
//       rectCounter = rectCounter + 1;

//               }























    
//     ///////////////// ==================////////////////////
//     long endTime = System.nanoTime();
//     long timeElapsed = endTime - startTime;
//     System.out.println("Execution time in miliseconds: " + timeElapsed / 1000000);
//     ///////////////// ==================////////////////////

//   }

// }