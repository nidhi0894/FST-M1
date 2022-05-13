# Given a list of numbers, return True if first and last number of a list is same.
from numpy import true_divide


input_list = input("Enter the list of numbers:")
print("\n")
# Split by space
enteredList =  input_list.split( )

print("Show list: ",input_list.split( ))

if enteredList[0]==enteredList[-1]:
    print(True)
else:
    print(False)    


