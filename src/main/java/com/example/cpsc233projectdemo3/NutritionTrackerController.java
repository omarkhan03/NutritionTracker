package com.example.cpsc233projectdemo3;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import utils.Entry;
import utils.Nutrient;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.imageio.IIOException;
import java.io.*;
import java.sql.Array;
import java.util.*;

public class NutritionTrackerController {//GUI FRAMEWORK FROM ASSIGNMENT 3 REUSED
    public static ArrayList<Nutrient> nutrients = new ArrayList<Nutrient>();
    public static ArrayList<Entry> entries = new ArrayList<Entry>();
    private File currentFile;
    @FXML
    private Label left;
    @FXML
    private FileChooser fileChooser = new FileChooser();//Reused from assignment 3
    @FXML
    private TextField entryDay;
    @FXML
    private TextField entryConsumption;
    @FXML
    private TextField entryNutrient;
    @FXML
    private TextField nutrientName;
    @FXML
    private TextField nutrientTarget;
    @FXML
    private TextField nutrientUnit;

    @FXML
    public void initialize(){
        left.setText("Program Status");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Comma Separated Value Files (.csv)", "*.csv"));//Reused from assignment 3
    }

    @FXML
    public void loadFile() {
        File file = fileChooser.showOpenDialog(null);
        entries.clear();
        nutrients.clear();
        System.out.println("Enter the name of the file to load from:");
        try {
            Scanner scan = new Scanner(file);
            while(scan.hasNextLine()){
                String fileIn = scan.nextLine();
                String[] in = fileIn.split(",");
                if (in.length == 5){//if there are 5 values in a line, it is stored as an entr
                    Nutrient nutrient = new Nutrient(in[1], in[2], Double.parseDouble(in[3]));
                    Entry entry = new Entry(Integer.parseInt(in[0]), nutrient, Double.parseDouble(in[4]));
                    entries.add(entry);
                }
                else if(in.length == 3){//if there are 3 values in a csv line, it is stored as a nutrient
                    Nutrient nutrient = new Nutrient(in[0], in[1], Double.parseDouble(in[2]));
                    nutrients.add(nutrient);
                }
            }
            left.setTextFill(Color.color(0,1,0));
            left.setText("Loaded World " + file.getName());
            currentFile = file;
        }
        catch (FileNotFoundException e){
            left.setTextFill(Color.color(1,0,0));
            left.setText("File could not be found: " + file.getName());
            System.exit(1);
        }
    }

    @FXML
    public void saveFile() {
        File file = currentFile;
        if(!file.exists()){//creates file if it doesn't exit, as per lecture
            try{
                file.createNewFile();
            }
            catch(IOException e){
                System.err.println("File could not be created: " + file);
                System.exit(1);
            }
        }

        if(file.isFile() && file.exists() && file.canWrite()){//Checking file existence, as per instructions from lecture
            try{
                FileWriter fw = new FileWriter(file);
                PrintWriter printWriter = new PrintWriter(fw);

                for(Entry e : entries){//stores entries in a csv format
                    printWriter.println(e.getDay() + "," + e.getNutrientName() + "," + e.getNutrientUnit() + "," + e.getNutrientTarget() + "," + e.getConsumption());
                }

                for(Nutrient n : nutrients){//stores nutrients in csv format
                    printWriter.println(n.getName() + "," + n.getUnit() + "," + n.getTarget());
                }
                printWriter.flush();

                left.setTextFill(Color.color(0,1,0));
                left.setText("Save successful!");
            }
            catch(IOException e){
                left.setTextFill(Color.color(1,0,0));
                left.setText("File could not be found: " + file.getName());
                System.exit(1);
            }
        }
        else{
            left.setTextFill(Color.color(1,0,0));
            left.setText("Cannot write to file!");
        }
    }

    @FXML
    public void saveFileAs() {
        File file = fileChooser.showOpenDialog(null);
        if(!file.exists()){//creates file if it doesn't exit, as per lecture
            try{
                file.createNewFile();
            }
            catch(IOException e){
                System.err.println("File could not be created: " + file);
                System.exit(1);
            }
        }

        if(file.isFile() && file.exists() && file.canWrite()){//Checking file existence, as per instructions from lecture
            try{
                FileWriter fw = new FileWriter(file);
                PrintWriter printWriter = new PrintWriter(fw);

                for(Entry e : entries){//stores entries in a csv format
                    printWriter.println(e.getDay() + "," + e.getNutrientName() + "," + e.getNutrientUnit() + "," + e.getNutrientTarget() + "," + e.getConsumption());
                }

                for(Nutrient n : nutrients){//stores nutrients in csv format
                    printWriter.println(n.getName() + "," + n.getUnit() + "," + n.getTarget());
                }
                printWriter.flush();

                left.setTextFill(Color.color(0,1,0));
                left.setText("Save successful!");
                currentFile = file;
            }
            catch(IOException e){
                left.setTextFill(Color.color(1,0,0));
                left.setText("File could not be found: " + file.getName());
                System.exit(1);
            }
        }
        else{
            left.setTextFill(Color.color(1,0,0));
            left.setText("Cannot write to file!");
        }
    }

    @FXML
    public void quitProgram() {
        System.exit(1);
    }

    @FXML
    public void aboutInfo() {
    }

    @FXML
    public void addNutrient() {
        try {
            Nutrient nutrient = new Nutrient(nutrientName.getText(), nutrientUnit.getText(), Double.parseDouble(nutrientTarget.getText()));
            nutrients.add(nutrient);
            left.setTextFill(Color.color(0,1,0));
            left.setText("Added Nutrient!");
        }

        catch(Exception e) {
            left.setTextFill(Color.color(1,0,0));
            left.setText("Invalid values given! Ensure the target value is a number!");
        }
    }

    @FXML
    public void addEntry() {
        try {
            Entry entry = null;
            for(Nutrient n : nutrients) {
                if(n.getName().equals(entryNutrient)) {
                    entry = new Entry(Integer.parseInt(entryDay.getText()), n, Double.parseDouble(entryConsumption.getText()));//finds nutrient in list and creates entry
                }
            }

            if (!(entry == null)) {
                entries.add(entry);
                left.setTextFill(Color.color(0,1,0));
                left.setText("Added Entry!");
            }

            else {
                left.setTextFill(Color.color(1,0,0));
                left.setText("Nutrient not found!");
            }
        }

        catch(Exception e) {
            left.setTextFill(Color.color(1,0,0));
            left.setText("Invalid values given! Ensure the day is an integer and the consumption is a number!");
        }
    }
}