/*
This is the assignment for data structures and algorithmns in which we write a java application that uses an interactiva
GUI based on the JFrame class using SWING GUI components.This is the vendingitem application class in which we create various
textlabel,combobox,button,Jframe,Jlabel and implement it.Various buttons,combobox,textlabel are defiend as per the requirement of the project with its associated name.
Name: Amit Bhandari
Sid: 12080721


 */


import java.awt.event.ItemEvent;            //all the packages are imported as per required.
import java.awt.event.ItemListener;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class VendingItemApplication extends JFrame {   //main class
    /**

     */


    private JLabel titleLabel;       //tibleLabel new Jlabel created
    private JComboBox<String> candyCombobox;
    private JComboBox<String> gumCombobox;
    private JComboBox<String> chipsCombobox;//combobox created named chipsCombobox
    private JTextArea displayTextarea; //textarea defined
    private JButton showtotalcostButton;
    private JButton paycostButton;
    private JButton releaseitemButton;
    private JButton exitButton;
    private JPanel displaytitlePanel;
    private JPanel displaytextareaPanel;
    private JPanel displayallbuttonPanel;
    VendingItem item;  //object of VendingItem Created


    public VendingItemApplication() {
        super("Vending Machine");
        setLayout(new BorderLayout());  //boredrLayout is created.=
        item = new VendingItem();

        titleLabel = createLabel("Please select Items you would like to purchase: ");//Jlabel is created to display the title
        candyCombobox = createCombobox(VendingItem.candy);//combo box created to store name of candy
        gumCombobox = createCombobox(VendingItem.gum);//name of gum is stored
        chipsCombobox = createCombobox(VendingItem.chip);//name of chips is stored in this combobox.

        candyCombobox.addItemListener(new ItemListener() {//listener that perform immediate response to the event

            @Override
            public void itemStateChanged(ItemEvent event) {
                if (event.getStateChange() == ItemEvent.SELECTED) {
                    item.initialcandyIndex = candyCombobox.getSelectedIndex();  //user selected value of candy is assigned to the initialcandyindex which is initially assign to -2.
                }
            }
        });



        gumCombobox.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent event) {//this method assigned the user selected value of gum and assign to the initial value of gum which is initially assigned as -2.
                if (event.getStateChange() == ItemEvent.SELECTED) {
                    item.initialgumIndex = gumCombobox.getSelectedIndex();
                }

            }
        });

        chipsCombobox.addItemListener(new ItemListener() {//listener method of combo box

            @Override
            public void itemStateChanged(ItemEvent event) {
                if (event.getStateChange() == ItemEvent.SELECTED) {
                    item.initialchipIndex = chipsCombobox.getSelectedIndex();//user selected value of chips is allocated to the intital value allocated to chips
                }

            }
        });

        displaytitlePanel = createPanel();
        displaytitlePanel.add(titleLabel);//title label is added and to the panel
        displaytitlePanel.add(candyCombobox);//combobox is added to the panel
        displaytitlePanel.add(gumCombobox);//combobox is added to the he panel
        displaytitlePanel.add(chipsCombobox);

        add(displaytitlePanel, BorderLayout.NORTH);//the panel is displayed at the top.North is used to display title from the top.

        displayTextarea = new JTextArea(null, 25, 75);//new textarea is created to display the total cost,dispense item,change all etc.
        displayTextarea.setEditable(false);//textarea cannot be edited.
        displaytextareaPanel = createPanel();
        displaytextareaPanel.add(displayTextarea);//add is used to display the text area to display all the text

        add(displaytextareaPanel, BorderLayout.CENTER);//text area is displayed at the center.

        showtotalcostButton = createButton("Show Total Cost");//various buttons are created.
        paycostButton = createButton("Pay Cost");
        releaseitemButton = createButton("Release Item");
        exitButton = createButton("Exit");

        EventHandler eventHandler = new EventHandler();// new event handler is created
        showtotalcostButton.addActionListener(eventHandler);//action listener is added to the button
        paycostButton.addActionListener(eventHandler);
        releaseitemButton.addActionListener(eventHandler);
        exitButton.addActionListener(eventHandler);//action listener is added to the exit button

        displayallbuttonPanel = createPanel();//panel is created
        displayallbuttonPanel.add(showtotalcostButton);//button is added to the panel
        displayallbuttonPanel.add(paycostButton);
        displayallbuttonPanel.add(releaseitemButton);
        displayallbuttonPanel.add(exitButton);

        add(displayallbuttonPanel, BorderLayout.SOUTH);//all the button are displayed at the bottom

    }

    public static void main(String[] args) {//main method of java
        VendingItemApplication vendingItem = new VendingItemApplication();//new object of VendingItemApplication is created.
        vendingItem.setSize(1000, 500);
        vendingItem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vendingItem.setVisible(true);//user interface is made visible to user.
    }

    public JButton createButton(String arg) {//method to create JButton.
        return new JButton(arg);
    }

    public JLabel createLabel(String arg) {//method to create JLabel
        return new JLabel(arg);
    }

    public JComboBox<String> createCombobox(String[] args) {//method to create JcomboBox
        return new JComboBox<String>(args);
    }

    public JPanel createPanel() {//method to create Jpanel
        return new JPanel();
    }


    public class EventHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {//method performed after clicking button
            String click = event.getActionCommand();

            if (click.equals ("Show Total Cost")) {    //total cost button is clicked and following run
                double totalSum = calculateTotalcost();     //totalsum object is assigned to the value totalcost of product.

                if(totalSum>0.0)
                {
                    displayTextarea.setText("Total cost to be paid by you is $ "+ totalSum);

                }
                else

                {
                    displayTextarea.setText("0");//displayTextarea display the argument provided on the screen
                }


            }

            if (click.equals("Pay Cost")) {//if pay cosst button is clicked then Joption pane appear to allow enter to pay money
                String output = JOptionPane.showInputDialog(null,
                        "Enter the value of the bank note, which must be greater \nthan the total cost to be paid (e.g.5, 10, 20, 50, 100)");

                double paymentbyCustomer = returnPaymentvalue(output);//returnPaymentVaule method used to convert string into double
                if (paymentbyCustomer < calculateTotalcost())//paymentby customer is less than actual cost following message display
                    JOptionPane.showMessageDialog(null,
                            "Sorry,the payment cannot be proceed.The amount you are going to pay is less than the bill amount .Please try again with  an appropriate amount");
                else {

                    String purchaseReceipt = "Your purchase has been completed. Here is your receipt:\n\n"//purchaseReceipt is string variable that store candy,gumnchip descripton along with total cost and payment made by customer.
                            + "\t\tVending Machine\n"
                            + "\t-------------------------------------------\n"
                            + item.getCandydescription() + item.getGumdescription() + item.getChipsdescription() + "\n"
                            + "\tTotal Cost \t\t\t" + calculateTotalcost() + "\n" + "\tAmount Paid \t\t\t" + paymentbyCustomer
                            + "\n" + "\tChange \t\t\t" + (paymentbyCustomer - calculateTotalcost()) + "\n"
                            + "\t-------------------------------------------\n\n"
                            + "\t\tABN: 45179875501\n\n" + "\tThank You for shopping at this Vending Machine!";



                    displayTextarea.setText(purchaseReceipt);//displayTextarea.setText is used to display values stored on purchaseReceipt on the textarea.
                    item.initialcandyIndex = -2;//initial value of candy,gum and chip is initialized to make the totalcost 0 again after the customer sucessfully pay the bill and dispense the item.
                    item.initialgumIndex = -2;
                    item.initialchipIndex = -2;
                }

            }

            if (click.equals("Release Item")) {//release item button is clicked and following happend
                if (calculateTotalcost() > 0)//total cost is greater than 0 than customer have not done payment so following message appears.
                    JOptionPane.showMessageDialog(null, "Payment is not done. Please do the payment.");
                else
                    displayTextarea.setText("Please collect the items from the dispenser");//following message is displayed after customer pay the amount
            }

            if (click.equals ("Exit")) {//system exits
                System.exit(0);
            }
        }

    }

    public double calculateTotalcost() {//method to calculate the total cost that is to be paid by the customer
        double totalSum = 0.0;

        if (item.initialcandyIndex != -2) {//
            totalSum=totalSum + VendingItem.candyCost[item.initialcandyIndex];//if value of candy is not initial value then user selected value is assigned.
        }
        if (item.initialgumIndex != -2) {
            totalSum = totalSum+ VendingItem.gumCost[item.initialgumIndex];
        }
        if (item.initialchipIndex != -2) {
            totalSum = totalSum + VendingItem.chipCost[item.initialchipIndex];
        }
        return totalSum;//total sum is returned
    }

    public double returnPaymentvalue(String payValue) {//method that convert string into double
        try {
            return Double.parseDouble(payValue);
        } catch (NumberFormatException | NullPointerException e) {
            return -2;//if unsuccessful to convert string to double then return -2
        }

    }


}

