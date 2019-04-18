class Base:
    def base_method(self):
        print("base")

class Derived(Base):
    pass
    
derived = Derived()

derived.base_method()