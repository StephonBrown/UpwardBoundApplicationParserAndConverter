/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stephonb.studentappcsvconverter.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import org.docx4j.XmlUtils;
import org.docx4j.jaxb.XPathBinderAssociationIsPartialException;
import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.wml.Body;
import org.docx4j.wml.P;
import org.docx4j.wml.R;
import org.docx4j.wml.Text;

/**
 *
 * @author sbrown6
 */
public class CSVtoWordConverterImplementation implements CSVtoWordConverter {
    private static final String FILENAME = "/Users/sbrown6/Desktop/UpwardBoundApplication_09_17_2018_13_02_33.csv";
    private static final String DELIMITER = ",";
    
    @Override
    public void readCSVFile() {
        try{
            Scanner sc = new Scanner(new BufferedReader(new FileReader(FILENAME)));
            String currentLine;
            String[] currentTokens;
            int lineNumber = 0;
            
            while(sc.hasNextLine()){
                lineNumber +=1;
                currentLine = sc.nextLine();
                currentTokens = currentLine.split(DELIMITER);
                
                if(lineNumber ==1){
                    System.out.println("Ignore");
                }
                
                try{
                    String submissionDate = currentTokens[0];
                    System.out.println(currentTokens[0]);
                    String email = currentTokens[1];
                    System.out.println(currentTokens[1]);
                    String program = currentTokens[2];
                    System.out.println(currentTokens[2]);
                    String firstName = currentTokens[3];
                    System.out.println(currentTokens[3]);
                    String middleName = currentTokens[4];
                    System.out.println(currentTokens[4]);
                    String lastName = currentTokens[5];
                    System.out.println(currentTokens[5]);
                    String gender = currentTokens[6];
                    System.out.println(currentTokens[6]);
                    String currentAge = currentTokens[7];
                    System.out.println(currentTokens[7]);
                    String tShirtSize = currentTokens[8];
                    System.out.println(currentTokens[8]);
                    String guardianOfResidence = currentTokens[9];
                    System.out.println(currentTokens[9]);
                    String datOfBirth = currentTokens[10];
                    System.out.println(currentTokens[10]); 
                    String currentSchool = currentTokens[11];
                    System.out.println(currentTokens[11]);
                    String currentGrade = currentTokens[12];
                    System.out.println(currentTokens[12]);
                    String guidanceCounselorName = currentTokens[13];
                    System.out.println(currentTokens[13]);
                    String streetAddress = currentTokens[14];
                    System.out.println(currentTokens[14]);
                    String city = currentTokens[15];
                    System.out.println(currentTokens[15]);
                    String state = currentTokens[16];
                    System.out.println(currentTokens[16]);
                    String zipCode = currentTokens[17];
                    System.out.println(currentTokens[17]);
                    String homePhone = currentTokens[18];
                    System.out.println(currentTokens[18]); 
                    String parentCell = currentTokens[19];
                    System.out.println(currentTokens[19]);
                    System.out.println(currentTokens[20]);
                    System.out.println(currentTokens[21]);
                    System.out.println(currentTokens[22]);
                    System.out.println(currentTokens[23]);
                    System.out.println(currentTokens[24]);
                    System.out.println(currentTokens[25]); 
                } catch(ArrayIndexOutOfBoundsException ex){
                    break;
                }
            }
            sc.close();
        }catch(IOException ex){
            System.out.println("Problem accessing this file");
        }
           
    }

    @Override
    public void writeCSVToPDF(Map<Integer, String> studentInfo) {
        try {
            WordprocessingMLPackage wordDoc = WordprocessingMLPackage.load(new File("/Users/sbrown6/Desktop/UB Application Without Evaluations.docx"));
            List<Object> mp = wordDoc.getMainDocumentPart().getJAXBNodesViaXPath("//w:p", true);
            for(Object obj: mp){
                if(mp.indexOf(obj)==12){
                    ((Text)((JAXBElement)((R)((P)obj).getContent().get(0)).getContent().get(0)).getValue()).setValue("Today’s Date______" + LocalDate.now().format(DateTimeFormatter.ofPattern("MM/dd/yyyy"))+"________    Applicant" );
                    System.out.println(((Text)((JAXBElement)((R)((P)obj).getContent().get(0)).getContent().get(0)).getValue()).getValue());
                }
                System.out.println(mp.indexOf(obj) + obj.toString());;
            }
            wordDoc.save(new File("/Users/sbrown6/Desktop/StephonsApplication.docx"));
        } catch(Docx4JException |JAXBException  ex) {
            Logger.getLogger(CSVtoWordConverterImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    
}
