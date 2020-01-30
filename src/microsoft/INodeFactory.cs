namespace Geekforgeeks
{
    public interface INodeFactory<T> where T : Node
    {
        T create(int nID);
    }
}