from flask import Flask, request, jsonify

app = Flask(__name__)

@app.route('/learning', methods=['POST'])
def post_learning():
    learning = request.get_json()
    print(learning)
    # TODO 반환 값 수정 (문자열 X, JSON O)
    return {"test" : "1234"}

if __name__ == '__main__':
    app.run()