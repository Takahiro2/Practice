package kagoyume;

import java.util.ArrayList;

/**
 * ToDo
 */
public class itemData {

    private String totalSearch;
    private String query;
    private ArrayList<String> code;
    private ArrayList<String> name;
    private ArrayList<String> image;
    private ArrayList<String> price;

    public String getTotalSearch() {
        return totalSearch;
    }

    public void setTotalSearch(String totalSearch) {
        this.totalSearch = totalSearch;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public ArrayList<String> getCode() {
        return code;
    }

    public void setCode(ArrayList code) {
        this.code = code;
    }

    public ArrayList<String> getName() {
        return name;
    }

    public void setName(ArrayList name) {
        this.name = name;
    }

    public ArrayList<String> getImage() {
        return image;
    }

    public void setImage(ArrayList image) {
        this.image = image;
    }

    public ArrayList<String> getPrice() {
        return price;
    }

    public void setPrice(ArrayList price) {
        this.price = price;
    }
}
