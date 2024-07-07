#include <iostream> 
#include<math.h>
#include<ctype.h>
namespace MathFunction {

    void print(double number ){

        std::cout<<sqrt(number) ; 
    }
}


namespace StringFunction{
     
    void print(char * ptr , int size) {
        for(int i = 0 ; i< size ; i++ ){
            std::cout<< static_cast<char>(tolower(*ptr)) ; 
            ptr ++ ; 
        }
    }
}

namespace ArrayFunction {
    
    void print(int * arr , int size ){
        for(int i =size-1 ; i >=0 ; i--){
            std::cout<<arr[i]<<std::endl; 
        }
    }
} // namespace ArrayFunction 

int main(){

int arr[]={1 , 2 , 3 ,4 } ; 
ArrayFunction::print(arr , 4 ); 

char name []="MAHMOUD HAMED" ; 
StringFunction::print(name, 13); 
std::cout << std:: endl ; 

MathFunction::print(15.66) ;
std::cout << std:: endl ; 


}