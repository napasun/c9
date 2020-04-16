import urllib.request
import ssl

url = "http://uta.pw/shodou/img/28/214.png"
savename = "test.png"

# urllib.error.URLError: <urlopen error [SSL: CERTIFICATE_VERIFY_FAILED] certificate verify failed: unable to get local issuer certificate (_ssl.c:1056)>
context = ssl.SSLContext()
response = urllib.request.urlopen(url, context=context).read()

with open(savename, mode="wb") as f:
    f.write(response)