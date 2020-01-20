a, b = map(int, input().strip().split(' '))
c = int(input())

p = float(a/b)

res = (1-p) ** (c-1) * p

print(round(res, 3))
