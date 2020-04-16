# page97 연습프로젝트
def collatz(number):
    if number % 2 == 0:
        return number // 2
    else:
        return 3 * number + 1

print("Enter number:")
value = input()

while(value != 1):
    try:
        value = collatz(int(value))
    except ValueError:
        print("숫자를 입력하시오.")
        break
    print(value)