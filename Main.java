
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Comparator;
import java.util.Arrays;
import java.util.*;

class Main {
  //public static int maxRightVal = 0;

  ///////////////// Methods ////////////////////
  
         // --Method to combine two rectangles
  // public static ArrayList <Integer>  combo(ArrayList <Integer> a, ArrayList <Integer> b) {

  //         int minA = Math.min(a.get(1), a.get(3));
  //         int maxA = Math.max(a.get(1), a.get(3));
  //         int minB = Math.min(b.get(1), b.get(3));
  //         int maxB = Math.max(b.get(1), b.get(3));
  //         int max = Math.max(a.get(3), b.get(3));
  //          int min = Math.min(a.get(1), b.get(1));

  //         a.set(1, min);
  //         a.set(3, max);

     
  //    return a;
  // }
 

// -- Method to convert int[] to ArrayList <Integer>
public static ArrayList <Integer>  convertor2(int[] xArr){
ArrayList <Integer> boxedInt = new ArrayList<>();
  for(int i = 0; i < xArr.length; i++){
    boxedInt.add(i, xArr[i]);
  }
 
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
    int areaBox = 0;
if(arr.length == 1){
     int x1 = arr[0][0];
     int y1 = arr[0][1]; 
     int x2 = arr[0][2]; 
     int y2 = arr[0][3]; 
     areaBox = (x2 - x1)*(y2 - y1);
     
}


    
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
   // int areaJar = 0;
    
    ArrayList <ArrayList<Integer>> tempBox = new ArrayList<ArrayList<Integer>>();
    ArrayList <Integer> slicerBox = new ArrayList<>();
    ArrayList <ArrayList<Integer>> slicerPalet = new ArrayList<>();
    
    ArrayList <Integer> xBox = new ArrayList<>();
    
   ArrayList <ArrayList<Integer>> finalBox= new ArrayList<>();
   
    
    while (rectCounter < arr.length) {
     
          if(tempBox.size() == 0){
                tempBox.add(convertor2(arr[0]));
             
          }
   
          ArrayList <Integer> inBox = new ArrayList<>();
          for(int i = 0; i < tempBox.size(); i++){  
               if((arr[rectCounter][0]) < tempBox.get(i).get(2)){
                        inBox.add(0);
                     
               }else{                                                    // ((arr[rectCounter][0]) >= tempBox.get(i).get(2) )
                        inBox.add(1);
               
                 
               }
                 
          }
         
              
        
        tempBox.add(convertor2(arr[rectCounter]));
     
//******* Logic to calculate area SUM with maped ranges before next loop and set new start **  **  ** //
     
      int curMax = tempBox.get(tempBox.size()-1).get(0);  //current max X point to switch to inside calculation
        
          if(rectCounter == arr.length - 1){     // last loop add xbox last range and curMax
                    
                    curMax = arr[arr.length - 1][2];
                    xBox.add(arr[arr.length - 1][2]);
                  }
               
      
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
                                              slicerBox= (ArrayList <Integer>)tempBox.get(n).clone();
                                              
                                              slicerBox.set(0, min);
                                              slicerBox.set(2, max);

                                                                                                                                     
                                             rectRange.add(slicerBox);
                                         
                                              slicerPalet.add(slicerBox);

                                    }
                        
                                }
                           
                                                    
                         rectRange.clear();
 
                        
                          }


                  for(int n =0; n < tempBox.size(); n++){
                                    
                                    int b = tempBox.get(n).get(2);
                                   
                  
                    if(b > curMax){
                            midTemp = (ArrayList<Integer>)tempBox.get(n).clone();
                            midTemp.set(0, curMax);
                            midTempBox.add(midTemp);
                            
                        if(rectCounter == arr.length - 1){
                                   
                         }


                                    }

                         }
                         
                tempBox.clear();
                tempBox.addAll(midTempBox);
               
        
                 if(rectCounter == arr.length - 1){
                          slicerPalet.addAll(midTempBox);
                          tempBox.clear();
                        
                         }


          // System.out.println("[**] PALETTE |||||  " + slicerPalet + " " + slicerPalet.size());    
           Collections.sort(slicerPalet, new Comparator<ArrayList<Integer>>() {    
                        @Override
                        public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                            return o1.get(1).compareTo(o2.get(1));
                        }               
                });

         
       

                                   ArrayList <ArrayList<Integer>> comboBox = new ArrayList<>();
                                        
                                   for(int f =0; f < xBox.size(); f++){
                                   
                                          for(int e =0; e < slicerPalet.size(); e++){

                                            
                                            if(slicerPalet.get(e).get(0) == xBox.get(f) && e < slicerPalet.size() ){ //second argument might be deleted
                                                           if(comboBox.size() == 0){
                                                              comboBox.add(slicerPalet.get(e));
                                                             
                                                            }   

                                                            if(slicerPalet.get(e).get(1) > comboBox.get(comboBox.size()-1).get(3)){
                                                              comboBox.add(slicerPalet.get(e));
                                                              
                                                              
                                                            }   
                                                            
                                                            if(slicerPalet.get(e).get(1) <= comboBox.get(comboBox.size()-1).get(3)){
                                                              
                                                               int max = Math.max(slicerPalet.get(e).get(3), comboBox.get(comboBox.size()-1).get(3));
                                                               int min = Math.min(slicerPalet.get(e).get(1), comboBox.get(comboBox.size()-1).get(1));
                                                               comboBox.get(comboBox.size()-1).set(1, min);
                                                               comboBox.get(comboBox.size()-1).set(3, max);
                                                               
                                                            }   
                                                                                 
                                                      }
                                          
                                               
                                             }
                                    
                                    
                                     //System.out.println("CB ADD O :::::: " + comboBox);
                                     if(comboBox.size() == 1){
                                       
                                        areaBox = areaBox + area(comboBox.get(0));
                                     
                                     }else if(comboBox.size() > 1){
                                       
                                       for( ArrayList <Integer> o : comboBox){
                                         areaBox = areaBox + area(o);
                                      
                                         }
                                     }

                                    finalBox.addAll(comboBox);  
                                     comboBox.clear();
                                    // System.out.println(" -------------- " );
                                   }








        

                slicerPalet.clear();
                midTempBox.clear();
                xBox.clear();
                
        
            } 

     
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