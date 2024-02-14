import torch
from transformers import AutoTokenizer, AutoModelForSequenceClassification
from flask import Flask, jsonify

app = Flask(__name__)

tokenizer = AutoTokenizer.from_pretrained("asafaya/bert-base-arabic")
models = {
    "topic": AutoModelForSequenceClassification.from_pretrained("C:/Users/ASUS/Desktop/Final graduation project/Datasets/Models/topicModel"),
    "hate": AutoModelForSequenceClassification.from_pretrained("C:/Users/ASUS/Desktop/Final graduation project/Datasets/Models/hateModel")
}

@app.route("/predict/<string:model_type>/<string:text>", methods=["GET"])
def predict(model_type, text):
    if model_type not in models:
        return jsonify({"error": "Invalid model type"}), 400

    model = models[model_type]
    inputs = tokenizer(text, return_tensors="pt")
    outputs = model(**inputs)
    logits = outputs.logits
    predicted_class = torch.argmax(logits, dim=1).item()

    return jsonify({"predicted_class": predicted_class})

if __name__ == "__main__":
    app.run(host="0.0.0.0", port=5000)
