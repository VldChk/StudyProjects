def factorial(n):
    return 1 if n == 0 else n * factorial(n - 1)


def combination(n, k):
    return factorial(n) / (factorial(k) * factorial(n - k))


def binomial(n, k, p):
    return combination(n, k) * pow(p, k) * pow(1 - p, n - k)


b, g = map(float, input().strip().split(' '))
g = int(g)

result = round(sum([binomial(g, i, b / 100) for i in range(3)]), 3)
print(result)

result = round(sum([binomial(g, i, b / 100) for i in range(2, g + 1)]), 3)
print(result)
