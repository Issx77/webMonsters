package org.ldv.monster

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MonsterApplication

fun main(args: Array<String>) {
    runApplication<MonsterApplication>(*args)
}
