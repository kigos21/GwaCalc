package com.user;

import static java.lang.Math.*;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class IT2622 {
	
	private double classStandingPrelim, longTestPrelim, deliverablePrelim, examPrelim,
	rawPrelimGrade, transmutedPrelimGrade, 
	classStandingFinal, longTestFinal, deliverableFinal, integratedAssmnt,
	rawFinalGrade, transmutedFinalGrade;
	
	private double computeClassStandingPrelim(double attendance, double recitation, double FA) {
		classStandingPrelim = (attendance + recitation + FA)/3.0 * 0.1;
		return classStandingPrelim;
	}
	
	private double computeLongTestPrelim(double longTest) {
		longTestPrelim = (longTest/70.0 * 100) * 0.3;
		return longTestPrelim;
	}
	
	private double computeDeliverablePrelim(double wireframe, double storyboard, double prototype) {
		deliverablePrelim = (wireframe + storyboard + prototype)/3.0 * 0.3;
		return deliverablePrelim;
	}
	
	private double computeExamPrelim(double exam) {
		examPrelim = exam * 0.3;
		return examPrelim;
	}
	
	private double computeRawPrelimGrade() {
		rawPrelimGrade = (classStandingPrelim + longTestPrelim + deliverablePrelim + examPrelim);
		return rawPrelimGrade;
	}
	
	private double computeTransmutedPrelimGrade() {
		DecimalFormat df = new DecimalFormat("##.#");
        df.setRoundingMode(RoundingMode.CEILING);
		
		transmutedPrelimGrade = Double.parseDouble(df.format(0.625 * (rawPrelimGrade-60) + 75));
		return transmutedPrelimGrade;
	}
	
	
	// FINALS
	private double computeClassStandingFinal(double attendance, double recitation, double assigment) {
		classStandingFinal = (attendance + recitation + assigment)/3.0 * 0.1;
		return classStandingFinal;
	}
	
	private double computeLongTestFinal(double longTest) {
		longTestFinal = longTest * 0.3;
		return longTestFinal;
	}
	
	private double computeDeliverableFinal(double deliverable) {
		deliverableFinal = deliverable * 0.3;
		return deliverableFinal;
	}
	
	private double computeIntegratedAssmnt(double IA) {
		integratedAssmnt = IA * 0.3;
		return integratedAssmnt;
	}
	
	private double computeRawFinalGrade() {
		double tentativeFinalGrade = classStandingFinal + longTestFinal + deliverableFinal + integratedAssmnt;
		rawFinalGrade = (tentativeFinalGrade * 0.5) + (rawPrelimGrade * 0.5);
		return rawFinalGrade;
	}
	
	private double computeTransmutedFinalGrade() {
		DecimalFormat df = new DecimalFormat("##.#");
        df.setRoundingMode(RoundingMode.CEILING);
		
		transmutedFinalGrade = Double.parseDouble(df.format(0.625 * (rawFinalGrade-60) + 75));
		return transmutedFinalGrade;
	}
}
