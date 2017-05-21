package src;

import java.io.File;

/**
 * Write a description of class Importer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Importer
{
    File [] files;
    private static final float SIZE_CONSTANT = 1024;
    /**
     * Constructor for objects of class Importer
     */
    public Importer()
    {
    }
    
    public static void main(String[] args){
    	Importer importer = new Importer();
    	
    	File folder = new File("C:/Users/Luis/Downloads/nyt/nyt/data/2000/01/01"); //folder where to search, just change here to search somewhere else
    	importer.importe(folder);
    }
    
    public void importe(File folder){ 
    	Parser parser = new Parser();

    	File[] files = folder.listFiles();

    	    for (File file : files) {
    	      if (file.isFile() && file.getName().endsWith(".xml")) {
    	    	  System.out.println("name :" + file.getName() +  " and length : " + file.length() / SIZE_CONSTANT); // to remove when doing research
    	    	  parser.parseAndStem(file);
    	      }else if(file.isDirectory()){
    	    	  importe(file);
    	      	}
    	      
    	    }

    }
}