package src;

import java.io.File;

import parserSrc.NYTCorpusDocument;

import stem.ext.englishStemmer;



public class Parser extends parserSrc.NYTCorpusDocumentParser
{

    public Document parseAndStem(File file){
    	
    	 englishStemmer stemmer = new englishStemmer();

         
         NYTCorpusDocument doc = parseNYTCorpusDocumentFromFile(file, false);
         
         String headline = doc.getHeadline(); //get headline
         String url = doc.getUrl().toString();
         String content = removeNotChar(doc.getBody()).toLowerCase(); //first get body, then remove everything which is not char and then lowercase()

         stemmer.setCurrent(content); //stem the text 
         if (stemmer.stem()){ 
        	 content = stemmer.getCurrent();
         }
        System.out.println(content); // to remove, just for seeing the result

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