import java.util.*;
public class MergeIntervals {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().trim();

        // list<list<integer>>
        //intervals
        List<List<String>> list = new ArrayList<>();
        if (input.startsWith("[[") && input.endsWith("]]")) {
            String stripped = input.substring(2, input.length() - 2);
            String[] rows = stripped.split("\\],\\s*\\[");
            for (String row : rows) {
                String[] elements = row.split(",\\s*");
                list.add(new ArrayList<>(Arrays.asList(elements)));
            }
        } else {
            System.out.println("Invalid format. Please use the [[x,y],[a,b]] format.");
        }

        //new intervals
        String newinput=scanner.nextLine();
        newinput=newinput.substring(1,newinput.length()-1);
        String strarr[]=newinput.split(",");
        int arr[]=new int[strarr.length];
        for(int i=0;i<strarr.length;i++){
            arr[i]=Integer.parseInt(strarr[i]);
        }

        //converting the list of the string values to the integer;

        List<List<Integer>> intervals=new ArrayList<>();
        for(List<String> i:list){
            List<Integer> in=new ArrayList<>();
            for(String j:i){
                in.add(Integer.parseInt(j));
            }
            intervals.add(in);
        }
        List<Integer> newinterval=new ArrayList<>();
        for(int i:arr){
            newinterval.add(i);
        }
        //newinterval->[_,_];
        //intervals->[[_,_],[_,_]];
        intervals.add(newinterval);
        intervals.sort((a,b)->Integer.compare(a.get(0),b.get(0)));
        List<int[]> result=new ArrayList<>();
        int current[]={
            intervals.get(0).get(0),
            intervals.get(0).get(1)
        };
        for(int i=1;i<intervals.size();i++){
            List<Integer> interval=intervals.get(i);
            if(current[1]>=interval.get(0)){
                current[1]=Math.max(interval.get(1),current[1]);
            }else{
                result.add(current);
                current=new int[]{
                    interval.get(0),
                    interval.get(1)
                };
            }
        }
        result.add(current);

        //print
        System.out.print("[");
        for(int i=0;i<result.size();i++){
            System.out.print(Arrays.toString(result.get(i)));

            if(i != result.size()-1){
                System.out.print(",");
            }
        }
        System.out.println("]");
    }
}