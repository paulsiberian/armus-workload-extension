package io.github.paulsiberian.armus.workload.model;

import java.util.List;

public class WLSheet {

    private String title;
    private List<WLDiscipline> disciplines;

    public WLSheet() {
    }

    public WLSheet(String title) {
        this.title = title;
    }

    public WLSheet(String title, List<WLDiscipline> disciplines) {
        this.title = title;
        this.disciplines = disciplines;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<WLDiscipline> getDisciplines() {
        return disciplines;
    }

    public void setDisciplines(List<WLDiscipline> disciplines) {
        this.disciplines = disciplines;
    }

    @Override
    public String toString() {
        return "WLSheet{" +
                "title='" + title + '\'' +
                '}';
    }
}
