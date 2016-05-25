public interface IWeightedGraph 
{
    int getWeight(int v1, int v2);
    void addEdge(int v1, int v2, int weight);
}