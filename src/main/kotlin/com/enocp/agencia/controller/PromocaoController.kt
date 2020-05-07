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
    fun getGetId(@PathVariable id: Long) = promocoes[id]
    
    @RequestMapping(value = ["/promocoes"], method = arrayOf(RequestMethod.POST))
    fun create(@RequestBody promocao: Promocao) {
        promocoes[promocao.id] = promocao
    }
    
    @RequestMapping(value = ["/promocao/{id}"], method = arrayOf(RequestMethod.DELETE))
    fun delete(@PathVariable id: Long, @RequestBody promocao: Promocao) {
        promocoes.remove(id)
        promocoes[id] = promocao
    }
    @RequestMapping(value = ["/promocoes"], method = arrayOf(RequestMethod.GET))
    fun getAll(@RequestParam(required = false, defaultValue = " ")localFilter:String) {
        promocoes.filter {
            it.value.local.contains(localFilter, true)
        }.map(Map.Entry<Long, Promocao>::value).toList()
        
    }
}