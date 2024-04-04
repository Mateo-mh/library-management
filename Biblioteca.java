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

        //Boton añadir libro
        JButton btnAgregar = new JButton("Agregar");
        btnAgregar.addActionListener(this);
        btnAgregar.setFont(new Font("Arial", Font.BOLD, 16));
        btnAgregar.setBackground(new Color(138, 43, 226));
        btnAgregar.setForeground(new Color(255, 255, 255, 255));
        btnAgregar.setPreferredSize(new Dimension(200, 40));

        //Boton eliminar libro
        JButton btnEliminar = new JButton("Eliminar");
        btnEliminar.addActionListener(this);
        btnEliminar.setFont(new Font("Arial", Font.BOLD, 16));
        btnEliminar.setBackground(new Color(138, 43, 226));
        btnEliminar.setForeground(new Color(255, 255, 255, 255));
        btnEliminar.setPreferredSize(new Dimension(200, 40));

        //Boton buscar libro
        JButton btnBuscar = new JButton("Buscar");
        btnBuscar.addActionListener(this);
        btnBuscar.setFont(new Font("Arial", Font.BOLD, 16));
        btnBuscar.setBackground(new Color(138, 43, 226));
        btnBuscar.setForeground(new Color(255, 255, 255, 255));
        btnBuscar.setPreferredSize(new Dimension(200, 40));

        //Boton inventario
        JButton btnInventario = new JButton("Inventario");
        btnInventario.addActionListener(this);
        btnInventario.setFont(new Font("Arial", Font.BOLD, 16));
        btnInventario.setBackground(new Color(32, 83, 210));
        btnInventario.setForeground(new Color(255, 255, 255, 255));
        btnInventario.setPreferredSize(new Dimension(200, 40));
    }
}
