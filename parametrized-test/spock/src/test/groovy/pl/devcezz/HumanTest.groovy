package pl.devcezz

import spock.lang.Specification

class HumanTest extends Specification {

    def 'Should human greets \"#expectedGreeting\" when he is at age of #age'() {
        given:
            Human human = new Human(age)

        when:
            def greeting = human.greet()

        then:
            greeting == expectedGreeting

        where:
            age || expectedGreeting
            0   || "Gugu"
            1   || "Hi"
            4   || "Hi"
            5   || "Yo!"
            17  || "Yo!"
            18  || "G’day"
            25  || "G’day"
            26  || "Good morning"
            57  || "Gugu"
    }
}
