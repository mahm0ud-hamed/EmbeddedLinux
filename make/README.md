Why do Makefiles exist?

	Makefiles are used to help decide which parts of a large program need to be recompiled

Makefile Syntax
targets: prerequisites
	command
	command
	command
tareget:  is a file need to generate , The targets are file names, separated by spaces. Typically, there is only one per rule 
prerequisites: are also file names, separated by spaces. These files need to exist before the commands for the target are run. These are also called dependencies
example : 
hello:
	echo "Hello, World"
	echo "This line will print if the file hello does not exist."

We'll then run make hello. As long as the hello file does not exist, the commands will run. If hello does exist, no commands will run.
example : 
blah:
	cc blah.c -o blah

This time, try simply running make. Since there's no target supplied as an argument to the make command, the first target is run. 

In this case, there's only one target (blah). The first time you run this, blah will be created. The second time, you'll see make: 'blah' is up to date. That's because the blah file already exists. But there's a problem: if we modify blah.c and then run make, nothing gets recompiled

We solve this by adding a prerequisite:

blah: blah.c
	cc blah.c -o blah

	When we run make again, the following set of steps happens:

The first target is selected, because the first target is the default target
This has a prerequisite of blah.c
Make decides if it should run the blah target. It will only run if blah doesn't exist, or blah.c is newer than blah

This last step is critical, and is the essence of make. What it's attempting to do is decide if the prerequisites of blah have changed since blah was last compiled. That is, if blah.c is modified, running make should recompile the file. And conversely, if blah.c has not changed, then it should not be recompiled.

To make this happen, it uses the filesystem timestamps as a proxy to determine if something has changed. This is a reasonable heuristic, because file timestamps typically will only change if the files are modified. But it's important to realize that this isn't always the case. You could, for example, modify a file, and then change the modified timestamp of that file to something old. If you did, Make would incorrectly guess that the file hadn't changed and thus could be ignored.

More example : 

blah: blah.o
	cc blah.o -o blah # Runs third

blah.o: blah.c
	cc -c blah.c -o blah.o # Runs second

# Typically blah.c would already exist, but I want to limit any additional required files
blah.c:
	echo "int main() { return 0; }" > blah.c # Runs first

When you run make in the terminal, it will build a program called blah in a series of steps:

1-Make selects the target blah, because the first target is the default target
2-blah requires blah.o, so make searches for the blah.o target
3-blah.o requires blah.c, so make searches for the blah.c target
4-blah.c has no dependencies, so the echo command is run
5-The cc -c command is then run, because all of the blah.o dependencies are finished
6-The top cc command is run, because all the blah dependencies are finished
7-That's it: blah is a compiled c program

clean is often used as a target that removes the output of other targets, but it is not a special word in Make. You can run make and make clean on this to create and delete some_file.

Note that clean is doing two new things here:

It's a target that is not first (the default), and not a prerequisite. That means it'll never run unless you explicitly call make clean
It's not intended to be a filename. If you happen to have a file named clean, this target won't run, which is not what we want. See .PHONY later in this tutorial on how to fix this
some_file: 
	touch some_file

clean:
	rm -f some_file


Variables
Variables can only be strings. You'll typically want to use :=, but = also works. See Variables Pt 2.

files := file1 file2
some_file: $(files)
	echo "Look at this variable: " $(files)
	touch some_file

file1:
	touch file1
file2:
	touch file2

clean:
	rm -f file1 file2 some_file


Targets 
The all target
Making multiple targets and you want all of them to run? Make an all target. Since this is the first rule listed, it will run by default if make is called without specifying a target.

all: one two three 

one:
	touch one 
two:
	touch two 
three:
	touch three 
clean:
	rm one two three 

Multiple targets
When there are multiple targets for a rule, the commands will be run for each target. $@ is an automatic variable that contains the target name.


all: f1.o f2.o

f1.o f2.o:
	echo $@
# Equivalent to:
# f1.o:
#	 echo f1.o
# f2.o:
#	 echo f2.o

Automatic Variables and Wildcards

* Wildcard

Both * and % are called wildcards in Make, but they mean entirely different things. * searches your filesystem for matching filenames. I suggest that you always wrap it in the wildcard function

* may be used in the target, prerequisites, or in the wildcard function.

Danger: * may not be directly used in a variable definitions

Danger: When * matches no files, it is left as it is (unless run in the wildcard function)
thing_wrong := *.o # Don't do this! '*' will not get expanded
thing_right := $(wildcard *.o)

all: one two three four

# Fails, because $(thing_wrong) is the string "*.o"
one: $(thing_wrong)

# Stays as *.o if there are no files that match this pattern :(
two: *.o 

# Works as you would expect! In this case, it does nothing.
three: $(thing_right)

# Same as rule three
four: $(wildcard *.o)

% Wildcard % is really useful, but is somewhat confusing because of the variety of situations it can be used in.

When used in "matching" mode, it matches one or more characters in a string. This match is called the stem.
When used in "replacing" mode, it takes the stem that was matched and replaces that in a string.
% is most often used in rule definitions and in some specific functions.


Automatic Variables
$@ Outputs target name 
$? Outputs all prerequisites newer than the target

echo $^ Outputs all prerequisites
echo $< the first prerequisit 

.phony
Adding .PHONY to a target will prevent Make from confusing the phony target with a file name. In this example, if the file clean is created, make clean will still be run. Technically, I should have used it in every example with all or clean, but I wanted to keep the examples clean. Additionally, "phony" targets typically have names that are rarely file names, and in practice many people skip this.