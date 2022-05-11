package com.example.imgclassifier

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.sql.Blob
import aws.sdk.kotlin.services.s3.S3Client
import aws.sdk.kotlin.services.s3.model.PutObjectRequest
import aws.smithy.kotlin.runtime.content.asByteStream
import java.nio.file.Paths
import kotlin.system.exitProcess


@SpringBootApplication
class ImgclassifierApplication

fun main(args: Array<String>) {
	runApplication<ImgclassifierApplication>(*args)
}

@RestController
class MessageResource {
	@GetMapping
	fun index(): List<Message> = listOf(
			Message("1", "Sending Image 1"),
			Message("2", "Sending Image 2"),
			Message("3", "Sending Image 3"),
	)
}

// https://kotlinlang.org/docs/jvm-spring-boot-restful.html#run-the-application
data class Message(val id: String?, val text: String)

suspend fun putS3Object(bucketName: String, objectKey: String, objectPath: String) {

	val metadataVal = mutableMapOf<String, String>()
	metadataVal["myVal"] = "test"

	val request = PutObjectRequest {
		bucket = bucketName
		key = objectKey
		metadata = metadataVal
		this.body = Paths.get(objectPath).asByteStream()
	}

	S3Client { region = "us-east-1" }.use { s3 ->
		val response =s3.putObject(request)
		println("Tag information is ${response.eTag}")
	}
}


data class Image(val imgId: String?, val imgObj: Blob)

// TODO: implement endpoint to upload image to S3 to trigger lambda fcn.
// https://aws.amazon.com/blogs/machine-learning/how-to-deploy-deep-learning-models-with-aws-lambda-and-tensorflow/
