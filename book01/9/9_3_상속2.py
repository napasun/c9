class A:
    def aaa(self):
        print("aaa")

def call(data):
    data.aaa()

a = A()
call(a)

class B(A):
    pass

b = B()
call(b)