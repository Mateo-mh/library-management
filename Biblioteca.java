import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Biblioteca extends JFrame implements ActionListener {
    private JTextField txtTitulo;
    private JTextField txtAutor;
    private JTextArea txtAreaResultado;
    private List<Libro> libros;

    public Biblioteca() {
        super("Biblioteca");
        libros = new ArrayList<>();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
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

        formulario.add(btnAgregar);
        formulario.add(btnEliminar);
        formulario.add(btnBuscar);
        formulario.add(btnInventario);

        //Area de resultados
        txtAreaResultado = new JTextArea();
        txtAreaResultado.setEditable(false);
        txtAreaResultado.setFont(new Font("Arial", Font.PLAIN, 16));
        txtAreaResultado.setLineWrap(true);
        txtAreaResultado.setWrapStyleWord(true);
        txtAreaResultado.setBackground(new Color(144, 172, 246));
        txtAreaResultado.setBorder(BorderFactory.createLineBorder(Color.lightGray));
        JScrollPane scrollPane = new JScrollPane(txtAreaResultado);
        scrollPane.setPreferredSize(new Dimension(560, 200));

        //Panel principal
        JPanel panelPrincipal = new JPanel(new BorderLayout());
        panelPrincipal.add(formulario, BorderLayout.NORTH);
        panelPrincipal.add(scrollPane, BorderLayout.SOUTH);
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(panelPrincipal);
        setVisible(true);
    }

    //Aqui se empieza a manejar la logica
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Agregar")) {
            String titulo = txtTitulo.getText();
            String autor = txtAutor.getText();
            if (!titulo.isEmpty() && !autor.isEmpty()) {
                agregarLibro(titulo, autor);
                txtTitulo.setText("");
                txtAutor.setText("");
                txtAreaResultado.setText("El libro ha sido añadido correctamente a la biblioteca");
            } else {
                txtAreaResultado.setText("Por favor introduce el título y el autor del libro");
            }
        } else if (e.getActionCommand().equals("Eliminar")) {
            String titulo = txtTitulo.getText();
            eliminarLibro(titulo);
            txtTitulo.setText("");
            txtAutor.setText("");
            txtAreaResultado.setText("El libro ha sido eliminado correctamente");
        } else if (e.getActionCommand().equals("Buscar")) {
            String terminoBusqueda = txtTitulo.getText();
            String tipoBusqueda = "titulo";
            if (!terminoBusqueda.isEmpty()) {
                List<String> resultados = buscarLibro(terminoBusqueda, tipoBusqueda);
                txtAreaResultado.setText("");
                if (resultados.isEmpty()) {
                    txtAreaResultado.setText("No se encontraron libros con este titulo " + terminoBusqueda + ".");
                } else {
                    for (String resultado : resultados) {
                        txtAreaResultado.append(resultado + "\n");
                    }
                }
            } else {
                txtAreaResultado.setText("Por favor introduce un termino de busqueda");
            }
            txtTitulo.setText("");
            txtAutor.setText("");
        }else if(e.getActionCommand().equals("Inventario")){
            txtAreaResultado.setText("");
            List<String> inventario = getInventario();
            if (inventario.isEmpty()){
                txtAreaResultado.setText("No se encontraron libros en el inventario");
            }else {
                for(String libro : inventario){
                    txtAreaResultado.append(libro + "\n");
                }
            }
            txtTitulo.setText("");
            txtAutor.setText("");
        }
    }

    public void agregarLibro(String titulo, String autor) {
        Libro newLibro = new Libro(titulo, autor);
        libros.add(newLibro);
    }

    public void eliminarLibro(String titulo){
        for (int i = 0; i < libros.size(); i++){
            Libro libro = libros.get(i);
            if(libro.getTitulo().equalsIgnoreCase(titulo)){
                libros.remove(i);
                break;
            }
        }
    }

    public List<String> buscarLibro(String terminoBusqueda, String tipoBusqueda){
        List<String> results = new ArrayList<>();
        for (Libro libro: libros){
            if (tipoBusqueda.equalsIgnoreCase("titulo")){
                if (libro.getTitulo().equalsIgnoreCase(terminoBusqueda)){
                    results.add(libro.toString());
                }
            } else if (tipoBusqueda.equalsIgnoreCase("autor")) {
                if (libro.getAutor().equalsIgnoreCase(terminoBusqueda)){
                    results.add(libro.toString());
                }
            }
        }
        return results;
    }

    public List<String> getInventario(){
        List<String> inventario = new ArrayList<>();
        for (Libro libro: libros){
            inventario.add(libro.toString());
        }
        return inventario;
    }

    public static void main(String[] args){
        SwingUtilities.invokeLater(() ->{
            try{
                UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
            } catch (IllegalAccessException ex){
                ex.printStackTrace();
            } catch (ClassNotFoundException ex){
                Logger.getLogger(Biblioteca.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InstantiationException ex){
                Logger.getLogger(Biblioteca.class.getName()).log(Level.SEVERE, null, ex);
            } catch (UnsupportedLookAndFeelException ex){
                Logger.getLogger(Biblioteca.class.getName()).log(Level.SEVERE, null, ex);
            }
            new Biblioteca();
        });
    }
}
