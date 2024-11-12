import networkx as nx
import matplotlib.pyplot as plt

# Function to visualize the graph and highlight the shortest path
def draw_graph_with_shortest_path(graph, pos, shortest_path):
    plt.figure(figsize=(8, 6))

    # Draw all nodes and edges
    nx.draw(graph, pos, with_labels=True, node_color='skyblue', node_size=700, edge_color='gray', font_size=10, font_weight='bold')
    
    # Highlight the shortest path in red
    if shortest_path:
        path_edges = list(zip(shortest_path, shortest_path[1:]))
        nx.draw_networkx_edges(graph, pos, edgelist=path_edges, edge_color='red', width=3)
        nx.draw_networkx_nodes(graph, pos, nodelist=shortest_path, node_color='lightgreen')

    plt.show()

# Function to create a graph based on user input
def create_user_defined_graph():
    G = nx.Graph()

    # Ask the user how many edges they want to input
    num_edges = int(input("Enter the number of edges in the graph: "))

    # Collect edge data from the user
    for i in range(num_edges):
        print(f"Edge {i+1}:")
        u = input("  Enter source node: ").upper()
        v = input("  Enter destination node: ").upper()
        w = float(input("  Enter weight of the edge: "))
        G.add_edge(u, v, weight=w)
    
    return G

# Main function to get user input and show shortest path
def main():
    G = create_user_defined_graph()

    # Get positions for plotting the graph
    pos = nx.spring_layout(G)

    # Take source and destination input from the user
    source = input("Enter the source node: ").upper()
    target = input("Enter the destination node: ").upper()

    try:
        # Find shortest path using Dijkstra's algorithm
        shortest_path = nx.dijkstra_path(G, source, target)
        print(f"Shortest path from {source} to {target}: {shortest_path}")

        # Visualize the graph and highlight the shortest path
        draw_graph_with_shortest_path(G, pos, shortest_path)

    except nx.NetworkXNoPath:
        print(f"No path exists between {source} and {target}.")
    except nx.NodeNotFound:
        print("One or both of the nodes do not exist in the graph.")

if __name__ == "__main__":
    main()
