package tomkous.algos;



public class UserInput {
    
    public static class TextInput {
        
        protected String value;
        
        public TextInput(){  
        	value = "";
        }
        
        public void add(char c) {
			// TODO Auto-generated method stub
        	 value = value + String.valueOf(c);
			
		}
        
        public String getValue(){
        	return value;
        };
    }

    public static class NumericInput extends TextInput{
        
        @Override 
        public void add(char c){
            
           if(Character.isDigit(c))
        	   value = value + String.valueOf(c);
        }
               
    }

    public static void main(String[] args) {
        TextInput input = new NumericInput();
        input.add('1');
        //System.out.println("Just added " + input.getValue());
        input.add('a');
        //System.out.println("Just added " + input.getValue());
        input.add('0');
        //System.out.println("Just added " + input.getValue());
        input.add('b');
        input.add('9');
        System.out.println(input.getValue());
    }
}
