import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReadData {
    public List<Plant> selectAll() {

        List<Plant> plantList = new ArrayList<>();
        String sql = "SELECT name, description FROM " + Constants.TABLE_NAME;

        try (Statement stmt = DbConn.connect().createStatement()) {
            try (ResultSet rs = stmt.executeQuery(sql)) {
                while (rs.next()) {
                    plantList.add(new Plant(
                                    rs.getString("name"),
                                    rs.getString("description")
                            )
                    );
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return Collections.emptyList();
        }
        return plantList;
    }
}
