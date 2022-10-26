package main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MethodeKnn {
	private static List<Pokemon> datas;
	private static int baseEggSteps;
	private static double captureRate;
	private static int experienceGrowth;
	private static double speed;
	private static List<Double> listeMin;
	
	public MethodeKnn(List<Pokemon> datas) {
		MethodeKnn.datas = datas;
		List<Double> listeMax = this.max(datas);
		List<Double> listeMin = this.min(datas);
		MethodeKnn.baseEggSteps = (int) (listeMax.get(0) - listeMin.get(0));
		MethodeKnn.captureRate = listeMax.get(1) - listeMin.get(1);
		MethodeKnn.experienceGrowth = (int) (listeMax.get(2) - listeMin.get(2));
		MethodeKnn.speed = listeMax.get(3) - listeMin.get(3);
	}
	
	
	public MethodeKnn(String fichier) throws IOException {
		MethodeKnn.datas = ChargementDonneesPokemon.charger(fichier);
		List<Double> listeMax = this.max(datas);
		MethodeKnn.listeMin = this.min(datas);
		MethodeKnn.baseEggSteps = (int) (listeMax.get(0) - listeMin.get(0));
		MethodeKnn.captureRate = listeMax.get(1) - listeMin.get(1);
		MethodeKnn.experienceGrowth = (int) (listeMax.get(2) - listeMin.get(2));
		MethodeKnn.speed = listeMax.get(3) - listeMin.get(3);
	}
	
	
	public List<Pokemon> plusProcheVoisin(int k, Pokemon p, Distance d) {
		List<Pokemon> res = new ArrayList<Pokemon>();
		List<Double> listDistance = new ArrayList<Double>();
		for(int i = 0; i < MethodeKnn.datas.size(); i ++) {
			listDistance.add(d.distance(p, MethodeKnn.datas.get(i)));
		}
		
		List<Double> listDistanceSorted = listDistance;
		Collections.sort(listDistanceSorted);
		
		for(int i =0; i < k; i ++) {
			double min = listDistanceSorted.get(i);
			int j = 0;
			while(min != listDistance.get(j)) {
				j ++;
			}
			res.add(MethodeKnn.datas.get(j));
		}
		
		return res;
	}
	
	
	

	
	public List<Double> max(List<Pokemon> datas) {
		List<Double> res = new ArrayList<Double>();
		int tempB  = MethodeKnn.datas.get(0).getBaseEggSteps();
		double tempC = MethodeKnn.datas.get(0).getCaptureRate();
		int tempE = MethodeKnn.datas.get(0).getExperienceGrowth();
		double tempS = MethodeKnn.datas.get(0).getSpeed();
		
		for(int i = 1; i < MethodeKnn.datas.size(); i ++) {
			if(Math.max(tempB, MethodeKnn.datas.get(i).getBaseEggSteps()) != tempB) {
				tempB =  MethodeKnn.datas.get(i).getBaseEggSteps();	
			}
			if(Math.max(tempC, MethodeKnn.datas.get(i).getCaptureRate()) != tempC) {
				tempC =  MethodeKnn.datas.get(i).getCaptureRate();	
			}
			if(Math.max(tempE, MethodeKnn.datas.get(i).getExperienceGrowth()) != tempE) {
				tempE =  MethodeKnn.datas.get(i).getExperienceGrowth();	
			}
			if(Math.max(tempS, MethodeKnn.datas.get(i).getSpeed()) != tempS) {
				tempS =  MethodeKnn.datas.get(i).getSpeed();	
			}
		}
		res.add((double) tempB);
		res.add(tempC);
		res.add((double) tempE);
		res.add(tempS);
		return res;
	}
	
	public List<Double> min(List<Pokemon> datas) {
		List<Double> res = new ArrayList<Double>();
		int tempB  = MethodeKnn.datas.get(0).getBaseEggSteps();
		double tempC = MethodeKnn.datas.get(0).getCaptureRate();
		int tempE = MethodeKnn.datas.get(0).getExperienceGrowth();
		double tempS = MethodeKnn.datas.get(0).getSpeed();
		
		for(int i = 1; i < MethodeKnn.datas.size(); i ++) {
			if(Math.min(tempB, MethodeKnn.datas.get(i).getBaseEggSteps()) != tempB) {
				tempB =  MethodeKnn.datas.get(i).getBaseEggSteps();	
			}
			if(Math.min(tempC, MethodeKnn.datas.get(i).getCaptureRate()) != tempC) {
				tempC =  MethodeKnn.datas.get(i).getCaptureRate();	
			}
			if(Math.min(tempE, MethodeKnn.datas.get(i).getExperienceGrowth()) != tempE) {
				tempE =  MethodeKnn.datas.get(i).getExperienceGrowth();	
			}
			if(Math.min(tempS, MethodeKnn.datas.get(i).getSpeed()) != tempS) {
				tempS =  MethodeKnn.datas.get(i).getSpeed();	
			}
		}
		res.add((double) tempB);
		res.add(tempC);
		res.add((double) tempE);
		res.add(tempS);

		return res;
	}


	public static List<Pokemon> getDatas() {
		return datas;
	}


	public static int getBaseEggSteps() {
		return baseEggSteps;
	}


	public static double getCaptureRate() {
		return captureRate;
	}


	public static int getExperienceGrowth() {
		return experienceGrowth;
	}


	public static double getSpeed() {
		return speed;
	}


	public static List<Double> getListeMin() {
		return listeMin;
	}
	
	
}
