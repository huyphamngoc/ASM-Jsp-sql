package entity;

import java.util.ArrayList;
import java.util.HashMap;

public class Phone {
    private int id;
    private String name;
    private String brand;
    private String price;
    private String description;

    public Phone() {

    }

    public Phone(String name, String brand, String price, String description) {
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private HashMap<String, ArrayList<String>> errors;

    public boolean isValid() {
        validate();
        return this.errors.size() == 0;
    }

    public void validate() {
        if (this.errors == null) {
            this.errors = new HashMap<>();
        }

        ArrayList<String> errorsName = this.errors.get("name");

        if (errorsName == null) {
            errorsName = new ArrayList<>();
        }

        if (this.name == null || this.name.length() == 0) {
            errorsName.add("name is required!");
        } else if (this.name.length() < 2 || this.name.length() > 30) {
            errorsName.add("name is length 2-30");
        }
        if (errorsName.size() > 0) {
            this.errors.put("name", errorsName);
        }


        ArrayList<String> errorPrice = this.errors.get("price");
        if (errorPrice == null) {
            errorPrice = new ArrayList<>();
        }
        if (this.price == null || this.price.length() == 0) {
            errorPrice.add("price is required!");
        }
        if (errorPrice.size() > 0) {
            this.errors.put("price", errorPrice);
        }

        ArrayList<String> errorDes = this.errors.get("description");
        if (errorDes == null) {
            errorDes = new ArrayList<>();
        }
        if (this.description == null || this.description.length() == 0) {
            errorDes.add("description is required!");}
//        } else if (this.description.length() < 2 || this.description.length() > 30) {
//            errorDes.add("description is length 2-30");
//        }
        if (errorDes.size() > 0) {
            this.errors.put("description", errorDes);
        }
    }

    public HashMap<String, ArrayList<String>> getErrors() {
        return this.errors;
    }
}
