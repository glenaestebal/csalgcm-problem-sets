#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'libraryFine' function below.
#
# The function is expected to return an INTEGER.
# The function accepts following parameters:
#  1. INTEGER d1
#  2. INTEGER m1
#  3. INTEGER y1
#  4. INTEGER d2
#  5. INTEGER m2
#  6. INTEGER y2
#

def libraryFine(d1, m1, y1, d2, m2, y2):
    # Write your code here

    # book returned on same month and same year = 15 x number of days late
    # if m1 and m2 are same, 
        # subtract yung days
    fine = 0

    if (y1 == y2):
        if (m1 > m2):
            months_late = m1 - m2
            fine = 500 * months_late
        elif (m1 == m2):
            if (d1 > d2):
                days_late = d1 - d2
                fine = 15 * days_late
    elif (y1 > y2):                               
        fine = 10000
    

    # if (y1 == y2):         
    #     if (d1 > d2):
    #         days_late = d1 - d2
    #         fine = 15 * days_late
    #     if (m1 > m2):
    #         months_late = m1 - m2
    #         fine = 500 * months_late
    # elif (y1 > y2):                               
    #     fine = 10000

    return fine


if __name__ == '__main__':
    # fptr = open(os.environ['OUTPUT_PATH'], 'w')
    first_multiple_input = input().rstrip().split()
    d1 = int(first_multiple_input[0])
    m1 = int(first_multiple_input[1])
    y1 = int(first_multiple_input[2])
    second_multiple_input = input().rstrip().split()
    d2 = int(second_multiple_input[0])
    m2 = int(second_multiple_input[1])
    y2 = int(second_multiple_input[2])

    result = libraryFine(d1, m1, y1, d2, m2, y2)
    print(result)

    # fptr.write(str(result) + '\n')

    # fptr.close()
