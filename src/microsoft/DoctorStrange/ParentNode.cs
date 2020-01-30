using System;
using System.Collections.Generic;

namespace Geekforgeeks.DoctorStrange
{
    public class ParentNode : Node
    {
        public HashSet<int> Parents;
        public int Order;

        public ParentNode(int id) : base(id)
        {
            Parents = new HashSet<int>();
        }

        public ParentNode(Dictionary<int, int> edges, int id) : base(edges, id)
        {
            Parents = new HashSet<int>();
        }
    }
}