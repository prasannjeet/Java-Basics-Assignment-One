package ps222vt_assign1;
//Used basic self explanatory methods.
//Implemented in FractionMain.java
public class Fraction {
	int N;
	int D;
	
	public Fraction (int a, int b){
		N=a;
		D=b;
		if(b==0)
			try {
				throw new DenominatorIsZeroException("Error occured! Denominator cannot be zero. Program will now terminate.");
			} catch (DenominatorIsZeroException e) {
				System.out.print(e);
				System.exit(-1);
			}
		//this.simplifiedFraction(this);
	}
	public int getNumerator(){
		return N;
	}
	public int getDenominator(){
		return D;
	}
	public boolean isNegative (){
		return((N<0&&D>0)||(N>=0&&D<0)?true:false);
	}
	public Fraction add (Fraction a, Fraction b){
		return (simplifiedFraction(new Fraction (a.N*b.D+a.D*b.N, a.D*b.D)));
	}
	public Fraction subtract (Fraction a, Fraction b){
		return (simplifiedFraction(new Fraction (a.N*b.D-a.D*b.N, a.D*b.D)));
	}
	public Fraction multiply (Fraction a, Fraction b){
		return (simplifiedFraction(new Fraction(a.N*b.N, a.D*b.D)));
	}
	public Fraction divide (Fraction a, Fraction b){
		return (simplifiedFraction(new Fraction(a.N*b.D, a.D*b.N)));
	}
	public boolean isEqualTo (Fraction a, Fraction b){
		return (new Double(a.N/a.D)==new Double(b.N/b.D)?true:false);
	}
	public String toString (){
		return (new String(Integer.toString(this.N)+"/"+Integer.toString(this.D)));
	}
	//Using euclidean algorithm to calculate the highest common factor (GCD or HCF):
	public int GCD(int a, int b){
		   if (b==0) return a;
		   return GCD(b,a%b);
		}
	/* After finding out the GCD, just dividing both numerator and denominator with
	 * the GCD value gives us a simplified version of the fraction
	 */
	public Fraction simplifiedFraction (Fraction a){
		return (new Fraction (a.N/GCD(a.N, a.D), a.D/GCD(a.N, a.D)));
	}
}
//handle when denominator is zero
