#include<iostream>

class pair{
    private : 
    int first ; 
    int second ; 
    public: 
    pair(){
        this->first = 0 ; 
        this->second = 0 ; 
    }
    pair(int first , int second):first(first),second(second){

    }
    void SetFirst(int first){
        this->first = first ; 
    }
    void SetSecond(int second){
        this->second = second ; 
    }
    int  GetFirst(){
        return this->first ; 
    }
    int  GetSecond(){
        return this->second ;
    }
    void SetPair(int first , int second){
        this->first = first ; 
        this -> second = second ; 
    }
    void SwapPair() {
        int temp =0 ; 
        temp= first; 
        first = second ; 
        second = temp ; 
    }


}; 

int main(){

    pair mypair , yourpair(1,6); 
    std::cout<<"after default constructor"<<std::endl ; 
    std::cout<< "fisrt "<< mypair.GetFirst()<<std::endl ; 
    std::cout<< "second "<< mypair.GetSecond()<<std::endl ; 

    std::cout<<"after parameter constructor"<<std::endl ;
    std::cout<< "fisrt "<< yourpair.GetFirst()<<std::endl ; 
    std::cout<< "second "<< yourpair.GetSecond()<<std::endl ; 
    std::cout<<"-------------------------"<<std::endl ; 
    yourpair.SwapPair(); 
    std::cout<<"after swap"<<std::endl ;
    std::cout<< "fisrt "<< yourpair.GetFirst()<<std::endl ; 
    std::cout<< "second "<< yourpair.GetSecond()<<std::endl ; 
}