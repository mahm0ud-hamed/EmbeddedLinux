#include<iostream>
#include<thread>
#include<chrono>

void Beeb(int x ){
    std::string input ; 
    while(true){
        std::cout<<'\a'<<std::flush; 
        std::this_thread::sleep_for(std::chrono::seconds(x)) ;
        std::getline(std::cin , input ); 
        if(! input.empty()){
            break ;
        } 
        
    }

    
}


int main(){

    std::thread b{Beeb , 3} ; 
    b.join(); 

    return 0 ; 
}