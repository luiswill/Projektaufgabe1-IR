package src;

import java.io.File;

import parserSrc.NYTCorpusDocument;

import stem.ext.englishStemmer;



public class Parser extends parserSrc.NYTCorpusDocumentParser
{
    /**
     * Constructor for objects of class NYTCorpusDocumentParser
     */
    public static void main(String args[]){
    	Parser parser1 = new Parser(); 
    	parser1.parseAndStem();

    }
   
    /*
     * 
     * Return document
     */
    private Document parseAndStem(){
    	
    	 englishStemmer stemmer = new englishStemmer();

         File file1 = new File("C:/Users/Luis/Downloads/nyt/nyt/data/2000/01/01/1165029.xml");
         
         NYTCorpusDocument doc = parseNYTCorpusDocumentFromFile(file1, false);
         
         String headline = doc.getHeadline(); //get headline
         String url = doc.getUrl().toString();
         String content = removeNotChar(doc.getBody()).toLowerCase(); //first get body, then remove everything which is not char and then lowercase()

         stemmer.setCurrent(content); //stem the text 
         if (stemmer.stem()){ 
        	 content = stemmer.getCurrent();
         }
        System.out.print(content); // to remove, just for seeing the result

		return new Document(1, headline, url, content.split(" ")); // create a new document with properties
    }
    


	private String removeNotChar(String content){
    	String newContent = "";
    	for (char ch: content.toCharArray()) {
    		if(!Character.isLetterOrDigit(ch) && !Character.isSpaceChar(ch)){
    			ch = ' ';
    			
    		}else{
    			newContent += ch;
    		}
    	}
    	return newContent;
    }
}