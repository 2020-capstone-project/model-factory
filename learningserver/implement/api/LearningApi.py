from flask import Flask, request, jsonify, make_response

from implement.service.LearningService import LearningService

app = Flask(__name__)


@app.route('/learning', methods=['POST'])
def postLearning():
    learningService = LearningService(request.get_json())
    learningService.requestLearning()
    # TODO 에러 발생 시, 400 에러 반환 구현
    return make_response(jsonify({"message": "success"}), 200)


if __name__ == '__main__':
    app.run()
