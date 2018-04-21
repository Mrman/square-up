package com.squareup.app

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties

@SpringBootApplication
@EnableConfigurationProperties
class SquareUpApp

fun main(args: Array<String>) {
    SpringApplication.run(SquareUpApp::class.java, *args)
}