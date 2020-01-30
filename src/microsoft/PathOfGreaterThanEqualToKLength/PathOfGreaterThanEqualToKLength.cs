using System;
using System.Collections.Generic;

namespace Geekforgeeks.PathOfGreaterThanEqualToKLenght
{
    public class PathOfGreaterThanEqualToKLengthProblem : Problem
    {
        public override void Solution(string[] args)
        {
            var T = Int32.Parse((Console.ReadLine().Trim()));
            // Console.WriteLine("T is {0}", T);

            for (int i = 0; i < T; i++)
            {
                var graphString = Console.ReadLine().Trim();

                var graph = graphString.Split(' ');

                var V = Int32.Parse(graph[0]);
                // Console.WriteLine("V is {0}", V);

                var E = Int32.Parse(graph[1]);
                // Console.WriteLine("E is {0}", E);

                var minSum = Int32.Parse(graph[2]);
                // Console.WriteLine("mininum is {0}", minSum);

                var factory = new VisitedNodeFactory();

                var nodes = Node.readNodes<VisitedNode>(Console.ReadLine().Trim(), factory);

                var acc = 0;
                var stack = new Stack<VisitedNode>();
                stack.Push(nodes[0]);
                var path = new HashSet<int>();
                var pathString = "";
                path.Add(0);
                pathString = "0";

                while (stack.Count > 0 && acc < minSum)
                {
                    var n = stack.Peek();
                    var added = false;
                    foreach (int nodeId in n.Edges.Keys)
                    {
                        var edge = nodes[nodeId];
                        var newPath = pathString + edge.Id;
                        if (!path.Contains(edge.Id) && !n.VisitedEdges.Contains(newPath.GetHashCode()))
                        {
                            path.Add(nodeId);
                            pathString += nodeId;
                            stack.Push(edge);
                            added = true;
                            n.VisitedEdges.Add(newPath.GetHashCode());
                            acc += n.Edges[edge.Id];
                            // Console.WriteLine("adding {0} to path and {1} to acc which now is {2}", nodeId, n.Edges[edge.Id], acc);
                            break;
                        }
                        else
                        {
                            // Console.WriteLine("not adding {0} to path because it is invalid, acc now is {1}", nodeId, acc);
                        }

                    }
                    if (!added)
                    {
                        n = stack.Pop();
                        if (n.Id != 0)
                        {
                            var prevNode = stack.Peek();
                            acc -= prevNode.Edges[n.Id];
                            path.Remove(n.Id);
                            pathString = pathString.Substring(0, pathString.Length - 1);
                            // Console.WriteLine("removing {0} because there is nowhere to go, acc now is {1}", n.Id, acc);
                        }
                    }
                }
                // Console.WriteLine("acc is {0}", acc);
                Console.WriteLine(acc > 0 ? 1 : 0);
            }
        }

    }

}
