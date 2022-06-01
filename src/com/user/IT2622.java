package com.user;

import static java.lang.Math.*;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class IT2622 {
	
	private double classStandingPrelim, longTestPrelim, deliverablePrelim, examPrelim,
	rawPrelimGrade, transmutedPrelimGrade, 
	classStandingFinal, longTestFinal, deliverableFinal, integratedAssmnt,
	rawFinalGrade, transmutedFinalGrade,gwa;
	
	// PRELIMS
	public double computeClassStandingPrelim(double attendance, double recitation, double FA) {
		classStandingPrelim = (attendance + recitation + FA)/3.0 * 0.1;
		return classStandingPrelim;
	}
	
	public double computeLongTestPrelim(double longTest) {
		longTestPrelim = (longTest/70.0 * 100) * 0.3;
		return longTestPrelim;
	}
	
	public double computeDeliverablePrelim(double wireframe, double storyboard, double prototype) {
		deliverablePrelim = (((wireframe/24.0*100) + (storyboard/40.0*100) + (prototype/32.0*100))/3.0 * 0.3);
		return deliverablePrelim;
	}
	
	public double computeExamPrelim(double exam) {
		examPrelim = exam * 0.3;
		return examPrelim;
	}
	
	public double computeRawPrelimGrade() {
		DecimalFormat df = new DecimalFormat("##.##");
        df.setRoundingMode(RoundingMode.HALF_UP);
        
		rawPrelimGrade = Double.parseDouble(df.format(classStandingPrelim + longTestPrelim + deliverablePrelim + examPrelim));
		return rawPrelimGrade;
	}
	
	public double computeTransmutedPrelimGrade() {
		DecimalFormat df = new DecimalFormat("##.#");
        df.setRoundingMode(RoundingMode.HALF_UP);
		
		transmutedPrelimGrade = Double.parseDouble(df.format(0.625 * (rawPrelimGrade-60) + 75));
		return transmutedPrelimGrade;
	}
	
	
	// FINALS
	public double computeClassStandingFinal(double attendance, double recitation, double assigment) {
		classStandingFinal = (attendance + recitation + assigment)/3.0 * 0.1;
		return classStandingFinal;
	}
	
	public double computeLongTestFinal(double longTest) {
		longTestFinal = (longTest/105.0*100)* 0.3;
		return longTestFinal;
	}
	
	public double computeDeliverableFinal(double deliverable) {
		deliverableFinal = deliverable * 0.3;
		return deliverableFinal;
	}
	
	public double computeIntegratedAssmnt(double IA) {
		integratedAssmnt = IA * 0.3;
		return integratedAssmnt;
	}
	
	public double computeRawFinalGrade() {
		DecimalFormat df = new DecimalFormat("##.##");
        df.setRoundingMode(RoundingMode.HALF_UP);
        
		double tentativeFinalGrade = classStandingFinal + longTestFinal + deliverableFinal + integratedAssmnt;
		rawFinalGrade = Double.parseDouble(df.format((tentativeFinalGrade * 0.5) + (rawPrelimGrade * 0.5)));
		return rawFinalGrade;
	}
	
	public double computeTransmutedFinalGrade() {
		DecimalFormat df = new DecimalFormat("##.#");
        df.setRoundingMode(RoundingMode.HALF_UP);
		
		transmutedFinalGrade = Double.parseDouble(df.format(0.625 * (rawFinalGrade-60) + 75));
		return transmutedFinalGrade;
	}
	
	public double gwaReturn(double transmutedFG) {
		if(transmutedFG>=0 && transmutedFG<75) {
			gwa = 5.00;
		}
		else if (transmutedFG>=75 && transmutedFG<79) {
			gwa = 3.00;
		}
		else if (transmutedFG>=79 && transmutedFG<82) {
			gwa = 2.75;
		}
		else if (transmutedFG>=82 && transmutedFG<84) {
			gwa = 2.50;
		}
		else if (transmutedFG>=84 && transmutedFG<87) {
			gwa = 2.25;
		}
		else if (transmutedFG>=87 && transmutedFG<89) {
			gwa = 2.00;
		}
		else if (transmutedFG>=89 && transmutedFG<92) {
			gwa = 1.75;
		}
		else if (transmutedFG>=92 && transmutedFG<94) {
			gwa = 1.50;
		}
		else if (transmutedFG>=94 && transmutedFG<96) {
			gwa = 1.25;
		}
		else if (transmutedFG>=96 && transmutedFG<=100) {
			gwa = 1.00;
		}
		return gwa;
	}
}
