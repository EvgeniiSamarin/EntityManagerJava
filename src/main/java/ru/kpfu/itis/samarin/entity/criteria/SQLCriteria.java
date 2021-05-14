package ru.kpfu.itis.samarin.entity.criteria;

import java.util.ArrayList;
import java.util.List;

public class SQLCriteria implements Criteria {
    private final StringBuilder SQL = new StringBuilder();
    private final List<Object> values = new ArrayList<>();

    public SQLCriteria() {
    }

    public Where and() {
        SQL.append(" AND ");
        return new SQLWhere(this);
    }

    public Where or() {
        SQL.append(" OR ");
        return new SQLWhere(this);
    }

    public String getQuery() {
        return " WHERE " + SQL;
    }

    public StringBuilder getSql() {
        return SQL;
    }

    public List<Object> getValues() {
        return values;
    }
}
