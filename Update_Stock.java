package SnapSales;

class Update_Stock {

    // This class able to help user to keep track on their stock
    private String stockID = null; // get set done
    private String itemCategory; // get set done
    double total_stockValue; // total payment done by the bank account (including tax rates)

    // selling operation
    private double unit_sellingPrice;
    double totalSales = 0;;
    int itemSold = 0;
    int available_Quantity = 0;
    double currentProfit = 0;

    int returns = 0;

    // constructor
    public Update_Stock(String name, int quantity, double cost) {

        itemCategory = name;
        total_stockValue = cost;
        available_Quantity += quantity;
        currentProfit += (totalSales - cost);

    }

    public void add_NextStock(int quantity_arg2, double cost_arg2) {
        available_Quantity += quantity_arg2;
        total_stockValue += cost_arg2;
    }

    public void set_categoryName(String name) {
        itemCategory = name;
    }

    public String getCategoryName() {
        return itemCategory;
    }

    public void set_MarketPrice(double lkr) {
        unit_sellingPrice = lkr;
    }

    public double get_MarketPrice() {
        return unit_sellingPrice;
    }

    // selling with the default price
    public void sell(int quantity) {
        itemSold += quantity;
        available_Quantity -= quantity;
        totalSales += (quantity * unit_sellingPrice);
        currentProfit += (totalSales - total_stockValue);

    }

    // selling with the custome price
    public void sell(int qn, double custom_UnitPrice) {
        itemSold += qn;
        available_Quantity -= qn;
        totalSales += (qn * custom_UnitPrice);
        currentProfit += (totalSales - total_stockValue);
    }

    public void setStockID(String id) {
        stockID = id;
    }

    public String getID() {
        return stockID;
    }

    public void returns(int rtnQuantity, double RtnCost) {
        itemSold -= rtnQuantity;
        available_Quantity += rtnQuantity;
        totalSales -= (RtnCost + (rtnQuantity * unit_sellingPrice));
        currentProfit += (totalSales - total_stockValue);
        returns++;
    }

    public void returns(int rtnQuantity, double RtnCost, double customSellingCost) {
        itemSold -= rtnQuantity;
        available_Quantity += rtnQuantity;
        totalSales -= (RtnCost + (rtnQuantity * customSellingCost));
        currentProfit += (totalSales - total_stockValue);
        returns++;
    }

    public void info() {
        System.out.println("_ _ _ _ _ _ _ _ _ _ _ _ _");
        System.out.println("Stock ID: " + stockID);
        System.out.println("Stock Category: " + itemCategory);
        System.out.println("Stock Value: Rs." + total_stockValue);
        System.out.println("Current Market price(unit): Rs." + unit_sellingPrice);
        System.out.println("Items Sold: " + itemSold);
        System.out.println("Available Amount: " + available_Quantity);
        System.out.println("");
        System.out.println("Current Profit of the STOCK : Rs." + currentProfit);

    }

}
/*
 * 
 * NOTICE!
 * validations not implemented
 * 
 */
