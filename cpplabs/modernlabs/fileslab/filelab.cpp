#include<iostream>
#include<fstream>
#include <iomanip>
#include<vector>

/*  open file 
    read data in file 
    store every elemnt in vector 
    calaculte needed data 
    new output file 
    write output on it using manipulators 
*/

int main (){

    std::vector<int> values(10 , 0) ; 
    std:: string  line ;
    int value =0; 
    int i = 0  ; 
    int sum=0 ;
    double  avg =0 ; 
    int  max ; 
    int min ; 
  
    /* open input file */
    std::ifstream input; 
    input.open("textfile.txt") ; 

    if(!input.is_open() ){
        std::cout<<"cant open file "<<std::endl; 
        return 1  ; 
    }

    while(std::getline(input, line)){
       value = std::stoi(line) ;
       values[i]= value ;  
          ++ i ;  
    }
    input.close();

    max = min = values[0] ; 
    /*determine max value */
    for(int j =0 ; j < i ; j++){
        if(values[j] > max ){
            max = values[j]; 
        }
        if(values[j] < min ){
            min = values[j] ; 
        }
    }
    /* determin sum */
    for(int j =0 ; j< i ; j++){
        sum+=values[j];
    }
    /* get avrg */
    avg = sum / 10 ; 

    std::ofstream out("outfile", std::ios::out); 
    if(!out){
        std::cout<<"cant open file "<<std::endl;
        return 1 ; 
    }   

    // std::cout<<std::setw(40)<<std::setfill('-')<<""<<std::endl;
    // std::cout<<"|"<<std::setw(6)<< "sum" <<std::setw(4)<<"|"<<std::setw(6)<< "avg" <<std::setw(4)<<"|"<<std::setw(6)<< "min" <<std::setw(4)<<"|"<<std::setw(6)<< "max" <<std::setw(4)<<"|"<<std::endl;
    // std::cout<<"|"<<std::setw(39)<<std::setfill('-')<<""<<"|"<<std::endl;
    // std::cout<<"|"<<std::setw(6)<< sum <<std::setw(4)<<"|"<<std::setw(6)<< avg <<std::setw(4)<<"|"<<std::setw(6)<< min <<std::setw(4)<<"|"<<std::setw(6)<< max <<std::setw(4)<<"|"<<std::endl;
    // std::cout<<std::setw(41)<<std::setfill('-')<<""<<std::endl;
    
    out<<std::setw(40)<<std::setfill('-')<<" "<<std::endl;
    out<<"|"<<std::setw(6)<< "sum" <<std::setw(4)<<"|"<<std::setw(6)<< "avg" <<std::setw(4)<<"|"<<std::setw(6)<< "min" <<std::setw(4)<<"|"<<std::setw(6)<< "max" <<std::setw(4)<<"|"<<std::endl;
    out<<"|"<<std::setw(39)<<std::setfill('-')<<""<<"|"<<std::endl;
    out<<"|"<<std::setw(6)<< sum <<std::setw(4)<<"|"<<std::setw(6)<< avg <<std::setw(4)<<"|"<<std::setw(6)<< min <<std::setw(4)<<"|"<<std::setw(6)<< max <<std::setw(4)<<"|"<<std::endl;
    out<<std::setw(41)<<std::setfill('-')<<""<<std::endl;
    //out<<std::setw(50)<<std::setfill('-')<<""<<std::endl;

    out.close();

}
