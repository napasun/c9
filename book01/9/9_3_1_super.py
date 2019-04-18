class A:
    def __init__(self):
        self.message = "aaa"

class B:
    def __init__(self):
        super().__init__()  #A.__init__() 와 동일