package Trainticketgenerate;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Traininsertion {
    public static Train findTrain(int train) {
        Train tr = null;
       DBConnection db = new DBConnection();
        try {

            Connection connection = db.getConnection();
            //database connection
            String query = "select * from Train where Train_number = ?";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1, train);

            ResultSet rs =stmt.executeQuery();

            while(rs.next()) {
                int Train_number= rs.getInt("Train_number");
                String Train_name = rs.getString("Train_name");
                String Source = rs.getString("Source");
                String Destination = rs.getString("Destination");
                int Ticket_price = rs.getInt("Ticket_price");

                tr = new Train(Train_number,Train_name,Source,Destination,Ticket_price);
                return tr;

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tr;
    }

}
