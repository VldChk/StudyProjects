# Enter your code here. Read input from STDIN. Print output to STDOUT
import sys

num_of_pairs = int(input())

result = dict()

for i in range(num_of_pairs):
    values = list(map(str, input().rstrip().split()))
    result[values[0]] = values[1]

for line in sys.stdin:
    tmp = str(line.rstrip())
    val = result.get(tmp, 'Not found')
    if val == 'Not found':
        print('Not found')
    else:
        print(tmp + '=' + val)
