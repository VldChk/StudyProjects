#
# Objective
# In this challenge, we practice calculating standard deviation.
#

# Enter your code here. Read input from STDIN. Print output to STDOUT

num_of_values = int(input())

values = list(map(int, input().rstrip().split()))

sum_of_values = 0

for i in range(num_of_values):
    sum_of_values += values[i]

mean = sum_of_values / num_of_values

sum_of_square_dist = 0

for i in range(num_of_values):
    sum_of_square_dist += (values[i] - mean) ** 2

deviation = (sum_of_square_dist / num_of_values) ** 0.5

print("{:.1f}".format(deviation))
