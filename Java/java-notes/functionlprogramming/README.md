# functional programming 
 - starting from jdk 8 there is a default keyword that will be a defualt impelementatin for function in interface 
 - to override a default method in interface it you must use default keyword
 - you can change the default method to be abstract againg and the class who will implelmnt or inherite must impelemnt this function again 
 - it could has a static method 


 # functional interfaces 

- SAM intercae single abstract method interface  which is a interface that has ser defined single abstract method 

- @functional interface is mark to IDE to be sure that this interfece is a functional iterface 



## lambda Expression 

- usede with single abstract mthod interface , when you has an interface that has a single abstract method you can use lambda to impelemnt this funvtion , you dont need tosay the funvtion name because it was a single method  and interece know his name ; 

- it will generate a compiler error if you passed different data type for the parameter 


## method refrences 

- Dzone website for method refrence 