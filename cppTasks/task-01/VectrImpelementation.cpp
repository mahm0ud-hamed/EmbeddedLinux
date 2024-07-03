#include<stdio.h>
#include<stdlib.h>

typedef struct{
    int * Vector = NULL  ;
    int size ; 
    int OcupiedSize ; 
}VectInfo ; 

void  InitVector(VectInfo * VectorInfo); 
void PrintVectro( VectInfo * VectorInfo ); 
void InsertElement(int pos , int  value , VectInfo * VectorInfo);
char * DeleteElement(int pos  , VectInfo * VectorInfo ) ;



int main(){
    
    VectInfo Myvector = {0 , 5 , 0} ; 
    InitVector(&Myvector); 
    InsertElement(2, 77 , &Myvector ) ; 
    PrintVectro(&Myvector);
    printf("\n\n\n vetor after delete element \n "); 
    DeleteElement(2, &Myvector) ; 
    PrintVectro(&Myvector);


}
/*function to initialize vector */
void InitVector(VectInfo * VectorInfo){
    // allocate memory for vector array 
    VectorInfo->Vector=  (int *)malloc( VectorInfo->size * sizeof(int)) ;
    /* getteing vector inatialization values from user */
    printf("enter the initiialization vlaues of vector \n"); 
   for(int i =0 ; i<VectorInfo->size ; i++){
    printf("mahmoud hamed"); 
    scanf("%d",&VectorInfo->Vector[i]) ; 
   }
   /* at initilaize ocupide size will be == to vector total size */
   VectorInfo->OcupiedSize = VectorInfo->size ; 
}

/* functio to print vector content  element by element */
void PrintVectro(VectInfo * VectorInfo){

        for(int i = 0 ; i < VectorInfo->OcupiedSize ; i++){
        printf("vector[%d]= %d\n1" , i , VectorInfo->Vector[i]); 
    }   
}
/* vector to insert element to vector */
void InsertElement(int pos , int  value , VectInfo * VectorInfo){
    /* if ocupide size equal to vector size  we will dublicate size of all vector */
    if(VectorInfo->OcupiedSize == (VectorInfo->size -1) ){
        printf("hello iam on condition") ; 
         VectorInfo->Vector= (int*)realloc( VectorInfo->Vector , sizeof(int) * VectorInfo->size * 2);
    }   
    /* shifting all array right by one to find place for the new inserted element */
    for(int i= VectorInfo->OcupiedSize ; i >= pos ; i-- ){
         VectorInfo->Vector[i+1]=  VectorInfo->Vector[i]; 
    }
    /* insert element in its position */
    VectorInfo->Vector[pos] = value ;
    VectorInfo->OcupiedSize ++ ; 
}
/* function to delete element from it position */
char * DeleteElement(int pos  , VectInfo * VectorInfo ) {
    /* shifting all elemnt to left */
    for(int i = pos ; i< VectorInfo->OcupiedSize ; i++){
        VectorInfo->Vector[i]= VectorInfo->Vector[i+1]; 
    }
    --VectorInfo->OcupiedSize ; 
}
