
package helper;


import java.lang.reflect.Field;
import java.util.ArrayList;

/**
 *
 * @author asus
 */
public class QueryBuilder {

    ArrayList<Conditional> conditionals;
    String skippedColumn;
    Object dataObject;

    public void clearAllConditions() {
        conditionals.clear();
    }

    public QueryBuilder() {
        conditionals = new ArrayList<Conditional>();
    }

    public void setSkippedColumn(String name) {
        skippedColumn = name;
    }

    public String getSkippedColumn() {
        return skippedColumn;
    }

    public static enum Mode {
        INSERT,
        UPDATE,
        DELETE,
        SELECT_ALL,
        SELECT_SPECIFIC
    }

    public void addConditional(Conditional con) {
        conditionals.add(con);
    }

    public String getValueSafe(String val) {
        String data = null;
        try {

            Integer v = Integer.parseInt(val);
            return v.toString();
        } catch (Exception e) {
            data = "'" + val + "'";
        }

        return data;
    }

    private String getConditionalQuery() {
        StringBuilder stb = new StringBuilder();

        for (int i = 0; i < conditionals.size(); i++) {
            Conditional condt = conditionals.get(i);
            if (condt != null) {

                stb.append(condt.getColumn());
                if (!condt.isAlike()) {
                    stb.append("=");
                    stb.append(getValueSafe(condt.getValue()));
                }else{
                    stb.append(" LIKE ");
                    stb.append(getValueSafe("%" + condt.getValue() + "%"));
                }
                
                if (i < conditionals.size() - 1) {
                    stb.append(" AND ");
                }

            }
        }

        return stb.toString();
    }

    public String getConditional() {
        return "WHERE " + getConditionalQuery();
    }

    public String generate(Mode ops, String table_name, Class ob) {
        String query = null;

        if (ops == Mode.INSERT) {
            query = "INSERT INTO " + table_name + getColumnAndValues_forInsert(ob);
        } else if (ops == Mode.UPDATE) {
            query = "UPDATE " + table_name + " " + getColumn_forUpdate(ob) + " " + getConditional();
        } else if (ops == Mode.DELETE) {
            query = "DELETE FROM " + table_name + " " + getConditional();
        } else if (ops == Mode.SELECT_ALL) {
            query = "SELECT * FROM " + table_name;
        } else if (ops == Mode.SELECT_SPECIFIC) {
            query = "SELECT * FROM " + table_name + " " + getConditional();
        }

        return query;
    }

    private String getColumn_forUpdate(Class ob) {
        String result = null;
        StringBuilder stb = new StringBuilder();
        // final output is:
        // column='value'

        Class yourClass = ob;

        stb.append("SET ");
        Field[] fields = yourClass.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {

            if (!skippedColumn.equalsIgnoreCase(fields[i].getName())) {

                stb.append(fields[i].getName());
                stb.append("=?");

                if (i < fields.length - 1) {
                    stb.append(",");
                }
            }

        }

        result = stb.toString();

        return result;
    }

    private String getColumnAndValues_forInsert(Class ob) {
        String result = null;
        StringBuilder stb = new StringBuilder();
        // final output is:
        // (column, col) VALUES (?,?)

        Class yourClass = ob;

        stb.append("(");
        Field[] fields = yourClass.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            stb.append(fields[i].getName());
            if (i < fields.length - 1) {
                stb.append(",");
            }
        }

        stb.append(")");
        stb.append("VALUES (");
        for (int i = 0; i < fields.length; i++) {
            stb.append("?");
            if (i < fields.length - 1) {
                stb.append(",");
            }
        }

        stb.append(")");
        result = stb.toString();

        return result;
    }
}

