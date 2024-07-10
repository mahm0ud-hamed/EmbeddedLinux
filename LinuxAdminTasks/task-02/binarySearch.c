
#include<stdio.h>


int BinarySearch(int * array , int size , int value  ) ; 

int main(){
int arr [] = {2 ,3 ,4 ,5,6} ; 
int result = BinarySearch(arr, 5 ,1) ;
    printf("%d\n", result) ;  


}

int BinarySearch(int *array , int size , int value ){
    int strt = 0  , end = size-1  , mid , result =-1 ; 

    while (strt <= end){
        mid = (strt + end)/ 2 ; 
        if(value == array[mid] ){
            return mid  ; 
        }
        else if(value > array[mid]){
            strt = mid+1 ; 
        }
        else if(value < array[mid]){

            end = mid-1 ; 
        }
    }
    return result ; 
}