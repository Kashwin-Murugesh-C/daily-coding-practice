import java.util.*;

class Items{

   int values;

   int weights;

   Items(int values,int weights){

       this.values=values;

       this.weights=weights;

   }

}

public class Knapsackoops{

   

   public static double dpfraction(Items[] items,int capacity){

       

       

       double profit=0.0;

       

       // ratio finding and sorting at the same time

       

       Arrays.sort(items, new Comparator<Items>(){

          @Override

          

          public int compare(Items item1,Items item2){

              double ratio1=(double)item1.values/item1.weights;

              double ratio2=(double)item2.values/item2.weights;

              

              return Double.compare(ratio2,ratio1);

          }

       });

       

       for(Items i:items){

           if(capacity==0){

               break;

           }

           else if(capacity>=i.weights){

               profit+=i.values;

               capacity-=i.weights;

           }

           else{

               profit+=(double)capacity/i.weights*i.values;

               capacity=0;

               break;

           }

       }

       

       return profit;

               

   }

   

   public static void main(String[] args){

       Items[] items={

           new Items(60,10),

           new Items(100,20),

           new Items(120,30)

       };

       int capacity=50;

       System.out.print(dpfraction(items,capacity));

   }

}
