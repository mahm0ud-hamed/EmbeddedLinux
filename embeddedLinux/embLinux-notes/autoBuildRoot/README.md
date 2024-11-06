### Auto Build root 
creating image from scratch 
1. croos compiler 
2. uboot 
3. kernel 
4. busybox 

### how to make auto build root 

creating scripts and pass to it some configuration and it make some fetching from repos and after building it generate image 

## image content 
1. uboot , kernel 
2. userspace environment

how auto buildroot work 

it create its own environment 

## the most famous auto build root app 
1. build root 
2. Yocto 

## why yocto is better than build root 
1. build root contain less package than yocto -> features yocto has large features  
    to solve this problem you need to make it manulay which is 
    - searching for application source code 
    - build it using cross compiler 
    - inject it in image rootfs 

## disadvantage of yocto auto buildroot tool 
timing ->      yocto take large time 

foot print image  ->  yocato take large foot print 

wrokspace ->   yocto ocupy large workspace

## advantage of build root than yocto 
1. foot print image smaller than yocto 
2. timing take less time to generate image than yocto 
3. workspace space smaller than yocto 

## to configurre uboot in auto build root tools 
1. make -u-boot menuconfig 
## to configure kernel 
1. make -linux menuconfig 

### how to use build root 
1. git clone build roo 
2. cd build root 
3. make menuconfig -> open configuration window 
    1. tool chain -> chosse library you want  (glibc , musl ) 
        1. type of shell 
        2. enable boot passwd 
    2. kernel -> version of kernel 
    3. target package -> (user space applications )
        1. dropbear -> same ass open ssh (dropbear contain the most important applications in openssh)
        2. games -> it contain games ^_^

    5. file system image 
        1. type of rootfs 
        2. size 
    6. bootloader 
        1. select bootloader ( u-boot )
### output image from build root to your SD card 
```bash 
dd if=image.sd of=/dev/mmc#blk bs=4M status progress 
```
if -> input file 
of -> output file 
bs -> transfrering rate 
status progress -> trnsfere until finsih input file size 
-> it will copy content to your SD card also the type of filesystem 

### build root task 
    make application multithread application -> deampapp 
    -> target package 
    -> in make menuconfig [ ]check box of DemoApp
    -> under ./package crate demoapp and 
        under ./package/demoapp 
            -> config.in file 
            -> makefile or C-MAKE with CC compiler variable to compiler with any nedded compiler 
            -> crate file.mk -> descripton of  



