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
    	
    	File folder = new File("C:/Users/Luis/Downloads/nyt/nyt/data/2000/01");
    	importer.importe(folder);
    
    }
    
    public void importe(File folder){ 

    	File[] files = folder.listFiles();

    	    for (File file : files) {
    	      if (file.isFile() && file.getName().endsWith(".xml")) {
    	    	  System.out.println("name :" + file.getName() +  " and length : " + file.length() / SIZE_CONSTANT);
    	      }else if(file.isDirectory()){
    	    	  importe(file);
    	      	}
    	      
    	    }

       
    }


//File[] files = root.listFiles(); 
//for (File file : files) {
//    if (file.isFile()) {
//        ...
//    } else if (file.isDirectory()) {
//        find_files(file);
//    }
//}
//
    
    /*public static void main(String [] args){
        String verz = data;
        ArrayList<File> files = data;
        importe(data[0]);
    }*/
}