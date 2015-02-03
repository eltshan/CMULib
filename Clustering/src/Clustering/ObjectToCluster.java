package src.Clustering;

import src.Index.Cluster;
import src.Index.ClusteringMatrix;

import java.util.List;
import java.util.Map;

/**
 * Created by amaliujia on 15-2-1.
 */
public abstract class ObjectToCluster {
    protected Map<Integer, Double> linkage;

    public abstract void updateLinkage(ClusteringMatrix matrix, List<Cluster> clusters);

    public Map<Integer, Double>  getWeights(){
        return linkage;
    }

    public double getWeight(int i){
        return linkage.get(i);
    }
}
