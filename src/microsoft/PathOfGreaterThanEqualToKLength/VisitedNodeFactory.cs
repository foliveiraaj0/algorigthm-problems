namespace Geekforgeeks.PathOfGreaterThanEqualToKLenght
{
    public class VisitedNodeFactory : INodeFactory<VisitedNode>
    {
        public VisitedNode create(int nID)
        {
            return new VisitedNode(nID);
        }
    }
}