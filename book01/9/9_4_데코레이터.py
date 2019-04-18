class Callable:
    def __call__(self):
        print("call")

call = Callable()
call()