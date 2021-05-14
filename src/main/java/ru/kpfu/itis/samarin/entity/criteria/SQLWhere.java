package ru.kpfu.itis.samarin.entity.criteria;

import java.util.Date;
import java.util.List;

public class SQLWhere implements Where{

    private final SQLCriteria criteria;

    public SQLWhere() {
        this.criteria = new SQLCriteria();
    }

    public SQLWhere(SQLCriteria criteria) {
        this.criteria = criteria;
    }

    @Override
    public Criteria equal(String column, Object value) {
        criteria.getSql().append(column).append(" = ? ");
        criteria.getValues().add(value);
        return criteria;
    }

    @Override
    public Criteria like(String column, String value) {
        criteria.getSql().append(column).append(" LIKE ? ");
        criteria.getValues().add(value);
        return criteria;
    }

    @Override
    public Criteria more(String column, int value) {
        criteria.getSql().append(column).append(" > ? ");
        criteria.getValues().add(value);
        return criteria;
    }

    @Override
    public Criteria less(String column, int value) {
        criteria.getSql().append(column).append(" < ? ");
        criteria.getValues().add(value);
        return criteria;
    }

    @Override
    public Criteria more(String column, double value) {
        criteria.getSql().append(column).append(" > ? ");
        criteria.getValues().add(value);
        return criteria;
    }

    @Override
    public Criteria less(String column, double value) {
        criteria.getSql().append(column).append(" < ? ");
        criteria.getValues().add(value);
        return criteria;
    }

    @Override
    public Criteria more(String column, Date value) {
        criteria.getSql().append(column).append(" > ? ");
        criteria.getValues().add(value);
        return criteria;
    }

    @Override
    public Criteria less(String column, Date value) {
        criteria.getSql().append(column).append(" < ? ");
        criteria.getValues().add(value);
        return criteria;
    }

    @Override
    public <T> Criteria in(String column, List<T> values) {
        criteria.getSql().append(column).append(" IN ").append(generateQ(values.size()));
        criteria.getValues().addAll(values);
        return criteria;
    }
    private String generateQ(int amount) {
        StringBuilder q = new StringBuilder("( ");
        q.append(" ?, ".repeat(Math.max(0, amount - 1)));
        q.append(" ? ) ");

        return q.toString();
    }
}
