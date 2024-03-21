import java.util.Random;
import java.util.Vector;

public class Sim {
    int age;
    String name;
    String gender;
    String ageCategory;
    String sexuality;
    String primAspiration = "";
    String secAspiration = "";
    String hairColor;
    String eyeColor;
    String skinColor;
    String race = "Sim";
    String turnOffs;
    boolean Makeup;
    boolean College;
    boolean Jewelry;
    boolean freckles;
    boolean Tattoo;
    boolean orphan;
    boolean glasses;

    boolean fat;

    Vector<Sim> Children = new Vector<Sim>();
    Vector<Sim> Parents = new Vector<Sim>(2);
    Vector<Integer> personality = new Vector<Integer>(5);
    Vector<String> turnOns = new Vector<String>(2);

    //Generates Sims personality.
    public void GeneratePersonality(Sim person)
    {
        String newline = System.lineSeparator();
        System.out.printf("Enter Personality " +  newline );
        Random rand = new Random();
        int points = 25;
        person.personality.clear();
        //System.out.printf("personality size " + person.personality.size() +  newline );
        while((points > 0) && (person.personality.size() < 4)) {
           //System.out.printf("Enter personality while loop & personality size " + person.personality.size() +  newline );
            int temp = rand.nextInt(10);
            if(points - temp >= 0)
            {
                //System.out.printf("Enter personality if loop " +  newline );
                person.personality.add(temp);
                points = points - temp;
            }
        }
        //System.out.printf("These are points after for loop " + points + newline);
        while(points > 10)
        {
            int temp = 0;
            if(points > 10)
            {
                if(person.personality.elementAt(0) < 10)
                {
                    temp = person.personality.elementAt(0);
                    temp = temp +1;
                    person.personality.set(0,temp);
                    points = points -1;
                    //System.out.printf("These are points while loop element 1 " + points + newline);
                }
            }
            if(points > 10)
            {
                if(person.personality.elementAt(1) < 10)
                {
                    temp = person.personality.elementAt(1);
                    temp = temp +1;
                    person.personality.set(1,temp);
                    points = points -1;
                    //System.out.printf("These are points while loop element 2 " + points + newline);
                }
            }
            if(points > 10)
            {
                if(person.personality.elementAt(2) < 10)
                {
                    temp = person.personality.elementAt(2);
                    temp = temp +1;
                    person.personality.set(2,temp);
                    points = points -1;
                    //System.out.printf("These are points while loop element 3 " + points + newline);
                }
            }
            if(points > 10)
            {
                if(person.personality.elementAt(3) < 10)
                {
                    temp = person.personality.elementAt(3);
                    temp = temp +1;
                    person.personality.set(3,temp);
                    points = points -1;
                    //System.out.printf("These are points while loop element 4 " + points + newline);
                }
            }
            if(points > 10 && person.personality.size() == 5)
            {
                if(person.personality.elementAt(4) < 10)
                {
                    temp = person.personality.elementAt(4);
                    temp = temp +1;
                    person.personality.set(4,temp);
                    points = points -1;
                    //System.out.printf("These are points while loop element 5 " + points + newline);
                }
            }
        }
        person.personality.add(points);
        if(person.personality.size() < 5)
        {
            //System.out.printf("These are points while loop element 1 " + points + newline);
            person.personality.add(points);
        }
    }

    public void DetermineGender(Sim person)
    {
        String newline = System.lineSeparator();

        Random rand = new Random();
        int temp = rand.nextInt(2);
        if(temp == 0)
        {
            person.gender = "Male";
        }
        else
        {
            person.gender = "Female";
        }
        //System.out.printf("Enter Gender of Sim " +  person.gender + newline );
    }

    public void AssignName(Sim person, Vector<String> femaleNameList, Vector<String> maleNameList)
    {
        String name = "";
        String newline = System.lineSeparator();

        if(person.gender.equals("Female"))
        {
            Random rand = new Random();
            int temp = rand.nextInt(1000);
            person.name = femaleNameList.elementAt(temp);
        }
        else if(person.gender.equals("Male"))
        {
            Random rand = new Random();
            int temp = rand.nextInt(2943);
            person.name = maleNameList.elementAt(temp);
        }
        //System.out.printf("Enter age Category of Sim " + person.name +  newline );
    }

    public void DetermineAgeCategory(Sim person)
    {
        String newline = System.lineSeparator();

        Random rand = new Random();
        int temp = rand.nextInt(5);
        temp = temp + 1;
        switch(temp){
            case 1:
                person.ageCategory = "Toddler";
                break;
            case 2:
                person.ageCategory = "Child";
                break;
            case 3:
                person.ageCategory = "Teen";
                break;
            case 4:
                person.ageCategory = "Adult";
                break;
            case 5:
                person.ageCategory = "Elder";
                break;
        }
        //System.out.printf("Enter age Category of Sim " + person.ageCategory +  newline );
    }

    public void DetermineAge(Sim person)
    {
        int temp = 0;
        String newline = System.lineSeparator();

        if(person.ageCategory.equals("Toddler"))
        {
            Random rand = new Random();
            temp = rand.nextInt(3);
            temp = temp + 3;
            person.age = temp;
        }
        else if(person.ageCategory.equals("Child"))
        {
            Random rand = new Random();
            temp = rand.nextInt(12-6) + 6;
            person.age = temp;

        }
        else if(person.ageCategory.equals("Teen"))
        {
            Random rand = new Random();
            temp = rand.nextInt(17-13) + 13;
            person.age = temp;
        }
        else if(person.ageCategory.equals("Adult"))
        {
            Random rand = new Random();
            temp = rand.nextInt(59-18) + 18;
            person.age = temp;
        }
        else if(person.ageCategory.equals("Elder"))
        {
            Random rand = new Random();
            temp = rand.nextInt(80-60) + 60;
            person.age = temp;
        }
        //System.out.printf("Enter age of Sim " + person.ageCategory +  newline );
    }

    public void DetermineTurnOns(Sim person)
    {
        String newline = System.lineSeparator();

        String[] TurnOns = {"Blonde Hair", "Black Hair", "Brown Hair", "Red Hair", "Gray Hair", "Custom Hair", "Facial Hair", "Glasses", "Hats", "Jewerly", "Swim Wear", "Underwear", "Formal Wear",
                "Makeup", "Full Face Makeup", "Fat", "Fit", "Cologne", "Stink", "Vampirism", "Lycanthropy",
                "Plant Sim", "Zombiism", "Robots", "Witch", "Good at Cooking", "Good at Cleaning", "Good at Creativity", " Good at Body", "Good at logic", "Good at Charisma", "Good at Mechanical",
                "Unemployed", "Hard Worker"};

        int temp = 0;
        String turnOn1 = "";
        String turnon2 = "";
        Random rand = new Random();
        temp = rand.nextInt(34);
        turnOn1 = TurnOns[temp];
        person.turnOns.add(turnOn1);

        temp = rand.nextInt(34);
        turnon2 = TurnOns[temp];
        while(turnOn1.equals(turnon2))
        {
            temp = rand.nextInt(34);
            turnon2 = TurnOns[temp];
        }
        person.turnOns.add(turnon2);
        //System.out.printf("Enter Turn Ons of Sim " + person.turnOns.elementAt(0) +   newline );
    }

    public void DetermineTurnOffs(Sim person)
    {
        String newline = System.lineSeparator();

        int temp = 0;
        String[] TurnOffs = {"Blonde Hair", "Black Hair", "Brown Hair", "Red Hair", "Gray Hair", "Custom Hair", "Facial Hair", "Glasses", "Hats", "Jewerly", "Swim Wear", "Underwear", "Formal Wear",
                "Makeup", "Full Face Makeup", "Fat", "Fit", "Cologne", "Stink", "Vampirism", "Lycanthropy",
                "Plant Sim", "Zombiism", "Robots", "Witch", "Good at Cooking", "Good at Cleaning", "Good at Creativity", " Good at Body", "Good at logic", "Good at Charisma", "Good at Mechanical",
                "Unemployed", "Hard Worker"};
        String turnOff = "";
        Random rand = new Random();
        temp = rand.nextInt(34);
        turnOff = TurnOffs[temp];
        while(turnOff.equals(person.turnOns.elementAt(0)) || turnOff.equals(person.turnOns.elementAt(1)))
        {
            temp = rand.nextInt(34);
            turnOff = TurnOffs[temp];
        }
        person.turnOffs = turnOff;
        //System.out.printf("Enter Turn Offs of Sim " + person.turnOffs + newline );
    }

    public void DetermineHair(Sim person)
    {
        String newline = System.lineSeparator();
        //System.out.printf("Enter Hair of Sim " +  newline );
        String[] HairColor = {"Blonde", "Black", "Red", "Black", "Custom"};
        int temp = 0;
        Random rand = new Random();
        temp = rand.nextInt(5);
        temp = temp +1;
        switch(temp){
            case 1:
                person.hairColor = HairColor[temp - 1];
                break;
            case 2:
                person.hairColor = HairColor[temp - 1];
                break;
            case 3:
                person.hairColor = HairColor[temp - 1];
                break;
            case 4:
                person.hairColor = HairColor[temp - 1];
                break;
            case 5:
                person.hairColor = HairColor[temp - 1];
                break;
        }
        //System.out.printf("Enter Turn Offs of Sim " + person.hairColor + newline );

    }

    public void DetermineEyes(Sim person)
    {
        String newline = System.lineSeparator();
        //System.out.printf("Enter Eyes of Sim " +  newline );
        String[] EyeColor = {"Dark Blue", "Light Blue", "Gray", "Brown", "Green"};
        int temp = 0;
        Random rand = new Random();
        temp = rand.nextInt(5);
        temp = temp +1;
        switch(temp){
            case 1:
                person.eyeColor = EyeColor[temp - 1];
                break;
            case 2:
                person.eyeColor = EyeColor[temp - 1];
                break;
            case 3:
                person.eyeColor = EyeColor[temp - 1];
                break;
            case 4:
                person.eyeColor = EyeColor[temp - 1];
                break;
            case 5:
                person.eyeColor = EyeColor[temp - 1];
                break;
        }
        //System.out.printf("Enter Turn Offs of Sim " + person.eyeColor + newline );
    }

    public void DetermineAccessories(Sim person)
    {
        String newline = System.lineSeparator();
        //System.out.printf("Enter Accessories of Sim " +  newline );
        int temp = 0;
        Random rand = new Random();
        temp = rand.nextInt(101);
        if( temp <= 25)
        {
            person.glasses = true;
        }
        temp = rand.nextInt(101);
        if(temp <= 25)
        {
            person.Jewelry = true;
        }

        temp = rand.nextInt(101);
        if(temp <= 25)
        {
            person.Tattoo = true;
        }

        temp = rand.nextInt(101);
        if(temp <= 25)
        {
            person.Makeup = true;
        }

        temp = rand.nextInt(101);
        if(temp <= 25)
        {
            person.fat = true;
        }

        temp = rand.nextInt(101);
        if(temp <= 25)
        {
            person.freckles = true;
        }

        temp = rand.nextInt(2);
        if(temp == 1)
        {
            person.College = true;
        }
    }

    public void DetermineSkin(Sim person)
    {
        String newline = System.lineSeparator();
        //System.out.printf("Enter Skin of Sim " +  newline );
        int temp = 0;
        String [] SkinColor = {"S1", "S2", "S3", "S4"};
        Random rand = new Random();
        temp = rand.nextInt(4);
        temp = temp +1;
        switch(temp)
        {
            case 1:
                person.skinColor = SkinColor[temp - 1];
                break;
            case 2:
                person.skinColor = SkinColor[temp - 1];
                break;
            case 3:
                person.skinColor = SkinColor[temp - 1];
                break;
            case 4:
                person.skinColor = SkinColor[temp - 1];
                break;
        }
    }

    public void DetermineRace(Sim person)
    {
        String newline = System.lineSeparator();
        //System.out.printf("Enter Race of Sim " +  newline );
        int temp = 0;
        String [] Race = {"Mermaid", "Fairy", "Witch", "Werewolf", "Vampire", "Genie", "Plantsim"};
        Random rand = new Random();
        temp = rand.nextInt(101);
        if(temp <= 25)
        {
            temp = rand.nextInt(7);
            temp = temp +1;
            switch(temp) {
                case 1:
                    person.race = Race[temp - 1];
                    break;
                case 2:
                    person.race = Race[temp - 1];
                    break;
                case 3:
                    person.race = Race[temp - 1];
                    break;
                case 4:
                    person.race = Race[temp - 1];
                    break;
                case 5:
                    person.race = Race[temp - 1];
                    break;
                case 6:
                    person.race = Race[temp - 1];
                    break;
                case 7:
                    person.race = Race[temp - 1];
                    break;
            }
        }
    }

    public void DetermineSexuality(Sim person)
    {
        String newline = System.lineSeparator();
        //System.out.printf("Enter Sexuality of Sim " +  newline );
        int temp = 0;
        Random rand = new Random();
        temp = rand.nextInt(101);
        if(temp <= 20)
        {
            person.sexuality = "Gay";
        }
        else if(temp >= 21 && temp <= 40)
        {
            person.sexuality = "Bisexual";
        }
        else if(temp >= 41 && temp <= 100)
        {
            person.sexuality = "Straight";
        }
    }

    public void DeterminePrimaryAspiration(Sim person)
    {
        String newline = System.lineSeparator();
        //System.out.printf("Enter Primary Aspiration of Sim " +  newline );
        int temp = 0;
        Random rand = new Random();
        temp = rand.nextInt(6);
        temp = temp +1;
        switch(temp)
        {
            case 1:
                person.primAspiration = "Pleasure";
                break;
            case 2:
                person.primAspiration = "Fortune";
                break;
            case 3:
                person.primAspiration = "Knowledge";
                break;
            case 4:
                person.primAspiration = "Romance";
                break;
            case 5:
                person.primAspiration = "Family";
                break;
            case 6:
                person.primAspiration = "Popularity";
                break;

        }
    }

    public void DetermineSecondaryAspiration(Sim person)
    {
        String newline = System.lineSeparator();
        //System.out.printf("Enter Secondary Aspiration of Sim " +  newline );
        int temp = 0;
        Random rand = new Random();
        temp = rand.nextInt(7);
        temp = temp +1;
        System.out.printf("Case number " + temp + newline );
        switch(temp)
        {
            case 1:
                person.secAspiration = "Pleasure";
                System.out.printf("Case 1" + newline);
                break;
            case 2:
                System.out.printf("Case 2" + newline);
                person.secAspiration = "Fortune";
                break;
            case 3:
                System.out.printf("Case 3" + newline);
                person.secAspiration = "Knowledge";
                break;
            case 4:
                System.out.printf("Case 4" + newline);
                person.secAspiration = "Romance";
                break;
            case 5:
                System.out.printf("Case 5" + newline);
                person.secAspiration = "Family";
                break;
            case 6:
                System.out.printf("Case 6" + newline);
                person.secAspiration = "Popularity";
                break;
            case 7:
                System.out.printf("Case 7" + newline);
                person.secAspiration = "Grilled Cheese";
                break;

        }
        while(person.primAspiration.equals(person.secAspiration))
        {
            System.out.printf("enter while loop" + newline);
            temp = rand.nextInt(7);
            temp = temp +1;
            switch(temp)
            {
                case 1:
                    person.secAspiration = "Pleasure";
                    System.out.printf("Case 1" + newline);
                    break;
                case 2:
                    System.out.printf("Case 2" + newline);
                    person.secAspiration = "Fortune";
                    break;
                case 3:
                    System.out.printf("Case 3" + newline);
                    person.secAspiration = "Knowledge";
                    break;
                case 4:
                    System.out.printf("Case 4" + newline);
                    person.secAspiration = "Romance";
                    break;
                case 5:
                    System.out.printf("Case 5" + newline);
                    person.secAspiration = "Family";
                    break;
                case 6:
                    System.out.printf("Case 6" + newline);
                    person.secAspiration = "Popularity";
                    break;
                case 7:
                    System.out.printf("Case 7" + newline);
                    person.secAspiration = "Grilled Cheese";
                    break;

            }
        }
    }

    public void DetermineElderAdultRelations(Family fam)
    {
        String newline = System.lineSeparator();
        //System.out.printf("Enter Elder/Adult relations of Sim " +  newline );
        int i = 0;
        while(i < fam.family.size())
        {
            if(fam.family.elementAt(i).ageCategory.equals("Elder"))
            {
                int j = 0;
                while(j < fam.family.size())
                {
                    if(fam.family.elementAt(j).ageCategory.equals("Adult"))
                    {
                        if((fam.family.elementAt(j).hairColor.equals(fam.family.elementAt(i).hairColor)) || (fam.family.elementAt(j).eyeColor.equals(fam.family.elementAt(i).eyeColor)))
                        {
                            fam.family.elementAt(i).Children.add(fam.family.elementAt(j));
                            if(fam.family.elementAt(j).Parents.size() < 2) {
                                fam.family.elementAt(j).Parents.add(fam.family.elementAt(i));
                            }
                        }
                    }
                    j++;
                }
            }
            i++;
        }
    }

    public void DetermineAdultChildrenRelations(Family fam)
    {
        String newline = System.lineSeparator();
        //System.out.printf("Enter Adult/Children of Sim " +  newline );
        int i = 0;
        while(i < fam.family.size())
        {
            if(fam.family.elementAt(i).ageCategory.equals("Adult"))
            {
                int j = 0;
                while(j < fam.family.size())
                {
                    if(fam.family.elementAt(j).ageCategory.equals("Teen") || fam.family.elementAt(j).ageCategory.equals("Child") || fam.family.elementAt(j).ageCategory.equals("Toddler"))
                    {
                        if((fam.family.elementAt(j).hairColor.equals(fam.family.elementAt(i).hairColor)) || (fam.family.elementAt(j).eyeColor.equals(fam.family.elementAt(i).eyeColor)))
                        {
                            fam.family.elementAt(i).Children.add(fam.family.elementAt(j));
                            if(fam.family.elementAt(j).Parents.size() < 2) {
                                fam.family.elementAt(j).Parents.add(fam.family.elementAt(i));
                            }
                        }
                    }
                    j++;
                }
            }
            i++;
        }
    }

}

