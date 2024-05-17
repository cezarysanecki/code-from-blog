package pl.cezarysanecki.jpalistoptimization

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import org.springframework.transaction.support.TransactionTemplate
import java.util.*

@Component
class HouseService(
    val houseRepository: HouseRepository,
    val inmateRepository: InmateRepository,
    val houseInmatesRepository: HouseInmatesRepository,
    val transactionTemplate: TransactionTemplate
) {

    val log = LoggerFactory.getLogger(HouseService::class.java)

    fun call() {
        val houseId = transactionTemplate.execute {
            log.debug("saving house")
            val house = houseRepository.save(House("Pogodny domek"))

            log.debug("saving inmates")
            inmateRepository.save(Inmate("Tadzik", house.id, "Tata"))
            inmateRepository.save(Inmate("Grażyna", house.id, "Mama"))
            inmateRepository.save(Inmate("Albert", house.id, "Syn"))
            inmateRepository.save(Inmate("Roksana", house.id, "Córka"))

            return@execute house.id
        }

        transactionTemplate.execute {
            log.debug("fetching inmates by house id")
            val first = houseId?.let { inmateRepository.findAllByHouseId(it) }.orEmpty()
            log.debug("first size {}", first.size)
            val second = houseId?.let { inmateRepository.findAllByHouseId(it) }.orEmpty()
            log.debug("second size {}", second.size)

            log.debug("fetching inmates by house id with aggregation")
            val third = houseId?.let { houseInmatesRepository.findById(it) } ?: Optional.empty()
            third.ifPresentOrElse(
                { log.debug("third size {}", it.size()) },
                { log.debug("third size is 0") }
            )
            val fourth = houseId?.let { houseInmatesRepository.findById(it) } ?: Optional.empty()
            fourth.ifPresentOrElse(
                { log.debug("fourth size {}", it.size()) },
                { log.debug("fourth size is 0") }
            )
        }
    }

}
