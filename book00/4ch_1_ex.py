# page 124 연습프로젝트
span = ['apples', 'bananas', 'tofu', 'cats']

def listOutString(lists):
    result = ""
    for value in lists:
        if (result == ""):
            result = value
        else:
            result = result + ", " + value
    return result


print(listOutString(span))