# Objective
# In this challenge, we practice calculating quartiles.
# Check out the Tutorial tab for learning materials and an instructional video!

# Enter your code here. Read input from STDIN. Print output to STDOUT


def median(a: list):
    ln = a.__len__()
    return a[int(ln / 2)] if ln % 2 == 1 else (a[int(ln / 2)] + a[int(ln / 2) - 1]) / 2


num_of_values = int(input())

values = list(map(int, input().rstrip().split()))

values.sort()

Q2 = median(values)
Q1 = median(values[0:int(num_of_values / 2)])
Q3 = median(values[int(num_of_values / 2):num_of_values]) if num_of_values % 2 == 0 else median(
    values[int(num_of_values / 2) + 1:num_of_values])

print(round(Q1))
print(round(Q2))
print(round(Q3))
