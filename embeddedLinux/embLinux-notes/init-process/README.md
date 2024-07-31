### inint process 
first process created by the kernel 
init=/sbin/init 

## busybox init process " simple init process "
1. running application /sbin/init there is input file which is inittab  
* inittab format 
node :: action :: application to run 

* ::sysint ::/etc/init.d/rcs 
* rcS bash script to auto mount proc and sys ``` to prevet user to make it every time 
* rcS loaction in etc because it is a configuration file  
* :: askfirst :/bin/sh ->ask user to press enter before run kernel 

## how the rcs script run and there is no shellrunning in this stage ?
because the shebang !#/bin/sh 
this indicates that this script is shell script it will run this script as bash script 

the program it will die becouse exit status of program

any interpreted languge need shebang to specify type of this script 

### system v init process 

why to switch from busy boc to system v ? 
if am run only one init process -> 
you will init all nedded and unnedded functionality 

so we will partiotion our sysytem to run level which is equilvelnt to mode 

every node will specify functionalities to run 
mode 1 run  
    1. run gui 
    2. init wifi 
mode 2 
    1. deinit gui 
    2. deinit shell 
mdoe 3
    1. deinit wifi 
    2. deinit gui 
    3. init gui 

## why mode is used ? 
mode is used to init to reduce cpu load on system 

## how to switch between mode 
init or 

wahts is the used of this modes in embedded 

in embedded linux are divided into 2 modes 
mode 1 
    application mode 
        infotainment 
mode 2 
    maintinance mode 
         -> in service center when connect to OBD
         -> flashin 

## how system v make this mode 
# 1. create a large dir which contain scripts for programs /etc/init.d such as : 
    1. tftp 
    2. blutooth 
# 2. create /etc/rc1.d 
# 2. create /etc/rc5.d 
# 2. create /etc/rc3.d
each run level has it own folder 

we will make a softlink in each mode directory for program tht we need on this  mode 
/etc/rc1.d
ln -s /etc/init.d/network k01 network -> k stand for kill 
ln -s /etc/init.d/ssh  s02 ssh -> s start stand for  

/etc/rc5.d
ln -s /etc/init.d/network s01 gui ->

what was in tftpscript 
switch ($1)
    start) 
    start-stop-daemon /usr/bin/tftp --start

    stop ) 
    start-stop-daemon /usr/bin/tftp --stop 

    * ) 

in rc.c 
```c 
int runlevel /* mode selector*/
switch(runlevel){ 
    case 1 :
        cd /etc/rc1.d/
        for (parsing to any files in that start with k and you will increment in prority )
        for(parsing(k),00){
            k01gui -> pass tp tftp stop
        } 

        for(parsing(s),00){
            s01shell ->pass start to tftp satrt to start application 
        }

}
``` 
in inttab for system v 

node:runlevel: action : app -> this called node 
:s:sysinit:rcS -> will parse rcS file which mount  proc , sys and go to run level which  select in rcS ->init 2 run on runlevel 2 

:1: wait : rc 
:2: wait :rc 
-> we run rc in each level becouse it was check for workiing level 
it can formated as :1 2 3 4 5 : wait :rc 

change runnig mode will not run sysinit again it will got to wait  direct 

1. kernel will run on init 
2. will run inittab 
3. will excute :s:sysintin : rcs at first and this will parse rcs which will mount and then select run mode 
then return to inittab and run wait which is selected in rcS in run mode and pass it to rc.c whic will start applaications and and block application that slected in each run mode in switch case 

after complete starting change change running mode will not run :s:sysinit:rcS again 

bydefault you run in s node 
you can change default in boot args  init = /sbin/intin 5 -> in meanuconfig 
or make in extlinux in label called APPEND 


## problem of system v 

1. initialization done in serial >> because of for loop in every application and start it in series 

### system D 

type of process in linux 
1. forground -> process runnig an user can make an interact with it 
2. back ground process -> process runnig and user cant make interact with at 
3. oriphin process -> 
    when process inti process creat process 2 and process 3 -> so process 2 was parent wto process 3 if process 2 get killed , init process will be parent of process 3 
4. zombie process ->  its a process that finished it work and dosen't return an exit status to it parent so parent cant complete its kill and free it resources fro init tabel so ->it take space form kernel process space whic is limited to run specific number of process at a time 
5. daemon process -> it's a back ground process in concept but it  can't be forground process its was an services run applications in back ground "jobs" command viwe runs back ground process 

## is an init process
/sbin/bin -> sotlinked to /lib/systemd/system -> which is a c apllication 

there is 2 main directories in systemd 

1. /etc/system/systemd-> contain configuration -> edit part any edit you need to make done here 

2. /lib/systemd/system/  

## unit concept 
![alt text](image.png)

unit was partitioned to  

    1. service -> run application 
    2. mount   -> mount 
    3. network -> setip
    4. automount ->  
    5. socket  -> realted to ports 
    6. traget  -> 

# each unit has a specific way to write it 
1. service -> run application in back ground as daemon process it will run without user interaction 

how to write srvice 
go configuration  : - 
/etc/systemd/system
touch myservie.service 
vim myservie.service 
-> header section 
[unit]
    description  =" .. "
    documentation=" url if it available"
    SourcPath    =" path of application ". 
    After        = give it another "unit file" - run myservice after "unit file" was runed .
    don't wait for its completion .
    wants = give it another "unit file" and run it and wait it to successfully run and then run myservice .
    Before       = give it another "unit file" run myservice before run the passed unit file "unit file" dont wait completion of myservice 
    requires = give it another "unit file" run my service and wait tell it was successfully run  and then the passed unit file .
[service] 
    type = type of process you need to create -> { simple , oneshot , forking }
            1. simple   -> if my service create process and myservice get killed , process also get killed 
            2. one shot ->  used for initialization -> for any application give funtionality direct 
            3. forking  -> if myservice create child process and myservice get killed -> init process will be parent of child process  you should write in execstop to kill process 
    Execstart= application to run -> only one application can be wriiten here  systemctl start  -> run Execstart variable
    Execstop = run this application when you send stop sigal to the service    systemctl stop  ->  run Execstop variable
    workdir  = path of directory tht contain applicaation 
    restart  =  on-faliure -> if application go to faliure state restart it aging / always -> restart applcaiton if it finish it work 
    restart sec = 3 -> wait 3 second befor restart 
    // service + apllcation = daemon prpcess 


### lets ceaete servive 
1. service name my touch -> service .service 
    [unit]
        want= touch -> mynetwork 

    [service]
    type= simple 
    ExecSatrt=ping 192.162.1.10 -> qemu ip 
    restart= always
    restartsec = 3 
    workdir= /usr/bin


2. network service 

    [uinit]
    name="enps 3"

    [network]
    ip=192.168.1.9
    subnet=255.255.255.0


systemctl 
1. start -> start service 
2. stop -> stop service 
3. cat 
4. edit 
5. get-default -> .target which is some of services 
    [isntall]
    wantedBy=graphic.target 
6. set-default 

## process of creating services 
systemctl list-dependcies 
any service you will create service -> /etc/systmd/system 
touch my service.service 
which containg unit and service  and install 

when  suystemctl enable myservice 
will see  install -> 'wantedBy=graphic.target'  and see that it is belong to which target "graphic.target" 
 in graphical.target will create softlink for service under /etc/systmd/system 
 # to show default target 
 systemctl get-default
 # to change default target 
 systemctl set-default multi-user.target 