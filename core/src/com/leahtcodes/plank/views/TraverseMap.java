package com.leahtcodes.plank.views;
import org.jgrapht.Graph;
import org.jgrapht.GraphType;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;
import org.jgrapht.nio.*;
import org.jgrapht.nio.graphml.GraphMLEventDrivenImporter;
import org.jgrapht.nio.graphml.GraphMLImporter;
import org.jgrapht.nio.graphml.GraphMLImporter;
import org.jgrapht.nio.graphml.GraphMLImporter.*;
import java.io.*;
import java.io.File;
import java.io.FileReader;
import java.nio.file.Path;
import java.util.Collection;
import java.util.Set;
import java.util.function.Supplier;
import java.nio.file.Files;


public class TraverseMap {
    private GraphMLImporter importer;
    private Graph<String, DefaultEdge> graph;
    public TraverseMap(){
        importer = new GraphMLImporter();
        graph = new SimpleGraph<>(DefaultEdge.class);
//        Path path = Path.of("c:\\dev\\licenses\\windows\\readme.txt");
        //Current path of graphml C:\Users\v\IdeaProjects\VisualNovel4\assets\dialogueNodes.graphml
        String fileName = "dialogueNodes1.graphml";
        File file = new File(fileName);
        try (FileReader fileReader = new FileReader(file)) {
            importer.importGraph(graph, fileReader);
            System.out.println(graph.toString());
        }
        catch (IOException | ImportException e) { e.printStackTrace(); }



    }
//        java.io.Reader file = new FileReader("dialogueNodes1.graphml");
//        importer.importGraph(graph, file);







}
