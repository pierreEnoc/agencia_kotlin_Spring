package com.enocp.agencia

import com.enocp.agencia.model.Promocao
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import java.util.concurrent.ConcurrentHashMap

@SpringBootApplication
class AgenciaApplication {
    companion object {
        val initialPromocoes = arrayOf(
                Promocao(1, "Andrea viagem Cancun", "Camcun", true, 8, 1220.00),
                Promocao(2, "paula", "novayork", true, 8, 4444.00),
                Promocao(3, "johana viagem realy", "sp", true, 15, 1220.00),
                Promocao(4, "kala viagem ", "baiha", true, 8, 1220.00)
        )
    }
    @Bean
    fun promocoes() =
            ConcurrentHashMap<Long, Promocao>(initialPromocoes.associateBy(Promocao::id))
    
}

fun main(args: Array<String>) {
    runApplication<AgenciaApplication>(*args)
}
//