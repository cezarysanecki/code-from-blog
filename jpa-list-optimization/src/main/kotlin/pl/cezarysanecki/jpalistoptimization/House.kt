package pl.cezarysanecki.jpalistoptimization

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import lombok.AccessLevel
import lombok.NoArgsConstructor

@Entity
@Table(name = "house")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
class House {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    var id: Long? = null
    var name: String? = null

    constructor(name: String?) {
        this.name = name
    }

}
