package com.mobilecenter.services;

import com.mobilecenter.models.Mobile;
import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private List<Mobile> mobiles;

    public Inventory() {
        this.mobiles = new ArrayList<>();
    }

    public void addMobile(Mobile mobile) {
        mobiles.add(mobile);
    }

    public void removeMobile(String mobileId) {
        mobiles.removeIf(mobile -> mobile.getId().equals(mobileId));
    }

    public Mobile findMobileById(String mobileId) {
        return mobiles.stream()
                .filter(mobile -> mobile.getId().equals(mobileId))
                .findFirst()
                .orElse(null);
    }

    public List<Mobile> getAllMobiles() {
        return mobiles;
    }

    @Override
    public String toString() {
        return "Inventory [Mobiles=" + mobiles + "]";
    }
}
