package com.company;

public class GameItem implements Game{
    public int ID;
    public String Name;
    public int Price;
    public boolean Physical; // Represents if the game is available as a physical example
    public boolean Virtual; // Represents if the game is available as a Downloadable example





    @Override
    public void PrintGameNameAndPrice() {
            System.out.printf("Item: %s Price: %s ID: %s%n", Name, Price, ID);
    }
}
