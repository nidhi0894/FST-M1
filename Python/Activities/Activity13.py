# Write a function sum() such that it can accept a list of elements and print the sum of all elements

import re


def sum(nums):
	total=0
	for num in nums:
		total=total+num
	return total

list = [1,8,4,10,3,6]
sumCalculated = sum(list)
print("Sum of all the numbers in the list:  "+str(sumCalculated))