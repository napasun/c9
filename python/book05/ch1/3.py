import urllib.request
import ssl

url = "http://api.aoikujira.com/ip/ini"

# urllib.error.URLError: <urlopen error [SSL: CERTIFICATE_VERIFY_FAILED] certificate verify failed: unable to get local issuer certificate (_ssl.c:1056)>
context = ssl.SSLContext()
response = urllib.request.urlopen(url).read()

# 바이너리 문자열로 변환
text = response.decode("utf-8")
print(text)