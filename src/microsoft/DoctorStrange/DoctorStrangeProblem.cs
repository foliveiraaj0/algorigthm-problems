using System;
using System.Collections;
using System.Collections.Generic;

namespace Geekforgeeks.DoctorStrange
{
    public class DoctorStrangeProblem : Problem
    {
        public override void Solution(string[] args)
        {
            var T = Int32.Parse((Console.ReadLine().Trim()));
            // Console.WriteLine("T is {0}", T);

            for (int i = 0; i < T; i++)
            {
                var configString = Console.ReadLine().Trim();

                var config = configString.Split(' ');

                var V = Int32.Parse(config[0]);
                // Console.WriteLine("V is {0}", V);

                var E = Int32.Parse(config[1]);
                // Console.WriteLine("E is {0}", E);

                var graph = new Dictionary<int, ParentNode>();

                var brokenNodes = 0;

                for (int j = 0; j < E; j++)
                {
                    var edgeString = Console.ReadLine().Trim();
                    var edge = edgeString.Split(' ');
                    var e1 = Int32.Parse(edge[0]);
                    var e2 = Int32.Parse(edge[1]);
                    ParentNode n1 = null;
                    ParentNode n2 = null;
                    if (!graph.ContainsKey(e1))
                    {
                        n1 = new ParentNode(e1);
                        graph.Add(e1, n1);
                    }
                    else
                    {
                        n1 = graph[e1];
                    }
                    if (!graph.ContainsKey(e2))
                    {
                        n2 = new ParentNode(e2);
                        graph.Add(e2, n2);
                    }
                    else
                    {
                        n2 = graph[e2];
                    }

                    n1.Edges.Add(e2, 0); // 0 is the weight
                    n2.Edges.Add(e1, 0); // 0 is the weight
                }

                var nodeList = new List<int>();
                nodeList.Add(graph[1].Id);

                while (nodeList.Count > 0)
                {
                    var node = graph[nodeList[0]];
                    nodeList.RemoveAt(0);

                    foreach (var child in node.Edges.Keys)
                    {
                        var childNode = graph[child];
                        if (!node.Parents.Contains(child))
                        {
                            childNode.Parents.Add(node.Id);
                            nodeList.Add(child);
                        }
                    }
                }

                if (graph.ContainsKey(V))
                {

                    // count doubled paths, index = nodeID, value = amount of total paths doubled
                    var doubledPaths = new Dictionary<int, int>();

                    // paths related to the next step
                    var paths = new Dictionary<int, List<int>>();

                    // next node to go, sorted by Order attribute
                    var nextStep = new List<int>();

                    nextStep.Add(V);
                    paths.Add(V, new List<int>());

                    while (nextStep.Count > 0)
                    {
                        var node = graph[nextStep[0]];
                        nextStep.RemoveAt(0);

                        //merge the paths to reduce the doubled paths
                        foreach (var path in paths[node.Id])
                        {
                            
                        }

                        foreach (var child in node.Parents)
                        {
                            if (node.Parents.Count > 1)
                            {
                                doubledPaths[child] = doubledPaths.ContainsKey(child) ? doubledPaths[child] = 1 : 1;
                            }

                            if (!nextStep.Contains(child))
                            {
                                nextStep.Add(child);
                                paths.Add(child, paths[node.Id]);
                            }
                            else {
                                //merge the paths to reduce doubled paths
                                var oldPath = paths[child];
                                foreach (var p in paths[node.Id])
                                {
                                    
                                }
                            }

                            

                            if (doubledPaths.Count == 0)
                            {
                                brokenNodes++;
                            }
                            nextStep.Sort((id1, id2) =>
                            {
                                var n1 = graph[id1].Order;
                                var n2 = graph[id2].Order;
                                return n2 - n1;
                            });
                        }
                    }
                    Console.WriteLine(brokenNodes);
                }
            }

        }
    }
}