package com.example.imgclassifier

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController


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
