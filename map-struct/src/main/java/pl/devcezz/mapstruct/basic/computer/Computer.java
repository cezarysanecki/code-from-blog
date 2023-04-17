package pl.devcezz.mapstruct.basic.computer;

public class Computer {

    private final ProcessorProducer processor;
    private final String graphicCard;
    private final int ramGb;

    public Computer(ProcessorProducer processor, String graphicCard, int ramGb) {
        this.processor = processor;
        this.graphicCard = graphicCard;
        this.ramGb = ramGb;
    }

    public ProcessorProducer getProcessor() {
        return processor;
    }

    public String getGraphicCard() {
        return graphicCard;
    }

    public int getRamGb() {
        return ramGb;
    }
}
