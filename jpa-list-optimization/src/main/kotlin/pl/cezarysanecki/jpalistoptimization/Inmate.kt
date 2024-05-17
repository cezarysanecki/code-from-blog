package pl.cezarysanecki.jpalistoptimization

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import lombok.AccessLevel
import lombok.NoArgsConstructor

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
class Inmate {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    var id: Long? = null
    var houseId: Long? = null
    var name: String? = null
    var role: String? = null

    constructor(name: String?, houseId: Long?, role: String?) {
        this.name = name
        this.houseId = houseId
        this.role = role
    }

}
