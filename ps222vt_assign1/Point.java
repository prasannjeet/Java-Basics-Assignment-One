package ps222vt_assign1;
import java.lang.Math;
//These codes have been implemented in another file: PointImplementation.java
//The methods are self explanatory
public class Point {
	int xCo;
	int yCo;
	
	public Point (){
		xCo = 0;
		yCo = 0;
	}
	
	public Point (int a, int b){
		xCo = a;
		yCo = b;
	}
	
	public boolean isEqualTo (Point p){
		if (p.xCo==xCo && p.yCo==yCo)return true;
		return false;
	}
	public String toString (){
		StringBuilder str = new StringBuilder("(");
		str.append(xCo);
		str.append(',');
		str.append(yCo);
		str.append(')');
		return(str.toString());
	}
	
	public void move (int a, int b){
		xCo+=a;
		yCo+=b;
	}
	
	public void moveToXY(int a, int b){
		xCo = a;
		yCo = b;
	}
	
	public double distanceTo (Point p){
		return (Math.sqrt(Math.pow((p.xCo-xCo),2)+Math.pow((p.yCo-yCo),2)));
	}
}