package tomkous.algos;



public class TextInput {
	
	private static String currValue = new String();
    
     static class TxtInput {
        
        public void add(char c){
          
            currValue += c;
        }
        
        public String getValue(){
            return currValue;
        }
    }

     static class NumericInput extends TxtInput {
        
        @Override
          public void add(char c){
             if(Character.isDigit(c)){
             	currValue += c;
        }
    }
    }
     
     static class CharInput extends TxtInput {
         
         @Override
           public void add(char c){
              if(Character.isLetter(c)){
            	  System.out.println(Character.getType(c));
              	currValue += c;
         }
     }
     }

    public static void main(String[] args) {
        TxtInput input1 = new NumericInput();
        input1.add('1');
        input1.add('M');
        input1.add('a');
        input1.add('2');
        input1.add('t');
        input1.add('t');
        input1.add(' ');
        input1.add('B');
        input1.add('3');
        input1.add('e');
        input1.add('l');
        input1.add('4');
        input1.add('l');
        input1.add('a');
        input1.add('m');
        input1.add('y');
        input1.add(' ');
        input1.add('!');
        input1.add('!');
        input1.add('!');
        
        System.out.println("Numeric input is:");
        System.out.println(input1.getValue());
        
        System.out.println("");
        
        TxtInput input2 = new CharInput();
        input2.add('1');
        input2.add('M');
        input2.add('a');
        input1.add('2');
        input2.add('t');
        input2.add('t');
        input2.add(' ');
        input2.add('B');
        input1.add('3');
        input2.add('e');
        input2.add('l');
        input2.add('l');
        input1.add('4');
        input2.add('a');
        input2.add('m');
        input2.add('y');
        input2.add(' ');
        input2.add('!');
        input2.add('!');
        input2.add('!');
        input2.add('0');
        
        System.out.println("Character input is:");
        System.out.println(input2.getValue());
    }
}
