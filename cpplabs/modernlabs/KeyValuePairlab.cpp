#include<iostream>

template < typename T , typename T2 >
class  Keyvalue {
    private: 
    T key; 
    T2 value ; 
    public : 
    Keyvalue(){
        this->key= 0 ; 
        this->value=0; 
    }
    Keyvalue(T key , T2 value):key(key),value(value){}

    void Setkey(T key){
        this->key = key ; 
    }
    void SetValue(T2 value){
        this->value = value ;
    } 
    auto GetKey(){
        return this->key ;
    }
    auto GetValue(){
        return this->value ;
    }
}; 

int main(){
    Keyvalue <int,int> mahmoud ;
   std::cout<<"key = "<< mahmoud.GetKey()<<std::endl; 
   std::cout<<"value = "<< mahmoud.GetValue()<<std::endl; 



}
