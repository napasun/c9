from selenium  import webdriver

url = "http://www.naver.com/"



browser = webdriver.PhantomJS() # 함수 안에 phantomjs 경로를 입력하거나 path 지정
browser.implicitly_wait(3)
browser.get(url)
browser.save_screenshot("test.png")
browser.quit()