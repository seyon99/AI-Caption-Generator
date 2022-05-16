# AI Image Caption Generator

## About
A REST API to generate image captions using a Convolutional Neural Network (CNN). With a few trivial modifications (which depend on the use case), this code can be reused in an Android application if needed.

## Technologies Used
  - Kotlin
  - Spring Boot
  - Python
  - TensorFlow
  - Keras
  - AWS Lambda, S3

## Basic Architechture
The `/captiongen/:bucketName` endpoint can be used to upload an image to an S3 bucket, and the S3 bucket event invokes the lambda function `lambda_handler` which runs the deep learning model and generates an image caption.
