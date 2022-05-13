# Given a two list of numbers create a new list such that new list should contain only odd numbers 
# from the first list and even numbers from the second list.

from numpy import append


# inputlist1 = int(input("Enter the list 1 :"))
# list1 = (inputlist1).split( )
# print("Show list1: ",list1)
# inputlist2 = int(input("Enter the list 2 :"))
# list2 = (inputlist2).split( )
# print("Show list2: ",list2)

list1 = [2,5,3,1,8,6]
list2 = [1,5,4,7,8]

# Creating an empty list
list3 = []

for i in list1:
    if ((i % 2) != 0):
        list3.append(i)
for i in  list2:
    if (i%2==0):
        list3.append(i)
print("New list::   ",list3)
