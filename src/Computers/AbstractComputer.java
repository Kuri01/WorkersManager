package Computers;

public class AbstractComputer {
    private String name;
    private String processor;
    private String ram;

    public AbstractComputer(String name, String processor, String ram) {
        this.name = name;
        this.processor = processor;
        this.ram = ram;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }
}
