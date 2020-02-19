package Util;

public class Module {
    private long moduleID;
    private String moduleName;
    private int capacity;
    private int num_of_students;
    private String staff_coordinator_ID;

    public Module(long moduleID, String moduleName, int capacity, int num_of_students, String staff_coordinator_ID){
        this.moduleID = moduleID;
        this.moduleName = moduleName;
        this.capacity = capacity;
        this.num_of_students = num_of_students;
        this.staff_coordinator_ID= staff_coordinator_ID;
    }


    public long getModuleId() {
        return this.moduleID;
    }

    public void setModuleID(long moduleID){
        this.moduleID = moduleID;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getNum_of_students() {
        return num_of_students;
    }

    public void setNum_of_students(int num_of_students) {
        this.num_of_students = num_of_students;
    }

    public String getStaff_coordinator_ID() {
        return staff_coordinator_ID;
    }

    public void setStaff_coordinator_ID(String staff_coordinator_ID) {
        this.staff_coordinator_ID = staff_coordinator_ID;
    }
}
