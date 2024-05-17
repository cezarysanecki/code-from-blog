package pl.cezarysanecki.jpalistoptimization

import jakarta.persistence.*
import lombok.AccessLevel
import lombok.NoArgsConstructor

@Table(name = "house")
@Entity(name = "house_inmates")
@NoArgsConstructor(access = AccessLevel.PACKAGE)
class HouseInmates {

    @Id
    var id: Long? = null

    @OneToMany(mappedBy = "houseId", cascade = [CascadeType.ALL], orphanRemoval = true, fetch = FetchType.EAGER)
    var inmates: Set<Inmate> = HashSet()

    constructor(id: Long?, inmates: Set<Inmate>) {
        this.id = id
        this.inmates = inmates
    }

    fun size(): Int {
        return inmates.size
    }

}
