public class Knapsack{

&#x20;   

&#x20;   public static double dpfraction(int values\[],int weights\[], int capacity){

&#x20;       double profit=0;

&#x20;       

&#x20;       double ratios\[]=new double \[values.length];

&#x20;       

&#x20;       //for finding the values per kg

&#x20;       

&#x20;       for (int i=0;i<values.length;i++){

&#x20;           ratios\[i]=(double)values\[i]/weights\[i];

&#x20;       }

&#x20;       

&#x20;       //sort them in desc to keep the greedy methods

&#x20;       

&#x20;       for(int i=0;i<values.length-1;i++){

&#x20;           for(int j=0;j<values.length-1-i;j++){

&#x20;               if(ratios\[j+1]>ratios\[j]){

&#x20;                   double temp=ratios\[j+1];

&#x20;                   ratios\[j+1]=ratios\[j];

&#x20;                   ratios\[j]=temp;

&#x20;                   

&#x20;                   int temp1=values\[j+1];

&#x20;                   values\[j+1]=values\[j];

&#x20;                   values\[j]=temp1;

&#x20;                   

&#x20;                   temp1=weights\[j+1];

&#x20;                   weights\[j+1]=weights\[i];

&#x20;                   weights\[i]=temp1;

&#x20;               }

&#x20;           }

&#x20;       }

&#x20;       

&#x20;       //find the capacity that the bags can hold

&#x20;       //formula to find the fractional weight ---> capacity/weights\[i]\*values\[i]

&#x20;       

&#x20;       int i=0;

&#x20;       while(capacity!=0 \&\& i<values.length){

&#x20;           if(capacity>=weights\[i]){

&#x20;               profit+=values\[i];

&#x20;               capacity-=weights\[i];

&#x20;           }else{

&#x20;               profit+=((double)capacity/weights\[i]\*values\[i]);

&#x20;           }

&#x20;           i++;

&#x20;       }

&#x20;       

&#x20;       

&#x20;       return profit;

&#x20;   }

&#x20;   

&#x20;   public static void main(String\[] args){

&#x20;       int values\[]={60,100,120};

&#x20;       int weights\[]={10,20,30};

&#x20;       int capacity=50;

&#x20;       System.out.print(dpfraction(values,weights,capacity));

&#x20;   }

}
