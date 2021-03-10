/*
 * 
 *  finish (and comment) me!
 * 
 */

package gui;

import filters.EdgeDetectFilter;
import filters.EdgeHighlightFilter;
import filters.FlipHorizontalFilter;
import filters.FlipVerticalFilter;
import filters.GrayscaleFilter;
import filters.SharpenFilter;
import filters.SoftenFilter;
import image.PixelImage;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


/** */

/**
 * 
 * Class Header: This program is a photo image editor program that uses graphical user interface components in Java using Swing.
 * 
 * @author Julie ChanJoo Kim 
 * @version 1
 */
public class SnapShopGUI extends JFrame {
    /**
     * 
     */
    private static final long serialVersionUID = -2144739668936849562L;
    
    /** chooser for the image. */
    private final JFileChooser myChooser;
    
    /** pixel image that is to be edited. */
    private PixelImage myPixelImage;
    
    /** label where the image will be inserted. */
    private final JLabel myImageLabel; 
    
    /** panel that holds the filter buttons. */
    private final JPanel myFilterPanel;
    
    /** panel where the label will be placed. */
    private final JPanel myImagePanel;
    
    /** panel that holds open, save as, and close image. */ 
    private final JPanel myOptionPanel; 
    
    /** an array list of buttons that will hold the filter buttons. */
    private final List<JButton> myButtonList;
    
    /** an array list of buttons that will hold the options buttons(open, save as, close image). */
    private final List<JButton> myOptionbuttonList;
    

    /** a parameterless constructor that initializes the variables and calls the other methods.  */
    public SnapShopGUI() {
        super("TCSS 305 - Assignment 5");
        myFilterPanel = new JPanel(new FlowLayout());
        myChooser = new JFileChooser(".");
        myImageLabel = new JLabel();
        myImagePanel = new JPanel();
        myOptionPanel = new JPanel(new FlowLayout()); 
        myButtonList = new ArrayList<JButton>();
        myOptionbuttonList = new ArrayList<JButton>();    
        helperM();   
    }
    
    /** a helper method that calls the other methods and adds the panels to the frame. */
    private void helperM() {
        buttonClicksForFilter();
        buttonClicksForOption();        
        add(myFilterPanel, BorderLayout.NORTH);
        myImagePanel.add(myImageLabel);
        add(myImagePanel, BorderLayout.CENTER);
        add(myOptionPanel, BorderLayout.SOUTH);
    }
    
    /** adds the buttons into the filter panel, and creates action event listener for each filter buttons to do its thing. */
    public void buttonClicksForFilter() {
        final JButton edgeDetect = new JButton("Edge Detect");
        final EdgeDetectFilter edgeDetectFilter = new EdgeDetectFilter();
        final JButton edgeHighlight = new JButton("Edge Hightlight");
        final EdgeHighlightFilter edgeHighlightFilter = new EdgeHighlightFilter();
        final JButton flipHorizontal = new JButton("Flip Horizontal");
        final FlipHorizontalFilter flipHorizontalFilter = new FlipHorizontalFilter();
        final JButton flipVertical = new JButton("Flip Vertical");
        final FlipVerticalFilter flipVerticalFilter = new FlipVerticalFilter();
        final JButton grayscale = new JButton("Grayscale");
        final GrayscaleFilter grayScaleFilter = new GrayscaleFilter();
        final JButton sharpen = new JButton("Sharpen");
        final SharpenFilter sharpenFilter = new SharpenFilter();
        final JButton soften = new JButton("Soften");
        final SoftenFilter softenFilter = new SoftenFilter();
        
        myButtonList.add(edgeDetect);
        myButtonList.add(edgeHighlight);
        myButtonList.add(flipHorizontal);
        myButtonList.add(flipVertical);
        myButtonList.add(grayscale);
        myButtonList.add(sharpen);
        myButtonList.add(soften);
        
        edgeDetect.setEnabled(false);
        edgeHighlight.setEnabled(false);
        flipHorizontal.setEnabled(false);
        flipVertical.setEnabled(false);
        grayscale.setEnabled(false);
        sharpen.setEnabled(false);
        soften.setEnabled(false);
        /** when clicked, applies filter to image. */
        edgeDetect.addActionListener(new ActionListener() {      
            @Override
            public void actionPerformed(final ActionEvent theEvent) {
                edgeDetectFilter.filter(myPixelImage);
                myImageLabel.setIcon(new ImageIcon(myPixelImage));
            }
        });
        /** when clicked, applies filter to image. */
        edgeHighlight.addActionListener(new ActionListener() {      
            @Override
            public void actionPerformed(final ActionEvent theEvent) {
                edgeHighlightFilter.filter(myPixelImage);
                myImageLabel.setIcon(new ImageIcon(myPixelImage));
            }
        });
        /** when clicked, applies filter to image. */
        flipHorizontal.addActionListener(new ActionListener() {      
            @Override
            public void actionPerformed(final ActionEvent theEvent) {
                flipHorizontalFilter.filter(myPixelImage);
                myImageLabel.setIcon(new ImageIcon(myPixelImage));
            }
        });
        /** when clicked, applies filter to image. */
        flipVertical.addActionListener(new ActionListener() {      
            @Override
            public void actionPerformed(final ActionEvent theEvent) {
                flipVerticalFilter.filter(myPixelImage);
                myImageLabel.setIcon(new ImageIcon(myPixelImage));
            }
        });
        /** when clicked, applies filter to image. */
        grayscale.addActionListener(new ActionListener() {      
            @Override
            public void actionPerformed(final ActionEvent theEvent) {
                grayScaleFilter.filter(myPixelImage);
                myImageLabel.setIcon(new ImageIcon(myPixelImage));
            }
        });
        
        /** when clicked, applies filter to image. */
        sharpen.addActionListener(new ActionListener() {      
            @Override
            public void actionPerformed(final ActionEvent theEvent) {
                sharpenFilter.filter(myPixelImage);
                myImageLabel.setIcon(new ImageIcon(myPixelImage));
            }
        });
        
        /** when clicked, applies filter to image. */
        soften.addActionListener(new ActionListener() {      
            @Override
            public void actionPerformed(final ActionEvent theEvent) {
                softenFilter.filter(myPixelImage);
                myImageLabel.setIcon(new ImageIcon(myPixelImage));
            }
        });
        myFilterPanel.add(edgeDetect);
        myFilterPanel.add(edgeHighlight);
        myFilterPanel.add(flipHorizontal);
        myFilterPanel.add(flipVertical);
        myFilterPanel.add(grayscale);
        myFilterPanel.add(sharpen);
        myFilterPanel.add(soften);      
    }
    
    /** adds the option buttons into the option panel, creates action event listener for each buttons. */
    public void buttonClicksForOption() {
        final JButton open = new JButton("Open...");
        final JButton saveAs = new JButton("Save As...");
        final JButton closeImage = new JButton("Close Image...");
        myOptionPanel.add(open);
        myOptionPanel.add(saveAs);
        myOptionPanel.add(closeImage);
        
        myOptionbuttonList.add(open);
        myOptionbuttonList.add(saveAs);
        myOptionbuttonList.add(closeImage);
        
        /** saves the image into the folder if the button is clicked. */
        saveAs.addActionListener(new ActionListener() {      
            @Override
            public void actionPerformed(final ActionEvent theEvent) {
                final int result = myChooser.showSaveDialog(myOptionPanel);
                if (result == JFileChooser.APPROVE_OPTION) {
                    final File selectedFile = myChooser.getSelectedFile();
                    try {
                        myPixelImage.save(selectedFile);
                    } catch (final IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        
        /** closes the image if the button is clicked */
        closeImage.addActionListener(new ActionListener() {      
            @Override
            public void actionPerformed(final ActionEvent theEvent) {
                myImageLabel.setIcon(null);
                setMinimumSize(new Dimension(0, 0)); 
                pack();
                setMinimumSize(getBounds().getSize());
                for (JButton button: myButtonList) {
                    button.setEnabled(false);
                }
                for (JButton button: myOptionbuttonList) {
                    button.setEnabled(false);
                }
                open.setEnabled(true);
            }
        });
 
        saveAs.setEnabled(false);
        closeImage.setEnabled(false);
        
        /** opens the image and loads the image onto the panel. */
        open.addActionListener(new ActionListener() {      
            @Override
            public void actionPerformed(final ActionEvent theEvent) {
                final int result = myChooser.showOpenDialog(myOptionPanel);
                if (result == JFileChooser.APPROVE_OPTION) {
                    final File selectedFile = myChooser.getSelectedFile();
                    try {
                        myPixelImage = PixelImage.load(selectedFile);
                        helperM2();
                    } catch (final IOException e) {
                        JOptionPane.showMessageDialog(myOptionPanel, "The selected file did not contain an image!");
                    }
                  
                }
            }
        });
        
    }
    
    /** 2nd helper method that sets the image icon, packs back. */
    private void helperM2() {
        myImageLabel.setIcon(new ImageIcon(myPixelImage));
        setMinimumSize(new Dimension(0, 0));
        pack();
        setMinimumSize(getBounds().getSize());   
        for (JButton button: myButtonList) {
            button.setEnabled(true);
        }
        for (JButton button: myOptionbuttonList) {
            button.setEnabled(true);
        }
    }
    
    /** creates the icon for the message, packs. */
    public void start() {
        final Image icon = Toolkit.getDefaultToolkit().getImage("./icons/smile.jpg"); 
        setIconImage(icon); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setMinimumSize(new Dimension(0, 0));
        pack();
        setMinimumSize(getBounds().getSize());
        
    }
    
  
    
}