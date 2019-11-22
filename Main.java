package Main;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class Main{
    public static void main (String[] args) throws IOException{
    	
    	getFileName();
    	
        Path passagem = Paths.get("data.txt").toAbsolutePath();
        List<String> entrada;
		entrada = Files.lines(passagem).collect(Collectors.toList());
        
        String busca = getInput();
        
        exhibitResults(busca, entrada);
    }
    
    public class Input{
	    public static String getInput(){
	        Scanner azul = new Scanner(System.in);
	        System.out.print("Insira uma palavra para ser buscada: ");
	        
	        String busca = azul.nextLine();
	        busca = busca.replaceAll(" ","");
	        busca = busca.toLowerCase();
	        
	        azul.close();
	        
	        return busca;
	    }
    }
    
    public static String getFileName(){
  
    	File fonte = new File("C:\\src\fonte");
    	File[] matchingFiles = fonte.listFiles(new FilenameFilter(){
    	    public boolean accept(File dir, String name) {
    	        return name.startsWith("data") && name.endsWith("txt");
    	    }
    	});
		return null;
    }
    
    public class indiceInverso {
        
        private final String VOCABULARY_PATH = getFileName();

        public ArrayList<String> listaTermos() throws FileNotFoundException, IOException  {
            ArrayList <String> termos = new ArrayList <String>();
            BufferedReader leitor = new BufferedReader (new FileReader (VOCABULARY_PATH));
            String leitura;
            
            while ((leitura = leitor.readLine()) != null){
                String [] t = leitura.split(" ");
                termos.add(t[0]);
            }
            System.out.println(termos);
            return (termos);
        }
    }
    
    public static void exhibitResults(String busca, List<String> entrada){
        boolean inFile = entrada.stream().anyMatch(p->p.equalsIgnoreCase(busca));
        
        if (inFile) {
        	System.out.println(busca);
        }
        else {
        	System.out.println("\nA busca nao gerou resultados nos arquivos");
        }
    }
}