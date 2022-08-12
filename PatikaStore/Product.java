package PatikaStore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Product {
    static Scanner scanner = new Scanner(System.in);
    private static int id;
    private static int idPhone;
    private static int idNotebook;
    private static double price;
    private static double discountRate;
    private static int stock;
    private static String name;
    private static String brand;
    private static double memory;
    private static double screenSize;
    private static double battery;
    private static double ram;
    private static String color;
    private String productName;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    private static HashMap<String, ArrayList<Product>> products = new HashMap<>() {
        {
            put("Notebook", new ArrayList<Product>());
            put("MobilePhone", new ArrayList<Product>());
        }
    };

    public Product(int idPhone, int idNotebook, double price, double discountRate, int stock, String name, String brand,
            double memory, double screenSize, double battery, double ram, String color) {
        this.idPhone = idPhone;
        this.idNotebook = idNotebook;
        this.price = price;
        this.discountRate = discountRate;
        this.stock = stock;
        this.name = name;
        this.brand = brand;
        this.memory = memory;
        this.screenSize = screenSize;
        this.battery = battery;
        this.ram = ram;
        this.color = color;
    }

    public Product(int idPhone, int idNotebook, double price, double discountRate, int stock, String name, String brand,
            double memory, double screenSize, double battery, double ram) {
        this.idPhone = idPhone;
        this.idNotebook = idNotebook;
        this.price = price;
        this.discountRate = discountRate;
        this.stock = stock;
        this.name = name;
        this.brand = brand;
        this.memory = memory;
        this.screenSize = screenSize;
        this.battery = battery;
        this.ram = ram;
    }

    public static void menu(int number) {
        if (number == 1) {
            System.out.println("Notebook");
        } else {
            System.out.println("Mobil Phone");
        }
        System.out.println(".......................");
        System.out.println("1-List Items");
        System.out.println("2-Add Items");
        System.out.println("3-Delete Items");
        System.out.println("4-Filter Items");
        System.out.println("Make a choice");
        int select = scanner.nextInt();

        switch (select) {
            case 1:
                listItems(number);
                break;
            case 2:
                addItems(number);
                break;
            case 3:
                deleteItems(number);
                break;
            case 4:
                filterItems(number);
                break;
            default: {
                System.out.println();
                System.out.println("There is no such an option. Please enter your choice again.");
                menu(number);
            }

        }
    }

    public static void listItems(int number) {
        if (number % 2 != 0) {
            // Notebook
            System.out.println(
                    "----------------------------------------------------------------------------------------------------------");
            System.out.println(
                    "| ID | Product Name                   | Price      | Brand      | Storage    | Screen Size  | RAM        |");
            System.out.println(
                    "----------------------------------------------------------------------------------------------------------");

            ArrayList<Product> productList = products.get("Notebook");

            if (!productList.isEmpty()) {
                for (Product product : productList) {
                    String productName = product.getName();
                    product.setName(productName);

                    System.out.printf("| %-2s | %-30s| %-10s TL | %-10s| %-10s| %-12s | %-10s |\n",
                            product.getId(), product.getName(), product.getPrice(), product.getName(),
                            product.getMemory(), product.getScreenSize(), product.getRam());
                }
                System.out.println(
                        "----------------------------------------------------------------------------------------------------------");
            }
            System.out.println();

        } else {
            // Mobile phone
            System.out.println(
                    "-------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println(
                    "| ID | Product Name                   | Price      | Brand      | Storage    | Screen Size  | Camera     | Battery    | RAM        | COLOR      |");
            System.out.println(
                    "-------------------------------------------------------------------------------------------------------------------------------------------------");

            ArrayList<Product> productList = products.get("MobilePhone");

            if (!productList.isEmpty()) {
                for (Product product : productList) {
                    String productName = product.getName();
                    product.setProductName(productName);

                    System.out.printf(
                            "| %-2s | %-30s| %-10s TL | %-10s| %-10s| %-12s | %-10s | %-10s | %-10s | %-10s |\n",
                            product.getId(), product.getName(), product.getPrice(), product.getName(),
                            product.getMemory(), product.getScreenSize(), product.getBattery(), product.getRam(),
                            product.getColor());
                }
                System.out.println(
                        "-------------------------------------------------------------------------------------------------------------------------------------------------");

            }
            System.out.println();

        }
    }

    public static void addItems(int number) {
        System.out.print("Unit Price: ");
        double unitPricescascanner = scanner.nextDouble();
        System.out.print("Discount Rate: ");
        double discountRatescascanner = scanner.nextDouble();
        System.out.print("Stock: ");
        int stockscascanner = scanner.nextInt();
        System.out.print("Brand: ");
        String brandscascanner = scanner.next();
        scanner.nextLine();
        System.out.print("Model: ");
        String modelscascanner = scanner.nextLine();
        System.out.print("Storage: ");
        int storagescascanner = scanner.nextInt();
        System.out.print("Screen Size: ");
        double screenSizescascanner = scanner.nextDouble();
        System.out.print("RAM: ");
        int RAMscascanner = scanner.nextInt();

        if (number % 2 != 0) {
            // Notebook
            idNotebook += 1;
            int id = idNotebook;

            Product newNotebook = new Product(idPhone, idNotebook, price, discountRate, stock, name, brand, memory,
                    screenSize, battery, ram);
            products.get("Notebook").add(newNotebook);

        } else {
            // Mobile Phone
            idPhone += 1;
            int id = idPhone;
            System.out.print("Camera: ");
            int camerascascanner = scanner.nextInt();
            System.out.print("Battery Capacity: ");
            int batteryscascanner = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Color: ");
            String colorscascanner = scanner.nextLine();

            Product newMobilePhone = new Product(idPhone, idNotebook, price, discountRate, stock, name, brand, memory,
                    screenSize, battery, ram, color);
            products.get("MobilePhone").add(newMobilePhone);

        }
    }

    public static void deleteItems(int number) {
        System.out.print("Enter an ID value to delete: ");
        int idProduct = scanner.nextInt();
        boolean notExist = true;
        if (number % 2 != 0) {
            for (Product product : products.get("Notebook")) {
                if (product.getId() == idProduct) {
                    products.get("Notebook").remove(product);
                    notExist = false;
                    System.out.println("The product with ID " + idProduct + " has been removed from the system.");
                    break;
                }
            }

        } else {
            for (Product product : products.get("MobilePhone")) {
                if (product.getId() == idProduct) {
                    products.get("MobilePhone").remove(product);
                    notExist = false;
                    System.out.println("The product with ID " + idProduct + " has been removed from the system.");
                    break;
                }
            }

        }
        if (notExist) {
            System.out.println("The value ID is not found in the system. Please check your ID and Try again...");
        }
    }

    public static void filterItems(int number) {
        System.out.print("Enter an ID to filter products or '0' if you don't like to enter an ID: ");
        int idProduct = scanner.nextInt();
        boolean idExits = idProduct != 0;

        System.out.print("Enter the brand to filter products or 'none' if you don't like to enter a brand: ");
        String brandProduct = scanner.next();
        boolean brandExits = !brandProduct.equals("none");

        ArrayList<Product> filteredProducts = new ArrayList<>();

        if (number % 2 != 0) {
            if (idExits && brandExits) {
                for (Product product : products.get("Notebook")) {
                    if (brandProduct.equals(product.getName()) && product.getId() == idProduct) {
                        filteredProducts.add(product);
                        listFilteredItems(number, filteredProducts);
                        break;
                    } else {
                        System.out.println(
                                "The value ID or brand is not found in the system. Please check your ID or brand. Then Try again...");
                        filterItems(number);
                    }
                }
            } else {
                if (brandExits) {
                    for (Product product : products.get("Notebook")) {
                        if (brandProduct.equals(product.getName())) {
                            filteredProducts.add(product);
                        }
                    }
                    listFilteredItems(number, filteredProducts);
                } else {
                    System.out.println(
                            "The brand is not found in the system. Please check your brand. Then Try again...\nATTENTION: **You must enter ID with a brand together.**");
                    filterItems(number);
                }
            }

        } else {
            if (idExits && brandExits) {
                for (Product product : products.get("MobilePhone")) {
                    if (brandProduct.equals(product.getName()) && product.getId() == idProduct) {
                        filteredProducts.add(product);
                        listFilteredItems(number, filteredProducts);
                        break;
                    } else {
                        System.out.println(
                                "The value ID or brand is not found in the system. Please check your ID or brand. Then Try again...");
                        filterItems(number);
                    }
                }
            } else {
                if (brandExits) {
                    for (Product product : products.get("MobilePhone")) {
                        if (brandProduct.equals(product.getName())) {
                            filteredProducts.add(product);
                        }
                    }
                    listFilteredItems(number, filteredProducts);
                } else {
                    System.out.println(
                            "The brand is not found in the system. Please check your brand. Then Try again...\nATTENTION: **You must enter ID with a brand together.**");
                    filterItems(number);
                }
            }
        }
    }

    private static void listFilteredItems(int number, ArrayList<Product> filteredProductList) {
        if (number % 2 != 0) {
            // Notebook
            System.out.println(
                    "---------------------------------------------------------------------------------------------------------------");
            System.out.println(
                    "| ID | Product Name                   | Price           | Brand      | Storage    | Screen Size  | RAM        |");
            System.out.println(
                    "---------------------------------------------------------------------------------------------------------------");

            if (!filteredProductList.isEmpty()) {
                for (Product product : filteredProductList) {
                    System.out.printf("| %-2s | %-30s| %-15s TL | %-10s| %-10s| %-12s | %-10s |\n",
                            product.getId(), product.getName(), product.getPrice(), product.getName(),
                            product.getMemory(), product.getScreenSize(), product.getRam());
                }
                System.out.println(
                        "---------------------------------------------------------------------------------------------------------------");
            }
            System.out.println();

        } else {
            // Mobile phone
            System.out.println(
                    "------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println(
                    "| ID | Product Name                   | Price           | Brand      | Storage    | Screen Size  | Camera     | Battery    | RAM        | COLOR      |");
            System.out.println(
                    "------------------------------------------------------------------------------------------------------------------------------------------------------");

            if (!filteredProductList.isEmpty()) {
                for (Product product : filteredProductList) {
                    System.out.printf(
                            "| %-2s | %-30s| %-15s TL | %-10s| %-10s| %-10s | %-12s | %-10s | %-10s | %-10s |\n",
                            product.getId(), product.getName(), product.getPrice(), product.getName(),
                            product.getMemory(), product.getScreenSize(), product.getBattery(), product.getRam(),
                            product.getColor());
                }
                System.out.println(
                        "------------------------------------------------------------------------------------------------------------------------------------------------------");

            }
            System.out.println();

        }
    }

    public static Scanner getScanner() {
        return scanner;
    }

    public static void setScanner(Scanner scanner) {
        Product.scanner = scanner;
    }

    public static int getIdPhone() {
        return idPhone;
    }

    public static void setIdPhone(int idPhone) {
        Product.idPhone = idPhone;
    }

    public static int getIdNotebook() {
        return idNotebook;
    }

    public static void setIdNotebook(int idNotebook) {
        Product.idNotebook = idNotebook;
    }

    public static double getPrice() {
        return price;
    }

    public static void setPrice(double price) {
        Product.price = price;
    }

    public static double getDiscountRate() {
        return discountRate;
    }

    public static void setDiscountRate(double discountRate) {
        Product.discountRate = discountRate;
    }

    public static int getStock() {
        return stock;
    }

    public static void setStock(int stock) {
        Product.stock = stock;
    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        Product.name = name;
    }

    public static String getBrand() {
        return brand;
    }

    public static void setBrand(String brand) {
        Product.brand = brand;
    }

    public static double getMemory() {
        return memory;
    }

    public static void setMemory(double memory) {
        Product.memory = memory;
    }

    public static double getScreenSize() {
        return screenSize;
    }

    public static void setScreenSize(double screenSize) {
        Product.screenSize = screenSize;
    }

    public static double getBattery() {
        return battery;
    }

    public static void setBattery(double battery) {
        Product.battery = battery;
    }

    public static double getRam() {
        return ram;
    }

    public static void setRam(double ram) {
        Product.ram = ram;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public static HashMap<String, ArrayList<Product>> getProducts() {
        return products;
    }

    public static void setProducts(HashMap<String, ArrayList<Product>> products) {
        Product.products = products;
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Product.id = id;
    }

}
