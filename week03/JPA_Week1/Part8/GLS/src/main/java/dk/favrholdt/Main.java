package dk.favrholdt;

public class Main {
    public static void main(String[] args) {

        PackageDAO packageDAO = new PackageDAO();
        packageDAO.getAllPackages().forEach(System.out::println);

    }
}