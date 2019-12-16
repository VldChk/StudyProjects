#!/bin/python3

import math
import os
import random
import re
import sys


def int_to_list(num: int):
    return [int(char) for char in str(num)]


def add_zeros(in_list: list, num: int):
    for i in range(num):
        in_list.append(0)
    return in_list


def sum_of_lists(a: list, b: list):
    a.reverse()
    b.reverse()
    result_sum = list()
    if a.__len__() > b.__len__():
        add_zeros(b, a.__len__() - b.__len__())
    elif a.__len__() < b.__len__():
        add_zeros(a, b.__len__() - a.__len__())
    else:
        pass
    over_10 = False

    for i in range(a.__len__()):
        tmp = a[i] + b[i] if over_10 is False else a[i] + b[i] + 1
        if tmp >= 10:
            over_10 = True
            result_sum.append(tmp - 10)
        else:
            over_10 = False
            result_sum.append(tmp)

    if over_10 is True:
        result_sum.append(1)

    result_sum.reverse()

    return result_sum


def print_list(a: list):
    res = ''
    for i in range(a.__len__()):
        res += str(a[i])

    return res


def aVeryBigSum(ar: list):
    result_sum = list()
    for i in range(ar.__len__()):
        result_sum = sum_of_lists(int_to_list(ar[i]), result_sum)
    return result_sum


if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    ar_count = int(input())

    ar = list(map(int, input().rstrip().split()))

    result = print_list(aVeryBigSum(ar))

    fptr.write(str(result) + '\n')

    fptr.close()
