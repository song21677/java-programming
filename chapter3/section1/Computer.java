// 상속(Inheritance)1
public class Computer {
    protected String manufacturer;
    protected String processor;
    protected int ramSize;
    protected int diskSize;
    protected double processorSpeed;

//    생성자가 없을 경우 자동으로 아래와 같은 no-parameter 생성자가 만들어진다.
//    public Computer() {
//    }
    public Computer(String man, String proc, int ram, int disk, double procSpeed) {
        manufacturer = man;
        processor = proc;
        ramSize = ram;
        diskSize = disk;
        processorSpeed = procSpeed;
    }

    public double computerPower() {
        return ramSize * processorSpeed;
    }

    public double getRamSize() {
        return ramSize;
    }

    public double getProcessorSpeed() {
        return processorSpeed;
    }

    public int getDiskSize() {
        return diskSize;
    }

    public String toString() {
        String result = "Manufacturer: " + manufacturer +
                "\nCPU: " + processor +
                "\nRAM: " + ramSize + "megabytes" +
                "\nDisk: " + diskSize + " gigabytes" +
                "\nProcessor speed: " + processorSpeed + " gigahertz";
        return result;
    }
}
