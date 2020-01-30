using System;
using System.Collections.Generic;

namespace Geekforgeeks
{
    public class Node
    {
        public Dictionary<int, int> Edges;

        public int Id;

        public Node(int id)
        {
            Edges = new Dictionary<int, int>();
            this.Id = id;
        }

        public Node(Dictionary<int, int> edges, int id)
        {
            Edges = edges;
            this.Id = id;
        }


        public static Dictionary<int, T> readNodes<T>(string description, INodeFactory<T> factory) where T : Node
        {
            var nodes = new Dictionary<int, T>();
            var split = description.Split(' ');

            for (int i = 0; i < split.Length; i += 3)
            {
                var id = Int32.Parse(split[i]);
                var n = nodes.ContainsKey(id) ? nodes[id] : factory.create(id);
                int edgeId = Int32.Parse(split[i + 1]);
                int edegeWeight = Int32.Parse(split[i + 2]);
                n.Edges.Add(edgeId, edegeWeight);

                if (!nodes.ContainsKey(id))
                {
                    nodes.Add(id, n);
                }

                if (nodes.ContainsKey(edgeId))
                {
                    var nEdge = nodes[edgeId];
                    if (!nEdge.Edges.ContainsKey(n.Id))
                    {
                        nEdge.Edges.Add(n.Id, edegeWeight);
                    }
                }
                else
                {
                    var nEdge = factory.create(edgeId);
                    nEdge.Edges.Add(n.Id, edegeWeight);
                    nodes.Add(edgeId, nEdge);
                }
            }
            return nodes;
        }

        // public Dictionary<int, T> readNodes<T>(Dictionary<int, Node> nodes, INodeConverter<T> converter) where T : Node
        // {
        //     var dict = new Dictionary<int, T>();
        //     foreach (var node in nodes.Values)
        //     {
        //         dict.Add(node.Id, converter.convert(node));
        //     }
        //     return dict;
        // }
    }
}