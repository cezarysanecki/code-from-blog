package pl.cezarysanecki.jpalistoptimization

import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class JpaListOptimizationApplication {

    @Bean
    fun runCase(
        houseService: HouseService
    ): CommandLineRunner {
        return CommandLineRunner {
            houseService.call()
        }
    }

}

fun main(args: Array<String>) {
    runApplication<JpaListOptimizationApplication>(*args)
}
