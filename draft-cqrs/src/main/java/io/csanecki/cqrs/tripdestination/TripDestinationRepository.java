package io.csanecki.cqrs.tripdestination;

import org.springframework.data.repository.CrudRepository;

interface TripDestinationRepository extends CrudRepository<TripDestination, Long> {
}
