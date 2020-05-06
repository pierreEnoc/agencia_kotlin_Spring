package com.enocp.agencia.controller

import com.enocp.agencia.model.Promocao
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.ConcurrentHashMap

@RestController
class PromocaoController {
    @Autowired
    lateinit var promocoes: ConcurrentHashMap<Long, Promocao>
    
    @RequestMapping(value = ["/bunjourLemonde"], method = arrayOf(RequestMethod.GET))
    fun bunjourLemonde(): String {
        return "Bonjour le monde!"
    }
    @RequestMapping(value = ["/promocoes/{id}"], method = arrayOf(RequestMethod.GET))
    fun getPromocao(@PathVariable id:Long) = promocoes[id]
}