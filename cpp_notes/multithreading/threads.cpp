#include <iostream>
#include<thread>

class count{
    private : 
        int id {0} ; 
        int iterator {0} ;
    public: 
    count(int id , int iterator ):id{id}, iterator{iterator} {}
    void 

}; 
void counter(int id , int iterator){

    for(int i{0} ; i< iterator ; i++){
        std::cout<<"in id "<<id<<"counter is "<<i<<std::endl; 
    }
}

int main(){

    std::thread t1(counter, 1 , 100 ); 
    std::thread t2(counter , 2, 100 ); 

    t1.join(); 
    t2.join() ; 
}