#include<iostream> 

// template< typename T , typename T2 >
// auto GetValue(T first , T2 second){
//     return first ; 
// }

template<typename T , typename T2>
class Pair{
    T first ; 
    T2 second ;
    public: 
    Pair(){
        this->first = 0 ; 
        this->second = 0 ; 
    }
    Pair(T first , T2 second):first(first),second(second){

    }
    void SetFirst(T first){
        this->first = first ; 
    }
    T2 SetSecond(T2 second){
        this->second = second ; 
    }
    T  GetFirst(){
        return this->first ; 
    }
    T2  GetSecond(){
        return this->second ;
    }
    void SetPair(T first , T2 second){
        this->first = first ; 
        this -> second = second ; 
    }
    void SwapPair() {
        auto temp =0 ; 
        temp= first; 
        first = second ; 
        second = temp ; 
    }
};

int main(){
 
 Pair<int , int > mahmoud ( 2 ,5 ); 

}

