package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Inventory {
    public List<GameItem> InventoryList = new ArrayList<>();
    private List<GameItem> PhysicalItems = new ArrayList<>();
    private List<GameItem> DownloadableItems = new ArrayList<>();

    public Inventory() {
        InventoryList.add(new PUBG(1, "PUBG", 100, true, true));
        InventoryList.add(new PokemonLetsGoEvee(2, "Pokemon Let's GO Evee", 400, true, false));
        InventoryList.add(new CyberPunk(3, "Cyberpunk", 250, true, true));
        InventoryList.add(new BattleField(4, "Battlefield", 150, false, true));
        PhysicalItems = ListPhysicalItems();
        DownloadableItems = ListDownLoadable();
    }

    private List<GameItem> ListPhysicalItems() {
        assert InventoryList != null;
        return InventoryList.stream().filter(x -> x.Physical).toList();
    }

    private List<GameItem> ListDownLoadable() {
        assert InventoryList != null;
        return InventoryList.stream().filter(x -> x.Virtual).toList();
    }

    public void PrintInventory(String command)
    {
        if (Objects.equals(command, "1"))
        {
            Print(InventoryList);
        }
        else if(Objects.equals(command, "2"))
        {
            Print(PhysicalItems);
        }
        else
        {
            Print(DownloadableItems);
        }
    }
    public void Print(List<GameItem> list){
      for(var l : list){
          l.PrintGameNameAndPrice();
      }
    }
}
