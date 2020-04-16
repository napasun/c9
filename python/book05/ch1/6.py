from bs4 import BeautifulSoup

html = """
<html><body>
    <h1>adf</h1>
    <p id="test">zcxv</p>
    <p>bvnm</p>
</body></html>
"""

soup = BeautifulSoup(html, 'html.parser')

h1 = soup.html.body.h1
test = soup.find(id="test")
p = soup.findAll("p")

print(h1)
print(test)

for temp in p:
    print(temp)