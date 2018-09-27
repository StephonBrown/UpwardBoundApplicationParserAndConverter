/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stephonb.studentappcsvconverter.dao;

import java.io.File;
import java.util.Map;

/**
 *
 * @author sbrown6
 */
public interface CSVtoWordConverter {
    public void readCSVFile();
    
    public void writeCSVToPDF(Map<Integer, String> studentInfo);
}
