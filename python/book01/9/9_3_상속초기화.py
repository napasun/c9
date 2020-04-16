class A:
    def __init__(self):
        print("A.__init__()")
        self.message = "A"

class B(A):
    def __init__(self):
        A.__init__(self)   # 명시적으로 호출해야 한다.
        print("B.__init__()")

b = B()
#b.message
#예외가 발생했습니다. AttributeError
#'B' object has no attribute 'message'