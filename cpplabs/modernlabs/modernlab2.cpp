#include<iostream>
 
 namespace DynmaicAllocate{

    char ** Create2dArray(int size){

        char ** arr= new char* [size];
        for(int i =0 ; i< size ;i++){
            std::cout<<"enter your "<<i<<" sting"; 
            arr[i]= new char[3] ;

            for(int j =0 ; j<3 ;j++){
                
                std::cin>> arr[i][j] ; 
            }

        }
        return arr ; 
    }
 }

int main(){
// std::cout<<"enter the arrat length"<<std::endl; 
char ** name = DynmaicAllocate::Create2dArray(2); 
for(int i = 0 ; i < 2 ; i++ ){
    std::cout<<name[i];}

}