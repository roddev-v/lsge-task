public class Main {

    /**
     * It seems that the best way to put this data organization in perspective is to use a binary tree.
     * Since the task description wasn't so clear I made the assumption that
     * the company will have only one main Manager (the root element of a tree) and the nodes
     * of the organisation will be ordered by the ranking
     */
    public static void main(String[] args) {
        Company company = Company.getInstance();

        company.storeEmployees();
        company.findTheClosestManager();
    }
}
