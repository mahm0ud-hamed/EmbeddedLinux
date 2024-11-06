# interfaces 
**Synatx**
```java

interface Numbers{
    public  int getNext();
    abstract void reset(); 
    void setStart(); 

}

``` 
- in override you can large access specifire not small it you can 

- is that valid to make refrence from interfaec to point in impelemnt class that implement interface ? 
    - yes it can done to have a refrence from interface point to an impelemnt class 

## multi threading 
what is the multithreading ? 

- at least jaava program contain two threads one for java program and garbage collector 

- types of threads 
    - dameon thread 
        - garabage collector 
    - user created thread  

- thread has 
    - life cylce 
        - start() - just go in ready queue by developer 
        - run() -> dsipatecher will run threads will clled as call back function 
        - sleep()-> go in wait for specific time and when it out will go in ready queue 
        - suspend()*-> will go in wait state and will not go in ready queue until make resume()*; 
        - stop()*-> will kill thread objetc 
    - rub method 

- creating thread in java 
    - **extend thread class so you have life cycle**
     and run method 
         - never call run method , you has to start thread it will go in ready queue and os will call run method with callback **if you call run() by yourself it will treated as ordinary method on main threaad if it was a heavy task may cause application freez**

    - **impelemnt runable interface**
        - crate an object fotm thread class 
        - it has a constructor that take a object refrence to runable so it will call interface function "it treated as interface object point to implement object "

    - 


- **when to create thread ?** 
    - Blocking code
        - like while(true)
        - listen in connection ,sensor or reading file  
    - lenght code 
        - any connection code 
        - accessing data base 
        - hardware accessing 