#include<stdio.h>
#include <stdlib.h>
/* data type of pointer to function that take to int and return int  */
typedef int(* PtrToFunc)(int *, int )  ;
int Add(int * , int  ); 

/* pointer to function that take 2d array and row size and # of cloumns and pointer to function take 2 arguments*/
typedef int * (*CallbackFunc)(int ** , int , int* , PtrToFunc ); 
int* ArrayAddRow(int** , int , int* , PtrToFunc );

int main(){

    int arr1[3]={1 ,2 ,3};
    int arr2[5]={1 ,2 ,3 ,4,5 }; 
    int arr3[4]= {1,2,3,4};
    int rows = 3; 
    int *_2dArr[]={arr1 ,arr2 ,arr3}; 
    int column[] = {3 , 5 ,4 } ;

    CallbackFunc pointertofunc = ArrayAddRow ;
    int *sumptr = pointertofunc(_2dArr, rows , column,Add); 

    for(int i =0 ; i<rows ; i++){
        printf("arr[%d] = [%d]\n" , i , sumptr[i]); 
    }
    /*delallocating memory */
    free(sumptr); 

}

 
int Add(int *arr , int size ){
    int sum =0 ;
    for(int i = 0 ; i < size ; i++ ){
        sum+= arr[i]; 
    } 
    return sum ; 
}
int* ArrayAddRow(int** arr  , int rows , int* columns  , PtrToFunc Addptr){

    int * SumArray = (int*)malloc(sizeof(int)* rows);
    for(int i = 0 ; i < rows ;i++ ){
        SumArray[i] = Addptr(arr[i], columns[i]);
    }
  return SumArray ;
}
 