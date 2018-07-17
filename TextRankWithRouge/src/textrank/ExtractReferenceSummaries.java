package textrank;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author cuonggm48
 */
public class ExtractReferenceSummaries {
    public static final String REFERENCE_DIR = "reference_summaries";
    public static final String ORIGINAL_DIR = "original_documents";
    public static final String SYSTEM_DIR = "system_summaries";
    
    private int startIndex;
    private final String fileName;
    private final File file;
    private final Scanner scanner;

    public static void main(String[] argv) {
        try {
            ExtractReferenceSummaries tool = new ExtractReferenceSummaries(0, "0012-baomoi-articles.txt");
            tool.extract();
        } catch (FileNotFoundException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }
    
    public ExtractReferenceSummaries(int startIndex, String fileName) throws FileNotFoundException {
        this.startIndex = startIndex;
        this.fileName = fileName;
        file = new File(this.fileName);
        scanner = new Scanner(file);
    }
    
    public void extract() {
        String content = "";
        while(scanner.hasNextLine()) {
            String line = scanner.nextLine();
            line = line.trim();
            if(line.isEmpty()) {
                continue;
            }
            if(line.matches("#")) {
                if(!content.isEmpty()) {
                    content = content.trim();
                    createOriginalFile(content);
                    createSystemSummaries(ORIGINAL_DIR + "/" + String.valueOf(startIndex) + ".txt", SYSTEM_DIR + "/" + String.valueOf(startIndex) + "_textrank.txt");
                    content = "";
                }
                line = scanner.nextLine();
                line = scanner.nextLine();
                startIndex++;
                createReferenceSummaryFile(line);
            } else {
                content += "\n";
                content += line;
            }
        }
        if(!content.isEmpty()) {
            content = content.trim();
            createOriginalFile(content);
            content = "";
        }
    }
    
    private void createReferenceSummaryFile(String content) {
        File newFile = new File(REFERENCE_DIR + "/" + String.valueOf(startIndex) + "_ref.txt");
        Writer writer;
        try {
            writer = new FileWriter(newFile);
            writer.write(content);
            writer.flush();
            writer.close();
            System.out.println("Write Ref " + startIndex);
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }
    
    private void createOriginalFile(String content) {
        File newFile = new File(ORIGINAL_DIR + "/" + String.valueOf(startIndex) + ".txt");
        Writer writer;
        try {
            writer = new FileWriter(newFile);
            writer.write(content);
            writer.flush();
            writer.close();
            System.out.println("Write Original " + startIndex);
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }
    
    private void createSystemSummaries(String fileNameIn, String fileNameOut) {
        TextRank textRank = new TextRank();
        textRank.summarizeADocument(fileNameIn, fileNameOut);
    }
    
}
