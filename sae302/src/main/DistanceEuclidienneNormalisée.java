package main;

public class DistanceEuclidienneNormalisée implements Distance{

	@Override
	public double distance(Pokemon p1, Pokemon p2) {
		return Math.sqrt(Math.pow(((p1.getCaptureRate() - MethodeKnn.getListeMin().get(0)) / MethodeKnn.getCaptureRate()) - ((p2.getCaptureRate() - MethodeKnn.getListeMin().get(0)) / MethodeKnn.getCaptureRate()) , 2) +
			  Math.pow(((p1.getBaseEggSteps() - MethodeKnn.getListeMin().get(1)) / MethodeKnn.getBaseEggSteps()) - ((p2.getBaseEggSteps() - MethodeKnn.getListeMin().get(1)) / MethodeKnn.getBaseEggSteps()) , 2) +
			  Math.pow(((p1.getExperienceGrowth() - MethodeKnn.getListeMin().get(2)) / MethodeKnn.getExperienceGrowth()) - ((p2.getExperienceGrowth() - MethodeKnn.getListeMin().get(2)) / MethodeKnn.getExperienceGrowth()), 2) +
			  Math.pow(((p1.getSpeed() - MethodeKnn.getListeMin().get(3)) / MethodeKnn.getSpeed()) - ((p2.getSpeed() - MethodeKnn.getListeMin().get(3)) / MethodeKnn.getSpeed()), 2));
		}

}
