def factorial(n):
    return 1 if n == 1 else n * factorial(n-1)


def tuples(n, k):
    return n ** k


def k_permutations(n, k):
    return factorial(n) / (factorial(n-k))


def combinations(n, k):
    return factorial(n) / (factorial(n-k) * factorial(k))


def combinations_with_repetitions(n, k):
    return combinations(n - 1 + k, n - 1)


print(combinations(38, 2) * combinations(6, 2))

