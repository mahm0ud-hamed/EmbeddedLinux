#include <iostream>
#include<string>
enum class error{
    BadRequest= 400 ,
    NotFound = 404 , 
    ServerError = 500 , 
    GetWayTimeOut= 504 
};

void PrintError(error value ); 

int main(){
    PrintError(static_cast<error>(500) ); 
}

void  PrintError(error value ){

    switch (value){
        case error:: BadRequest :  std::cout<< "BadRequest" ; break ; 
        case error:: NotFound :  std::cout<< "NotFound" ; break ;  
        case error:: ServerError :  std::cout<< "ServerError" ; break ;  
        case error:: GetWayTimeOut :  std::cout<< "GetWayTimeOut" ; break ;  

    }
}