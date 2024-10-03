package springNotes;

import java.util.Scanner;

public class NoteController {
    private NoteDAO noteDAO = new NoteDAO();
    private Scanner sc = new Scanner(System.in);




    public void showMenu(){
        while(true){
        noteDAO.showText("(1)создать заметку");
        noteDAO.showText("(2)найти заметку");
        noteDAO.showText("(3)удалить заметку");
        String input = sc.nextLine();
        switch (input){
            case "1" :
                noteDAO.createNote();
                break;
            case "2" :
                noteDAO.searchNote();
                break;
            case "3":
                noteDAO.removeNote();
                break;
        }
    }
    }
}
