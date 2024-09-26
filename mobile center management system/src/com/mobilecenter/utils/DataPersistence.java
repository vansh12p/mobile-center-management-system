package com.mobilecenter.utils;

import com.mobilecenter.models.Mobile;
import com.mobilecenter.services.Inventory;
import java.io.*;
import java.util.List;

public class DataPersistence {
    public static void saveInventory(Inventory inventory, String fileName) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(inventory.getAllMobiles());
        }
    }

    @SuppressWarnings("unchecked")
    public static Inventory loadInventory(String fileName) throws IOException, ClassNotFoundException {
        Inventory inventory = new Inventory();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            List<Mobile> mobiles = (List<Mobile>) ois.readObject();
            mobiles.forEach(inventory::addMobile);
        }
        return inventory;
    }
}
