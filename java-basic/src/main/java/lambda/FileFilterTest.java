package lambda;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class FileFilterTest {
/*
 * http://zh.lucida.me/blog/java-8-lambdas-insideout-language-features/
 */
	public static void main(String[] args) {
		File dir = new File("D://");
		File[] dirs = dir.listFiles((File f) -> f.isDirectory()); // FileFilter: boolean accept(File pathname);
		System.out.println(Arrays.toString(dirs));

//		Button bt = new Button();
//		ActionListener listener = event -> { ui.showSomething(); }; //void actionPerformed(ActionEvent e);
//		bt.addActionListener(listener);

	    List<String> languages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");  
	    System.out.println("Languages which starts with J :");  
	    filter(languages, (str)->str.startsWith("J"));  //Predicate: boolean test(T t);
	    System.out.println("Languages which ends with a ");  
	    filter(languages, (str)->str.endsWith("a"));  
	    System.out.println("Print all languages :");  
	    filter(languages, (str)->true);  
	    System.out.println("Print no language : ");  
	    filter(languages, (str)->false);  
	    System.out.println("Print language whose length greater than 4:");  
	    filter(languages, (str)->str.length() > 4);
		
	}
	public static void filter(List<String> names, Predicate<String> condition) {
	    for(String name: names) {  
	        if(condition.test(name)) {  
	            System.out.println(name + " ");  
	        }  
	    }  
	}  
}
