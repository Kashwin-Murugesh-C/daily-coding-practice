public class Knapsack{

   

   public static double dpfraction(int values[],int weights[], int capacity){

       double profit=0;

       

       double ratios[]=new double [values.length];

       

       //for finding the values per kg

       

       for (int i=0;i<values.length;i++){

           ratios[i]=(double)values[i]/weights[i];

       }

       

       //sort them in desc to keep the greedy methods

       

       for(int i=0;i<values.length-1;i++){

           for(int j=0;j<values.length-1-i;j++){

               if(ratios[j+1]>ratios[j]){

                   double temp=ratios[j+1];

                   ratios[j+1]=ratios[j];

                   ratios[j]=temp;

                   

                   int temp1=values[j+1];

                   values[j+1]=values[j];

                   values[j]=temp1;

                   

                   temp1=weights[j+1];

                   weights[j+1]=weights[i];

                   weights[i]=temp1;

               }

           }

       }

       

       //find the capacity that the bags can hold

       //formula to find the fractional weight ---> capacity/weights[i]*values[i]

       

       int i=0;

       while(capacity!=0 && i<values.length){

           if(capacity>=weights[i]){

               profit+=values[i];

               capacity-=weights[i];

           }else{

               profit+=((double)capacity/weights[i]*values[i]);

           }

           i++;

       }

       

       

       return profit;

   }

   

   public static void main(String[] args){

       int values[]={60,100,120};

       int weights[]={10,20,30};

       int capacity=50;

       System.out.print(dpfraction(values,weights,capacity));

   }

}
