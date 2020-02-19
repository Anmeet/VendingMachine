/*
 This is the vendingItem.java class in which various values and types of candy,gum and chips are stored and their associated price are also
stored in double.this class consists of 3 method to get the description of candy,chips and gums when the user select only
one product.
 */


public class VendingItem {
    public static final String[] candy = { "Select a Candy", "Freddo Frog", "Flake", "Jelly Snakes", "Snickers" };//types of candy
    public static final double[] candyCost = { 0.0, 2.50, 3.00, 3.50, 3.75 };//cost associated with candy types

    public static final String[] gum = { "Select a Gum", "Bubble Gum", "Extra", "Mentos", "Minties" };//types of gum
    public static final double[] gumCost = { 0.0, 2.00, 3.00, 3.50, 5.50 };//cost associated with gum types

    public static final String[] chip = { "Select Chips", "Smiths", "Doritos", "Thins", "Pringles" };//types of chips
    public static final double[] chipCost = { 0.0, 3.00, 3.50, 4.50, 6.00 };//cost associated with chips types


    int initialcandyIndex = -2;//initial value of candy,gum and chips is declared
    int initialgumIndex = -2;
    int initialchipIndex = -2;

    public VendingItem() {//constructor of VendingItem class

    }
    public String getCandydescription() {//this method is used when user select only candy items and wants the details associated with candy
        if (initialcandyIndex != -2)
            return "\t" + VendingItem.candy[initialcandyIndex] + "\t\t\t"
                    + VendingItem.candyCost[initialcandyIndex] + "\n";

        else {
            return "";
        }

    }

    public String getGumdescription() {//this method is used when user select only gums types and want to display the detail associated with gums
        if (initialgumIndex != -2)
            return "\t" + VendingItem.gum[initialgumIndex] + "\t\t\t" + VendingItem.gumCost[initialgumIndex]
                    + "\n";

        else {
            return "";
        }
    }

    public String getChipsdescription() {//this method is invoked when user select only one type i.e. chips and its associated all other data are displayed in text field
        if (initialchipIndex != -2)
            return "\t" + VendingItem.chip[initialchipIndex] + "\t\t\t" + VendingItem.chipCost[initialchipIndex]
                    + "\n";

        else {
            return "";
        }
    }

  }



