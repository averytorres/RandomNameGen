import java.util.Random;
import java.util.Scanner;

/*
 * This class will generate random names
 * 
 * It has the functionality randomly add prefixes and suffixes specific to the first and last names
 * 
 */
public class randomName {
	
	final private String[] consonants ={"q","w","r","t","y","p","s","d","f","g","h","j","k","l","z","x","c","v","b","n","m"};
	final private String[] vowels ={"e","u","i","o","a"};
	final private String[] fPrefixes ={"Flo","Lou","La","Es","Be","Vi","In","Fra","Lov","Je","Col","Ju","Ali","Lei","Bra","Tob","Mas","Row","Ju","Fi","She","Ja","Av","Lau","Arc","Ste","Bri","Moe","Enr","Ale"};
	final private String[] lPrefixes ={"Sm","Jo","Wil","Bro","Da","Mil","Ta","Mo","Jac","And","Whi","Ha","Tho","Ga","Rob","Cla","Ha","Al","He","San","Rod","Dom","Dad","Tor","Jo","Ste","Cam","Be","Mur","Pur"};
	final private String[] fSuffixes ={"es","on","la","ra","iam","am","nce","cie","cey","me","ia","et","pe","le","ny","vy","ty","py","lia","on","se","ah","tin","nn","ob","ton","de","gh","ah","die"};
	final private String[] lSuffixes ={"es","on","th","te","is","in","son","ez","cia","len","dez","ng","re","tin","ing","ee","ers","ed","ox","ra","ans","ker","ok","ed","ris","ait","ips","ray","oss","man"};
	private String first,last;
	private  Random randomGenerator = new Random();


	public void genNewName(){

		int fLength = randomGenerator.nextInt(8-3)+3;
		int lLength = randomGenerator.nextInt(9-3)+3;
		int sucCons=0,sucVows=0;
		String fName="",lName="";

		//generate first name
		for(int i=0;i<fLength;i++){
			int choice = randomGenerator.nextInt(2);
			
			//Randomly add a prefix to name
			if(i==0){
				int pre=randomGenerator.nextInt(2);
				
				if(pre==1){
					fName=fName+fPrefixes[randomGenerator.nextInt(fPrefixes.length)];
					i=fLength-fName.length();
				}
			}
			
			//decides to choose consonant or vowel
			if(choice==0&&sucCons<2||sucVows>=1){
				fName=fName+consonants[randomGenerator.nextInt(consonants.length)];
				sucCons++;
				sucVows=0;
			}
			else{
				fName=fName+vowels[randomGenerator.nextInt(vowels.length)];
				sucCons=0;
				sucVows++;
			}
			
			//Randomly add a suffix to name (last 3 letters)
			if((fLength-i)==3){
				int suff=randomGenerator.nextInt(2);
				
				if(suff==1){
					fName=fName+fSuffixes[randomGenerator.nextInt(fSuffixes.length)];
					i=fLength;
				}
			}
		}
		sucCons=0;
		sucVows=0;
		
		//generate last name
		for(int i=0;i<lLength;i++){
			int choice = randomGenerator.nextInt(2);
			
			//Randomly add a prefix to name
			if(i==0){
				int pre=randomGenerator.nextInt(2);
				
				if(pre==1){
					lName=lName+lPrefixes[randomGenerator.nextInt(lPrefixes.length)];
					i=lLength-lName.length();
				}
			}
			
			//decides to choose consonant or vowel
			if(choice==0&&sucCons<2||sucVows>=2){
				lName=lName+consonants[randomGenerator.nextInt(consonants.length)];
				sucCons++;
				sucVows=0;
			}
			else{
				lName=lName+vowels[randomGenerator.nextInt(vowels.length)];
				sucCons=0;
				sucVows++;
			}
			
			//Randomly add a suffix to name (last 3 letters)
			if((lLength-i)==3){
				int suff=randomGenerator.nextInt(2);
				
				if(suff==1){
					lName=lName+lSuffixes[randomGenerator.nextInt(lSuffixes.length)];
					i=lLength;
				}
			}
		}
		
		first=fName.substring(0,1).toUpperCase()+fName.substring(1);
		last=lName.substring(0,1).toUpperCase()+lName.substring(1);


	}
	public String getName(){
		return first+" "+last;
	}
	
	//testing out name generation
	public static void main(String[] args){
		randomName r = new randomName();
		boolean flag=true;
		String in="";
		while(flag){
			
			r.genNewName();
			System.out.println("Your name is: "+r.getName());
			System.out.println();
			in=new Scanner(System.in).nextLine();
			if(in.equals("exit")){
				flag=false;
			}
		}
	}
}
