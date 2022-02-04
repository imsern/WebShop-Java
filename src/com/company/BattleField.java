package com.company;

public class BattleField extends GameItem{
    public BattleField(int id, String name, int price, boolean physical, boolean virtual){
        this.ID = id;
        this.Name = name;
        this.Price = price;
        this.Physical = physical;
        this.Virtual = virtual;
    }
}
