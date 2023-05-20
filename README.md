# contal-group
a cash dispensing application
How to build the application

All source code is built based on Java 8+, Junit is used for test suite, and for automated build, the Jenkins is used.

To build this application, I do my best to follow SOLID principle.
1.	SRP: Single Responsibility Principle
2.	OCP: Open/Close Principle
3.	LSP: Liskov substitution principle
4.	ISP: Interface segregation principle
5.	DIP: Dependency inversion principle
 
There are some classes and interface
1.	Client
: a person to withdraw money
2.	Bank Account
: only less the amount of money in this bank account can be withdrawn.
3.	ATM
: have and deal with notes
4.	Auth
: To check whether the client or administration.
-	Client: enter account number and password
-	Admin: enter special numbers (614510)
5.	Note interface
: this interface is used in various concrete note classes (FiveNote, TenNote, TwentyNote, FiftyNote, HundredNote, TwoCoin, OneCoin).
6.	Administration
: To handle the device 

<img width="285" alt="image" src="https://github.com/proandceo/contal-group/assets/3205452/a78c8314-d1e2-4041-a0dc-f1742d986f1a"> 

Figure 1 usercase 1

<img width="295" alt="image" src="https://github.com/proandceo/contal-group/assets/3205452/313c606a-88e8-4a71-9acd-d53021bf6ede">

Figure 2 usercase 2


How to execute the application

For Client
1.	Check the authorization
a.	Enter the password to check the owner
b.	Enter the amount of money to withdraw
c.	Check the balance whether the bank account has enough money or not
i.	If so, do it and reduce the amount of money from device and bank account. However, if failure to dispense money because of an error, the amount of available cash in device and the bank account should not be decreased 
ii.	If not, show the message why it is impossible to do it.
2.	When this process is completed above, show the amount of withdraw money on the screen

<img width="245" alt="image" src="https://github.com/proandceo/contal-group/assets/3205452/efb494a1-4eb5-4c3b-926a-d754590b41b9">

Figure 3 Sequence Diagram 1

For Administration
1.	Before initial the device, check the amount of money.
a.	If not enough, fill the money in and record it
2.	Initial Note before implementation.
a.	Show how many of each type of bank note it has. 

<img width="245" alt="image" src="https://github.com/proandceo/contal-group/assets/3205452/1c025b21-f193-42e7-8c71-f51fb59f8f2f">

Figure 4 Sequence Diagram 2
