import com.github.javafaker.Faker;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.*;

public class GeneratorGUIForm {
    private JPanel mainPanel;
    private JPanel topLabelPanel;
    private JPanel bottomPanel;
    private JLabel sayingLabel;
    private JButton generateButton;
    private JLabel subheadLabel;
    private JLabel generatedName;
    private JLabel topLabel;

    //Faker stuff
    private Faker faker = new Faker();
    private String appName = faker.app().name();
    private String superHero = faker.superhero().name();
    private String animal = faker.animal().name();
    private String hipster = faker.hipster().word();
    private String legends = faker.leagueOfLegends().champion();
    private String artist = faker.artist().name();

    //String arrays to randomly pick from
    private String[] sayings = new String[]{"Nice to meet you:", "Your rapper name is:" , "Hmm.. interesting"};
    private String[] domainsToPickFrom = new String[]{appName, artist, legends, superHero, hipster};
    private String[] namePrefixes = new String[]{"Lil", "Big", "Young", "Yung", "Luh"};

    //Constructor with frame
    public GeneratorGUIForm() {
        JFrame frame = new JFrame("The Rap Corner");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        frame.setVisible(true);
        frame.add(mainPanel);

        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String randPref = getRandomArrayElement(namePrefixes);
                String randDomain = getRandomArrayElement(domainsToPickFrom);
                String randSayings = getRandomArrayElement(sayings);

                sayingLabel.setText(randSayings);
                generatedName.setText(randPref + " " + randDomain);

            }
        });
    }

    //initialization

    /**
     * Generates a random element from the array provided
     * @param strArray the array provided
     * @return string element
     */
    public String getRandomArrayElement(String[] strArray) {
        Random generator = new Random();
        int randomIndex = generator.nextInt(strArray.length);
        return strArray[randomIndex];
    }


}

