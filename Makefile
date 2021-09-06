# Makefile for BinarySearchTree.java, LSBSTApp.java, LSArray.java and LSArrayApp.java
# Origanally by Hussein Suleman and adapted for this project by Thomas Baloyi
# 27 March 2017 | 05 March 2019


JAVAC= javac -d bin -cp ../bin
#JAVAC=/../bin/javac -d bin -cp ../bin

.SUFFIXES: .java .class

.java.class:
	$(JAVAC) $<

classes: src/BinarySearchTree.class \
	src/LSArray.class src/LSArrayApp.class \
	src/LSBSTApp.class

default: $(CLASSES)

clean:
	rm bin/*.class

docs:
	javadoc -d doc src/*.java