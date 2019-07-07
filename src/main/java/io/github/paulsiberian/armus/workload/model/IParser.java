/*
 * Copyright (c) Храпунов П. Н., 2019.
 */

package io.github.paulsiberian.armus.workload.model;

public interface IParser {
    void parse();
    void parse(String path);
    void close();
}
