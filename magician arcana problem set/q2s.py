import copy

def enqueue(stack1, element):
    stack1.append(element)


def dequeue(stack1, stack2):
    if (len(stack2) == 0):
        s1_len = len(stack1)
        i = 0
        while i < s1_len:
            stack2.append(stack1.pop())
            i += 1

    return stack2.pop()

def print_first_element(stack1, stack2):
    num = dequeue(stack1, stack2)
    enqueue(stack2, num)
    print(num)
    
if __name__ == '__main__':
        
    stack1 = []
    stack2 = []
    i = 0

    queries = int(input())

    while i < queries:
        choice = list(map(int, input().rstrip().split()))
        if (choice[0] == 1):
            enqueue(stack1, choice[1])
        elif (choice[0] == 2):
            dequeue(stack1, stack2)
        else:
            print_first_element(stack1, stack2)
        i += 1    
