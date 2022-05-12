# Image-Classifier

## About
A RESTful web service to generate image captions using a Convolutional Neural Network (CNN).

## Technologies Used
  - Kotlin
  - Spring Boot
  - Python
  - TensorFlow
  - Keras
  - AWS Lambda, S3

## Building/running
Using IntelliJ IDEA, users may run the API by cloning and opening the project, and clicking the run button.
Otherwise, the following steps can be taken if the user prefers to run the API through the terminal.

```
git clone https://github.com/seyon99/AI-Caption-Generator.git
cd AI-Caption-Generator/imgclassifier
kotlinc ImgclassifierApplication.kt -include-runtime -d ImgclassifierApplication.jar
java -jar ImgclassifierApplication.jar
```
