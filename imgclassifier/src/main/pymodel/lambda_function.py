import os
import json
from pickle import load
from numpy import argmax
from keras.preprocessing.sequence import pad_sequences
from keras.applications.vgg16 import VGG16
from keras.preprocessing.image import load_img
from keras.preprocessing.image import img_to_array
from keras.applications.vgg16 import preprocess_input
from keras.models import Model
from keras.models import load_model

def lambda_handler(event, context):
    tokenizer = load(open('tokenizer.pkl', 'rb'))
    max_length = 34
    model = load_model('model-ep002-loss3.245-val_loss3.612.h5')
    photo = extract_features(event.queryStringParameters.filename)
    description = generate_desc(model, tokenizer, photo, max_length)
    print(description)
    return {
        "statusCode": 200,
        "headers": {
        "Content-Type": "application/json"
        },
        "body": json.dumps({
         "Image caption": description
    })
    }