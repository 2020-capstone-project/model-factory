from flask import Flask, request, jsonify

app = Flask(__name__)


@app.route('/learning', methods=['POST'])
def post_learning():
    learning = request.get_json()
    print(learning)
    return {"test": "1234"}


if __name__ == '__main__':
    app.run()
