#include<iostream>
#include<string>

std::string StrigReplace(std::string  haystack , std::string needle , std::string replace); 

int main(){
    std::string haystack ,needle ,replace  ; 
    std::cout<<"enter whole string " ; 
    getline(std:: cin, haystack); 
    std::cout<<"enter neddle " ; 
    std:: cin >> needle ; 
    std::cout<<"enter replacement " ; 
    std:: cin >> replace ; 
    std::cout<< StrigReplace(haystack , needle , replace)<<std::endl; 

    

}
std::string StrigReplace(std::string  haystack , std::string needle , std::string replace){

    int pos = haystack.find(needle) ; 
    while(pos != std::string::npos){
        haystack.replace(pos,needle.length(),replace);
        pos = haystack.find(needle , pos+replace.length()) ;
    }
    return haystack ; 
}