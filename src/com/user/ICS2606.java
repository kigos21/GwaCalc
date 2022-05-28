package com.user;

import static java.lang.Math.*;

public class ICS2606 {
	private double labExerPrelims, longTestPrelims, examPrelims, 
	labExerFinals, longTestFinals, examFinals, 
	prelimGrade, transmutedPrelim, finalGrade, transmutedFinal,
	subjectGrade;
	
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
		longTestFinals = (lt3)*.3;
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
}
