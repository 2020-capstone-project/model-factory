from flask import Flask, request, jsonify, make_response

from implement.service.LearningService import LearningService
from implement.service.TestService import TestService

app = Flask(__name__)


@app.route('/learning', methods=['POST'])
def postLearning():
    learningService = LearningService(request.get_json())
    response = learningService.requestLearning()
    return make_response(jsonify({"message": response['message']}), response['code'])


@app.route('/test', methods=['POST'])
def postTest():
    service = TestService(request.get_json())
    result = service.testModel()
    return make_response(jsonify({'result': result}), 200)


if __name__ == '__main__':
    app.run()
