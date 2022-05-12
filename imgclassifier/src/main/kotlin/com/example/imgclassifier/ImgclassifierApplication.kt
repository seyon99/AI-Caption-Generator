package com.example.imgclassifier

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
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
@RequestMapping("/captiongen")
class CaptionGenerationController() {
	@GetMapping
	fun findAll() = "{img-link: aws3..., img-caption: A blue dog}"

	@PostMapping
	// TODO: implement endpoint to upload image to S3 to trigger lambda fcn.
	suspend fun putS3Object(@RequestBody s3image: S3image) {

		val metadataVal = mutableMapOf<String, String>()
		metadataVal["myVal"] = "caption-gen-trigger"

		val request = PutObjectRequest {
			bucket = s3image.bucketName // aikotlin
			key = s3image.objectKey
			metadata = metadataVal
			this.body = Paths.get(s3image.objectPath).asByteStream()
		}

		S3Client { region = "us-east-2" }.use { s3 ->
			val response = s3.putObject(request)
			println("Tag information: ${response.eTag}")
		}
	}
}

data class S3image(val bucketName: String, val objectKey: String, val objectPath: String)

data class Image(val imgId: String?, val imgObj: Blob)

// https://aws.amazon.com/blogs/machine-learning/how-to-deploy-deep-learning-models-with-aws-lambda-and-tensorflow/
