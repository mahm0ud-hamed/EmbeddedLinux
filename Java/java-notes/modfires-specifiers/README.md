# Modifires and Access Specifires in Java  

- **public** : is accessable from any where in program 
    - class:  that class can  be imported outside the package it belong to 
    - method : it accessable in calss and outside class 
    -  
- **private** : 
    - variavble : accessable in side class oly 


- **protected** : member is accessable inside class and through inheritance and inside the package it belong to 
    - method 
    - variable 

- **default access** : if you never any specifire "firendly, package access" is accessable in same package only and it cant be imported 
    - method 
    - variable 
    - class 

- **public class** can access from another package using fully qulaified class name "class D extends package1.a{}"
    - fully qulified class name -> packageName.class name 


- **Static** : is a class member is belong to class no for object it can be access through class name or object name 
    - static method : is a utility method 

- free floating block is a part of code run when the class go inside memory used to initialize static members using any code you need  can called as "static initializer "

```java
class myclass{
    private int x ; 
    private static int y ; 
    static {

        // write any part of code you need not depend on class code methods
        // we are using this static intializer to avoid make static method that will forec developer to call static memner , bu using this satatic initializer the part of code will run automatically once calss go inside memory  
        // ii will rin before constructor 
        // it will run one time even if you create many objects 

    }
}
```

- **Abstract** : 
    - class : is a class cant creat object of it 
        - if it contain abstrct method class must be abstrcat also 


- **final** 
    class : can't make iheritance form this calss 
    method : cant be overrridden 
    variable : is a constant variable once it take the first value you cant chane it any more
    refrence : cant point to another object 

- **native** 
    - method  : can write a c or cpp code inside method 

- **volatile** 
    - lock for variable or method  for threadig 
    - using with thread that access variable or method that access variable 

    - volatile with varaible 
    - synchronized with method 

- **transient**
    - serializrion is to tansform object to array of bytes , that will take a snapshot of object state  
    once you pass object to another 
    - transient will remove an member variable for serializtion operation 


- when you find any intger varibale it vlaue dosent under any locg to calculate , search inside class it me public static final 

- when you fine abstrcat calss like tool kit and need object to use , search for publuc static method that will return object from class 

## exception handlinng 

- exception is an object is created in run time , an it was crested by happening of un excpected behaviour
    - unexcpeted but it not developer mistake 
        - devloper write code correct and run correct but outside behaviour make the exception 

    - unexcpeted and it was developer mistake 
        - use refrence which its value null 

- **exception** 

- throwable 
    - error : out of memory , stack over flow 
    - exceptions
        - checked exceptions : NOT DEVELOPER MISTAKE , terminate compilation , help you to make an exception hadeling code to handle exception expected to happen , unchecked exception , iherite from run time exception and then inherite from exception , no handeling for unchecked exception 
        - run time exception : 

- how to make ann exeption handeling : 
    - try catch finally 
    