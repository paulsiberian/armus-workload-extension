package com.github.paulsiberian.armus.workload.model.errandcard;

import java.util.List;
import java.util.Objects;

public class ECDiscipline {

    private String name;
    private String academicGroup;
    private int studentsCount;
    private List<Double> fallSemesterAmountHours;
    private List<Double> springSemesterAmountHours;

    public ECDiscipline() {
    }

    public ECDiscipline(String name, String academicGroup, int studentsCount) {
        this.name = name;
        this.academicGroup = academicGroup;
        this.studentsCount = studentsCount;
    }

    public ECDiscipline(String name, String academicGroup, int studentsCount, List<Double> fallSemesterAmountHours, List<Double> springSemesterAmountHours) {
        this(name, academicGroup, studentsCount);
        this.fallSemesterAmountHours = fallSemesterAmountHours;
        this.springSemesterAmountHours = springSemesterAmountHours;
    }

    public String getName() {
        return name;
    }

    public ECDiscipline setName(String name) {
        this.name = name;
        return this;
    }

    public String getAcademicGroup() {
        return academicGroup;
    }

    public ECDiscipline setAcademicGroup(String academicGroup) {
        this.academicGroup = academicGroup;
        return this;
    }

    public int getStudentsCount() {
        return studentsCount;
    }

    public ECDiscipline setStudentsCount(int studentsCount) {
        this.studentsCount = studentsCount;
        return this;
    }

    public List<Double> getFallSemesterAmountHours() {
        return fallSemesterAmountHours;
    }

    public ECDiscipline setFallSemesterAmountHours(List<Double> fallSemesterAmountHours) {
        this.fallSemesterAmountHours = fallSemesterAmountHours;
        return this;
    }

    public List<Double> getSpringSemesterAmountHours() {
        return springSemesterAmountHours;
    }

    public ECDiscipline setSpringSemesterAmountHours(List<Double> springSemesterAmountHours) {
        this.springSemesterAmountHours = springSemesterAmountHours;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ECDiscipline that = (ECDiscipline) o;
        return getStudentsCount() == that.getStudentsCount() &&
                Objects.equals(getName(), that.getName()) &&
                Objects.equals(getAcademicGroup(), that.getAcademicGroup()) &&
                Objects.equals(getFallSemesterAmountHours(), that.getFallSemesterAmountHours()) &&
                Objects.equals(getSpringSemesterAmountHours(), that.getSpringSemesterAmountHours());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAcademicGroup(), getStudentsCount(), getFallSemesterAmountHours(), getSpringSemesterAmountHours());
    }

    @Override
    public String toString() {
        return "ECDiscipline{" +
                "name='" + name + '\'' +
                ", academicGroup='" + academicGroup + '\'' +
                ", studentsCount=" + studentsCount +
                ", fallSemesterAmountHours=" + fallSemesterAmountHours +
                ", springSemesterAmountHours=" + springSemesterAmountHours +
                '}';
    }
}
