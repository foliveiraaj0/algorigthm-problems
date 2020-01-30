namespace Geekforgeeks.DoctorStrange
{
    public class ParentNodeFactory : INodeFactory<ParentNode>
    {
        public ParentNode create(int nID)
        {
            return new ParentNode(nID);
        }
    }
}