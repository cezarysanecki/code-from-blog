package pl.devcezz.createemptycomposites.next;

import javax.persistence.Embeddable;

@Embeddable
public class MetaData {

    private static final String DELIMITER = ",";

    private String labels;

    public void addLabel(final String label) {
        if (labels == null) {
            labels = label;
        } else {
            labels = labels + DELIMITER + label;
        }
    }

    public String print() {
        return labels;
    }
}