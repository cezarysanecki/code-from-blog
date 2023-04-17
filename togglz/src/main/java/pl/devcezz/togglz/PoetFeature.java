    package pl.devcezz.togglz;

    import org.togglz.core.Feature;
    import org.togglz.core.annotation.EnabledByDefault;
    import org.togglz.core.annotation.Label;

    enum PoetFeature implements Feature {

        @EnabledByDefault
        @Label("First verse")
        FIRST_VERSE("Nic dwa razy się nie zdarza"),

        @EnabledByDefault
        @Label("Second verse")
        SECOND_VERSE("i nie zdarzy. Z tej przyczyny"),

        @EnabledByDefault
        @Label("Third verse")
        THIRD_VERSE("zrodziliśmy się bez wprawy"),

        @EnabledByDefault
        @Label("Fourth verse")
        FOURTH_VERSE("i pomrzemy bez rutyny.");

        private final String verse;

        PoetFeature(String verse) {
            this.verse = verse;
        }

        String getVerse() {
            return verse;
        }
    }
