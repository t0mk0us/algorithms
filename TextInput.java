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

    public static void main(String[] args) {
        TxtInput input = new NumericInput();
        input.add('1');
        input.add('a');
        input.add('0');
        System.out.println(input.getValue());
    }
}
