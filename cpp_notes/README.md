### atomic operation 
its a reentrant used wiht "primitive data types " to prevent data race between threads on multi threading applications 


its a way to pevent data race in  multithreading by excute 

```c++ 
std::atomic < T > object ; 
```
object  will be the shared resourece between threads 
it was a synchoranization mechanism 


## locck gaurd 
 its automaticlaly release mtx 
 ```c++ 
 std::lock_gaurd l(mtx) ; 
 ``` 
 ## unique-lock 
 it same as lock-gaurd 
 ```c++ 
 std::unique_lock(mtx , std::defer-lock);
 /* unique lock is to lock in mutex but not at this moment it will done after an event */ 
 ``` 

 ## scoped lock 
 ``` c++
 std::scoped-lock(mtx r1 , mtx r2 , mtx r3 , mtx r4); 
 ```  
### mutex types 

1. std::mtex -> can be accuired and not time to release it 
    1.  recursive mutex 
    2. shred mutex -> its read only mutex 
2. std::timed-mutex -> can accuore for certain time 
    1. recursive mutex 
    2. shred mutex 

    ## condition variable 
    used with mutex 

### semaphore 
-> counter synch mechanism 
types of semaphore 
1. binary semaphore 
2. counting semaphore 

-> semaphore dosent has the concept of ownership 

task -> read about future and promise 
