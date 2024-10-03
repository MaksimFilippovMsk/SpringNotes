package springNotes;

import java.sql.*;
import java.util.HashMap;
import java.util.Scanner;

public class NoteDAO {
   private  HashMap<String, String> notes= new HashMap<>();
   private Scanner sc = new Scanner(System.in);

   private Connection conn;     // провод к базе данных


   public NoteDAO() {

       try {
           String url = "jdbc:mysql://localhost:3306/notes";
           String username = "root";
           String password = "root";
           Class.forName("com.mysql.cj.jdbc.Driver");
          conn = DriverManager.getConnection(url, username, password);

               System.out.println("Connection to Store DB succesfull!");

       } catch (SQLException ex) {
           System.out.println("Connection failed...");

           System.out.println(ex);
       } catch (ClassNotFoundException e) {
           throw new RuntimeException(e);
       }
   }


    public void createNote(){
        showText("Введи название заметки:");
        String name = sc.nextLine();
        showText("Введи заметку: ");
        String note = sc.nextLine();

        String query = "INSERT INTO notes VALUES('" + name + "','" +  note + "');";

        System.out.println(query);

        try {
            PreparedStatement ps =  conn.prepareStatement(query);
           ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        showText("Заметка успешно создана");
    }

    public void searchNote(){
        try {
            showText("Введи название заметки: ");
            String noteName = sc.nextLine();

//           PreparedStatement ps = conn.prepareStatement("SELECT * FROM notes;");
//            ResultSet rs = ps.executeQuery();
//
//            while (rs.next()){
//                if (rs.getString(1).equals(noteName)) {
//                    System.out.println(rs.getString(2));
//                    break;
//                }
//            }

            //  description
            //  bvnnmx

            PreparedStatement ps = conn.prepareStatement("SELECT description FROM notes WHERE name = '" + noteName + "';");
            ResultSet rs = ps.executeQuery();      // resultSet это таблица
            rs.next();
            System.out.println(rs.getString("description"));

//            while (rs.next()) {
//                System.out.print(rs.getString(1) + " ");
//                System.out.println(rs.getString(2));
//            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
//
//        if(notes.containsKey(input)){
//            System.out.println(notes.get(input));
//        }else{
//            System.out.println("Такой записи нет ");
//        }
        }


    public void removeNote(){
        showText("Введи название заметки: ");
        notes.remove(sc.nextLine());
        showText("Заметка удалена");
    }

    public void showText(String text){
        System.out.println(text);
    }

}


