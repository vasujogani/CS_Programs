public interface ISet<E>
{
    public boolean add(E obj);
    public boolean contains(E obj);
    public boolean remove(Object obj);
    public int size();
    public boolean isEmpty();
}