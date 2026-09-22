package tomkous.algos;

public class PrimitiveTypes {
	
	int i;
	short s;
	long l;
	double d;
	float f;
	boolean b;
	byte b1;
	char c;
}

/*
Why void feels primitive:
It is a lowercase reserved keyword (void) that represents "no type" or an empty return value. 
If you look at Java’s Class API via reflection using void.class, 
it explicitly states isPrimitive() == true
*/