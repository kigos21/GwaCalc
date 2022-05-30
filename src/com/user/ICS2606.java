package com.user;

import static java.lang.Math.*;

public class ICS2606 {
	private double labExerPrelims, longTestPrelims, examPrelims, 
	labExerFinals, longTestFinals, examFinals, 
	prelimGrade, transmutedPrelim, finalGrade, transmutedFinal,
	subjectGrade,gwa;
	
	public double labExerPrelims(int lab1, int lab2, int lab3) {
		labExerPrelims = (lab1 + lab2 + lab3)/3*.3;
		return labExerPrelims;
	}
	
	public double longTestPrelims(int lt1, int lt2) {
		longTestPrelims = (lt1 + lt2)*.3;
		return longTestPrelims;
	}
	
	public double examPrelims(int examPrelims) {
		this.examPrelims = (examPrelims)*.4;
		return this.examPrelims;
	}
	
	public double labExerFinals(int lab4) {
		labExerFinals = (lab4)*.3;
		return labExerFinals;
	}
	
	public double longTestFinals(int lt3) {
		longTestFinals = (lt3/50*100)*.3;
		return longTestFinals;
	}
	
	public double examFinals(int examFinals) {
		this.examFinals = (examFinals)*.4;
		return this.examFinals;
	}
	
	public double prelimGrade() {
		prelimGrade = labExerPrelims + longTestPrelims + examPrelims;
		return prelimGrade;
	}
	
	public double transmutedPrelim() {
		transmutedPrelim = round(25*(prelimGrade-60)/40+75);
		return transmutedPrelim;
	}
	
	public double finalGrade() {
		finalGrade = labExerFinals + longTestFinals + examFinals;
		return finalGrade;
	}
	
	public double transmutedFinal() {
		transmutedFinal = round(25*(finalGrade-60)/40+75);
		return transmutedFinal;
	}
	
	public double subjectGrade() {
		double ave = (prelimGrade+finalGrade)/2;
		subjectGrade = round(25*(ave-60)/40+75);
		return subjectGrade;
	}
	
	public double gwa(double subjGrade) {
		if(subjGrade==0) {
			gwa = 5.00;
		}
		else if (subjGrade>=75 && subjGrade<=78) {
			gwa = 3.00;
		}
		else if (subjGrade>=79 && subjGrade<=81) {
			gwa = 2.75;
		}
		else if (subjGrade>=82 && subjGrade<=83) {
			gwa = 2.50;
		}
		else if (subjGrade>=84 && subjGrade<=86) {
			gwa = 2.25;
		}
		else if (subjGrade>=87 && subjGrade<=88) {
			gwa = 2.00;
		}
		else if (subjGrade>=89 && subjGrade<=91) {
			gwa = 1.75;
		}
		else if (subjGrade>=92 && subjGrade<=93) {
			gwa = 1.50;
		}
		else if (subjGrade>=94 && subjGrade<=95) {
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
