package pl.cezarysanecki.jpalistoptimization

import org.springframework.data.repository.CrudRepository

interface InmateRepository : CrudRepository<Inmate, Long> {

    fun findAllByHouseId(houseId: Long): Set<Inmate>

}
