package SnapSales;

import java.util.Scanner;
import java.util.ArrayList;
import java.io.IOException;

public class SnapCollection {

    static int choice;
    static Scanner keyboard = new Scanner(System.in);

    public static void showMenu() {

        System.out.println();
        System.out.println("WELCOME TO THE SNAP COLLECTION!");
        System.out.println("======= == === ==== ===========");
        System.out.println("");
        System.out.println("1.ADD NEW STOCK");
        System.out.println("2.SHOW INVENTORY");
        System.out.println("0.EXIT");
        System.out.println("");
        System.out.print("PLEASE INPUT THE NUMBER OF YOUR CHOICE: ");
        choice = keyboard.nextInt();
        System.out.println("-----------------------------------------");
    }

    public static Update_Stock addStock_Menu() {
        System.out.println("ADDING NEW STOCK");
        System.out.println("------ --- -----");

        System.out.print("1.Enter the Stock category : ");
        keyboard.nextLine(); // this extra keyboard input for consuming newLine that replacing actual user
                             // input | its good to Remember!
        String input_stock = keyboard.nextLine();

        System.out.print("2.Enter the quantity: ");
        int input_Quantity = keyboard.nextInt();

        System.out.print("3.Enter the total cost: Rs.");
        double input_cost = keyboard.nextDouble();
        clearConsole();
        System.out.println("STOCK ADDED SUCCESSFULLY!");

        return new Update_Stock(input_stock, input_Quantity, input_cost);

    }

    public static void main(String[] args) {

        ArrayList<Update_Stock> all_stocks = new ArrayList<>();

        int rotate = 0;
        while (rotate != -1) {
            showMenu();
            clearConsole();
            if (choice == 1) {
                all_stocks.add(addStock_Menu()); // after this line executed, system automaticaly display the main menu
                                                 // (going back to the main menu)

                // Starting of the Show stock panel, This going deeper!
            } else if (choice == 2) {
                int rotate_2 = 0;

                int selection;
                while (rotate_2 == 0) {
                    System.out.println("ALL STOCKS");
                    System.out.println("----------");
                    System.out.println("");

                    // display all the stock user added
                    for (int i = 0; i < all_stocks.size(); i++) {
                        if (all_stocks.get(i).getID() == null) {
                            all_stocks.get(i).setStockID(stockID_Generator());
                        }
                        System.out.println(
                                (i + 1) + ". [STOCK ID:" + all_stocks.get(i).getID() + "] | "
                                        + all_stocks.get(i).getCategoryName() + " | "
                                        + all_stocks.get(i).available_Quantity
                                        + " items");
                    }
                    System.out.println("0.back");
                    System.out.println("Select:");

                    int stock_choice = keyboard.nextInt();
                    clearConsole();
                    int rotate_3 = 0;
                    while (rotate_3 == 0) {
                        for (int i = 0; i < all_stocks.size(); i++) {
                            if (stock_choice == (i + 1)) {
                                // 1. Selling
                                // 2. set/change selling price
                                // 3. add more items to the stock
                                // 4. returned items
                                // 5. info
                                // 0. back
                                System.out.println(
                                        stock_choice + "." + all_stocks.get(i).getCategoryName() + " STOCK!" + " ["
                                                + all_stocks.get(i).getID() + "]");
                                System.out.println();
                                System.out.println("1.sell item with new price");
                                System.out.println("2.sell item with exiting price");
                                System.out.println("3.set selling price");
                                System.out.println("4.Increase stock");
                                System.out.println("5.returned");
                                System.out.println("6.Stock status");
                                System.out.println("7.back");
                                System.out.println("8.Main Menu");
                                System.out.println("");

                                System.out.print("Select:");

                                selection = keyboard.nextInt();
                                clearConsole();
                                if (selection == 1) {
                                    System.out.print("Selling Quantity:");
                                    int sellingQuantity = keyboard.nextInt();
                                    System.out.println("Unit price: Rs.");
                                    double newUnitPrice = keyboard.nextDouble();
                                    all_stocks.get(i).sell(sellingQuantity, newUnitPrice);
                                    System.out.println(sellingQuantity + "items has been Ssold successfull for Rs."
                                            + newUnitPrice + "each.");
                                    System.out.println("Enter to continue:");
                                    keyboard.nextLine();
                                    continue;

                                }
                                if (selection == 2) {
                                    // 2.
                                    if (all_stocks.get(i).get_MarketPrice() <= 0) {
                                        System.out.println("Please set the unit selling price first");
                                        System.out.println("Unit price: Rs.");
                                        double newUnitPrice = keyboard.nextDouble();
                                        all_stocks.get(i).set_MarketPrice(newUnitPrice);
                                    }
                                    System.out.print("Selling Quantity:");
                                    int sellingQuantity = keyboard.nextInt();
                                    all_stocks.get(i).sell(sellingQuantity);
                                    System.out.println(sellingQuantity + "items has been Ssold successfull for Rs."
                                            + all_stocks.get(i).get_MarketPrice() + "each.");
                                    System.out.println("Enter to continue:");
                                    keyboard.nextLine();
                                    continue;

                                }

                                if (selection == 3) {
                                    System.out.println("Enter Unit price: Rs.");
                                    double newUnitPrice = keyboard.nextDouble();
                                    all_stocks.get(i).set_MarketPrice(newUnitPrice);
                                    System.out.println("martket Price has been changed successfully!");
                                    System.out.println("Enter to continue:");
                                    keyboard.nextLine();

                                    continue;

                                }
                                if (selection == 4) {
                                    System.out.println("new stock qauntity:");
                                    int newStockQ = keyboard.nextInt();
                                    System.out.println("new stock total cost:");
                                    double newStockValue = keyboard.nextDouble();
                                    all_stocks.get(i).add_NextStock(newStockQ, newStockValue);
                                    System.out.println("new atock has been added to the exiting stock!");
                                    System.out.println("Enter to continue:");
                                    keyboard.nextLine();
                                    continue;

                                }
                                if (selection == 5) {
                                    // returns
                                    System.out.println("sold with custome cost? Y/N");
                                    keyboard.next();
                                    char yn = keyboard.next().charAt(0);
                                    if (yn == 'y' || yn == 'Y') {
                                        System.out.println("enter return qauntity:");
                                        int returnQuantity = keyboard.nextInt();
                                        System.out.println("enter return cost:");
                                        double soldCost = keyboard.nextInt();
                                        System.out.println("enter return cost:");
                                        double returnCost = keyboard.nextInt();

                                        all_stocks.get(i).returns(returnQuantity, returnCost, soldCost);

                                    } else if (yn == 'n' || yn == 'N') {
                                        System.out.println("enter return qauntity:");
                                        int returnQuantity = keyboard.nextInt();
                                        System.out.println("enter return cost:");
                                        double returnCost = keyboard.nextInt();

                                        all_stocks.get(i).returns(returnQuantity, returnCost);

                                    }
                                    System.out.println("Returned sales updated successfully!");
                                    System.out.println("Enter to continue:");
                                    keyboard.nextLine();
                                    continue;

                                }
                                if (selection == 6) {
                                    clearConsole();
                                    all_stocks.get(i).info();
                                    System.out.println("--------------");

                                    System.out.println("Enter to continue:");
                                    @SuppressWarnings("unused")
                                    String blank;
                                    blank = keyboard.nextLine();

                                }
                                if (selection == 7) {
                                    clearConsole();
                                    rotate_3 = -1;

                                }

                            }
                            if (stock_choice == 0) {
                                clearConsole();
                                rotate_2 = -1;
                            }
                        }
                    }
                }

            } else if (choice == 0) {
                rotate = -1;
                System.out.println("SEE YOU! GOOD LUCK WITH YOUR BUSINESS!");
                System.exit(0);
            } else {
                System.out.println("INVALID INPUT! Please Try Again");
            }
        }
    }

    static int digit_01 = 0;
    static int digit_02 = 0;
    static int digit_03 = 0;

    static String stockID_Generator() {

        digit_03++;
        if (digit_03 == 10) {
            digit_03 = 0;
            digit_02++;
            if (digit_02 == 10) {
                digit_02 = 0;
                digit_01++;
                if (digit_01 == 10) {
                    System.out.println("STOCK_ID GENERATING LIMIT EXCEEDED!!");
                    System.out.println("Stock ID has been reset!");
                    digit_01 = 0;
                }
            }
        }

        String serielNo = digit_01 + "" + digit_02 + "" + digit_03 + "";
        return serielNo;
    }

    static void clearConsole() {
        try {
            // Check if the OS is Windows
            if (System.getProperty("os.name").contains("Windows")) {
                // Execute the clear command for Windows
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                // Execute the clear command for Unix-based systems
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (IOException | InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
