package pl.devcezz.mapstruct.basic.computer;

public class ComputerDto {

    private ProcessorProducer processor;
    private String graphicCard;
    private int ramGb;

    public void setProcessor(ProcessorProducer processor) {
        this.processor = processor;
    }

    public void setGraphicCard(String graphicCard) {
        this.graphicCard = graphicCard;
    }

    public void setRamGb(int ramGb) {
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
