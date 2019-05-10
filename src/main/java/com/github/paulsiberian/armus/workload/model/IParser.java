package com.github.paulsiberian.armus.workload.model;

public interface IParser {
    void parse();
    void parse(String path);
    void close();
}
