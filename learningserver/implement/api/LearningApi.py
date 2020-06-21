from flask import Flask, request, jsonify, make_response

from implement.service.LearningService import LearningService

app = Flask(__name__)


@app.route('/learning', methods=['POST'])
def postLearning():
    learningService = LearningService(request.get_json())
    response = learningService.requestLearning()
    return make_response(jsonify({"message": response['message']}), response['code'])


if __name__ == '__main__':
    app.run()
