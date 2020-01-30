using System;
using System.Collections.Generic;

namespace Geekforgeeks.PathOfGreaterThanEqualToKLenght
{
    public class VisitedNode : Node
    {
        public HashSet<int> VisitedEdges;
        public int Ways;
        public VisitedNode(int id) : base(id)
        {
            VisitedEdges = new HashSet<int>();
        }

        public VisitedNode(Dictionary<int, int> edges, int id) : base(edges, id)
        {
            VisitedEdges = new HashSet<int>();
        }

    }
}