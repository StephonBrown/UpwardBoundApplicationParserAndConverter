/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stephonb.studentappcsvconverter;

import java.util.HashMap;
import java.util.Map;
import org.apache.log4j.BasicConfigurator;
import stephonb.studentappcsvconverter.dao.CSVtoWordConverter;
import stephonb.studentappcsvconverter.dao.CSVtoWordConverterImplementation;

/**
 *
 * @author sbrown6
 */
public class app {
    public static void main(String[] args) {
        BasicConfigurator.configure();
        CSVtoWordConverter conv = new CSVtoWordConverterImplementation();
        conv.readCSVFile();
        Map<Integer, String> students = new HashMap();
        students.put(1, "Student");
        conv.writeCSVToPDF(students);
    }
}