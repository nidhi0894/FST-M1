# To calculate the sum of all the elements in a list.

input_list = input("Enter the numbers:")
print("\n")
# Split by space
enteredList =  input_list.split( )

print("Get sum of: ",input_list.split( ))
sum =0
for number in enteredList:
    sum = sum + int(number)
print("Sum of the entered list is:   ",sum)