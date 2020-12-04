package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
        public static ArrayList<Products> products = new ArrayList<Products>();
        public static ArrayList<Customers> customers = new ArrayList<Customers>();

    public static void main(String[] args) {
        //add items to inventory
        products.add(new Products("Red-Hot Spicy Doritos", 2.99));
        products.add(new Products("Cool Ranch Doritos", 2.99));
        products.add(new Products("Coke",0.99));
        products.add(new Products("Diet Coke", 0.99));
        products.add(new Products("Pepsi", 0.99));
        products.add(new Products("Five Hour Energy", 3.99));
        products.add(new Products("Sunflower Seeds",0.99));
        products.add(new Products("Peanuts",0.99));
        products.add(new Products("MacBook Charger",120));
        products.add(new Products("Dell Charger",50));

        //get customer
        Scanner input = new Scanner(System.in);
        String answer = null;
        do{
            System.out.println("Are you a new customer? Yes(y) or No(n)?");
            answer = input.nextLine();
            if(answer.equals("y")){
                newCustomer();
            }
        } while(! answer.equals("n"));

        //print individual customer receipts
        System.out.println("Receipts: ");
        for (int i = 0; i < customers.size(); i++) {
            System.out.println(customers.get(i).getName());
            for (int j = 0; j < customers.get(i).getMyproducts().size(); j++) {
                System.out.println("    " + customers.get(i).getMyproducts().get(j).getName() + " - " + customers.get(i).getMyproducts().get(j).getPrice());
            }
            System.out.println("        Total: " + customers.get(i).getTotal());
            System.out.println();
        }

        //loop through customer. Then loop through each customers products. Then loop through overall products array and add 1 to the product amount if it matches
        for (int i = 0; i < customers.size(); i++) {
            for (int j = 0; j < customers.get(i).getMyproducts().size(); j++) {
                for (int k = 0; k < products.size(); k++) {
                    if(customers.get(i).getMyproducts().get(j).getName().equals(products.get(k).getName())){
                        products.get(k).setAmount(products.get(k).getAmount() + 1);
                    }
                }
            }
        }

        //print inventory
        System.out.println("Inventory Sold");
        for (int i = 0; i < products.size(); i++) {
            if(products.get(i).getAmount() > 0){
                System.out.println("    " + products.get(i).getName() + " - " + products.get(i).getAmount());
            }
        }

        //print grand total
        System.out.println();
        double grandTotal = 0;
        for (int i = 0; i < customers.size(); i++) {
            grandTotal += customers.get(i).getTotal();
        }
        System.out.println("Grand Total: " + grandTotal);
    }

    //new customer method
    static void newCustomer(){
        Scanner input = new Scanner(System.in);
        String choice;
        String item = null;
        String name;

        System.out.println("What's your name?");
        name = input.nextLine();
        Customers newcustomer = new Customers(name);
        customers.add(newcustomer);

        //prompt user to input item names they want
        double total = 0;
        do{
            System.out.println("What would you like to do? Add item(1) Change Name(2) Finish(3)");
            choice = input.nextLine();
            if(choice.equals("1")) {
                System.out.println("What item do you want?");
                item = input.nextLine();

                for (int i = 0; i < products.size(); i++) {
                    if (products.get(i).getName().equals(item)) {
                        newcustomer.addProducts(products.get(i));
                        total += products.get(i).getPrice();
                        newcustomer.setTotal(total);
                        System.out.println("Success!");
                    }
                }
            } else if(choice.equals("2")) {
                System.out.println("What would you like to change it to?");
                name = input.nextLine();
                newcustomer.setName(name);
                System.out.println("Success!");
            } else if(choice.equals("3")) {
                System.out.println("Thanks for shopping with us!");
            }
        } while(! choice.equals("3"));
    }
}
