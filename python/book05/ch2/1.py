import requests
from bs4 import BeautifulSoup
from urllib.parse import urljoin

user="tkanfkdl12"
password=""

session = requests.session()

login_info = {
    "m_id": user
    , "m_passwd": password
}

url_login = "http://www.hanbit.co.kr/member/login_proc.php"
res = session.post(url_login, data=login_info)
res.raise_for_status() # 오류가 발생하면 예외가 발생합니다.

# 마이페이지에 접근하기

url_mypage = "http://www.hanbit.co.kr/myhanbit/myhanbit.html"
res = session.get(url_mypage)
res.raise_for_status()
#print(res.text)
soup = BeautifulSoup(res.text, "html.parser")
mileage = soup.select_one(".mileage_section1 span").get_text()
ecoin = soup.select_one(".mileage_section2 span").get_text()
print(mileage)
print(ecoin)