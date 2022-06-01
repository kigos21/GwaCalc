package com.user;

import static java.lang.Math.*;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class ICS2606 {
	private double labExerPrelims, longTestPrelims, examPrelims, 
	labExerFinals, longTestFinals, examFinals, 
	prelimGrade, transmutedPrelim, finalGrade, transmutedFinal,
	subjectGrade,gwa;
	
	public double labExerPrelims(int lab1, int lab2, int lab3) {
		labExerPrelims = (lab1 + lab2 + lab3)/3.0 * 0.3;
		return labExerPrelims;
	}
	
	public double longTestPrelims(int lt1, int lt2) {
		longTestPrelims = (lt1 + lt2) * 0.3;
		return longTestPrelims;
	}
	
	public double examPrelims(int examPrelims) {
		this.examPrelims = (examPrelims) * 0.4;
		return this.examPrelims;
	}
	
	public double labExerFinals(int lab4) {
		labExerFinals = (lab4) * 0.3;
		return labExerFinals;
	}
	
	public double longTestFinals(int lt3) {
		longTestFinals = ((lt3/50.0)*100) * 0.3;
		return longTestFinals;
	}
	
	public double examFinals(int examFinals) {
		this.examFinals = (examFinals) * 0.4;
		return this.examFinals;
	}
	
	public double prelimGrade() {
		DecimalFormat df = new DecimalFormat("##.##");
        df.setRoundingMode(RoundingMode.HALF_UP);
        
        prelimGrade = Double.parseDouble(df.format(labExerPrelims + longTestPrelims + examPrelims));
		return prelimGrade;
	}
	
	public double transmutedPrelim() {
		transmutedPrelim = round(25*(prelimGrade-60)/40.0+75);
		return transmutedPrelim;
	}
	
	public double finalGrade() {
		DecimalFormat df = new DecimalFormat("##.##");
        df.setRoundingMode(RoundingMode.HALF_UP);
        
        finalGrade = Double.parseDouble(df.format(labExerFinals + longTestFinals + examFinals));
		return finalGrade;
	}
	
	public double transmutedFinal() {
		transmutedFinal = round(25*(finalGrade-60)/40.0+75);
		return transmutedFinal;
	}
	
	public double subjectGrade() {
		double ave = (prelimGrade+finalGrade)/2.0;
		subjectGrade = round(25*(ave-60)/40.0+75);
		return subjectGrade;
	}
	
	public double gwa(double subjGrade) {
		if(subjGrade>=0 && subjGrade<75) {
			gwa = 5.00;
		}
		else if (subjGrade>=75 && subjGrade<79) {
			gwa = 3.00;
		}
		else if (subjGrade>=79 && subjGrade<82) {
			gwa = 2.75;
		}
		else if (subjGrade>=82 && subjGrade<84) {
			gwa = 2.50;
		}
		else if (subjGrade>=84 && subjGrade<87) {
			gwa = 2.25;
		}
		else if (subjGrade>=87 && subjGrade<89) {
			gwa = 2.00;
		}
		else if (subjGrade>=89 && subjGrade<92) {
			gwa = 1.75;
		}
		else if (subjGrade>=92 && subjGrade<94) {
			gwa = 1.50;
		}
		else if (subjGrade>=94 && subjGrade<96) {
			gwa = 1.25;
		}
		else if (subjGrade>=96 && subjGrade<=100) {
			gwa = 1.00;
		}
		return gwa;
	}

	public double getLabExerPrelims() {
		return labExerPrelims;
	}

	public double getLongTestPrelims() {
		return longTestPrelims;
	}

	public double getExamPrelims() {
		return examPrelims;
	}

	public double getLabExerFinals() {
		return labExerFinals;
	}

	public double getLongTestFinals() {
		return longTestFinals;
	}

	public double getExamFinals() {
		return examFinals;
	}

	public double getPrelimGrade() {
		return prelimGrade;
	}

	public double getTransmutedPrelim() {
		return transmutedPrelim;
	}

	public double getFinalGrade() {
		return finalGrade;
	}

	public double getTransmutedFinal() {
		return transmutedFinal;
	}

	public double getSubjectGrade() {
		return subjectGrade;
	}
	
}
