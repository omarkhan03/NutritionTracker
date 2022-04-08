package com.example.cpsc233projectdemo3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import utils.Entry;
import utils.Nutrient;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import static com.example.cpsc233projectdemo3.NutritionTrackerController.*;

public class NutritionTrackerMain extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(NutritionTrackerMain.class.getResource("NutritionTrackerMain.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1000, 600);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.setTitle("Nutrition Tracker Demo 3 by Carter Tam and Omar Khan");
        stage.show();
    }

    public static void main(String[] args) {
        if (args.length == 1){//if a file name is given, load from it
            try {
                File file = new File(args[0]);
                Scanner scanner = new Scanner(file);
                while(scanner.hasNextLine()){
                    String fileIn = scanner.nextLine();
                    String[] in = fileIn.split(",");//splits line into an array
                    if (in.length == 5){// if the length of the line is 5, store it as an entry
                        Nutrient nutrient = new Nutrient(in[1], in[2], Double.parseDouble(in[3]));
                        Entry entry = new Entry(Integer.parseInt(in[0]), nutrient, Double.parseDouble(in[4]));
                        entries.add(entry);
                    }
                    else if(in.length == 3){//if the length of the line is 3, store it as a nutrient
                        Nutrient nutrient = new Nutrient(in[0], in[1], Double.parseDouble(in[2]));
                        nutrients.add(nutrient);
                    }
                }
                System.out.println("Successfully loaded from file");
            }
            catch (FileNotFoundException e){//handles case when file read from argument doesn't exist
                System.out.println("File could not be found: " + args[0]);
                System.exit(1);
            }
        }
        else if(args.length > 1){//exits program if arguments are invalid
            System.out.println("Invalid Arguments");
            System.exit(1);
        }
        launch();
    }
}