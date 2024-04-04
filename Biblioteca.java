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

        //Panel formulario para agregar libros
        JPanel formulario = new JPanel(new GridLayout(2, 2, 10, 10));
        formulario.setBorder(BorderFactory.createEmptyBorder(20, 20, 10, 20));

        JLabel lblTitulo = new JLabel("Titulo: ");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 16));
        txtTitulo = new JTextField();
        txtTitulo.setFont(new Font("Arial", Font.PLAIN, 16));

        JLabel lblAutor = new JLabel("Autor: ");
        lblAutor.setFont(new Font("Arial", Font.BOLD, 16));
        txtAutor = new JTextField();
        txtAutor.setFont(new Font("Arial", Font.PLAIN, 16));

        formulario.add(lblTitulo);
        formulario.add(txtTitulo);
        formulario.add(lblAutor);
        formulario.add(txtAutor);
    }
}
