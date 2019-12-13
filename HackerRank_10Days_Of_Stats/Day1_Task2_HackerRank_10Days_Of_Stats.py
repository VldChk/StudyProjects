# Objective
# In this challenge, we practice calculating the interquartile range.
# We recommend you complete the Quartiles challenge before attempting this problem.

# Enter your code here. Read input from STDIN. Print output to STDOUT


def median(a: list):
    ln = a.__len__()
    return a[int(ln / 2)] if ln % 2 == 1 else (a[int(ln / 2)] + a[int(ln / 2) - 1]) / 2


num_of_values = int(input())

values = list(map(int, input().rstrip().split()))
freqs = list(map(int, input().rstrip().split()))

final_values = list()

for i in range(num_of_values):
    final_values += [values[i] for x in range(freqs[i])]

final_values.sort()

final_num_of_values = final_values.__len__()

Q2 = median(final_values)
Q1 = median(final_values[0:int(final_num_of_values / 2)])
Q3 = median(final_values[int(final_num_of_values / 2):final_num_of_values]) if final_num_of_values % 2 == 0 else median(
    final_values[int(final_num_of_values / 2) + 1:final_num_of_values])

print("{:.1f}".format(Q3 - Q1))
