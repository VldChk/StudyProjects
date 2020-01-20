a, b = map(int, input().strip().split(' '))

c = int(input())

p = float(a/b)

res = float(0)

for i in (range(c)):
    res += (1 - p) ** i * p

print(round(res, 3))
