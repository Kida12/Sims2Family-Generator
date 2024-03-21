import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class GUI2 {
    private JLabel SimFamilyGenerator;
    private JTextField Output;
    private JButton enterButton;
    private JPanel GUIMain;
    private JTextArea FamilyOutput;
    private JScrollBar scrollBar1;

    //JScrollPane y = new JScrollPane(FamilyOutput, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

    public void Print(Family fam, Vector<String> outputList) {
        int i = 0;
        String output = "";
        while (i < fam.family.size()) {
            String newline = System.lineSeparator();
            output = fam.lastName + " Household" + newline;
            output = output + fam.family.elementAt(i).gender + newline;
            output = output + fam.family.elementAt(i).name + newline;
            output = output + fam.family.elementAt(i).ageCategory + newline;
            output = output + fam.family.elementAt(i).age + newline;
            output = output + "Hair Color: " + fam.family.elementAt(i).hairColor + newline;
            output = output + "Eye Color: " + fam.family.elementAt(i).eyeColor + newline;
            output = output + "Skin Color: " + fam.family.elementAt(i).skinColor + newline;
            output = output + "Race: " + fam.family.elementAt(i).race + newline;
            output = output + "Sexuality: " + fam.family.elementAt(i).sexuality + newline;
            output = output + "Primary Aspiration: " + fam.family.elementAt(i).primAspiration + newline;
            output = output + "Secondary Aspiration: " + fam.family.elementAt(i).secAspiration + newline;
            output = output + "Sloppy - Neat: " + fam.family.elementAt(i).personality.elementAt(0) + newline;
            output = output + "Shy - Outgoing: " + fam.family.elementAt(i).personality.elementAt(1) + newline;
            output = output + "Lazy - Active: " + fam.family.elementAt(i).personality.elementAt(2) + newline;
            output = output + "Serious - Playful: " + fam.family.elementAt(i).personality.elementAt(3) + newline;
            output = output + "Grouchy - Nice: " + fam.family.elementAt(i).personality.elementAt(4) + newline;
            output = output + "Turn Ons: " + fam.family.elementAt(i).turnOns.elementAt(0) + ", " + fam.family.elementAt(i).turnOns.elementAt(1) + newline;
            output = output + "Turn Offs: " + fam.family.elementAt(i).turnOffs + newline;
            output = output + "Accessories: ";
            if (fam.family.elementAt(i).glasses) {
                output = output + "Glasses, ";
            }
            if (fam.family.elementAt(i).Jewelry) {
                output = output + "Jewelry, ";
            }
            if (fam.family.elementAt(i).Tattoo) {
                output = output + "Tattoo, ";
            }
            if (fam.family.elementAt(i).freckles) {
                output = output + "Freckles, ";
            }
            if (fam.family.elementAt(i).Makeup) {
                output = output + "Makeup, ";
            }
            if (fam.family.elementAt(i).fat) {
                output = output + "Fat";
            }
            if (fam.family.elementAt(i).College && (fam.family.elementAt(i).ageCategory.equals("Adult") || fam.family.elementAt(i).ageCategory.equals("Elder"))) {
                output = output + newline + fam.family.elementAt(i).name + " has passed college." + newline;
            }
            output = output + newline;
            outputList.add(output);
            i++;
        }
    }

    public GUI2(Family fam) {

        String newline = System.lineSeparator();
        Vector<String> outputList = new Vector<String>();
        JFrame frame = new JFrame("Sims 2 Family Generator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        JMenuBar mb = new JMenuBar();

        JPanel panel = new JPanel();
        JTextField tf = new JTextField(10);
        enterButton = new JButton("Enter");
        panel.add(enterButton);

        FamilyOutput = new JTextArea();
        JScrollPane scrollableTextArea = new JScrollPane(FamilyOutput);

        scrollableTextArea.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollableTextArea.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        frame.getContentPane().add(scrollableTextArea);

        frame.getContentPane().add(BorderLayout.SOUTH, panel);
        frame.getContentPane().add(BorderLayout.NORTH, mb);
        frame.getContentPane().add(BorderLayout.CENTER, scrollableTextArea);
        frame.setVisible(true);

        enterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Print(fam, outputList);

                //JOptionPane.showMessageDialog(GUI.this, "Hello World"); int i = 0; i < outputList.size(); i++
                for (String s : outputList) {
                    FamilyOutput.append(s + newline);
                }
                //new JScrollBar();

            }
        });
    }
}
