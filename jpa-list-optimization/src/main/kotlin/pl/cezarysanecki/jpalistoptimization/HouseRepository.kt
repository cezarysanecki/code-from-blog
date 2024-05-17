package pl.cezarysanecki.jpalistoptimization

import org.springframework.data.repository.CrudRepository

interface HouseRepository : CrudRepository<House, Long> {
}
