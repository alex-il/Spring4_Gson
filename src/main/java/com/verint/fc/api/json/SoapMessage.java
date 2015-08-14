package com.verint.fc.api.json;
import java.util.List;

/**
 * Created by OBranopolsky on 17/06/2015.
 */
public class SoapMessage {
    private String name;
    private int population;
    private List<String> listOfStates;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public List<String> getListOfStates() {
        return listOfStates;
    }

    public void setListOfStates(List<String> listOfStates) {
        this.listOfStates = listOfStates;
    }
}
