import urllib.request
import urllib.parse

api = "http://www.kma.go.kr/weather/forecast/mid-term-rss3.jsp"

values = {
    'stnId': '108'
}
# 딕셔너리 자료형을 URL 인코딩
params = urllib.parse.urlencode(values)

url = api + "?" + params
print("url = ", url)

data = urllib.request.urlopen(url).read()
text = data.decode("utf-8")

print(text)