#include<iostream>

class Solution {
    int num=0 ;
public:
    Solution (){}
    int addDigits(int num) {
        int digSum =num ; 
       while (num / 10 ){
        digSum = 0 ;
        while (num){
            digSum+= num%10 ;  
            num/=10 ; 
        }
        num = digSum ;
       }  
       return digSum ;
    }
};


int main(){
    Solution p  ; 
    std::cout<< p.addDigits(1) ;
}