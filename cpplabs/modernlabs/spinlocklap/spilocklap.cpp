#include<iostream>
#include<thread>
#include<chrono>
#include<atomic>
#include<vector>
int  result= 2 ; 
class Spinlock{
    private : 
    std::atomic_flag flag ; 
    public: 

    Spinlock():flag{ATOMIC_FLAG_INIT} {}
    void lock(int trehsold=20 ){
        int counter =0 ; 
        while (flag.test_and_set(std::memory_order_acquire)){
            if(++counter >= trehsold){
                std::this_thread::sleep_for(std::chrono::milliseconds(20)); 
                counter =0 ; 
            }

        }
        
    }

    void unlock(){

        flag.clear(std::memory_order_release);
    }

}; 

void Multiply(int var){
    var*=2 ; 
    std::cout<<"variable multiblicated *2 "<<var<<std::endl; 
}

void Divide(int var){
    var/=2 ; 
    std::cout<<"variable in dividoin is "<<std::endl; 
}

int main(){ 
   
    std::vector<std::thread> threads ; 
    threads.emplace_back(Multiply,result); 
    threads.emplace_back(Divide, result); 
    for(auto &t : threads){
        t.join();
    }
    return 0 ; 
}