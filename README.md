# loadshedding-app-v1
Loadshedding is the systematic shutdown of power to households and organisations by South African power utility, Eskom. 
It occurs at different stages, times, and days for different areas.

This program provides an interactive way of accessing the loadshedding schedule. The user will key in the stage, 
time, and day; the program will then output a list of areas affected given the input. If one or more of 
the three parameters are not entered, the program will print out the entire schedule.

The application is implemented using two different data structures; arrays and binary search trees, the goal is to assess the efficiency
of one over the other for data storage and retrieval. As a consequence, there are two runnable classes; <i> LSArrayApp </i>
and <i> LSBSTApp </i>.

# To run LSArrayApp:

Compile source files using Makefile, in the bin folder, type <i> LSArrayApp [stage] [time] [day] </i>
e.g. LSArrayApp 2 13 04

# To run LSBSTApp:

Similarly, compile source files using Makefile, in the bin folder, type <i> LSBSTApp [stage] [time] [day] </i>
e.g. LSBSTApp 2 13 04