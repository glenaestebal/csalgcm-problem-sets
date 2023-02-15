# MAIN GOAL: get the knight's name and their hillichurl kills
#
#   sub goals:   [] get most powerful skill
#                [] sort hilichurls hp


import math

def get_damage(temp):

    attack = temp.pop(0)                                                 # get attack
    most_powerful_skill = int(math.floor(attack * max(temp)/100))        # get most powerful skill

    return most_powerful_skill

def solve(k,h,knights,hillichurls):

    hillichurls.sort()                                           # sorts hilichurls hp in ascending order
    results = []

    # find the number of hilichurls each knight can kill
    for name, temp in knights:                                      # loops through all knights
        lo = 0
        hi = len(hillichurls)

        damage = get_damage(temp)

        while lo < hi:
            mid = lo + (hi - lo) // 2                            # gets the index 

            # if knight's damage is greater than hilichurls hp
            if damage < hillichurls[mid]:
                hi = mid                                         # nag-hhalf yung array   
                             
            else:
                lo = mid + 1                                                                        
                
        results.append((name, lo))
        
    results.sort(key=lambda x: (-x[1], x[0]))                   # custom sorting: asciibetical

    for name, count in results:
        print(name, count)


def main():
    k, h = list(map(int,input().strip().split(" ")))        # gets the number of knights and hilichurls
    knights = []                                            # an array for the name of the knights

    for i in range(k):
        name = input().strip()                              # gets the name of the knight
        temp = list(map(int,input().strip().split(" ")))    # gets the atk and other scales
        knights.append((name,temp))                         # appends name of the knight and the atks in the knights array

    hillichurls = [int(input().strip()) for i in range(h)]  # stores the hp of the hilichurl in the hilichurls array
    solve(k,h,knights,hillichurls)  

if __name__ == "__main__":
    main()