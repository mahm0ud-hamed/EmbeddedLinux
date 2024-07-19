#include<iostream>

/*
Implement a class for a dynamic array (Vector)
    * Containing the following functions
        * resize() - resize the array to double the size
        * pushback(value) - add the value to the end of the array
        * popback() - remove the last element from the array
        * removeAt(index) - remove the element at the given index
        * insertAt(index, value) - insert the value at the given index and shift the elements to the right
        * insertMiddle(value) - insert the value in the middle of the array
        * removeMiddle() - remove the middle element from the array
        * size() - return the size of the array
        * print() - print the array
 
    * The following overload constructors:
        * DynamicArray() - default constructor with capacity of 1
        * DynamicArray(size) - constructor with given capacity
        * DynamicArray(size, value) - constructor with given capacity and initial value for all elements --> DynamicArray arr(5, 10);
        * DynamicArray(size, values) - constructor with given capacity and initial values --> DynamicArray arr(5, new int[5]{1, 2, 3, 4, 5});
        * DynamicArray(arr) - copy constructor
 
    * Appropriate destructor
 
    - Private members:
        * array - pointer to the array
        * capacity - capacity of the array
        * currentSize - current size of the array */
template< typename T >
class _vector{
    T * array ; 
    int capacity ; // the wohle size used and unused 
    int size ;     // the used size only  
    public: 
    _vector():capacity(1),size(0){
        array = new T[capacity] ;  
    }

    _vector(int capacity ):capacity(capacity),size(0){
        array = new T[capacity] ; 
    }

    _vector(int capacity , int initVal  ):capacity(capacity){
        array = new T[capacity] ; 
        /* init all array element with same value */
        for(int i =0 ; i < initVal ; i++){
            array[i]= initVal ; 
        }
        size = capacity ; 
    }

    _vector(std::initializer_list<int> initlist){
        int i =0 ; 
        for(auto elem : initlist ){
            array[i] = elem ; 
            i++ ; 
        }
        capacity = initlist.size() ; 
        size = capacity ; 
    }

    ~_vector(){
        delete[] array ;
    }

    void print(){
        for (int i =0 ; i< size ; i++){
            std:: cout<< array[i]; 
        }
        std::cout<<std::endl; 
    }
    void printsize(){
        std::cout<< size << std::endl; 
    }
    void removeMiddle(){
        if(size > 1){
            int mid = static_cast<int>(size/2);
            for(int i =mid ; i< size ;i++){
                array[i] = array[i+1] ; 
            }
            size -- ; 
        }
        
    }
    void insertMiddle(T value){
        if(size > 1){
            int mid = static_cast<int>(size/2);
            for(int i = size-1 ; i>= mid ;i--){
                array[i+1] = array[1] ; 
            }
            array[mid]=value ; 
            size ++ ; 
        }        
    }
    void insertAt(int index, T value){
        // double array if size = capacity 
        if(index <= size){
            // need to shift array element 
            for(int i = index ; i< size ; i++){
                array[i+1]= array[i] ; 
            }
            array[index] = value ; 
            size ++ ; 
        }
    }
    void removeAt(int index){
        if(index <= size ){ // && > 0 
            // need to shift all array to left and then update size 
            for(int i = index ; i<size ; i++){
                array[i]= array[i+1] ; 
            }
            size-- ; 
        }
    }
    void resize() {
        capacity*=2 ; 
        int * newArray = new int [capacity] ; 
        delete [] array  ;
        array = newArray ; 
    }
    void pushback(T value){
        if (size == capacity){
            resize(); 
        }
        else {
            array[size] = value ; 
        }
    }
    void popback(){
        if(size > 0 ){
            size -- ; 
        }
    } 
   /* copy constructor 
    _vector(_vector & _newVec){

    }
*/
};
int main(){

    _vector <int>myvec ; 
    myvec.printsize(); 
    std::cout<<"----------------"<<std::endl; 
    _vector <char>vec1(5 , '5'); 
    vec1.printsize();
    vec1.print(); 
    std::cout<<"----------------"<<std::endl; 
    std::cout<<"-----After insertion -------"<<std::endl; 
    vec1.insertAt(2 ,6);
    vec1.printsize();
    vec1.print(); 
    std::cout<<"------insert middle------"<<std::endl;
    vec1.insertMiddle('6');  
    vec1.printsize();
    vec1.print(); 
    std::cout<<"------delete middle------"<<std::endl;
    vec1.removeMiddle();
    vec1.printsize();
    vec1.print(); 
}