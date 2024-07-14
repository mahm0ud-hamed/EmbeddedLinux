#include<iostream>
#include<string>

int main(){

    std:: string text = "the cylce of life is a cylce of cylces " ;
    std:: string wr = "cylce" ;  
    auto pos  {text.find(wr)}; 
    std::cout<<"position"<< pos <<std::endl; ; 
    while( pos != std::string::npos){ 
        text.replace(pos,wr.length(),"circle"); 
        pos = text.find(wr , pos+wr.length()) ;
        std::cout<<"next postion "<<pos+wr.length()<<std::endl; 
    }
    std::cout<< text<<std::endl ;
    pos = text.find("circle") ;
    text.insert(pos,"greate ");
    // insert never end before the second circle 
    
    std::cout<< text ; 


}


