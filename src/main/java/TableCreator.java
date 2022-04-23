import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Locale;

public class TableCreator {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> employeeClass = Class.forName("Employee");
        DBTable dbTable = employeeClass.getAnnotation(DBTable.class);

        if(dbTable == null){
            System.out.println("Нет табличных аннотаций для класса "+employeeClass.getName());
        }
        else {
            String tableName = dbTable.name();
            String columnDef = "";
            StringBuilder createCommand = new StringBuilder("CREATE TABLE "+tableName+"(");
            for(Field field : employeeClass.getDeclaredFields()){
                String columnName = null;
                Annotation[] annotations = field.getDeclaredAnnotations();
                if(annotations.length<1){ System.out.println("Поле не столбец базы данных");}
                else{
                    if(annotations[0] instanceof ColumnInteger) {
                        ColumnInteger columnInteger = (ColumnInteger) annotations[0];
                        if (columnInteger.name().length() < 1)
                            columnName = field.getName().toUpperCase();
                        else
                            columnName = columnInteger.name();
                        columnDef = columnName + " INT" + getConstrains(columnInteger.constraints());
                    } else if (annotations[0] instanceof ColumnString){
                        ColumnString columnString = (ColumnString) annotations[0];
                        if (columnString.name().length() < 1)
                            columnName = field.getName().toUpperCase();
                        else
                            columnName = columnString.name();
                        columnDef = columnName+" VARCHAR("+columnString.value()+")"+getConstrains(columnString.constraints());

                    }
                    createCommand.append("\n    ").append(columnDef).append(", ");
                }
            }
            String tableCreate = createCommand.substring(0,createCommand.length()-2)+");";
            System.out.println(tableCreate);
            runCommandInDB(tableCreate);
        }
    }

    private static String getConstrains(Constraints con){
        String constraints = "";
        if(con.notNull())
            constraints += " NOT NULL";
        if(con.primaryKey())
            constraints += " PRIMARY KEY";
        if(con.unique())
            constraints += " UNIQUE";

        return constraints;
    }

    private static void runCommandInDB(String command){
        try{
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection( "jdbc:postgresql://localhost:5432/test","postgres", "denchik2702" );
            con.prepareCall(command).execute();
            con.close();
        } catch(SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
