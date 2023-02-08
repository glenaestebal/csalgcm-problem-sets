
def partition(array, l, r):
    x = array[r]
    i = l
    for j in range(l, r):
          
        if array[j] <= x:
            array[j], array[i] = array[i], array[j]
            i += 1
              
    array[r], array[i] = array[i], array[r]
    return i

def kth_largest(array, l, r, k):
  
    if (k >= 0 and k <= r - l + 1):
  
        index = partition(array, l, r)
  
        if (index - l == k):
            return array[index]
  
        if (index - l > k):
            return kth_largest(array, l, index - 1, k)
  
        return kth_largest(array, index + 1, r, k - index + l - 1)

    return 0


n = int(input())
movies = []

for i in range(n):
    r,c = list(map(int,input().rstrip().split(" ")))
    movies.append(r - c)
 
q = int(input())
for cc in range(q):
    s,e,a,k = list(map(int,input().rstrip().split(" ")))
    # solve for answer here

    kth = a // k

    movies = movies[s:e + 1]

    if kth == 0:
        print(-1)
    elif kth >= len(movies):
        print(kth_largest(movies, 0, len(movies) - 1, 0))
    else:
        print(kth_largest(movies, 0, len(movies) - 1, len(movies) - kth))
