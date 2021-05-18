package utils;

public enum EmployeeRank {
    EMPLOYEE(1),
    MANAGER_1(2),
    MANAGER_2(3),
    MANAGER_3(4),
    MANAGER_4(5);

    private final int rank;

    EmployeeRank(int i) {
        this.rank = i;
    }

    public int getRank() {
        return this.rank;
    }
}
