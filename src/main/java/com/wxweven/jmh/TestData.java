package com.wxweven.jmh;

import java.util.Objects;

/**
 * @author wxweven
 */
public class TestData {
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public TestData setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public TestData setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TestData testData = (TestData) o;
        return id == testData.id &&
                Objects.equals(name, testData.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}