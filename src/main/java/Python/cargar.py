import networkx as nx
import matplotlib.pyplot as plt
import tkinter as tk
from tkinter import simpledialog, filedialog, messagebox


class Grafo:
    def __init__(self):
        self.G = nx.Graph()
        self.root = tk.Tk()
        self.root.withdraw()


    def cargar(self):
        # Aqui abró el filedialog para que el usuario pueda seleccionar el archivo desde dentro de su memoria
        filename = filedialog.askopenfilename(filetypes=[("GraphML files", "*.graphml")])
        if filename:
            self.G = nx.read_graphml(filename)
            return True
        else:
            pass


# Aqui se crea una instancia de la clase Grafo y se llama a los metodos cargar y dibujar
if __name__ == '__main__':
    g = Grafo()
    if g.cargar():
        matriz = nx.adjacency_matrix(g.G)
        print(matriz.todense())