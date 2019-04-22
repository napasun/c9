from selenium import webdriver

user = "wkzkfmxk12"
password = "akwdmffo12@!"

browser = webdriver.PhantomJS()
browser.implicitly_wait(3)

url_login = "https://nid.naver.com/nidlogin.login"
browser.get(url_login)

e = browser.find_element_by_id("id")
e.clear()
e.send_keys(user)
e = browser.find_element_by_id("pw")
e.clear
e.send_keys(password)

form = browser.find_element_by_css_selector("input.btn_global[type=submit]")
form.submit()

browser.get("https://order.pay.naver.com/home?tabMenu=SHOPPING")

products = browser.find_elements_by_css_selector(".name")
print(products)
for product in products:
    print("-", product.text)