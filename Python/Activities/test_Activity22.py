# Create a new test file and write test to validate the following cases:

# Apply the marker 'activity' to the last 2 test methods.
# Run tests based on substring
# Run tests based using the 'activity' marker.

import pytest
 
# Additon test
def test_addition():
	
    # Initialize two numbers
	num1 = 30
	num2 = 15
    
	sum = num1 + num2
	assert sum == 45
	print("Result:", sum)
	print("Additon test sucessful") 

# Subtraction test
def test_subtraction():

	num1 = 9
	num2 = 3
    
	sub = num1 - num2
	assert sub == 6
	print("Result:", sub)
	print("Substraction test sucessful") 
 
# Multiplication test
	
@pytest.mark.activity
def test_multiplication():

	num1 = 7
	num2 = 9
    
	multi = num1 * num2
	assert multi == 63
	print("Result:", multi)
	print("Multiplication test sucessful")
 
# Division test
	
@pytest.mark.activity
def test_division():
  
	num1 = 124
	num2 = 4
    
	quot = num1 / num2
	assert quot == 31
	print("Result:", quot)
	print("Division test sucessful")

# pytest -m activity  ------- run this program using marker
