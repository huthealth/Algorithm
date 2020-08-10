package Etc;

/*
public class QuickSort {

    private int partitioning(int[] ary,int lo, int hi){
        int pivot = ary[hi];
        int i = lo;
        for(int j = lo;j<hi;j++){
            if(ary[j] < pivot){
                swap(ary,i,j);
                i++;
            }
        }
        swap(ary,i,hi);
        return i;
    }

    private void swap(int[] ary, int i, int j) {
        int temp = ary[i];
        ary[i] = ary[j];
        ary[j] = temp;
    }

    public void quickSort(int[]ary, int lo, int hi){
        if(lo > hi) return;
        int pivot = partitioning(ary,lo,hi);
        quickSort(ary,lo,pivot-1);
        quickSort(ary,pivot+1,hi);
    }

    public static void main(String... args){
        int[] ary = {3,7,11,9,100,20,56,1,5,10,18,15};
        QuickSort qs = new QuickSort();
        qs.quickSort(ary,0,ary.length-1);
        for(int elem : ary)
            System.out.print(elem+" ");

    }
}
*/
public class QuickSort {
    public void quickSort(int[] ary, int start, int end) {
        if(start >= end) return;
        for(int elem : ary)
            System.out.print(elem+" ");
        System.out.println();
        int partitionIndex = partition(ary, start, end);
        quickSort(ary,start,partitionIndex);
        quickSort(ary,partitionIndex+1,end);
    }

    private int partition(int[] ary, int start, int end) {
        int pivot = ary[(start+end)/2];
        int i = start;
        int j = end;
        while(true) {
            while(i <= end && ary[i] < pivot) i++;
            while(j >= start && ary[j] > pivot ) j--;
            if(i>=j) return j;
            swap(ary, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] ary, int index1, int index2){
        int temp = ary[index1];
        ary[index1] = ary[index2];
        ary[index2] = temp;
    }

    public static void main(String... args){

        int[] ary = {3,2,6,1,5};
        //int[] ary = {3,1,5};
        QuickSort qs = new QuickSort();
        qs.quickSort(ary,0,ary.length-1);
        for(int elem : ary)
            System.out.print(elem+" ");
    }
}
