package joseluisgs.es.dto

import joseluisgs.es.serializers.LocalDateTimeSerializer
import joseluisgs.es.serializers.UUIDSerializer
import kotlinx.serialization.Serializable
import java.time.LocalDateTime
import java.util.*

@Serializable
data class RaquetasPageDto(
    val page: Int,
    val perPage: Int,
    val data: List<RepresentanteDto>,
    @Serializable(with = LocalDateTimeSerializer::class)
    val createdAt: LocalDateTime? = LocalDateTime.now()
)

@Serializable
data class RaquetaCreateDto(
    val marca: String,
    val precio: Double,
    @Serializable(with = UUIDSerializer::class)
    val represetanteId: UUID
)

@Serializable
data class RaquetaDto(
    @Serializable(with = UUIDSerializer::class)
    val id: UUID? = null,
    val marca: String,
    val precio: Double,
    val represetante: RepresentanteDto,
    val metadata: MetaData? = null,
) {
    @Serializable
    data class MetaData(
        @Serializable(with = LocalDateTimeSerializer::class)
        val createdAt: LocalDateTime? = LocalDateTime.now(),
        @Serializable(with = LocalDateTimeSerializer::class)
        val updatedAt: LocalDateTime? = LocalDateTime.now(),
        val deleted: Boolean = false
    )
}