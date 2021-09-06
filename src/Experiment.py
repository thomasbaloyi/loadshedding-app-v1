import os
import random

# Uses LSBSTApp.java and LSArrayApp.java in an experiment to demonstrate
# the speed difference for searching between a BST and a traditional array.
#
# @author: Thomas Baloyi
# @version 1
# 03 March 2020

size = int(input("Dataset size: "))

if (size>2976):
    print("Size has to be between zero and 2976 inclusive.")
    exit()

dataFile = open("../data/Load_Shedding_All_Areas_Schedule_and_Map.clean.final.txt", "r")
dataset = dataFile.readlines()
dataFile.close()

randomIndices = []
subset = []

for i in range(size):
    subset.append( (dataset[random.randint(0,2975)])[0:7].strip() )

print("compiling java programs")
os.system("javac BinarySearchTree.java")
os.system("javac LSBSTApp.java")
os.system("javac LSArray.java")
os.system("javac LSArrayApp.java")
print("compiling done.")

print("working...")
for i in range(size):
    print("Run Number: " + str(i))       
    os.system("java LSBSTApp " + str(subset[i]) + " >> ../Test_Output/Part5/BSTvalues.txt")
    os.system("java LSArrayApp " + str(subset[i]) + " >> ../Test_Output/Part5/ArrayValues.txt")
    
print("done")