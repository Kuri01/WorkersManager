package Computers;

public class Mac extends AbstractComputer {
    private boolean hasAirdrop;

    public Mac(String name, String processor, String ram, boolean hasAirdrop) {
        super(name, processor, ram);
        this.hasAirdrop = hasAirdrop;
    }

    @Override
    public String toString() {
        return "Mac{" +
                "name='" + getName() + '\'' +
                ", processor='" + getProcessor() + '\'' +
                ", ram='" + getRam() + '\'' +
                ", hasAirdrop=" + hasAirdrop +
                '}';
    }
}

