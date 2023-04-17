package pl.devcezz.createemptycomposites;

import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import java.util.HashSet;
import java.util.Set;

@Embeddable
public class MetaData {

    @ElementCollection
    private Set<String> labels;

    public void addLabel(final String label) {
        if (labels == null) {
            labels = new HashSet<>();
        }
        labels.add(label);
    }

    public String print() {
        return String.join(",", labels);
    }
}
