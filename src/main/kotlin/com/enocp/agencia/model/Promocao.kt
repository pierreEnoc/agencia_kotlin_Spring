package com.enocp.agencia.model

data class Promocao (
        val id: Long =1,
        val descricao: String,
        val local: String,
        val isAllInclusive: Boolean,
        val qtDias: Int,
        val preco: Double
)
