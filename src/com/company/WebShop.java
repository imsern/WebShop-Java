package com.company;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class WebShop {
    private final Inventory inventory;
    private final List<GameItem> ShoppingCart = new ArrayList<>();
    public WebShop(){
        inventory = new Inventory();
    }

    public void OpenShop(){
            while (true) {
                System.out.println("Welcome to the shop! ");
                System.out.println("1: Show all available games");
                System.out.println("2: Show only physical games");
                System.out.println("3: Show only downloadable games");
                String command = null;
                try {
                    command = Main.br.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                inventory.PrintInventory(command);
                HandleCommand();
            }
    }


    //TODO:
    private void HandleCommand() {
        //Skal lese inn input fra brukere her
        // Inventory skal printe ut informasjon basert på valget brukeren tok.
System.out.println("input the ID of game you want to buy");
        String gameID = null;
        try {
            gameID = Main.br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert gameID != null;
        var finalGameID = Integer.parseInt(gameID);
        var gameToBuy = inventory.InventoryList.stream().filter(x -> finalGameID == x.ID).findAny().orElse(null);
        ShoppingCart.add(gameToBuy);
        System.out.println("Your shoppingcart:");
        for (var s : ShoppingCart){
            System.out.println(s.Name);
        }
        assert gameToBuy != null;
        if(gameToBuy.Virtual && gameToBuy.Physical){
            System.out.println("Do you want to download the game? y/n");
            var response = "";
            try {
                response = Main.br.readLine().toLowerCase(Locale.ROOT);
            } catch (IOException e) {
                e.printStackTrace();
            }
            if(response.equals("y")) System.out.printf("%s is ready to be downloaded now...%n", gameToBuy.Name);
            else System.out.printf("%s is ready to be picked up at the store%n", gameToBuy.Name);
        } else if(gameToBuy.Virtual){
            System.out.printf("%s is ready to be downloaded now...%n", gameToBuy.Name);
        } else{
            System.out.printf("%s is ready to be picked up at the store%n", gameToBuy.Name);
        }

    }
}
