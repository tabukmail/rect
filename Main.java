
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Comparator;
import java.util.Arrays;
import java.util.*;

class Main {
  public static int maxRightVal = 0;

  ///////////////// Methods ////////////////////
  
  // --V2 Method to check two squares intersection taken from 2D Array[] and ArrayList during loop
  public static int olapRecCheck(int[] a, ArrayList <Integer> b) {
    int result;
    if (a[2] >= b.get(0) && 
        a[3] >= b.get(1) && 
        b.get(2) >= a[0] && 
        b.get(3) >= a[1]) {
            if(a[2] <= b.get(2) && 
               a[3] <= b.get(3) && 
               b.get(0) <= a[0] && 
               b.get(1) <= a[1]){
              System.out.println(" ------ inside");
                 result = -1;   //inside OLAP not taking
                 
               }else{
              System.out.println(" ------ olap");
                 result = 1;   //outside OLAP
              
               }
      
      
    } else {
      System.out.println(" ------ outside");
      result = 0; //non OLAP
      
      
    }
    
    return result;
  }


    // --V3 Method to check two squares intersection taken from 2D Array[] and ArrayList during loop
  public static boolean olapRecCheck3(ArrayList <Integer> a, ArrayList <Integer> b) {
    
    if (a.get(2) >= b.get(0) && 
        a.get(3) >= b.get(1) && 
        b.get(2) >= a.get(0) && 
        b.get(3) >= a.get(1)){
           
          System.out.println(" ------ olap" + a + b);
          return true;

      } else {
          System.out.println(" ------ NON olap" + a + b);
          return false; //non OLAP
      
      
       }
    
   // return result;
  }



      // --V3 Method to check two squares intersection taken from 2D Array[] and ArrayList during loop
  public static boolean olapRecCheck4(ArrayList <Integer> a, ArrayList <Integer> b) {

          int minA = Math.min(a.get(1), a.get(3));
          int maxA = Math.max(a.get(1), a.get(3));
          int minB = Math.min(b.get(1), b.get(3));
          int maxB = Math.max(b.get(1), b.get(3));
       
    
    if (   (minB < minA && minA < maxB) || (minA < minB && minB < maxA)){
           
          System.out.println(" ------ olap" + a + b);
          return true;

      } else {
          System.out.println(" ------ NON olap" + a + b);
          return false; //non OLAP
      
      
       }
    
   // return result;
  }



        // --Method to combine two rectangles
  public static ArrayList <Integer>  combo(ArrayList <Integer> a, ArrayList <Integer> b) {

          int minA = Math.min(a.get(1), a.get(3));
          int maxA = Math.max(a.get(1), a.get(3));
          int minB = Math.min(b.get(1), b.get(3));
          int maxB = Math.max(b.get(1), b.get(3));
          int max = Math.max(a.get(3), b.get(3));
           int min = Math.min(a.get(1), b.get(1));

          a.set(1, min);
          a.set(3, max);

       // if(minB < minA && minA < maxB){
       //    a.set(1, minA);
       //    a.set(3, maxB);
       // }else if(minA < minB && minB < maxA){
       //    a.set(1, minA);
       //    a.set(3, maxB);
       // }
       
    
      //System.out.println(" ---****--- " + a);
     return a;
  }
 

// -- Method to convert int[] to Integer[]
public static Integer[] convertor(int[] xArr){
Integer[] boxedInt = new Integer[xArr.length];
  for(int i = 0; i < xArr.length; i++){
    boxedInt[i] = Integer.valueOf(xArr[i]);
  }
  //System.out.println(Arrays.toString(boxedInt));
  return boxedInt;
  
} 


// -- Method to convert int[] to ArrayList <Integer>
public static ArrayList <Integer>  convertor2(int[] xArr){
ArrayList <Integer> boxedInt = new ArrayList<>();
  for(int i = 0; i < xArr.length; i++){
    boxedInt.add(i, xArr[i]);
  }
  //System.out.println(boxedInt);
  return boxedInt;
  
} 


  // -- Method to calculate area
public static int  area(ArrayList <Integer> rect ){
     Integer x1 = rect.get(0);
     Integer y1 = rect.get(1); 
     Integer x2 = rect.get(2);  
     Integer y2 = rect.get(3); 
     int area = ((int)x2 - (int)x1)*((int)y2 - (int)y1);
     return area;
  
  }


  
// -- Method to remove dublicate
public static <T> ArrayList<T> removeDuplicates(ArrayList<T> list)
    {
        // Create a new LinkedHashSet
        Set<T> set = new LinkedHashSet<>();
  
        // Add the elements to set
        set.addAll(list);
  
        // Clear the list
        list.clear();
  
        // add the elements of set
        // with no duplicates to the list
        list.addAll(set);
  
        // return the list
        return list;
    }

  
 
  ///////////////// ======SART POINT=======////////////////////
  public static void main(String[] args) {
    long startTime = System.nanoTime();

    ///////////////// ==================////////////////////
    // System.out.println(Arrays.deepToString(Data.dArr));
    int[][] arr = Data.dArr;

    // 1. Sort the arrays by first
    // element----------------------------------------------------------------
    Arrays.sort(arr, new Comparator<int[]>() {
      public int compare(int[] a0, int[] a1) {
        return Integer.compare(a0[0], a1[0]);
      }
    });
   


//System.out.println(Arrays.deepToString(arr) + " arr not converted yet"); 

    // 2.
    // voodoo---------------------------------------------------------------
    int rectCounter = 1; 
    int areaJar = 0;
    
    ArrayList <ArrayList<Integer>> tempBox = new ArrayList<>();
    ArrayList <Integer> slicerBox = new ArrayList<>();
    ArrayList <ArrayList<Integer>> slicerPalet = new ArrayList<>();
    
    ArrayList <Integer> xBox = new ArrayList<>();
    Integer sliceStart = 0;
    Integer sliceEnd = 0;
    
   ArrayList <ArrayList<Integer>> finalBox= new ArrayList<>();
  int areaBox = 0;
    
    while (rectCounter < arr.length) {
      // System.out.println("N: " + rectCounter + " LOOP");
      //System.out.println(Arrays.toString(arr[rectCounter]));

          if(tempBox.size() == 0){
                tempBox.add(convertor2(arr[0]));
                // System.out.println("1st ELEMENT " + tempBox);
          }
     // System.out.println(rectCounter); 
     // System.out.println(tempBox.size()); 
     //  tempBox.add(convertor2(arr[rectCounter]));
          ArrayList <Integer> inBox = new ArrayList<>();
          for(int i = 0; i < tempBox.size(); i++){  
               if((arr[rectCounter][0]) < tempBox.get(i).get(2)){
                        inBox.add(0);
                       // System.out.println(inBox + "  "  + "  TB[2]" + tempBox.get(i).get(2) + " REC [0]" +  arr[rectCounter][0]);
                //  System.out.println((arr[rectCounter][0]) + " " + tempBox.get(i).get(2));
               }else{                                                    // ((arr[rectCounter][0]) >= tempBox.get(i).get(2) )
                        inBox.add(1);
                  // System.out.println(inBox);
                 // System.out.println(inBox + "  "  + "  TB[2]" + tempBox.get(i).get(2) + " REC [0]" +  arr[rectCounter][0]);
                 
               }
                 
          }
         
        // System.out.println(inBox.contains(1)); 
            
        
        tempBox.add(convertor2(arr[rectCounter]));
        //System.out.println("TEMBOX >>> " + tempBox);
//******* Logic to calculate area SUM with maped ranges before next loop and set new start **  **  ** //
     
      int curMax = tempBox.get(tempBox.size()-1).get(0);  //current max X point to switch to inside calculation
        
          if(rectCounter == arr.length - 1){     // last loop add xbox last range and curMax
                    
                    curMax = arr[arr.length - 1][2];
                    xBox.add(arr[arr.length - 1][2]);
                  }
               
      // System.out.println("[curMax]   " + curMax);
      // System.out.println("[xBox]   " + xBox);
      
      if(inBox.contains(1) || curMax == arr[arr.length - 1][2]){
                            
                        for(ArrayList <Integer> i : tempBox){
                                 xBox.add(i.get(0));
                                 if(i.get(2) < curMax){
                                   xBox.add(i.get(2));
                                   }
                                 }
                          Collections.sort(xBox);
                          removeDuplicates(xBox);

                // for loop tempBox with xBox find set ranges, make the list rectangels, find rect intersection and calculate area
                          ArrayList <Integer> midTemp = new ArrayList<>();
                          ArrayList <ArrayList<Integer>> slBoxTemp = new ArrayList<>();
                          ArrayList <ArrayList<Integer>> midTempBox = new ArrayList<>();
                          ArrayList <ArrayList<Integer>> rectRange = new ArrayList<>();
                          
                          for(int k =1; k < xBox.size(); k++){
                            int min = xBox.get(k - 1);
                            int max = xBox.get(k);
                                                 
                             for(int n =0; n < tempBox.size(); n++){
                                    int a = tempBox.get(n).get(0);
                                    int b = tempBox.get(n).get(2);
                                    if(min >= a && max <= b){
                                              //System.out.println("TEST" + tempBox.get(n) + min + max + " " + xBox);
                                              slicerBox= (ArrayList)tempBox.get(n).clone();
                                              
                                              slicerBox.set(0, min);
                                              slicerBox.set(2, max);

                                            
                                             //   for(int e =0; e < rectRange.size(); e++){
                                             //      System.out.println("Е:: " + rectRange.get(e) + "    S:: " + slicerBox);

                                             // }

                                               

                                                                                             
                                             rectRange.add(slicerBox);
                                           // System.out.println("RR --" + rectRange + "    SB >>" + slicerBox);
                                      

                                      
                                      
                                             // for(int e =0; e < rectRange.size(); e++){
                                             //         int maxim = Math.max(rectRange.get(e).get(3), slicerBox.get(3));
                                             //         int minim = Math.min(rectRange.get(e).get(1), slicerBox.get(1));

                                                   
                                             //          if(olapRecCheck4(rectRange.get(e), slicerBox)){
                                             //                         // rectRange.get(e).set(1, minim);
                                             //                         // rectRange.get(e).set(3, maxim);
                                             //            combo(rectRange.get(e),slicerBox);
                                                        
                                                       
                                             //          }else{
                                             //                       rectRange.add(slicerBox);
                                             //          }


                                             // }



                                       
                                              // if(slicerPalet.size()>0 && slicerBox.get(0) == slicerPalet.get(slicerPalet.size()-1).get(0)){
                                              //   System.out.println("TEST tttt" + slicerBox + slicerPalet.get(slicerPalet.size()-1));
                                              // }                       
                                              
                                              slicerPalet.add(slicerBox);

                                             

                                              //System.out.println("TEST pppppp" + slicerPalet );
                                             
                                      // System.out.println("SLICER >>> " + slicerBox);
                                   
                                       //System.out.println("RR --" + rectRange + "SB >>" + slicerBox);
                                      
                                      
                                      // for(int e =0; e < rectRange.size(); e++){
                                      //   int maxim = Math.max(rectRange.get(e).get(3), slicerBox.get(3));
                                      //   int minim = Math.min(rectRange.get(e).get(1), slicerBox.get(1));

                                      //  if(olapRecCheck4(rectRange.get(e), slicerBox)){
                                      //      //slBoxTemp.add(combo(rectRange.get(e), slicerBox)); 
                                      //      //++++++++++++++
                                      //    // slBoxTemp.add(combo(rectRange.get(e), slicerBox));
                                      //    // slBoxTemp.remove(slBoxTemp.size()-1);
                                      //  // if(){}
                                      //       rectRange.get(e).set(1, minim);
                                      //       rectRange.get(e).set(3, maxim);

                                         
                                         
                                      //    System.out.println("R OLAP" + rectRange.get(e));
                                         
                                      //  }else{
                                      //       //slBoxTemp.add(slicerBox);
                                      //    System.out.println("NON    " +  slicerBox);
                                      //    rectRange.add(slicerBox);
                                            
                                      //  }

                                        
                                          
                                      //  // System.out.println("SB" + slBoxTemp);
                                      //   // System.out.println("RR" + rectRange.get(e) + "SB" + slicerBox + "[ LLL ]" + rectRange.get(e).get(1) + " - "+ rectRange.get(e).get(3) + " && " + slicerBox.get(1) + " - " + slicerBox.get(3) + " FUNC +++ " + olapRecCheck4(rectRange.get(e), slicerBox));
                                      //  //  System.out.println("RR" + rectRange.get(e) + "SB" + slicerBox);

                                        
                                        
                                      // }
                                      
                                  
                                    }
                        
                                }
                           
                           // midTempBox = (ArrayList)rectRange.clone();
                            
                         rectRange.clear();
 
                            
                            // System.out.println("RR" + rectRange);
                            // System.out.println("MTB" + midTempBox);
                           // System.out.println("xBox" + xBox);

                          
                            
                          }


   //                if(rectCounter == arr.length - 1){
   //                 
   //                  curMax = arr[arr.length - 1][2];
   //                }
                
               // System.out.println("########### " + tempBox);
                  for(int n =0; n < tempBox.size(); n++){
                                    //int a = tempBox.get(n).get(0);
                                    int b = tempBox.get(n).get(2);
                                   
                  
                    if(b > curMax){
                            midTemp = (ArrayList)tempBox.get(n).clone();
                            midTemp.set(0, curMax);
                            midTempBox.add(midTemp);
                            
                        if(rectCounter == arr.length - 1){
                                 //  System.out.println("MIDTEMP" + midTemp + "  XBOX " + xBox);   
                         }




                      
                                    }

                         }
                         
                tempBox.clear();
                tempBox.addAll(midTempBox);
               
        
                 if(rectCounter == arr.length - 1){
                          slicerPalet.addAll(midTempBox);
                          tempBox.clear();
                          // System.out.println("[last LOOP]   " + midTempBox);
                          //System.out.println("[last LOOP ??????]   " + midTempBox +  "  CMAX " + curMax +  "   RECT COUNTER " + rectCounter + "  TBOXXX " + tempBox);
                         }


        
        
    //           System.out.println("[**] PALETTE |||||  " + slicerPalet + " " + slicerPalet.size());
              // System.out.println(" ccccccccccccccccc  "  + midTempBox);
               //System.out.println("{**} RANGE COORD. LIST" + xBox);
               //System.out.println("TEMBOX >>> " + tempBox);
                
                          
                

              // ArrayList <ArrayList <Integer>> rectCombine = new ArrayList<>();
              // rectCombine = (ArrayList)slicerPalet.clone();
              //rectCombine.addAll(slicerPalet);
        
              // for(int j =1; j < slicerPalet.size(); j++){
              //                       //int a = tempBox.get(n).get(0);
              //                       //int d = slicerPalet.get(j).get(2);
                
                
              //           // if(olapRecCheck3(slicerPalet.get(j),rectCombine.get(j-1))){
              //           //          System.out.println("[RECTANGLES]  ");
                          
              //           // }
                
                           
              // }
          // System.out.println("[**] PALETTE |||||  " + slicerPalet + " " + slicerPalet.size());    
           Collections.sort(slicerPalet, new Comparator<ArrayList<Integer>>() {    
                        @Override
                        public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                            return o1.get(1).compareTo(o2.get(1));
                        }               
                });

         
         //System.out.println("[**] INBOX  " + xBox);

                                   ArrayList <ArrayList<Integer>> comboBox = new ArrayList<>();
                                   ArrayList <ArrayList<Integer>> equalBox = new ArrayList<>();
                                  
                                    
                                   for(int f =0; f < xBox.size(); f++){
                                   
                                          for(int e =0; e < slicerPalet.size(); e++){

                                            
                                            if(slicerPalet.get(e).get(0) == xBox.get(f) && e < slicerPalet.size() ){ //second argument might be deleted
                                                           if(comboBox.size() == 0){
                                                              comboBox.add(slicerPalet.get(e));
                                                              //System.out.println("COMBO BOX ::::: " + comboBox);
                                                            }   

                                                            if(slicerPalet.get(e).get(1) > comboBox.get(comboBox.size()-1).get(3)){
                                                              comboBox.add(slicerPalet.get(e));
                                                               //System.out.println("CB ADD N ::::: " + slicerPalet.get(e));
                                                              
                                                            }   
                                                            
                                                            if(slicerPalet.get(e).get(1) <= comboBox.get(comboBox.size()-1).get(3)){
                                                              
                                                               int max = Math.max(slicerPalet.get(e).get(3), comboBox.get(comboBox.size()-1).get(3));
                                                               int min = Math.min(slicerPalet.get(e).get(1), comboBox.get(comboBox.size()-1).get(1));
                                                               comboBox.get(comboBox.size()-1).set(1, min);
                                                               comboBox.get(comboBox.size()-1).set(3, max);
                                                               
                                                            }   
                                                                                     //System.out.println("SP:: " + slicerPalet.get(e));
                                                         // if(comboBox.size() > 1){
                                                         //   System.out.println("CB ADD O :::::: " + comboBox.get(1));
                                                         // }else{
                                                         //   System.out.println("CB ADD O :::::: " + comboBox.get(0));
                                                         // }
                                                            // System.out.println("CB ADD O :::::: " + comboBox);
                                                  
                                                                                     
                                                      }
                                          
                                               
                                             }
                                    
                                    
                                     //System.out.println("CB ADD O :::::: " + comboBox);
                                     if(comboBox.size() == 1){
                                        areaBox = areaBox + area(comboBox.get(0));
                                       // System.out.println("AREA :: " + area(comboBox.get(0)));
                                       // System.out.println("AREA :: " + areaBox);
                                      // System.out.println("CB ADD O :::::: " + comboBox.get(0));
                                     }else if(comboBox.size() > 1){
                                       for( ArrayList <Integer> o : comboBox){
                                         areaBox = areaBox + area(o);
                                        // System.out.println("CB ADD O :::::: " + o);
                                         // System.out.println("AREA :: " + area(o));
                                         // System.out.println("AREA :: " + areaBox);
                                         }
                                     }

                                    finalBox.addAll(comboBox);  
                                     comboBox.clear();
                                    // System.out.println(" -------------- " );
                                   }








        

                slicerPalet.clear();
                midTempBox.clear();
                xBox.clear();
                
        
            }  // #######  area calculation stage finish


      











      
       
        //System.out.println("TEMBOX AT THE END" + tempBox);
        



      

      // if(arr[rectCounter-1][2] > arr[rectCounter][0]){
      //   xBox.add(arr[rectCounter][0]);
      //   xBox.add(arr[rectCounter][2]);
      //   //Collections.sort(xBox);
      //  // removeDuplicates(xBox);
      //   System.out.println(xBox);
      //    System.out.println(arr[rectCounter-1][2]);
      // System.out.println(arr[rectCounter][0]);

      // }
      

       

         
      

      

    
      
     
      rectCounter = rectCounter + 1;

              }
    

    System.out.println("[**] FINALLE |||||  " + finalBox);
    
    System.out.println("AREA :: " + areaBox);







    
    ///////////////// ==================////////////////////
    long endTime = System.nanoTime();
    long timeElapsed = endTime - startTime;
    System.out.println("Execution time in miliseconds: " + timeElapsed / 1000000);
    ///////////////// ==================////////////////////

  }

}