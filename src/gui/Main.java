package gui;

import assets.Artist;
import assets.Festival;
import assets.Performance;
import assets.Stage;
import gui.AgendaForm;

import javax.swing.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by Stijn on 6-2-2017.
 */
public class Main {

    public static AgendaForm mp;
    public static Festival festival;

    public static void main(String[] args){
        createTestFest();
        mp = new AgendaForm();
    }

    public JFrame getMainPanel(){
        return mp;
    }

    public static void createTestFest(){
        festival = new Festival(10000, 10, LocalDate.parse("2017-05-23", DateTimeFormatter.ISO_DATE),
                LocalTime.parse("06:00"), LocalTime.parse("23:00"), "testfest");
        festival.addStage(new Stage("Stage1", "", 1));
        festival.addStage(new Stage("Stage2", "", 2));
        festival.addStage(new Stage("Stage3", "", 3));
        festival.addStage(new Stage("Stage4", "", 4));
        festival.addStage(new Stage("Stage5", "", 5));
        festival.addStage(new Stage("Stage6", "", 6));

        festival.addPerformance(new Performance(new Artist("testguy", "kiphop", 2), festival.stages.get(2), LocalTime.parse("06:00"), LocalTime.parse("07:45")));
        festival.addPerformance(new Performance(new Artist("testboi", "kipkop", 4), festival.stages.get(3), LocalTime.parse("22:00"), LocalTime.parse("23:12")));
        festival.addPerformance(new Performance(new Artist("testdude0", "idek", 10000), festival.stages.get(0), LocalTime.parse("22:15"), LocalTime.parse("23:55")));
        festival.addPerformance(new Performance(new Artist("testdude1", "idek", 1000), festival.stages.get(5), LocalTime.parse("22:45"), LocalTime.parse("23:55")));
        festival.addPerformance(new Performance(new Artist("testdude2", "idek", 300), festival.stages.get(4), LocalTime.parse("22:27"), LocalTime.parse("23:55")));
    }
}