public interface IMap <K, V>
{
	public V get(Object key);
	public V put(K key, V value);
	public V remove(Object key);
	public int size();
	public boolean isEmpty();
}