```python
import numpy as np
import matplotlib.pyplot as plt
from scipy.optimize import leastsq

# 数据
X = np.array([0, 3, 5, 7, 9, 11, 12, 13, 14, 15])
Y = np.array([0, 1.2, 1.7, 2.0, 2.1, 2.0, 1.8, 1.2, 1.0, 1.6])
# X = np.array([2010, 2011, 2012, 2013, 2014, 2015, 2016])
# Y = np.array([70, 122, 144, 156, 174, 196, 202])

num = 0


# n函数的标准形式，具体取决于使用几次函数来迭代
def calculate1(params, x):
    a, b = params
    return a * x + b


def calculate2(params, x):
    a, b, c = params
    return a * x ** 2 + b * x + c


def calculate3(params, x):
    a, b, c, d = params
    return a * x ** 3 + b * x ** 2 + c * x + d


def calculate4(params, x):
    a, b, c, d, e = params
    return a * x ** 4 + b * x ** 3 + c * x * x + d * x + e


# 误差函数，即拟合曲线所求的值与实际值的差
def error(params, x, y):
    if num == 1:
        return calculate1(params, x) - y
    if num == 2:
        return calculate2(params, x) - y
    if num == 3:
        return calculate3(params, x) - y
    if num == 4:
        return calculate4(params, x) - y


# 对参数求解
def slove():
    a = []
    for i in range(num + 1):
        a.append(1)
    Para = leastsq(error, a, args=(X, Y))
    return Para


# 输出最后的结果
def solution():
    global num
    print("1707004732  李凯凯")
    print("下面展示使用二次函数，三次函数，四次函数拟合的图像")
    for i in range(4):
        num = num + 1
        print("使用"+str(num)+"次函数进行最小二乘法拟合")
        Para = slove()
        if num == 1:
            a, b = Para[0]
            print("a=", a, " b=", b)
            print("求解的曲线是:")
            print("y=" + str(a) + "x+" + str(b))
        if num == 2:
            a, b, c = Para[0]
            print("a=", a, " b=", b, " c=", c)
            print("求解的曲线是:")
            print("y=" + str(a) + "x*x+" + str(b) + "x+" + str(c))
        if num == 3:
            a, b, c, d = Para[0]
            print("a=", a, " b=", b, " c=", c, "d=", d)
            print("求解的曲线是:")
            print("y=" + str(a) + "x ** 3+" + str(b) + "x ** 2+" + str(c) + "*x" + str(d))
        if num == 4:
            a, b, c, d, e = Para[0]
            print("a=", a, " b=", b, " c=", c, "d=", d, "e=", e)
            print("求解的曲线是:")
            print("y=" + str(a) + "x ** 4+" + str(b) + "x ** 3+" + str(c) + "x**2" + str(d) + "*x" + str(e))

        plt.figure(figsize=(8, 6))
        plt.scatter(X, Y, color="green", label="point", linewidth=2)

        #   画拟合直线
        x = np.linspace(0, 18, 500)
        if num == 1:
            y = a * x + b
        if num == 2:
            y = a * x ** 2 + b * x + c
        if num == 3:
            y = a * x ** 3 + b * x ** 2 + c * x + d
        if num == 4:
            y = a * x ** 4 + b * x ** 3 + c * x * x + d * x + e
        plt.plot(x, y, color="blue", label="line", linewidth=2)
        plt.legend()
        plt.show()


if __name__ == '__main__':
    solution()

```