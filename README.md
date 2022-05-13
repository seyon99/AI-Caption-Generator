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

## Building/running
Use the following documentation to set the AWS Access Key ID and AWS Secret Access Key variables to the appropriate values:
https://docs.aws.amazon.com/sdk-for-kotlin/latest/developer-guide/setup.html

Using IntelliJ IDEA, users may run the API by cloning and opening the project, and clicking the run button.
Otherwise, the following steps can be taken if the user prefers to run the API through the terminal.

```
git clone https://github.com/seyon99/AI-Caption-Generator.git
cd AI-Caption-Generator/imgclassifier
kotlinc ImgclassifierApplication.kt -include-runtime -d ImgclassifierApplication.jar
java -jar ImgclassifierApplication.jar
```
