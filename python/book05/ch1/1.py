import urllib.request

url = "http://uta.pw/shodou/img/28/214.png"
savename = "test.png"

# 다운
urllib.request.urlretrieve(url, savename)

# urllib.error.URLError: <urlopen error [SSL: CERTIFICATE_VERIFY_FAILED] certificate verify failed: unable to get local issuer certificate (_ssl.c:1056)>
