#
# Objective
# In this challenge, we practice calculating the mean, median, and mode.
# Check out the Tutorial tab for learning materials and an instructional video!
#

# Enter your code here. Read input from STDIN. Print output to STDOUT

num_of_values = int(input())

values = list(map(int, input().rstrip().split()))

values.sort()

sum_of_values = 0

max_appearance = 0
curr_appearance = 0
mode_values = list()

for i in range(num_of_values):
    sum_of_values += values[i]
    if i == 0:
        max_appearance = 1
        curr_appearance = 1
        mode_values.append(values[i])
    else:
        if values[i] == values[i - 1]:
            curr_appearance += 1
        else:
            curr_appearance = 1

        if curr_appearance == max_appearance:
            mode_values.append(values[i])
        elif curr_appearance > max_appearance:
            mode_values.clear()
            mode_values.append(values[i])
            max_appearance = curr_appearance
        else:
            pass

mode_values.sort()

mean = sum_of_values / num_of_values

median = values[int(num_of_values / 2)] if num_of_values % 2 == 1 else (values[int(num_of_values / 2)] + values[
    int(num_of_values / 2) - 1]) / 2

print("{:.1f}".format(mean))
print("{:.1f}".format(median))
print(mode_values[0])
