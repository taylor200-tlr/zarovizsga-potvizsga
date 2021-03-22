package hu.nive.ujratervezes.zarovizsga.cleaning;

import java.util.ArrayList;
import java.util.List;

public class CleaningService {
    private List<Cleanable> cleanables = new ArrayList<>();

    public List<Cleanable> getCleanables() {
        return cleanables;
    }

    public int cleanAll() {
        int result = 0;
        for (int i = 0; i < cleanables.size(); i++) {
            result += cleanables.get(i).clean();
        }
        cleanables.clear();
        return result;
    }

    public int cleanOnlyOffices() {
        int result = 0;
        List<Cleanable> cleaned = new ArrayList<>();
        for (int i = 0; i < cleanables.size(); i++) {
            if (cleanables.get(i) instanceof Office) {
                result += cleanables.get(i).clean();
                cleaned.add(cleanables.get(i));
            }
        }
        cleanables.removeAll(cleaned);
        return result;
    }

    public List<Cleanable> findByAddressPart(String s) {
        List<Cleanable> result = new ArrayList<>();
        for (Cleanable actual : cleanables) {
            if (actual.getAddress().contains(s)) {
                result.add(actual);
            }
        }
        return result;
    }

    public String getAddresses() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < cleanables.size(); i++) {
            stringBuilder.append(cleanables.get(i).getAddress());
            if (i < cleanables.size() - 1) {
                stringBuilder.append(", ");
            }

        }
        return stringBuilder.toString();
    }

    public void add(Cleanable building) {
        cleanables.add(building);
    }
}
