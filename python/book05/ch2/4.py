import requests
import json

apikey = "590d2b51af74ca5a2b3e06f23f13c509"

cities = ["Seoul,KR", "Tokyo,JP", "New York,US"]
api = "http://api.openweathermap.org/data/2.5/weather?q={city}&APPID={key}"

#k2c = lambda k: k = 273.15

for name in cities:
    url = api.format(city=name, key=apikey)

    r = requests.get(url)

    data = json.loads(r.text)

    print("도시 = ", data["name"])
    print("")