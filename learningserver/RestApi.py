from flask import Flask, request, jsonify


class RestApi:
    app = Flask(__name__)

    @app.route('/learning', methods=['POST'])
    def post_learning(self):
        learning = request.get_json()
        print(learning)
        return 'hello'

    def run(self):
        self.app.run()


api = RestApi()
api.run()
