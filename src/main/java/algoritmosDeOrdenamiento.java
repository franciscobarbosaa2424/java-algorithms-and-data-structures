import java.util.ArrayList;
import java.util.List;

public class algoritmosDeOrdenamiento {
    //Selection Sort: O(n²).
    public static void selectionSort(List<Integer> list){
        int n = list.size();

        for(int i = 0; i < n-1;i++){
            int minIndex = i;
            for(int j = i+1; j < n;j++){
                if(list.get(j) < list.get(minIndex)){
                    minIndex = j;
                }
            }
            int temp = list.get(minIndex);
            list.set(minIndex,list.get(i));
            list.set(i,temp);
            System.out.println("cambios: "+list);
        }
    }

    static void main() {
        List<Integer> list = new ArrayList<>();
        list.add(64);
        list.add(25);
        list.add(12);
        list.add(22);
        list.add(11);
        selectionSort(list);
        System.out.println(list);
    }
}
