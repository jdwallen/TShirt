/**********************************************************
 * LOW PASS FILTER
 * 
 * Implements a low pass filter of the form:
 * 
 * 		Xn = K*Xin + (1-K)*Xn-1
 * 
 * Or, by factoring, eliminate a multiplication:
 * 
 *  	Xn = K*(Xin - Xn-1) + Xn-1
 *********************************************************/

package org.usfirst.frc4579.utilities;

public class LowPassFilter {

	private final double K;

	public LowPassFilter(double K) {
		
		assert (K >= 0.0) & (K <= 1.0) : "Low pass filter K is out of range.";
		this.K = K;
	}

	private double m_Xnm1 = 0.0;

	public double filter(double Xin) {
		double Xn = K*(Xin - m_Xnm1) + m_Xnm1;
		m_Xnm1 = Xn;
		return Xn;
	}

	public void reset() {
		m_Xnm1 = 0.0;
	}
}
