import networkx as nx
import tkinter as tk
from tkinter import simpledialog, filedialog, messagebox


class Grafo:
    def __init__(self):
        self.G = nx.Graph()
        self.root = tk.Tk()
        self.root.withdraw()

    def cargar(self):
        # Abrir el filedialog para que el usuario pueda seleccionar el archivo desde dentro de su memoria
        filename = filedialog.askopenfilename(filetypes=[("GraphML files", "*.graphml")])
        if filename:
            self.G = nx.read_graphml(filename)
            return True
        else:
            pass

    def camino_mas_corto(self):
        # Solicitar vértices de origen y destino al usuario
        origen = simpledialog.askstring("Origen", "Ingrese el vértice de origen: ")
        destino = simpledialog.askstring("Destino", "Ingrese el vértice de destino: ")

        if origen and destino:
            try:
                camino = nx.shortest_path(self.G, source=origen, target=destino)
                print(f"El camino más corto de {origen} a {destino} es: {camino}")
            except nx.NetworkXNoPath:
                print(f"No hay camino entre {origen} y {destino}")
            except nx.NodeNotFound as e:
                print(f"Error: {str(e)}")
        else:
            print("Debe ingresar ambos vértices")


# Crear una instancia de la clase Grafo y llamar a los métodos cargar y dibujar
if __name__ == '__main__':
    g = Grafo()
    if g.cargar():
        g.camino_mas_corto()
