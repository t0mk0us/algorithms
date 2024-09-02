package tomkous.algos;

import java.lang.String;

public class ReverseChars {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReverseChars clazz = new ReverseChars();
		
		String s = "Hello Darling Tomkous";
		
		System.out.println(s);
		String result = clazz.replaceChars(s, 'o');
		
		System.out.println(result);
		
		System.out.print(clazz.reverseCh(s));

	}
	
	public String reverseCh(String str){
		String result = "";
		for(int i = str.length()-1; i >= 0; i--){
			result = result + str.charAt(i);
		}
		return result;
	}
	
	public String replaceChars(String str, char ch){

		char[] temp = str.toCharArray();
		
		StringBuffer strb = new StringBuffer();

		for(int i=0; i<temp.length; i++){
			if (temp[i]==ch){
				strb.append("0");
			}else{
				strb.append(temp[i]);
			}
			System.out.println(i );	
			System.out.println(strb );
			}

		return strb.toString();
		
	}

}
