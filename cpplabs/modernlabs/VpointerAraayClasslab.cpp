#include<iostream>

enum  DT {
     _int='i', 
    _char ='c', 
    _double='d'
};

class VpointerArray{
    void ** ArrayVpointer ; 
    int size ; 
    public: 
    VpointerArray(int size ){
        ArrayVpointer= new void*[size] ;
    }
    ~VpointerArray(){

        delete[] ArrayVpointer ;
    }
    void SetSpecificIndex(int Index , void * ptr){
        if( typeid(int).name() == typeid(ptr).name()){
            ArrayVpointer[Index]=ptr; 
        }
        else if ( typeid(char).name() == typeid(ptr).name()){
            ArrayVpointer[Index]=static_cast<char*>(ptr);
        }
        else if ( typeid(double).name() == typeid(ptr).name()){
            ArrayVpointer[Index]=static_cast<double*>(ptr);
        }
        else{
            std:: cout<<"wromg data type"<<std::endl; 
        }
    }
    void* 
};