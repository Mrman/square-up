package com.squareup.app

import com.squareup.app.dao.User
import com.squareup.app.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class SquareUpApp : ApplicationRunner {

    @Autowired
    lateinit var userRepository : UserRepository

    override fun run(args: ApplicationArguments?) {
        userRepository.deleteAll()
        userRepository.save(User("test@square-up.co.uk", "Jim", "Bean"))
    }
}

fun main(args: Array<String>) {
    SpringApplication.run(SquareUpApp::class.java, *args)
}