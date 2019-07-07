/*
 * Copyright (c) Храпунов П. Н., 2019.
 */

package io.github.paulsiberian.armus.workload.model.errandcard;

import java.util.Objects;

public class ECDiscipline {

    private String name;
    private String academicGroup;
    private int studentsCount;
    private double[] fallSemesterAmountHours;
    private double[] springSemesterAmountHours;

    public ECDiscipline() {
    }

    public ECDiscipline(String name, String academicGroup, int studentsCount) {
        this.name = name;
        this.academicGroup = academicGroup;
        this.studentsCount = studentsCount;
    }

    public ECDiscipline(String name, String academicGroup, int studentsCount, double[] fallSemesterAmountHours, double[] springSemesterAmountHours) {
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

    public double[] getFallSemesterAmountHours() {
        return fallSemesterAmountHours;
    }

    public ECDiscipline setFallSemesterAmountHours(double[] fallSemesterAmountHours) {
        this.fallSemesterAmountHours = fallSemesterAmountHours;
        return this;
    }

    public double[] getSpringSemesterAmountHours() {
        return springSemesterAmountHours;
    }

    public ECDiscipline setSpringSemesterAmountHours(double[] springSemesterAmountHours) {
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
