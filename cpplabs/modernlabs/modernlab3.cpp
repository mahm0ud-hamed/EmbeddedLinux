#include<iostream>

namespace ArrayPair{
    std::pair<int , int >* CreateArray(int size){
       std:: pair<int , int >* mahmoud= new  std:: pair<int , int >[size] ;
    }
    void DeleteArrayPair( std::pair<int , int >* arraypair){
        delete arraypair ; 
    }
    void SetPairs(std::pair<int , int >* arraypair ,int size ){
         int x , y  ; 
        for(int i =0 ; i< size ; i++){
            std::cout<<"eneter the first of current element "<<std::endl; 
            std::cin>> x; 
            std::cout<<"eneter the fisecod first of current element "<<std::endl; 
            std::cin>> y; 
            arraypair[i].first= x  ; 
            arraypair[i].second= y  ; 
        }
    }

    std::pair<int , int > GetPair(std::pair<int , int >* arraypair , int Index ){
        return arraypair[Index]; 
    }
    
    void PrintArrayOfPair(std::pair<int , int >* arraypair , int size ){
        for (int i= 0 ; i<size ; i++){
            std::cout<<"first"<< arraypair[i].first << arraypair[i].second<<std::endl;

        }
    }
}
    int main(){

        std::pair<int , int > *mahmoud= ArrayPair:: CreateArray(2); 
        ArrayPair:: SetPairs(mahmoud , 2) ; 
       std::pair<int , int > ahmed =  ArrayPair::GetPair(mahmoud, 1) ; 
       std::cout<<"amed first "<<ahmed.first <<"ahmed second "<<ahmed.second<<std::endl; 
        return 0 ; 
    }


