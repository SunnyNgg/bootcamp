package com.vtxlab.model;

import java.nio.file.Path;
import java.nio.file.Paths;

public class File1 {

public static void main(String[] args) {
  Path path = Paths.get("/home/ubuntu/data/this-file-does-bot-exist.txt");

  System.out.println(File1.exist(path));
}
  
  
  
}
