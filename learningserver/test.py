import requests

url = "http://localhost:8787/data"


def post():
    for i in range(100):
        data = {"intData": i}
        print(requests.post(url, json=data))


post()
