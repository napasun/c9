from bs4 import BeautifulSoup
#import urllib.request
#import urllib.parse
from urllib.request import *
from urllib.parse import *
from os import makedirs
import os.path, time, re
import sys
import ssl

proc_files = {}

#링크 추출
def enum_links(html, base):
    soup = BeautifulSoup(html, "html.parser")
    links = soup.select("link[rel='stylesheet']") # css
    links += soup.select("a[href]")
    result = []

    for a in links:
        href = a.attrs['href']
        url = urljoin(base, href)
        result.append(url)
    return result

# 파일 다운
def download_file(url):
    o = urlparse(url)
    savepath = "./" + o.netloc + o.path

    if re.search(r"/$", savepath): # 폴더라면
        savepath += "index.html"
    savedir = os.path.dirname(savepath)
    # 모두 다운되는 지 확인
    if os.path.exists(savepath): return savepath
    # 다운 받을 폴더 생성
    if not os.path.exists(savedir):
        print("mkdir = ", savedir)
        makedirs(savedir)
    # 파일 다운
    try:
        print("down = ", url)
        #urlretrieve(url, savepath)
        context = ssl.SSLContext()
        response = urlopen(url, context=context).read()
        with open(savepath, mode="wb") as f:
            f.write(response)
        time.sleep(1)
        return savepath
    except:
        print("다운 실패: ", url)
        print(sys.exc_info())
        return None
# html을 분석하고 다운 받는 함수
def analyze_html(url, root_url):
    savepath = download_file(url)
    if savepath is None: return
    if savepath in proc_files: return
    
    proc_files[savepath] = True
    print("analyze_html = ", url)
    # 링크 추출
    html = open(savepath, "r", encoding="utf-8").read()
    links = enum_links(html, url)

    for link_url in links:
        if link_url.find(root_url) != 0:
            if not re.search(r".css$", link_url): continue
        
        if re.search(r".(html|htm)$", link_url):
            analyze_html(link_url, root_url)
            continue

        download_file(link_url)

if __name__ == "__main__":
    url = "https://docs.python.org/3.5/library/"
    analyze_html(url, url)