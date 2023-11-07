package lab7;

public class Computer
{
    private String developer;
    private String model;
    private double ramSize;
    private double driveSize;
    private Processor processor;

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getRamSize() {
        return ramSize;
    }

    public void setRamSize(double ramSize) {
        this.ramSize = ramSize;
    }

    public double getDriveSize() {
        return driveSize;
    }

    public void setDriveSize(double driveSize) {
        this.driveSize = driveSize;
    }

    public Processor getProcessor() {
        return processor;
    }

    public void setProcessor(Processor processor) {
        this.processor = processor;
    }

    public Computer(String developer, String model, double ramSize, double driveSize)
    {
        this.developer = developer;
        this.model = model;
        this.ramSize = ramSize;
        this.driveSize = driveSize;
    }

    public class Processor
    {
        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public double getBusSpeed() {
            return busSpeed;
        }

        public void setBusSpeed(double busSpeed) {
            this.busSpeed = busSpeed;
        }

        public int getCoresCount() {
            return coresCount;
        }

        public void setCoresCount(int coresCount) {
            this.coresCount = coresCount;
        }

        private String type;
        private double busSpeed;
        private int coresCount;

        public void boost(double value)
        {
            busSpeed *= value;
        }

        @Override
        public String toString()
        {
            return type + " | " + busSpeed + " Гц " + coresCount + " ядер";
        }

        public Processor(String type, double busSpeed, int coreCount)
        {
            this.type = type;
            this.busSpeed = busSpeed;
            this.coresCount = coreCount;
        }
    }
}