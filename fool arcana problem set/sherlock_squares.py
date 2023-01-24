#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'squares' function below.
#
# The function is expected to return an INTEGER.
# The function accepts following parameters:
#  1. INTEGER a
#  2. INTEGER b
#

def squares(a, b):
    # Write your code here

    sqrt_a = math.ceil(math.sqrt(a))
    sqrt_b = math.floor(math.sqrt(b))

    return (sqrt_b - sqrt_a) + 1
    # while a <= b:
    #     square_root = int(a ** 0.5)
    #     if (square_root ** 2 == a):
    #         no_of_perfect_squares += 1
    #     a += 1
        
        
if __name__ == '__main__':
    # fptr = open(os.environ['OUTPUT_PATH'], 'w')

    q = int(input().strip())

    for q_itr in range(q):
        first_multiple_input = input().rstrip().split()

        a = int(first_multiple_input[0])

        b = int(first_multiple_input[1])

        result = squares(a, b)
        print(result)
    
        # fptr.write(str(result) + '\n')

    # fptr.close()
