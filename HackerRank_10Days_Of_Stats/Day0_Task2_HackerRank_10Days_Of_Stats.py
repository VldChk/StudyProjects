#
# Objective
# In the previous challenge, we calculated a mean. In this challenge, we practice calculating a weighted mean.
# Check out the Tutorial tab for learning materials and an instructional video!
#

# Enter your code here. Read input from STDIN. Print output to STDOUT

num_of_values = int(input())

values = list(map(int, input().rstrip().split()))
weights = list(map(int, input().rstrip().split()))

sum_of_values_x_weight = 0
sum_of_weight = 0

for i in range(num_of_values):
    sum_of_values_x_weight += values[i] * weights[i]
    sum_of_weight += weights[i]

weighted_mean = sum_of_values_x_weight / sum_of_weight

print("{:.1f}".format(weighted_mean))
