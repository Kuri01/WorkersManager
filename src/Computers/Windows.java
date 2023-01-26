package Computers;

public class Windows extends AbstractComputer {
    private int windowsVersion;

    public Windows(String name, String processor, String ram, int windowsVersion) {
        super(name, processor, ram);
        this.windowsVersion = windowsVersion;
    }

    @Override
    public String toString() {
        return "Windows{" +
                "name='" + getName() + '\'' +
                ", processor='" + getProcessor() + '\'' +
                ", ram='" + getRam() + '\'' +
                ", windowsVersion=" + windowsVersion +
                '}';
    }
}

