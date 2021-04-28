package hu.nive.ujratervezes.zarovizsga.cleaning;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CleaningService {

    List<Cleanable> cleanables = new ArrayList<>();

    public void add(Cleanable cleanable) {
        cleanables.add(cleanable);
    }

    public List<Cleanable> getCleanables() {
        return cleanables;
    }

    public int cleanAll() {
        int sum = 0;
        Iterator<Cleanable> i = cleanables.iterator();
        while (i.hasNext()) {
            Cleanable cleanable = i.next();
            sum += cleanable.clean();
            i.remove();
        }
        return sum;
    }

    public int cleanOnlyOffices() {
        int sum = 0;
        Iterator<Cleanable> i = cleanables.iterator();
        while (i.hasNext()) {
            Cleanable cleanable = i.next();
            if (cleanable instanceof Office) {
                sum += cleanable.clean();
                i.remove();
            }
        }
        return sum;
    }

    public List<Cleanable> findByAddressPart(String address) {
        List<Cleanable> cleanableList = new ArrayList<>();
        for (Cleanable cleanable: cleanables) {
            if (cleanable.getAddress().contains(address)) {
                cleanableList.add(cleanable);
            }
        }
        return cleanableList;
    }

    public String getAddresses() {
        String addressOfRealEstates = "";
        for (int i = 0; i < cleanables.size(); i++) {
            if (i == cleanables.size()-1) {
                addressOfRealEstates += cleanables.get(i).getAddress();
                continue;
            }
            addressOfRealEstates += cleanables.get(i).getAddress() + ", ";
        }
        return addressOfRealEstates;
    }
}
