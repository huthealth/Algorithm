package Etc;/*
public class MergeSort {
    public void mergeSort(int[] ary, int start, int end, int[] sortedAry){
        if(start >= end) return;
        int mid = (start+end)/2;
        mergeSort(ary,start,mid,sortedAry);
        mergeSort(ary,mid+1,end,sortedAry);
        merge(ary,start,mid,end,sortedAry);
    }

    private void merge(int[] ary, int start, int mid, int end, int[] sortedAry){
        int leftPartIndex = start;
        int rightPartIndex = mid+1;
        int sortedAryIndex = start;

        while(leftPartIndex<=mid && rightPartIndex<=end){
            if(leftPartIndex<=mid && ary[leftPartIndex] <= ary[rightPartIndex]){
                sortedAry[sortedAryIndex] = ary[leftPartIndex];
                sortedAryIndex++;
                leftPartIndex++;
            }
            else{
                sortedAry[sortedAryIndex] = ary[rightPartIndex];
                sortedAryIndex++;
                rightPartIndex++;
            }
        }

        if(leftPartIndex > mid){
            for( ; rightPartIndex<=end ; rightPartIndex++ , sortedAryIndex++){
                sortedAry[sortedAryIndex] = ary[rightPartIndex];
            }
        }
        else {
            for( ; leftPartIndex<=mid ; leftPartIndex++, sortedAryIndex++){
                sortedAry[sortedAryIndex] = ary[leftPartIndex];
            }
        }

        for(int i = start;i<=end;i++){
            ary[i] = sortedAry[i];
        }

    }

    public static void main(String... args){
        int[] ary = {1,100,5};
        int[] ary2 = new int[ary.length];

        MergeSort m = new MergeSort();
        m.mergeSort(ary,0,ary.length-1,ary2);
        for(int i : ary2) System.out.println(i);
    }
}
*/

public class MergeSort {
    public void mergeSort(int[] ary, int start, int end, int[] sortedAry) {
        if(start >= end) return;

        int middle = (start + end) /2;
        mergeSort(ary, start, middle, sortedAry);
        mergeSort(ary,middle+1, end, sortedAry);
        merge(ary, start, middle, end, sortedAry);
    }

    private void merge(int[] ary, int start, int middle, int end, int[] sortedAry){
        int leftIndex = start;
        int rightIndex = middle + 1;
        int sortedAryIndex = start;
        while(leftIndex <= middle && rightIndex <= end) {
            if(ary[leftIndex] <= ary[rightIndex]) {
                sortedAry[sortedAryIndex] = ary[leftIndex];
                leftIndex++;
            }
            else {
                sortedAry[sortedAryIndex] = ary[rightIndex];
                rightIndex++;
            }
            sortedAryIndex++;
        }

        if(leftIndex<=middle){
            for(;leftIndex<=middle;leftIndex++,sortedAryIndex++){
                sortedAry[sortedAryIndex] = ary[leftIndex];
            }
        }
        else{
            for(;rightIndex<=end; rightIndex++,sortedAryIndex++) {
                sortedAry[sortedAryIndex] = ary[rightIndex];
            }
        }

        for(int i = start; i <= end; i++) {
            ary[i] = sortedAry[i];
        }
    }
}