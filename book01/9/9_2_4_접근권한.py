#p200
class HasPrivate:
    def __init__(self):
        self.public = "Public"
        self.__private = "Private"
    
    def print_from_internal(self):
        print(self.public)
        print(self.__private)

obj = HasPrivate()
obj.print_from_internal()

obj.public
#obj.__private   #접근권한  __ 접두어를 붙일 경우 private
# 접미사로 __ 를 붙일 경우 public 