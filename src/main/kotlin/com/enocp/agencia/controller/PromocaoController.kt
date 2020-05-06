package com.enocp.agencia.controller

import com.enocp.agencia.model.Promocao
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
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
    fun getGetId(@PathVariable id:Long) = promocoes[id]
    
    @RequestMapping(value = ["/promocoes"], method = arrayOf(RequestMethod.POST))
    fun create(@RequestBody promocao: Promocao){
        promocoes[promocao.id] = promocao
    }
}