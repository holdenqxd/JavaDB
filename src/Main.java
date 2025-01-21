import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        DB db = new DB();
        db.isConnection();

        db.createTable5("Participant", "id SERIAL PRIMARY KEY", " firstname VARCHAR(32) NOT NULL", "lastname VARCHAR(32) NOT NULL", " email VARCHAR(64) NOT NULL", "registered_at TIMESTAMP");
        db.createTable5("Sport", "id SERIAL PRIMARY KEY", "Competition_id int NOT NULL", " Cybersportname VARCHAR(128) NOT NULL", "sport_id int NOT NULL", "Participant_id int NOT NULL");
        db.createTable2("Location", "id SERIAL PRIMARY KEY", "locationname VARCHAR(255) NOT NULL");
        db.createTable4("Teams", "id SERIAL PRIMARY KEY", " Participant_id int NOT NULL", "teamname VARCHAR(255) NOT NULL UNIQUE", "quantity int NOT NULL CHECK (quantity>0)");
        db.createTable4("Competition", "id SERIAL PRIMARY KEY", "Location_id int NOT NULL", "Teams_id int NOT NULL", "Results_id int NOT NULL");

/*
        db.insertTable2("Location", "id", "locationname",
                "3", "'NikolAskoye'",
                "2", "'Kolpino'");

         db.insertTable5("Participant", "id", "firstname", "lastname", "email", "registered_at",
                "1", "'Jibrahil'", "'Mohradzhabov'", "'jibrahil@mail.ru'","'2023-10-27 15:00:00'",
                "2", "'Kornishon'", "'Pavlov'", "'kornishka@mail.ru'", "'2023-10-27 09:27:00'");

                db.insertTable5("Sport", "id", "Competition_id", "Cybersportname", "sport_id", "Participant_id",
                "1", "'1'", "'Dota'", "1", "1",
                "2", "'1'", "'DreamLeague'", "3", "2");

  db.insertTable4("Teams", "id", "Participant_id", "teamname", "quantity" ,
                "1", "1","'Spirit'", "1",
                "2", "2", "'Gladiators'" , "3");

db.insertTable4("Competition", "id", "Location_id", "Teams_id", "Results_id" ,
        "1", "1", "1", "1", "2", "2", "2", "2");







        db.update("Location", "locationname", "'Kolpino-City'", "'Kolpino'");





          db.del("Location", "3");



 */
        db.selectTable("Location");







    }
}