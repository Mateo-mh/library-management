import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

public class Biblioteca extends JFrame implements ActionListener {
    private JTextField txtTitulo;
    private JTextField txtAutor;
    private JTextArea txtAreaResultado;
    private List<Libro> libros;

    public Biblioteca (){
        super("Biblioteca");
        libros = new ArrayList<>();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600,400);
        setLayout(new BorderLayout());
        setResizable(false);
        setLocationRelativeTo(null);
    }
}
