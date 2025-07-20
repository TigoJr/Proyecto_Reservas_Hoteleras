/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.utp.estilo;

/**
 *
 * @author USUARIO
 */
import java.awt.Color;

public class PaletaColores {

    // Colores principales
    public static final Color PRIMARIO_CLARO = new Color(155, 95, 123);  // #9b5f7b
    public static final Color PRIMARIO_OSCURO = new Color(92, 62, 98);   // #5c3e62
    public static final Color ACENTO_VIOLETA = new Color(82, 85, 116);   // #525574
    public static final Color ACENTO_VERDE = new Color(150, 179, 151);   // #96b397
    public static final Color VERDE_PASTEL = new Color(200, 207, 174);   // #c8cfae
    
    public static final Color FONDO_ALTERNO = new Color(99, 83, 116);

    // Colores de texto y fondo
    public static final Color TEXTO_PRIMARIO = Color.BLACK;
    public static final Color TEXTO_SECUNDARIO = new Color(80, 80, 80);     // Gris oscuro
    public static final Color TEXTO_CLARO = Color.WHITE;
    public static final Color TEXTO_APAGADO = new Color(140, 140, 140);     // Gris medio

    // Fondo generales
    public static final Color FONDO_CLARO = new Color(245, 245, 245);
    public static final Color FONDO_OSCURO = new Color(30, 30, 30);

    // Bordes y líneas
    public static final Color BORDE_SUAVE = new Color(200, 200, 200);
    public static final Color SOMBRA = new Color(50, 50, 50, 100);  // Transparente

    // Acciones típicas
    public static final Color ACCION_POSITIVA = new Color(96, 165, 96);     // Verde medio
    public static final Color ACCION_NEUTRA = new Color(100, 100, 150);   // Azul-grisáceo neutro
    public static final Color ACCION_DESTRUCTIVA = new Color(185, 80, 80);  // Rojo suave
    public static final Color ACCION_SECUNDARIA = new Color(160, 130, 190); // Violeta claro

    // Tabla
    public static final Color TABLA_HEADER_FONDO = new Color(82, 85, 116);        // ACENTO_VIOLETA
    public static final Color TABLA_HEADER_TEXTO = Color.WHITE;                  // Blanco
    public static final Color TABLA_FILA_PAR = new Color(245, 245, 245);     // FONDO_CLARO
    public static final Color TABLA_FILA_IMPAR = new Color(230, 230, 230);     // Gris más tenue
    public static final Color TABLA_TEXTO = Color.BLACK;
    public static final Color TABLA_SELECCION = new Color(155, 95, 123);      // PRIMARIO_CLARO
    public static final Color TABLA_BORDE = new Color(200, 200, 200);

    //TextField
    public static final Color CAMPO_FONDO = Color.WHITE;
    public static final Color CAMPO_BORDE = new Color(180, 180, 180);
    public static final Color CAMPO_BORDE_FOCUS = PaletaColores.PRIMARIO_CLARO;
    public static final Color CAMPO_BORDE_ERROR = new Color(200, 80, 80);
    public static final Color CAMPO_TEXTO = Color.BLACK;
    public static final Color CAMPO_TEXTO_INACTIVO = new Color(120, 120, 120);
    public static final Color CAMPO_FONDO_INACTIVO = new Color(235, 235, 235);

    //ComboBox
    public static final Color COMBO_FONDO = Color.WHITE;
    public static final Color COMBO_FONDO_INACTIVO = new Color(235, 235, 235);
    public static final Color COMBO_BORDE = new Color(180, 180, 180);
    public static final Color COMBO_BORDE_FOCUS = PaletaColores.PRIMARIO_CLARO;
    public static final Color COMBO_TEXTO = Color.BLACK;
    public static final Color COMBO_TEXTO_INACTIVO = new Color(120, 120, 120);
    public static final Color COMBO_ITEM_HOVER = new Color(220, 220, 250); // opcional

    public static final Color LABEL_LATERAL_TEXTO = PaletaColores.TEXTO_CLARO;
    public static final Color LABEL_TITULO = Color.WHITE;
    public static final Color LABEL_FORMULARIO = PaletaColores.TEXTO_PRIMARIO;

}
