import java.io.*;
public class promote {
	public static int Bronzea = 0;
	public static int Bronzeb = 0;
	public static int Silvera = 0;
	public static int Silverb = 0;
	public static int Golda = 0;
	public static int Goldb = 0;
	public static int Platinuma = 0;
	public static int Platinumb = 0;
	
	public static void main(String [] args) {
		String bronze = "I";
		String silver = "";
		String gold = "";
		String platinum = "";
		try{
		FileReader fileReader = 
                new FileReader("promote.in");

            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);
		
            for (int i = 0; i <4; i++) {
            	if (i==0) {
            		 bronze = bufferedReader.readLine();
            	}
            	if (i==1) {
            		 silver = bufferedReader.readLine();
            	}
            	if (i==2) {
            		 gold = bufferedReader.readLine();
            	}
            	if (i==3) {
            		 platinum = bufferedReader.readLine();
            		 
            	}
            }
            bufferedReader.close();
		}
		catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file");                
        }
		 catch(IOException ex) {
	            System.out.println(
	                "Error reading file");                  
	        }
            
		promote.getBronze(bronze );
		promote.getSilver(silver );
		promote.getGold(gold);
		promote.getPlatinum(platinum);
		
		int oneoutput = Platinumb - Platinuma;
		int twooutput = Goldb - Golda + oneoutput;
		int threeoutput = Silverb - Silvera + twooutput;
		
		try {
            FileWriter fileWriter =
                new FileWriter("promote.out");

            BufferedWriter bufferedWriter =
                new BufferedWriter(fileWriter);

            bufferedWriter.write(String.valueOf(threeoutput));
            bufferedWriter.newLine();
            bufferedWriter.write(String.valueOf(twooutput));
            bufferedWriter.newLine();
            bufferedWriter.write(String.valueOf(oneoutput));
            bufferedWriter.close();
        }
        catch(IOException ex) {
            System.out.println(
                "Error writing to file");
                                }
	}
	public static void getBronze(String a) {
		int b = a.indexOf(" ");
		String c = a.substring(0, b);
		Bronzea = Integer.parseInt(c);
		String e = a.substring(b+1, a.length());
		Bronzeb = Integer.parseInt(e);
	}
	public static void getSilver(String a) {
		int b = a.indexOf(" ");
		String c = a.substring(0, b );
		Silvera = Integer.parseInt(c);
		String e = a.substring(b+1, a.length());
		Silverb = Integer.parseInt(e);
	}
	public static void getGold(String a) {
		int b = a.indexOf(" ");
		String c = a.substring(0, b);
		Golda = Integer.parseInt(c);
		String e = a.substring(b+1, a.length());
		Goldb = Integer.parseInt(e);
	}
	public static void getPlatinum(String a) {
		int b = a.indexOf(" ");
		String c = a.substring(0, b);
		Platinuma = Integer.parseInt(c);
		String e = a.substring(b+1, a.length());
		Platinumb = Integer.parseInt(e);
	}
}
