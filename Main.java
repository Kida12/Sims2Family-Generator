//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;
import java.util.Vector;
//TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
// for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
public class Main {

    public static void ReadNameFiles(Vector<String> femaleNameList, Vector<String> maleNameList, Vector<String> lastNameList)
    {
        try {
            File femaleFile = new File("C:\\Users\\a851423\\IdeaProjects\\Sims2FamilyGenerator\\src\\girlNames.txt");
            Scanner myReader = new Scanner(femaleFile);
            while (myReader.hasNextLine())
            {
                String name = myReader.nextLine();
                femaleNameList.add(name);
            }
            myReader.close();

            File maleFile = new File("C:\\Users\\a851423\\IdeaProjects\\Sims2FamilyGenerator\\src\\boyNames.txt");
            myReader = new Scanner(maleFile);
            while (myReader.hasNextLine())
            {
                String mname = myReader.nextLine();
                maleNameList.add(mname);
            }
            myReader.close();

            File lastNameFile = new File("C:\\Users\\a851423\\IdeaProjects\\Sims2FamilyGenerator\\src\\lastNames.txt");
            myReader = new Scanner(lastNameFile);
            while (myReader.hasNextLine())
            {
                String lname = myReader.nextLine();
                lastNameList.add(lname);
            }
            myReader.close();
        }
        catch(FileNotFoundException e)
        {
            System.out.println("File not Found.");
            e.printStackTrace();
        }

    }

    public static void GenerateSim(Sim person,Vector<String> femaleNameList, Vector<String> maleNameList)
    {

        String newline = System.lineSeparator();
        //System.out.printf("Enter Generate Sim " +  newline );
        person.GeneratePersonality(person);
        person.DetermineGender(person);
        person.AssignName(person,femaleNameList,maleNameList);
        person.DetermineAgeCategory(person);
        person.DetermineAge(person);
        person.DetermineTurnOns(person);
        person.DetermineTurnOffs(person);
        person.DetermineHair(person);
        person.DetermineEyes(person);
        person.DetermineAccessories(person);
        person.DetermineSkin(person);
        person.DetermineRace(person);
        person.DetermineSexuality(person);
        person.DeterminePrimaryAspiration(person);
        person.DetermineSecondaryAspiration(person);
        //System.out.printf("End of Generate Sim " +  newline );

    }

    public static void GenerateFamily(Family fam, Vector<String> femaleNameList, Vector<String> maleNameList, Vector<String> lastNameList)
    {
        String newline = System.lineSeparator();
        //System.out.printf("IN Generate family" +  newline );
         int temp = 0;
        Random rand = new Random();
        temp = rand.nextInt(1000);
        fam.lastName = lastNameList.elementAt(temp);
         int addNum = 0;
         while(addNum < 1)
         {
             //System.out.printf("In family while loop add Num " +  newline );
             addNum = 0;
            fam.family.clear();
            rand = new Random();
            temp = rand.nextInt(8);
            temp = temp + 1;
            while (temp > 0) {
                Sim newSim = new Sim();
                //System.out.printf("Generate sim " +  newline );
                     GenerateSim(newSim, femaleNameList, maleNameList);
                     fam.family.add(newSim);
                     temp = temp - 1;
                //System.out.printf("Temp is " + temp + newline );
            }
            for (int i = 0; i < fam.family.size(); i++) {
                //System.out.printf("increase addnum " +  newline );
                     if (fam.family.elementAt(i).ageCategory.equals("Adult") || fam.family.elementAt(i).ageCategory.equals("Elder")) {
                         addNum++;
                     }
                 }
             //System.out.printf("Reach end of while loop " +  newline );

         }
        //System.out.printf("Out of while loop " +  newline );

    }

    public static void EditFamilyRelations(Family fam)
    {
        fam.DetermineElderAdultRelations(fam);
        fam.DetermineAdultChildrenRelations(fam);
    }


    public static void Print(Family fam)
    {
        int i = 0;
        while(i < fam.family.size()) {
            String newline = System.lineSeparator();
            System.out.printf(fam.lastName + " Household" + newline);
            System.out.printf(fam.family.elementAt(i).gender + newline);
            System.out.printf(fam.family.elementAt(i).name + newline);
            System.out.printf(fam.family.elementAt(i).ageCategory + newline);
            System.out.printf(fam.family.elementAt(i).age + newline);
            System.out.printf("Hair Color: " + fam.family.elementAt(i).hairColor + newline);
            System.out.printf("Eye Color: " + fam.family.elementAt(i).eyeColor + newline);
            System.out.printf("Skin Color: " + fam.family.elementAt(i).skinColor + newline);
            System.out.printf("Race: " + fam.family.elementAt(i).race + newline);
            System.out.printf("Sexuality: " + fam.family.elementAt(i).sexuality + newline);
            System.out.printf("Primary Aspiration: " + fam.family.elementAt(i).primAspiration + newline);
            System.out.printf("Secondary Aspiration: " + fam.family.elementAt(i).secAspiration + newline);
            System.out.println("Sloppy - Neat: " +fam.family.elementAt(i).personality.elementAt(0));
            System.out.println("Shy - Outgoing: " + fam.family.elementAt(i).personality.elementAt(1));
            System.out.println("Lazy - Active: " + fam.family.elementAt(i).personality.elementAt(2));
            System.out.println("Serious - Playful: " + fam.family.elementAt(i).personality.elementAt(3));
            System.out.println("Grouchy - Nice: " + fam.family.elementAt(i).personality.elementAt(4));
            System.out.printf("Turn Ons: " + fam.family.elementAt(i).turnOns.elementAt(0) + ", " + fam.family.elementAt(i).turnOns.elementAt(1) + newline);
            System.out.printf("Turn Offs: " + fam.family.elementAt(i).turnOffs + newline);
            System.out.printf("Accessories: ");
            if (fam.family.elementAt(i).glasses) {
                System.out.printf("Glasses, ");
            }
            if (fam.family.elementAt(i).Jewelry) {
                System.out.printf("Jewelry, ");
            }
            if (fam.family.elementAt(i).Tattoo) {
                System.out.printf("Tattoo, ");
            }
            if (fam.family.elementAt(i).freckles) {
                System.out.printf("Freckles, ");
            }
            if (fam.family.elementAt(i).Makeup) {
                System.out.printf("Makeup, ");
            }
            if (fam.family.elementAt(i).fat) {
                System.out.printf("Fat");
            }
            if (fam.family.elementAt(i).College &&(fam.family.elementAt(i).ageCategory.equals("Adult") || fam.family.elementAt(i).ageCategory.equals("Elder"))) {
                System.out.printf(newline + fam.family.elementAt(i).name + " has passed college." + newline);
            }
            System.out.printf(newline);
            i++;
        }

    }

    public static void main(String[] args) {
        Sim person = new Sim();
        Family family = new Family();
        String newline = System.lineSeparator();
        Vector<String> femaleNameList = new Vector<String>();
        Vector<String> maleNameList = new Vector<String>();
        Vector<String> lastNameList = new Vector<String>();
        ReadNameFiles(femaleNameList, maleNameList, lastNameList);
        GenerateFamily(family, femaleNameList, maleNameList, lastNameList);
        //GenerateSim(person, femaleNameList, maleNameList);
        EditFamilyRelations(family);

        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!" + newline);

        new GUI2(family);
        //Print(family);

    }
}